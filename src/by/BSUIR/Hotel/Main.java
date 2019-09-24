package by.BSUIR.Hotel;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Client> clients = new ArrayList<>();

	    System.out.println("Welcome to Hotel!");

	    System.out.println("Choose menu point:");
	    int command = -1;
	    while (command!=0) {
            System.out.println("1-Book a room\n" +
                               "0-exit");
            command = in.nextInt();

            if (command == 1) {
                Client client = new Client();
                
                System.out.println("Name:");
                String name = in.next();
                client.setName(name);

                System.out.println("Surname:");
                String surname = in.next();
                client.setSurname(surname);

                System.out.println("Mobile number:");
                String mobile = in.next();
                client.setMobilePhone(mobile);

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
                    client.setRoom(room);
                    client.setPayCheque(price);
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
                    client.setRoom(room);
                    client.setPayCheque(price);
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
                    client.setRoom(room);
                    client.setPayCheque(price);
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
                        price = price + 50.20;
                    }
                    else
                        pool = false;

                    room = new Bungalo(price, number, beds,pool);
                    client.setRoom(room);
                    client.setPayCheque(price);
                }
                clients.add(client);

            }

        }
        //write to file
        String text = "";
        for (int i = 0; i < clients.size(); i++){
            Client listClient = (Client) clients.get(i);
            text = listClient.getName() +"|"+ listClient.getSurname() +"|"+ listClient.getMobilePhone() +"|"+ listClient.getPayCheque() +"|"+ listClient.getRoom().getNumberOfRoom();
            try(FileWriter writer = new FileWriter("clients.txt", false))
            {
                writer.write(text);
                writer.append('\n');

                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }

        }
         //read from file
        try(FileReader reader = new FileReader("clients.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
                text = text + Integer.toString(c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
