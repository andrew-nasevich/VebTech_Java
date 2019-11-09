package by.BSUIR.hotel.dao;

import by.BSUIR.hotel.bean.Client;
import by.BSUIR.hotel.parser.*;

import java.util.List;

/**
 * The type Dao client.
 */
public class DaoClient implements Dao<Client> {
    private static final String NOT_EXIST = "This client isn't exist";
    private static final String EXIST = "This client in exist";
    private static final String IS_NULL = "Clients is null";

    private ClientXmlParser xmlParser;

    /**
     * Instantiates a new Dao client.
     */
    public DaoClient() {
    }

    /**
     * Instantiates a new Dao client.
     *
     * @param clientXmlParser the client xml parser
     */
    public DaoClient(ClientXmlParser clientXmlParser) {
        this.xmlParser = clientXmlParser;
    }

    public List<Client> getAll() throws XmlParserException {
        return xmlParser.getData();
    }

    @Override
    public void delete(Client obj) throws DaoException {
        Boolean isInList = false;
        List<Client> clients;

        try {
            clients = xmlParser.getData();
        } catch (XmlParserException e) {
            throw new DaoException(e.getMessage());
        }

        for (int i = 0; i<clients.size();i++) {
            if (clients.get(i).getMobilePhone().equals(obj.getMobilePhone())) {
                clients.remove(i);
                isInList = true;
            }
        }

        if (isInList) {
            try {
                xmlParser.setData(clients);
            } catch (XmlParserException e) {
                throw new DaoException(e.getMessage());
            }

            return;
        }

        throw new DaoException(NOT_EXIST);
    }

    @Override
    public void add(Client obj) throws DaoException {
        if (obj == null) {
            throw new DaoException(IS_NULL);
        }

        var clients = xmlParser.getData();

        for (Client cl : clients) {
            if (cl.getMobilePhone().equals(obj.getMobilePhone())) {
                throw new DaoException(EXIST);
            }
        }
        clients.add(obj);
        xmlParser.setData(clients);
    }

    @Override
    public Client get(int id) throws DaoException, XmlParserException {
        return xmlParser.getData().stream().filter(x -> x.getId() == id).findFirst()
                .orElseThrow(() -> new DaoException(NOT_EXIST));
    }

    @Override
    public void addRange(List<Client> items) throws DaoException, XmlParserException {
        if (items == null) {
            throw new DaoException(IS_NULL);
        }

        var clients = xmlParser.getData();
        var stream = clients.stream();

        if (items.stream().anyMatch(x -> stream.anyMatch(z -> z.equals(x)))) {
            throw new DaoException(EXIST);
        }

        clients.addAll(items);
        xmlParser.setData(clients);
    }

    public void addSort(List<Client> clients) throws DaoException {
        xmlParser.setData(clients);
    }

    public void findByNameAndSurname(String name, String surname){
        String result;
        Boolean isInList=true;
        var clients = xmlParser.getData();
        for (Client cl : clients)
        {
            if (cl.getName().equals(name)&&cl.getSurname().equals(surname)){
                isInList=true;
                result = cl.getName()+" "+cl.getSurname()+" с номером телефона "+cl.getMobilePhone()+" есть в базе клиентов.";
                System.out.println(result);
            }
            else
                isInList=false;
        }

        if(isInList==false){
            result =  name+" "+surname+" отсутствует в базе.";
            System.out.println(result);
        }
        return;
    }

    public void findByRoom(int roomNumber){
        String result;
        Boolean isInList=true;
        var clients = xmlParser.getData();
        for (Client cl : clients)
        {
            if (cl.getRoom().getNumberOfRoom()==roomNumber){
                isInList=true;
                result = cl.getName()+" "+cl.getSurname()+" с номером телефона "+cl.getMobilePhone()+" проживает в "+ roomNumber;
                System.out.println(result);
                return;
            }
            else
                isInList=false;
        }

        if(isInList==false){
            result =  "Номер свободен";
            System.out.println(result);
        }
        return;

    }
}
