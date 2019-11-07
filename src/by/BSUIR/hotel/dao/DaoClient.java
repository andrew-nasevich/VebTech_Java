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
        List<Client> clients;

        try {
            clients = xmlParser.getData();
        } catch (XmlParserException e) {
            throw new DaoException(e.getMessage());
        }

        var stream = clients.stream().filter(x -> x.equals(obj));

        if (stream.count() != 0) {
            clients.remove(obj);

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

        if (clients.stream().anyMatch(x -> x.equals(obj))) {
            throw new DaoException(EXIST);
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
}
