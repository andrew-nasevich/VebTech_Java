package by.BSUIR.hotel.dao;

import java.io.*;

public class DAOHotelRooms {
    public static void saveArrayToFile(int[][] rooms) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("hotelRooms.txt"));
            bw.write(String.valueOf(rooms.length));
            bw.newLine();
            bw.write(String.valueOf(rooms[0].length));
            bw.newLine();
            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[0].length; j++) {
                    bw.write(String.valueOf(rooms[i][j]));
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int[][] loadArrayFromFile() {
        int[][] rooms = null;
        try (BufferedReader br = new BufferedReader(new FileReader("hotelRooms.txt"))) {
            // в первых 2-х строках файла цифры задают размерность массива
            String strRows = br.readLine();
            String strCols = br.readLine();
            if(strCols!=null && strRows!=null) {
                int rows = Integer.parseInt(strRows);
                int cols = Integer.parseInt(strCols);
                rooms = new int[rows][cols];
                for (int i = 0; i < rooms.length; i++) {
                    for (int j = 0; j < rooms[0].length; j++) {
                        rooms[i][j] = Integer.parseInt(br.readLine());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rooms;
    }

}
