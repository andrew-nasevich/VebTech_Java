package by.BSUIR.hotel;

import by.BSUIR.hotel.bean.*;
import by.BSUIR.hotel.compare.CompareById;
import by.BSUIR.hotel.controller.DBController;
import by.BSUIR.hotel.dao.DaoClient;
import by.BSUIR.hotel.parser.*;
import by.BSUIR.hotel.service.ClientService;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        ClientXmlParser clientParser = new ClientXmlParser("D:\\УНИВЕР\\3 курс\\WT_JAVA\\src\\by\\BSUIR\\hotel\\resources\\schemeXML.xml", "D:\\УНИВЕР\\3 курс\\WT_JAVA\\src\\by\\BSUIR\\hotel\\resources\\schemeXSD.xsd");
        ClientService clientService = new ClientService(new DaoClient(clientParser));

        clientService.getAll().forEach(x -> System.out.print(x.getId() + " "+x.getName()+">>"));
        System.out.println();





        System.out.println("Меню:");
        int command = -1;
        while (command!=0) {
            System.out.println("1-Добавить\n" +
                    "2-Редактировать\n" +
                    "3-Извлечь по индексу\n" +
                    "4-Удалить по id\n" +
                    "5-Отсортировать по id\n" +
                    "6-Найти по имени и фамилии\n"+
                    "7-Найти по комнате\n"+
                    "0-ВЫХОД");
            command = in.nextInt();
            Room room = new Room(35, 75.0);
            Client cl = new Client(3, "Luffy", "Monkey", "+375178401265",75.0, room);
            switch (command){
                case 1:
                    System.out.println("Create:");
                    clientService.create(cl);
                    break;

                case 2:
                    System.out.println("Update:");
                    cl.setSurname("Monkey D.");
                    clientService.update(cl);
                    clientService.getAll().forEach(x -> System.out.println(x.getId() + " - " + x.getSurname()));
                    break;

                case 3:
                    System.out.println("Read:");
                    Client client = clientService.read(1);
                    System.out.println(client.getId() + " - " + client.getName() + " " + client.getSurname() + " "+client.getMobilePhone()+
                            " "+client.getRoom().getNumberOfRoom()+" "+client.getRoom().getPrice());
                    break;

                case 4:
                    System.out.println("Delete:");
                    clientService.delete(3);
                    clientService.getAll().forEach(x -> System.out.println(x.getId()));
                    break;

                case 5:
                    System.out.println("Sort:");
                    clientService.sort(new CompareById());
                    break;

                case 6:
                    System.out.println("Find:");
                    clientService.findClientInBase("Zoro","Roronoa");
                    break;
                case 7:
                    System.out.println("Find:");
                    clientService.findClientInBase(105);
                    break;
            }
        }
    }
}
