package by.BSUIR.Hotel.Presentation;

import by.BSUIR.Hotel.Bean.*;
import by.BSUIR.Hotel.Compare.CompareByPrice;
import by.BSUIR.Hotel.Compare.CompareBySurname;
import by.BSUIR.Hotel.Controller.Controller;
import by.BSUIR.Hotel.DAO.DAOClients;
import by.BSUIR.Hotel.DAO.DAOHotelRooms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class HotelWork {
    private static ArrayList<Client> clients = new ArrayList<Client>();
    public static void Start() throws IOException {
        int[][] hotelRooms = {{0,1,2,3,4,5,6,7,8,9},
                {10,11,12,13,14,15,16,17,18,19},
                {20,21,22,23,24,25,26,27,28,29},
                {30,31,32,33,34,35,36,37,38,39}};

        Scanner in = new Scanner(System.in);

        System.out.println("Добро пожаловать в отель!");

        System.out.println("Меню:");
        int command = -1;
        int counter = 0;
        while (command!=0) {
            System.out.println("1-Забронировать номер\n" +
                    "2-Администратор\n" +
                    "0-ВЫХОД");
            command = in.nextInt();

            if (command == 1) {
                hotelRooms = DAOHotelRooms.LoadArrayFromFile();

                System.out.println("Имя:");
                String name = in.next();

                System.out.println("Фамилия:");
                String surname = in.next();

                System.out.println("Номер телефона:");
                String mobile = in.next();

                Room room;
                double price;
                int number;
                int beds;

                System.out.println("1-Superior\n" +
                        "2-Suite\n" +
                        "3-Studio\n" +
                        "4-Bungalo");
                int roomcommand = in.nextInt();

                if(roomcommand == 1){
                    price = 45.50;

                    System.out.print("Свободные Superior номера: ");
                    Controller.FindAvailableRooms(hotelRooms[1]);

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
                    Client client = new Client(name, surname,mobile,price,room);
                    clients.add(counter,client);
                    DAOClients.AddInClientBase(client);
                    hotelRooms = Controller.UpdateHotelRooms(number,hotelRooms);
                }
                else if(roomcommand == 2){
                    price = 65.50;

                    System.out.print("Свободные Suite номера:");
                    Controller.FindAvailableRooms(hotelRooms[2]);

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
                    Client client = new Client(name, surname,mobile,price,room);
                    clients.add(counter,client);
                    DAOClients.AddInClientBase(client);
                    hotelRooms = Controller.UpdateHotelRooms(number,hotelRooms);
                }
                else if(roomcommand == 3){
                    price = 105.70;

                    System.out.print("Свободные Studio номера: ");
                    Controller.FindAvailableRooms(hotelRooms[3]);

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
                    Client client = new Client(name, surname,mobile,price,room);
                    clients.add(counter,client);
                    DAOClients.AddInClientBase(client);
                    hotelRooms = Controller.UpdateHotelRooms(number,hotelRooms);
                }
                else if(roomcommand == 4){
                    price = 175.70;
                    System.out.print("Свободные Bungalo номера: ");
                    Controller.FindAvailableRooms(hotelRooms[0]);

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
                    Client client = new Client(name, surname,mobile,price,room);
                    clients.add(counter,client);
                    DAOClients.AddInClientBase(client);
                    hotelRooms = Controller.UpdateHotelRooms(number,hotelRooms);
                }
                counter = counter + 1;

            }
            else if(command == 2){
                Comparator<Client> comp;
                String clName;
                String clSurname;
                String clNumber;
                Double clCheque;
                ArrayList<Client> clientsFromBase = Controller.GetAllClientsInList();

                System.out.println("1-Показать список клиентов\n" +
                        "2-Найти клиента по фамилии\n" +
                        "3-Найти клиента по номеру телефона\n" +
                        "4-Удалить клиента\n" +
                        "5-Отсортировать по фамилии\n" +
                        "6-Отсортировать по цене брони\n"+
                        "7-Редактировать платежный чек\n");
                int adminCommand = in.nextInt();
                switch (adminCommand){
                    case 1:
                        OutputToScreen.OutputToScreenFromFile();
                        break;
                    case 2:
                        System.out.println("Имя:");
                        clName = in.next();
                        System.out.println("Фамилия:");
                        clSurname = in.next();
                        Controller.FindClientInBase(clName,clSurname,clientsFromBase);
                        break;
                    case 3:
                        System.out.println("Номер телефона:");
                        clNumber = in.next();
                        Controller.FindClientInBase(clNumber,clientsFromBase);
                        break;
                    case 4:
                        System.out.println("Номер телефона:");
                        clNumber = in.next();
                        Controller.DeleteClient(clNumber,clientsFromBase);
                        break;
                    case 5:
                        comp = new CompareBySurname();
                        clientsFromBase.sort(comp);
                        OutputToScreen.OutputToScreenFromList(clientsFromBase);
                        break;
                    case 6:
                        comp = new CompareByPrice();
                        clientsFromBase.sort(comp);
                        OutputToScreen.OutputToScreenFromList(clientsFromBase);
                        break;
                    case 7:
                        System.out.println("Имя:");
                        clName = in.next();
                        System.out.println("Фамилия:");
                        clSurname = in.next();
                        System.out.println("Номер телефона:");
                        clNumber = in.next();
                        System.out.println("Новый чек:");
                        clCheque = in.nextDouble();
                        Controller.RedactPayCheque(clName,clSurname,clNumber,clCheque,clientsFromBase);
                        break;
                }


            }

        }

    }
}
