package by.BSUIR.hotel.service.Comparer;



import by.BSUIR.hotel.bean.Client;
import by.BSUIR.hotel.service.Finder;

import java.util.Comparator;

/**
 * The type Client by first name comparer.
 */
public class ClientByFirstNameComparer implements Comparator<Client>, Finder<Client> {
    @Override
    public boolean isFound(Client obj, Client value) {
        return obj.getName().equals(value.getName());
    }

    @Override
    public int compare(Client o1, Client o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
