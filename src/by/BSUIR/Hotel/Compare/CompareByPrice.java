package by.BSUIR.Hotel.Compare;

import by.BSUIR.Hotel.Bean.Client;

import java.util.Comparator;

public class CompareByPrice implements Comparator<Client> {
    public int compare(Client a, Client b){
        return Double.compare(a.getPayCheque(),b.getPayCheque());
    }
}
