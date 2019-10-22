package by.BSUIR.hotel.controller;

import by.BSUIR.hotel.bean.*;
import by.BSUIR.hotel.dao.*;

import java.io.IOException;
import java.util.Scanner;

public class UserChoiceController {
    public void userChoices() throws IOException {
        //if file with rooms is empty array of room initialize here
        int[][] hotelRooms = {{0,1,2,3,4,5,6,7,8,9},
                {10,11,12,13,14,15,16,17,18,19},
                {20,21,22,23,24,25,26,27,28,29},
                {30,31,32,33,34,35,36,37,38,39}};

        Scanner in = new Scanner(System.in);
        DAOClients daoclients = new DAOClients();
        DAOHotelRooms daorooms = new DAOHotelRooms();
        Controller controller = new Controller();
        Client client = new Client();
        //if file with hotel rooms is not empty load from this file
        if (daorooms.loadArrayFromFile()!=null)
            hotelRooms = daorooms.loadArrayFromFile();

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
            controller.findAvailableRooms(hotelRooms[1]);

            System.out.println("Нет подходящего номера? Хотите выбрать в другом классе? 0-нет 1-да");
            if (in.nextInt()==1)
                return;

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
            daoclients.addInClientBase(client);
            hotelRooms = controller.updateHotelRooms(number,hotelRooms);
        }
        else if(roomcommand == 2){
            System.out.print("Свободные Suite номера:");
            controller.findAvailableRooms(hotelRooms[2]);

            System.out.println("Нет подходящего номера? Хотите выбрать в другом классе? 0-нет 1-да");
            if (in.nextInt()==1)
                return;

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
            daoclients.addInClientBase(client);
            hotelRooms = controller.updateHotelRooms(number,hotelRooms);
        }
        else if(roomcommand == 3){
            System.out.print("Свободные Studio номера: ");
            controller.findAvailableRooms(hotelRooms[3]);

            System.out.println("Нет подходящего номера? Хотите выбрать в другом классе? 0-нет 1-да");
            if (in.nextInt()==1)
                return;

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
            daoclients.addInClientBase(client);
            hotelRooms = controller.updateHotelRooms(number,hotelRooms);
        }
        else if(roomcommand == 4){
            System.out.print("Свободные Bungalo номера: ");
            controller.findAvailableRooms(hotelRooms[0]);

            System.out.println("Нет подходящего номера? Хотите выбрать в другом классе? 0-нет 1-да");
            if (in.nextInt()==1)
                return;

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
            daoclients.addInClientBase(client);
            hotelRooms = controller.updateHotelRooms(number,hotelRooms);
        }
    }
}
