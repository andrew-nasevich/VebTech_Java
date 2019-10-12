package by.BSUIR.Hotel.Controller;

import by.BSUIR.Hotel.Client;
import by.BSUIR.Hotel.DAO.DAOClients;
import by.BSUIR.Hotel.Room;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    //Создать список клиентов
    public static ArrayList<Client> GetAllClientsInList() throws IOException {
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<String> records = DAOClients.ReadFromClientBase();
        int i = 0;
        int index = 0;
        while (i < records.size()) {
            clients.add(index,new Client(records.get(i), records.get(i + 1), records.get(i + 2), Double.parseDouble(records.get(i + 3)), Integer.parseInt(records.get(i + 4))));
            i += 5;
            index+=1;
        }
        return clients;
    }

    //Поиск по фамилии и имени
    public static void FindClientInBase(String name, String surname,ArrayList<Client> base){
        String result = "База пуста.";
        Client finder = new Client(name,surname);
        for (Client cl : base)
        {
            if (cl.getSurname().equals(finder.getSurname()))
                result = name+" "+surname+" есть в базе клиентов.";

            else
                result =  name+" "+surname+" отсутствует в базе.";
        }
        System.out.println(result);
    }

    //Поиск по номеру телефона
    public static String FindClientInBase(String phone,ArrayList<Client> base){
        String result = "База пуста.";
        for (Client cl : base)
        {
            if (cl.getMobilePhone()==phone)
                result = cl.getName()+" "+cl.getSurname()+" есть в базе клиентов. Снимает номер " + cl.getRoom().getNumberOfRoom();

            else
                result =  cl.getName()+" "+cl.getSurname()+" отсутствует в базе.";
        }
        return result;
    }

    public static void DeleteClient(String phone,ArrayList<Client> base){
        for (Client cl : base)
        {
            if (cl.getMobilePhone()==phone)
                base.remove(cl);
        }
    }


}
