package by.BSUIR.hotel.controller;

import by.BSUIR.hotel.bean.Client;
import by.BSUIR.hotel.dao.DAOClients;
import by.BSUIR.hotel.dao.DAOHotelRooms;
import by.BSUIR.hotel.bean.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    //Создать список клиентов
    public List<Client> getAllClientsInList() throws IOException {
        DAOClients daoclients = new DAOClients();
        List<Client> clients = new ArrayList<>();
        List<String> records = daoclients.readFromClientBase();
        if(records!=null){
            int i = 0;
            int index = 0;
            while (i < records.size()) {
                Client client = new Client(records.get(i), records.get(i + 1), records.get(i + 2), Double.parseDouble(records.get(i + 3)), new Room(Double.parseDouble(records.get(i + 4)),Integer.parseInt(records.get(i+5)),Integer.parseInt(records.get(i + 6))));
                clients.add(index,client);
                i += 7;
                index+=1;
            }
        }
        return clients;
    }

    public void redactPayCheque(String name, String surname, String phone, Double newCheque, List<Client> base) throws IOException {
        DAOClients daoclients = new DAOClients();
        Boolean isInList=true;
        for (Client cl : base)
        {
            if (cl.getName().equals(name)&&cl.getSurname().equals(surname)&&cl.getMobilePhone().equals(phone)){
                isInList=true;
                cl.setPayCheque(newCheque);
                System.out.println("Новый чек клиента "+cl.getName()+" "+cl.getSurname()+" c номеров телефона "+cl.getMobilePhone()+": "+cl.getPayCheque());
                daoclients.addAllListInFile(base);
                return;
            }
            else
                isInList=false;
        }

        if(isInList==false)
            System.out.println(name+" "+surname+" отсутствует в базе.");

        return;
    }

    //Поиск по фамилии и имени
    public void findClientInBase(String name, String surname,List<Client> base){
        String result;
        Boolean isInList=true;
        for (Client cl : base)
        {
            if (cl.getName().equals(name)&&cl.getSurname().equals(surname)){
                isInList=true;
                result = cl.getName()+" "+cl.getSurname()+" с номером телефона "+cl.getMobilePhone()+" есть в базе клиентов.";
                System.out.println(result);
            }
            else
                isInList=false;
        }

        if(isInList==false){
            result =  name+" "+surname+" отсутствует в базе.";
            System.out.println(result);
        }
        return;

    }

    //Поиск по номеру телефона
    public void findClientInBase(String phone,List<Client> base){
        String result;
        Boolean isInList=true;
        for (Client cl : base)
        {
            if (cl.getMobilePhone().equals(phone)){
                isInList=true;
                result = cl.getName()+" "+cl.getSurname()+" есть в базе клиентов.";
                System.out.println(result);
                return;
            }

            else
                isInList = false;
        }
        if(isInList==false){
            result =  "Клиент с таким номером телефона отсутствует в базе.";
            System.out.println(result);
        }
        return;
    }

    private Client findDeleteClient(String phone,List<Client> base){
        for (Client cl : base) {
            if (cl.getMobilePhone().equals(phone)) {
                return  cl;
            }
        }
        return null;
    }

    private void findRoomDeleteClient(int numOfRoom){
        DAOHotelRooms daorooms = new DAOHotelRooms();
        int [][] baseForSearch = daorooms.loadArrayFromFile();
        int indI;
        int indJ;
        indI = numOfRoom/10;
        indJ = numOfRoom%10;
        baseForSearch[indI][indJ]=numOfRoom;
        daorooms.saveArrayToFile(baseForSearch);
    }

    public void deleteClient(String phone,List<Client> base) throws IOException {
        DAOClients daoclients = new DAOClients();
        Boolean isInList = true;
        Client cl = findDeleteClient(phone,base);
            if (cl!=null) {
                isInList = true;
                base.remove(cl);
                findRoomDeleteClient(cl.getRoom().getNumberOfRoom());
                System.out.println("Клиент "+cl.getName()+" "+cl.getSurname()+" с номером телефона "+cl.getMobilePhone()+" успешно удален");
            }
            else
                isInList = false;

        if(isInList==false)
            System.out.println("Клиента с таким номером в базе не существует");
        else
            daoclients.addAllListInFile(base);
        return;
    }

    public void findAvailableRooms(int[] level){
        int j = 0;
        String availableRooms = "";
        for (int i = 0; i < level.length; i++){
            if (level[i]!=0)
                availableRooms = availableRooms + String.valueOf(level[i]) + " ";
        }
        if (availableRooms == "")
            System.out.println("Нет свободных номеров в этом классе.");
        else
            System.out.println(availableRooms);
    }

    public int[][] updateHotelRooms(int reserve, int[][] hotelRooms){
        DAOHotelRooms daorooms = new DAOHotelRooms();
        for (int i = 0; i<4;i++){
            for (int j = 0; j<10; j++){
                if(hotelRooms[i][j] == reserve)
                    hotelRooms[i][j] = 0;
            }
        }
        daorooms.saveArrayToFile(hotelRooms);
        return hotelRooms;
    }

}
