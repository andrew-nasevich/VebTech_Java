package by.BSUIR.Hotel;
import by.BSUIR.Hotel.Compare.CompareByPrice;
import by.BSUIR.Hotel.Compare.CompareBySurname;
import by.BSUIR.Hotel.Controller.Controller;
import by.BSUIR.Hotel.DAO.DAOClients;
import by.BSUIR.Hotel.Presentation.OutputToScreen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;

public class Main {

    private static ArrayList<Client> clients = new ArrayList<Client>();


    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

	    System.out.println("Welcome to Hotel!");

	    System.out.println("Choose menu point:");
	    int command = -1;
	    int counter = 0;
	    while (command!=0) {
            System.out.println("1-Book a room\n" +
                               "2-Admin\n" +
                               "0-exit");
            command = in.nextInt();

            if (command == 1) {

                System.out.println("Name:");
                String name = in.next();

                System.out.println("Surname:");
                String surname = in.next();

                System.out.println("Mobile number:");
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

                    System.out.println("Available Superior rooms: 14, 15, 17, 19");
                    System.out.println("Number of room:");
                    number = in.nextInt();

                    System.out.println("Number of beds:");
                    beds = in.nextInt();

                    System.out.println("Do you want bar in your room? (1-yes, 0-no)");
                    Boolean bar;
                    if (in.nextInt() == 1){
                        bar = true;
                        price = price + 1.55;
                    }
                    else
                        bar = false;

                    System.out.println("Do you want air conditioning in your room? (1-yes, 0-no)");
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
                }
                else if(roomcommand == 2){
                    price = 65.50;

                    System.out.println("Available Suite rooms: 22, 26, 27, 29");
                    System.out.println("Number of room:");
                    number = in.nextInt();

                    System.out.println("Number of beds:");
                    beds = in.nextInt();

                    System.out.println("Do you want bar in your room? (1-yes, 0-no)");
                    Boolean bar;
                    if (in.nextInt() == 1){
                        bar = true;
                        price = price + 1.55;
                    }
                    else
                        bar = false;

                    System.out.println("Count of apartments:");
                    int countap = in.nextInt();

                    room = new Suite(price, number, beds,bar,countap);
                    Client client = new Client(name, surname,mobile,price,room);
                    clients.add(counter,client);
                    DAOClients.AddInClientBase(client);
                }
                else if(roomcommand == 3){
                    price = 105.70;

                    System.out.println("Available Studio rooms: 34, 36, 38");
                    System.out.println("Number of room:");
                    number = in.nextInt();

                    System.out.println("Number of beds:");
                    beds = in.nextInt();

                    System.out.println("Do you want kitchen in your room? (1-yes, 0-no)");
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
                }
                else if(roomcommand == 4){
                    price = 175.70;
                    System.out.println("Available Studio rooms: 1, 3, 6, 7, 9");
                    System.out.println("Number of room:");
                    number = in.nextInt();

                    System.out.println("Number of beds:");
                    beds = in.nextInt();

                    System.out.println("Do you want pool? (1-yes, 0-no)");
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
                }
                counter = counter + 1;

            }
            else if(command == 2){
                Comparator<Client> comp;
                String clName;
                String clSurname;
                String clNumber;
                ArrayList<Client> clientsFromBase = Controller.GetAllClientsInList();
                System.out.println("1-Показать список клиентов\n" +
                                    "2-Найти клиента по фамилии\n" +
                                    "3-Найти клиента по номеру телефона\n" +
                                    "4-Удалить клиента\n" +
                                    "5-Отсортировать по фамилии\n" +
                                    "6-Отсортировать по цене брони\n");
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
                }


            }

        }



    }
}
