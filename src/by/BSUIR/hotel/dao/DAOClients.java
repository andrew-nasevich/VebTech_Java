package by.BSUIR.hotel.dao;

import by.BSUIR.hotel.bean.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAOClients {

    public void addInClientBase(Client client) throws IOException {
        FileWriter fw = new FileWriter("clients.txt", true);

        try {
            fw.write(client.getName()+"\n"+client.getSurname()+"\n"+client.getMobilePhone()+"\n"+client.getPayCheque()+"\n"+client.getRoom().getPrice()+"\n"+client.getRoom().getNumberOfRoom()+"\n"+client.getRoom().getNumOfBeds()+"\n");
        }
        finally {
            fw.close();
        }
    }

    public List<String> readFromClientBase() throws IOException {
        List<String> records = new ArrayList();
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

    public void addAllListInFile(List<Client> clients) throws IOException {

        try {
            FileWriter fstream1 = new FileWriter("clients.txt");
            BufferedWriter out1 = new BufferedWriter(fstream1);
            out1.write("");
            out1.close();
        }
        catch (Exception e){
            System.err.println("Error in file cleaning: " + e.getMessage());}

        FileWriter fw = new FileWriter("clients.txt", true);
        for (Client client : clients)
            fw.write(client.getName()+"\n"+client.getSurname()+"\n"+client.getMobilePhone()+"\n"+client.getPayCheque()+"\n"+client.getRoom().getPrice()+"\n"+client.getRoom().getNumberOfRoom()+"\n"+client.getRoom().getNumOfBeds()+"\n");
        fw.close();
        return;
    }
}
