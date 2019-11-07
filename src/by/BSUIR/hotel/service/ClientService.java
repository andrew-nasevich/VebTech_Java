package by.BSUIR.hotel.service;



import by.BSUIR.hotel.bean.Client;
import by.BSUIR.hotel.dao.DaoClient;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Client service.
 */
public class ClientService implements Service<Client> {
    private static final String NOT_FOUND = "Client not found.";

    private DaoClient daoClient;

    /**
     * Instantiates a new Client service.
     *
     * @param daoClient the dao client
     */
    public ClientService(DaoClient daoClient) {
        this.daoClient = daoClient;
    }

    @Override
    public void create(Client item) throws ServiceException {
        if (item == null) {
            throw new ServiceException(NOT_FOUND);
        }

        if (daoClient.getAll().stream().anyMatch(x -> x.equals(item))) {
            throw new ServiceException("Client is exist");
        }

        daoClient.add(item);
    }

    @Override
    public Client read(int id) {
        return daoClient.get(id);
    }

    @Override
    public void update(Client item) {
        for (var x : daoClient.getAll()) {
            if (x.getId() == item.getId()) {
                daoClient.delete(x);
                daoClient.add(item);
                return;
            }
        }

        throw new ServiceException(NOT_FOUND);
    }

    @Override
    public void delete(int id) {
        daoClient.delete(daoClient.get(id));
    }

    @Override
    public void sort(Comparator<Client> comparator) {
        if (comparator == null) {
            throw new ServiceException("Comparator is null.");
        }

        var clients = daoClient.getAll();
        clients.sort(comparator);
    }

    @Override
    public List<Client> find(Finder<Client> finder, Client value) throws ServiceException {
        if (finder == null) {
            throw new ServiceException("Finder is null.");
        }

        if (value == null) {
            throw new ServiceException("Value is null.");
        }

        return daoClient.getAll().stream().filter(x -> finder.isFound(x, value)).collect(Collectors.toList());
    }

    @Override
    public List<Client> getAll() {
        return daoClient.getAll();
    }
}
