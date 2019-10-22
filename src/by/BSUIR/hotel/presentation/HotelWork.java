package by.BSUIR.hotel.presentation;

import by.BSUIR.hotel.controller.AdminChoiceController;
import by.BSUIR.hotel.controller.UserChoiceController;

import java.io.IOException;
import java.util.*;

public class HotelWork {

    public void start() throws IOException {

        UserChoiceController userChoiceController = new UserChoiceController();
        AdminChoiceController adminChoiceController = new AdminChoiceController();
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
                userChoiceController.userChoices();
            }
            //admin's action
            else if(command == 2){

                System.out.println("1-Показать список клиентов\n" +
                        "2-Найти клиента по имени и фамилии\n" +
                        "3-Найти клиента по номеру телефона\n" +
                        "4-Удалить клиента\n" +
                        "5-Отсортировать по фамилии\n" +
                        "6-Отсортировать по цене брони\n"+
                        "7-Редактировать платежный чек\n");
                adminChoiceController.adminChoices();
            }

        }

    }
}
