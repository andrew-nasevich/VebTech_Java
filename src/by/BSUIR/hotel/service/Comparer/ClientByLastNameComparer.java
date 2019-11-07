package by.BSUIR.hotel.service.Comparer;


import by.BSUIR.hotel.bean.Client;
import by.BSUIR.hotel.service.Finder;

import java.util.Comparator;

/**
 * The type Client by last name comparer.
 */
public class ClientByLastNameComparer implements Comparator<Client>, Finder<Client> {
    @Override
    public boolean isFound(Client obj, Client value) {
        return obj.getSurname().equals(value.getSurname());
    }

    @Override
    public int compare(Client o1, Client o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}