package by.BSUIR.hotel.service.Comparer;

import by.BSUIR.hotel.bean.Client;
import by.BSUIR.hotel.service.Finder;

import java.util.Comparator;

/**
 * The type Client by id comparer.
 */
public class ClientByIdComparer implements Comparator<Client>, Finder<Client> {
    @Override
    public boolean isFound(Client obj, Client value) {
        return value.getId() == obj.getId();
    }

    @Override
    public int compare(Client o1, Client o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
