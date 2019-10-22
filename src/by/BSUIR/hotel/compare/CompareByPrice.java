package by.BSUIR.hotel.compare;

import by.BSUIR.hotel.bean.Client;

import java.util.Comparator;

public class CompareByPrice implements Comparator<Client> {
    public int compare(Client a, Client b){
        return Double.compare(a.getPayCheque(),b.getPayCheque());
    }
}
