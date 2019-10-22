package by.BSUIR.hotel.presentation;

import by.BSUIR.hotel.bean.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OutputToScreen {

    public void outputToScreenFromFile(){
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

    public void outputToScreenFromList(List<Client> clients){

        for(Client cl:clients) {
            System.out.println(cl.getName()+" "+cl.getSurname()+" "+cl.getMobilePhone()+" "+cl.getPayCheque()+" "+cl.getRoom().getNumberOfRoom());
        }
    }
}
