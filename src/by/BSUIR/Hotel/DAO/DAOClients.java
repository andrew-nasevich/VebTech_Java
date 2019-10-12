package by.BSUIR.Hotel.DAO;

import by.BSUIR.Hotel.Client;

import java.io.*;
import java.util.ArrayList;

public class DAOClients {

    public static void AddInClientBase(Client client) throws IOException {
        FileWriter fw = new FileWriter("clients.txt", true);

        try {
            fw.write(client.getName()+"\n"+client.getSurname()+"\n"+client.getMobilePhone()+"\n"+client.getPayCheque()+"\n"+client.getRoom().getNumberOfRoom()+"\n");
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
        String strNumOfRoom;

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
                strNumOfRoom = br.readLine();
                if (strName != null && strSurname != null && strPhone != null && strPay != null && strNumOfRoom != null)
                {
                    records.add(strName);
                    records.add(strSurname);
                    records.add(strPhone);
                    records.add(strPay);
                    records.add(strNumOfRoom);
                }
            } while (strName != null && strSurname != null && strPhone != null && strPay != null && strNumOfRoom != null);
        }
        finally {
            fr.close();
            br.close();
        }
        return records;
    }
}
