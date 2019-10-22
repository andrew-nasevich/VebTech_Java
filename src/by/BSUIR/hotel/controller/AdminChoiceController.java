package by.BSUIR.hotel.controller;

import by.BSUIR.hotel.bean.Client;
import by.BSUIR.hotel.compare.CompareByPrice;
import by.BSUIR.hotel.compare.CompareBySurname;
import by.BSUIR.hotel.presentation.OutputToScreen;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AdminChoiceController {
    public void adminChoices() throws IOException {
        Scanner in = new Scanner(System.in);
        Controller controller = new Controller();
        OutputToScreen output = new OutputToScreen();
        Comparator<Client> comp;

        String clName;
        String clSurname;
        String clNumber;
        Double clCheque;

        List<Client> clientsFromBase = controller.getAllClientsInList();

        int adminCommand = in.nextInt();
        switch (adminCommand){
            //Output list of client to screen
            case 1:
                output.outputToScreenFromFile();
                break;

            //find client by surname
            case 2:
                System.out.println("Имя:");
                clName = in.next();
                System.out.println("Фамилия:");
                clSurname = in.next();
                controller.findClientInBase(clName,clSurname,clientsFromBase);
                break;

            //find client by phone number
            case 3:
                System.out.println("Номер телефона:");
                clNumber = in.next();
                controller.findClientInBase(clNumber,clientsFromBase);
                break;

            //delete client from list
            case 4:
                System.out.println("Номер телефона:");
                clNumber = in.next();
                controller.deleteClient(clNumber,clientsFromBase);
                break;

            //sort by surname
            case 5:
                comp = new CompareBySurname();
                clientsFromBase.sort(comp);
                output.outputToScreenFromList(clientsFromBase);
                break;

            //sort by pay cheque
            case 6:
                comp = new CompareByPrice();
                clientsFromBase.sort(comp);
                output.outputToScreenFromList(clientsFromBase);
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
                controller.redactPayCheque(clName,clSurname,clNumber,clCheque,clientsFromBase);
                break;
        }
    }
}
