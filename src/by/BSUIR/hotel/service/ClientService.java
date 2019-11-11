package by.BSUIR.hotel.service;


import by.bsuir.DBController;
import by.BSUIR.hotel.bean.Client;
//import by.BSUIR.hotel.controller.DBController;
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
        List<Client> clients = daoClient.getAll();
        if (item == null) {
            throw new ServiceException(NOT_FOUND);
        }

        if (clients.contains(item)) {
            throw new ServiceException("Client is exist");
        }
        daoClient.add(item);
        DBController dbcontroller = new DBController();
        dbcontroller.addInDB(item.getId(),item.getName(),item.getSurname(),item.getMobilePhone(),item.getRoom().getNumberOfRoom(),item.getRoom().getPrice());
        //dbcontroller.addInDB(item);
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
                DBController dbcontroller = new DBController();
                dbcontroller.updateInDB(item.getId(),item.getSurname());
                //dbcontroller.updateInDB(item);
                return;
            }
        }

        throw new ServiceException(NOT_FOUND);
    }

    @Override
    public void delete(int id) {
        daoClient.delete(daoClient.get(id));
        DBController dbcontroller = new DBController();
        dbcontroller.deleteFromDB(id);
        //dbcontroller.deleteFromDB(id);
    }

    @Override
    public void sort(Comparator<Client> comparator) {
        if (comparator == null) {
            throw new ServiceException("Comparator is null.");
        }

        var clients = daoClient.getAll();
        clients.sort(comparator);
        daoClient.addSort(clients);
    }


    @Override
    public List<Client> getAll() {
        return daoClient.getAll();
    }

    public void findClientInBase(String name, String surname){
       daoClient.findByNameAndSurname(name, surname);
    }

    public void findClientInBase(int roomNumber){
        daoClient.findByRoom(roomNumber);
    }
}
