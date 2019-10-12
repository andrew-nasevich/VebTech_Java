package by.BSUIR.Hotel.DAO;

import by.BSUIR.Hotel.Client;

import java.io.*;
import java.util.ArrayList;

public class DAOClients {

    public static void AddInClientBase(Client client) throws IOException {
        FileWriter fw = new FileWriter("clients.txt", true);

        try {
            fw.write(client.getName()+"\n"+client.getSurname()+"\n"+client.getMobilePhone()+"\n"+client.getPayCheque()+"\n"+client.getRoom().getPrice()+"\n"+client.getRoom().getNumberOfRoom()+"\n"+client.getRoom().getNumOfBeds()+"\n");
        }
        finally {
            fw.close();
        }
    }

    public static ArrayList<String> ReadFromClientBase() throws IOException {
        ArrayList<String> records = new ArrayList();
        String strName;
        String strSurname;
        String strPhone;
        String strPay;
        String strPrice;
        String strNumOfRoom;
        String strNumOfBeds;

        File f = new File("clients.txt");
        if(!f.exists())
        {
            f.createNewFile();
            return null;
        }

        FileReader fr = new FileReader("clients.txt");
        BufferedReader br = new BufferedReader(fr);

        try {
            do {
                strName = br.readLine();
                strSurname = br.readLine();
                strPhone = br.readLine();
                strPay = br.readLine();
                strPrice = br.readLine();
                strNumOfRoom = br.readLine();
                strNumOfBeds = br.readLine();

                if (strName != null && strSurname != null && strPhone != null && strPay != null && strNumOfRoom != null&& strPrice != null && strNumOfBeds != null)
                {
                    records.add(strName);
                    records.add(strSurname);
                    records.add(strPhone);
                    records.add(strPay);
                    records.add(strPrice);
                    records.add(strNumOfRoom);
                    records.add(strNumOfBeds);
                }
            } while (strName != null && strSurname != null && strPhone != null && strPay != null && strNumOfRoom != null&& strPrice != null && strNumOfBeds != null);
        }
        finally {
            fr.close();
            br.close();
        }
        return records;
    }

    public static void AddAllListInFile(ArrayList<Client> clients) throws IOException {

        try {
            FileWriter fstream1 = new FileWriter("clients.txt");
            BufferedWriter out1 = new BufferedWriter(fstream1);
            out1.write("");
            out1.close();
        }
        catch (Exception e){
            System.err.println("Error in file cleaning: " + e.getMessage());}

        FileWriter fw = new FileWriter("clients.txt", true);
        for (Client client : clients){

            try {
                fw.write(client.getName()+"\n"+client.getSurname()+"\n"+client.getMobilePhone()+"\n"+client.getPayCheque()+"\n"+client.getRoom().getPrice()+"\n"+client.getRoom().getNumberOfRoom()+"\n"+client.getRoom().getNumOfBeds()+"\n");
            }
            finally {
                fw.close();
            }
        }
        return;
    }
}
