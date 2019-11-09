package by.BSUIR.hotel.compare;

import by.BSUIR.hotel.bean.Client;

import java.util.Comparator;

public class CompareById implements Comparator<Client> {
    public int compare(Client a, Client b){
        return Integer.compare(a.getId(),b.getId());
    }
}
