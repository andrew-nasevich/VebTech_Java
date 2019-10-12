package by.BSUIR.Hotel.Presentation;

import by.BSUIR.Hotel.Client;

import java.io.*;
import java.util.ArrayList;

public class OutputToScreen {

    public static void OutputToScreenFromFile(){
        System.out.println("Hotel's clients:");

        try {
            File file = new File("clients.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            int i = 0;
            while (line != null) {
                i+=1;
                System.out.println(line);
                if (i%7==0)
                    System.out.println("---------------------");
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void OutputToScreenFromList(ArrayList<Client> clients){

        for(Client cl:clients) {
            System.out.println(cl.getName()+" "+cl.getSurname()+" "+cl.getMobilePhone()+" "+cl.getPayCheque()+" "+cl.getRoom().getNumberOfRoom());
        }
    }
}
