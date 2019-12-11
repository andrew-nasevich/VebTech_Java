package by.BSUIR.hotel.parser;

import by.BSUIR.hotel.bean.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ls.DOMImplementationLS;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Client xml parser.
 */
public class ClientXmlParser implements XmlParser<Client> {
    private static final String CLIENT = "client";
    private static final String CLIENTS = "clients";
    private static final String ID = "id";
    private static final String FIRST_NAME = "first-name";
    private static final String LAST_NAME = "last-name";
    private static final String PHONE = "phone";
    private static final String ROOM = "room";
    private static final String ROOM_NUMBER = "number";
    private static final String ROOM_PRICE = "cost";

    private DocumentBuilder documentBuilder;
    private String sourceFilePath;
    private String xsdFilePath;

    public String getSourceFilePath() {
        return sourceFilePath;
    }

    public String getXsdFilePath() {
        return xsdFilePath;
    }

    public ClientXmlParser() {
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }

    public ClientXmlParser(String sourceFilePath, String xsdFilePath) {
        this();
        this.sourceFilePath = sourceFilePath;
        this.xsdFilePath = xsdFilePath;
    }

    @Override
    public List<Client> getData() throws XmlParserException {
        var sourceFile = new File(sourceFilePath);
        var xsdFile = new File(xsdFilePath);

        if (!sourceFile.exists()) {
            throw new XmlParserException(sourceFilePath + ": file not exists.");
        }

        if (!xsdFile.exists()) {
            throw new XmlParserException(sourceFilePath + ": file not exists.");
        }

        validateXMLByXSD(sourceFile, xsdFile);

        List<Client> clients = new ArrayList<>();
        Document document;

        try {
            document = documentBuilder.parse(sourceFile);
        } catch (SAXException | IOException e) {
            throw new XmlParserException(e.getMessage());
        }

        var element = document.getDocumentElement();
        var nodeClients = element.getElementsByTagName(CLIENT);

        for (var i = 0; i < nodeClients.getLength(); i++) {
            if (nodeClients.item(i).getNodeType() == Node.ELEMENT_NODE) {
                clients.add(getClientElement((Element) nodeClients.item(i)));
            }
        }

        return clients;
    }

    @Override
    public void setData(List<Client> clients) throws XmlParserException {
        var document = documentBuilder.newDocument();
        var root = document.createElement(CLIENTS);
        document.appendChild(root);

        for (var client : clients) {
            root.appendChild(getClientElement(document, client));
        }

        var impl = document.getImplementation();
        var implLs = (DOMImplementationLS) impl.getFeature("LS", "3.0");
        var lsSerializer = implLs.createLSSerializer();
        lsSerializer.getDomConfig().setParameter("format-pretty-print", true);
        var output = implLs.createLSOutput();
        output.setEncoding("UTF-8");

        try {
            output.setByteStream(Files.newOutputStream(Paths.get(sourceFilePath)));
        } catch (IOException e) {
            throw new XmlParserException(e.getMessage());
        }

        lsSerializer.write(document, output);
    }

    private Client getClientElement(Element element) {
        Client client;

        try {
            client = new Client(Integer.parseInt(getElementTextContent(element, ID)));
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("'" + ID + "'" + "incorrect");
        }

        try {
            client.setMobilePhone(getElementTextContent(element, PHONE));
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("'" + PHONE + "'" + "incorrect");
        }

        client.setName(getElementTextContent(element, FIRST_NAME));
        client.setSurname(getElementTextContent(element, LAST_NAME));

        var roomElement = (Element) element.getElementsByTagName(ROOM).item(0);
        if (roomElement != null) {
            client.setRoom(getRoomElement(roomElement));
        }

        return client;
    }

    private static String getElementTextContent(Element element, String elementName) {
        var nList = element.getElementsByTagName(elementName);
        var node = nList.item(0);
        return node.getTextContent();
    }

    private Room getRoomElement(Element element) {
        var room = new Room();

        try {
            room.setPrice(Double.parseDouble(getElementTextContent(element, ROOM_PRICE)));
        } catch (Exception ex) {
            throw new IllegalArgumentException("'" + ROOM_PRICE + "'" + "item incorrect.");
        }

        try {
            room.setNumberOfRoom(Integer.parseInt(getElementTextContent(element, ROOM_NUMBER)));
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("'" + ROOM_NUMBER + "'" + "incorrect");
        }

        return room;
    }

    private Element getClientElement(Document document, Client client) {
        var clientElement = document.createElement(CLIENT);

        var idElement = document.createElement(ID);
        idElement.appendChild(document.createTextNode(Integer.toString(client.getId())));

        var firstNameElement = document.createElement(FIRST_NAME);
        firstNameElement.appendChild(document.createTextNode(client.getName()));

        var lastNameElement = document.createElement(LAST_NAME);
        lastNameElement.appendChild(document.createTextNode(client.getSurname()));

        var phoneElement = document.createElement(PHONE);
        phoneElement.appendChild(document.createTextNode(client.getMobilePhone()));


        clientElement.appendChild(idElement);
        clientElement.appendChild(firstNameElement);
        clientElement.appendChild(lastNameElement);
        clientElement.appendChild(phoneElement);

        if (client.getRoom() != null) {
            clientElement.appendChild(getRoomElement(document, client.getRoom()));
        }

        return clientElement;
    }

    private Element getRoomElement(Document document, Room room) {
        var roomElement = document.createElement(ROOM);

        var numberElement = document.createElement(ROOM_NUMBER);
        numberElement.appendChild(document.createTextNode(Integer.toString(room.getNumberOfRoom())));

        var isFreeElement = document.createElement(ROOM_PRICE);
        isFreeElement.appendChild(document.createTextNode(Double.toString(room.getPrice())));

        roomElement.appendChild(numberElement);
        roomElement.appendChild(isFreeElement);

        return roomElement;
    }

    private void validateXMLByXSD(File xml, File xsd) throws XmlParserException {
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator()
                    .validate(new StreamSource(xml));
        } catch (Exception e) {
            throw new XmlParserException("Invalid xml format");
        }
    }
}
