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
            Client client = new Client(records.get(i), records.get(i + 1), records.get(i + 2), Double.parseDouble(records.get(i + 3)), new Room(Double.parseDouble(records.get(i + 4)),Integer.parseInt(records.get(i+5)),Integer.parseInt(records.get(i + 6))));
            clients.add(index,client);
            i += 7;
            index+=1;
        }
        return clients;
    }

    //Поиск по фамилии и имени
    public static void FindClientInBase(String name, String surname,ArrayList<Client> base){
        String result;
        for (Client cl : base)
        {
            if (cl.getName().equals(name)&&cl.getSurname().equals(surname)){
                result = cl.getName()+" "+cl.getSurname()+" есть в базе клиентов.";
                System.out.println(result);
                return;
            }

            else{
                result =  cl.getName()+" "+cl.getSurname()+" отсутствует в базе.";
                System.out.println(result);
                return;
            }
        }
        return;

    }

    //Поиск по номеру телефона
    public static void FindClientInBase(String phone,ArrayList<Client> base){
        String result;
        for (Client cl : base)
        {
            if (cl.getMobilePhone().equals(phone)){
                result = cl.getName()+" "+cl.getSurname()+" есть в базе клиентов.";
                System.out.println(result);
                return;
            }

            else{
                result =  cl.getName()+" "+cl.getSurname()+" отсутствует в базе.";
                System.out.println(result);
                return;
            }
        }
        return;
    }

    public static void DeleteClient(String phone,ArrayList<Client> base) throws IOException {
        for (Client cl : base)
        {
            if (cl.getMobilePhone().equals(phone)) {
                base.remove(cl);
                System.out.println("Клиент "+cl.getName()+" "+cl.getSurname()+" с номером телефона "+cl.getMobilePhone()+"успешно удален");
                DAOClients.AddAllListInFile(base);
                return;
            }
            else {
                System.out.println("Клиента с таким номером в базе не существует");
                return;
            }
        }

        return;
    }


}
