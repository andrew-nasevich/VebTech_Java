package by.BSUIR.Hotel.Compare;

import by.BSUIR.Hotel.Client;

import java.util.Comparator;
public class CompareBySurname implements Comparator<Client> {
    public int compare(Client a, Client b){
        return a.getSurname().compareTo(b.getSurname());
    }
}

