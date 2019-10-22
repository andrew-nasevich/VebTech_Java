package by.BSUIR.hotel.presentation;

import by.BSUIR.hotel.bean.*;
import by.BSUIR.hotel.compare.CompareByPrice;
import by.BSUIR.hotel.compare.CompareBySurname;
import by.BSUIR.hotel.controller.Controller;
import by.BSUIR.hotel.dao.DAOClients;
import by.BSUIR.hotel.dao.DAOHotelRooms;

import java.io.IOException;
import java.util.*;

public class HotelWork {

    public void start() throws IOException {

        //if file with rooms is empty array of room initialize here
        int[][] hotelRooms = {{0,1,2,3,4,5,6,7,8,9},
                {10,11,12,13,14,15,16,17,18,19},
                {20,21,22,23,24,25,26,27,28,29},
                {30,31,32,33,34,35,36,37,38,39}};

        Scanner in = new Scanner(System.in);

        System.out.println("Добро пожаловать в отель!");

        //Output menu for choice
        System.out.println("Меню:");
        int command = -1;
        int counter = 0;
        while (command!=0) {
            //Choose start work like user or admin
            System.out.println("1-Забронировать номер\n" +
                    "2-Администратор\n" +
                    "0-ВЫХОД");
            command = in.nextInt();

            //user mode
            if (command == 1) {
                Client client = new Client();
                //if file with hotel rooms is not empty load from this file
                if (DAOHotelRooms.loadArrayFromFile()!=null)
                    hotelRooms = DAOHotelRooms.loadArrayFromFile();

                //main registration for user


                Room room;
                double price;
                int number;
                int beds;

                //choose type of room and initialize it in dependence by type
                System.out.println("1-Superior\n" +
                        "2-Suite\n" +
                        "3-Studio\n" +
                        "4-Bungalo");
                int roomcommand = in.nextInt();

                if(roomcommand == 1){
                    System.out.print("Свободные Superior номера: ");
                    Controller.findAvailableRooms(hotelRooms[1]);

                    System.out.println("Нет подходящего номера? Хотите выбрать в другом классе? 0-нет 1-да");
                    if (in.nextInt()==1)
                        continue;

                    System.out.println("Имя:");
                    client.setName(in.next());

                    System.out.println("Фамилия:");
                    client.setSurname(in.next());

                    System.out.println("Номер телефона:");
                    client.setMobilePhone(in.next());

                    price = 45.50;

                    System.out.println("Номер номера в отеле:");
                    number = in.nextInt();

                    System.out.println("Количество спальных мест:");
                    beds = in.nextInt();

                    System.out.println("Хотите ли вы бар? (1-да, 0-нет)");
                    Boolean bar;
                    if (in.nextInt() == 1){
                        bar = true;
                        price = price + 1.55;
                    }
                    else
                        bar = false;

                    System.out.println("Хотите ли вы кондиционер? (1-да, 0-нет)");
                    Boolean cond;
                    if (in.nextInt() == 1){
                        cond = true;
                        price = price + 1.00;
                    }
                    else
                        cond = false;

                    room = new Superior(price, number, beds,bar,cond);
                    client.setPayCheque(price);
                    client.setRoom(room);
                    DAOClients.addInClientBase(client);
                    hotelRooms = Controller.updateHotelRooms(number,hotelRooms);
                }
                else if(roomcommand == 2){
                    System.out.print("Свободные Suite номера:");
                    Controller.findAvailableRooms(hotelRooms[2]);

                    System.out.println("Нет подходящего номера? Хотите выбрать в другом классе? 0-нет 1-да");
                    if (in.nextInt()==1)
                        continue;

                    System.out.println("Имя:");
                    client.setName(in.next());

                    System.out.println("Фамилия:");
                    client.setSurname(in.next());

                    System.out.println("Номер телефона:");
                    client.setMobilePhone(in.next());

                    price = 65.50;

                    System.out.println("Номер номера в отеле:");
                    number = in.nextInt();

                    System.out.println("Количество спальных мест:");
                    beds = in.nextInt();

                    System.out.println("Хотите ли вы бар? (1-да, 0-нет)");
                    Boolean bar;
                    if (in.nextInt() == 1){
                        bar = true;
                        price = price + 1.55;
                    }
                    else
                        bar = false;

                    System.out.println("Количество комнат:");
                    int countap = in.nextInt();

                    room = new Suite(price, number, beds,bar,countap);
                    client.setPayCheque(price);
                    client.setRoom(room);
                    DAOClients.addInClientBase(client);
                    hotelRooms = Controller.updateHotelRooms(number,hotelRooms);
                }
                else if(roomcommand == 3){
                    System.out.print("Свободные Studio номера: ");
                    Controller.findAvailableRooms(hotelRooms[3]);

                    System.out.println("Нет подходящего номера? Хотите выбрать в другом классе? 0-нет 1-да");
                    if (in.nextInt()==1)
                        continue;

                    System.out.println("Имя:");
                    client.setName(in.next());

                    System.out.println("Фамилия:");
                    client.setSurname(in.next());

                    System.out.println("Номер телефона:");
                    client.setMobilePhone(in.next());

                    price = 105.70;


                    System.out.println("Номер номера в отеле:");
                    number = in.nextInt();

                    System.out.println("Количество спальных мест:");
                    beds = in.nextInt();

                    System.out.println("Хотите ли вы кухню? (1-да, 0-нет)");
                    Boolean kitchen;
                    if (in.nextInt() == 1){
                        kitchen = true;
                        price = price + 20.55;
                    }
                    else
                        kitchen = false;

                    room = new Studio(price, number, beds,kitchen);
                    client.setPayCheque(price);
                    client.setRoom(room);
                    DAOClients.addInClientBase(client);
                    hotelRooms = Controller.updateHotelRooms(number,hotelRooms);
                }
                else if(roomcommand == 4){
                    System.out.print("Свободные Bungalo номера: ");
                    Controller.findAvailableRooms(hotelRooms[0]);

                    System.out.println("Нет подходящего номера? Хотите выбрать в другом классе? 0-нет 1-да");
                    if (in.nextInt()==1)
                        continue;

                    System.out.println("Имя:");
                    client.setName(in.next());

                    System.out.println("Фамилия:");
                    client.setSurname(in.next());

                    System.out.println("Номер телефона:");
                    client.setMobilePhone(in.next());

                    price = 145.70;

                    System.out.println("Номер номера в отеле:");
                    number = in.nextInt();

                    System.out.println("Количество спальных мест:");
                    beds = in.nextInt();

                    System.out.println("Хотите ли вы бассейн? (1-да, 0-нет)");
                    Boolean pool;
                    if (in.nextInt() == 1){
                        pool = true;
                        price = price + 20.10;
                    }
                    else
                        pool = false;

                    room = new Bungalo(price, number, beds,pool);
                    client.setPayCheque(price);
                    client.setRoom(room);
                    DAOClients.addInClientBase(client);
                    hotelRooms = Controller.updateHotelRooms(number,hotelRooms);
                }
                counter = counter + 1;

            }
            //admin's action
            else if(command == 2){
                Comparator<Client> comp;
                String clName;
                String clSurname;
                String clNumber;
                Double clCheque;
                List<Client> clientsFromBase = Controller.getAllClientsInList();
                System.out.println("1-Показать список клиентов\n" +
                        "2-Найти клиента по имени и фамилии\n" +
                        "3-Найти клиента по номеру телефона\n" +
                        "4-Удалить клиента\n" +
                        "5-Отсортировать по фамилии\n" +
                        "6-Отсортировать по цене брони\n"+
                        "7-Редактировать платежный чек\n");
                int adminCommand = in.nextInt();
                switch (adminCommand){
                     //Output list of client to screen
                    case 1:
                        OutputToScreen.outputToScreenFromFile();
                        break;

                    //find client by surname
                    case 2:
                        System.out.println("Имя:");
                        clName = in.next();
                        System.out.println("Фамилия:");
                        clSurname = in.next();
                        Controller.findClientInBase(clName,clSurname,clientsFromBase);
                        break;

                    //find client by phone number
                    case 3:
                        System.out.println("Номер телефона:");
                        clNumber = in.next();
                        Controller.findClientInBase(clNumber,clientsFromBase);
                        break;

                     //delete client from list
                    case 4:
                        System.out.println("Номер телефона:");
                        clNumber = in.next();
                        Controller.deleteClient(clNumber,clientsFromBase);
                        break;

                    //sort by surname
                    case 5:
                        comp = new CompareBySurname();
                        clientsFromBase.sort(comp);
                        OutputToScreen.outputToScreenFromList(clientsFromBase);
                        break;

                     //sort by pay cheque
                    case 6:
                        comp = new CompareByPrice();
                        clientsFromBase.sort(comp);
                        OutputToScreen.outputToScreenFromList(clientsFromBase);
                        break;

                    //redact pay cheque
                    case 7:
                        System.out.println("Имя:");
                        clName = in.next();
                        System.out.println("Фамилия:");
                        clSurname = in.next();
                        System.out.println("Номер телефона:");
                        clNumber = in.next();
                        System.out.println("Новый чек:");
                        clCheque = in.nextDouble();
                        Controller.redactPayCheque(clName,clSurname,clNumber,clCheque,clientsFromBase);
                        break;
                }


            }

        }

    }
}
