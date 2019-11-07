package by.BSUIR.hotel;

import by.BSUIR.hotel.dao.DaoClient;
import by.BSUIR.hotel.parser.*;
import by.BSUIR.hotel.service.ClientService;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //HotelWork work = new HotelWork();
        //work.start();
        ClientXmlParser clientParser = new ClientXmlParser("D:\\УНИВЕР\\3 курс\\WT_JAVA\\src\\by\\BSUIR\\hotel\\resources\\schemeXML.xml", "D:\\УНИВЕР\\3 курс\\WT_JAVA\\src\\by\\BSUIR\\hotel\\resources\\schemeXSD.xsd");
        ClientService clientService = new ClientService(new DaoClient(clientParser));

        clientService.getAll().forEach(x -> System.out.print(x.getId() + " "+x.getName()+">>"));
        System.out.println();
    }
}
