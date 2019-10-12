package by.BSUIR.Hotel;

public class Room {
    public Room(double price, int numberOfRoom, int numOfBeds) {
        Price = price;
        NumberOfRoom = numberOfRoom;
        NumOfBeds = numOfBeds;
    }

    public Room(){};

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getNumberOfRoom() {
        return NumberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        NumberOfRoom = numberOfRoom;
    }

    public int getNumOfBeds() {
        return NumOfBeds;
    }

    public void setNumOfBeds(int numOfBeds) {
        NumOfBeds = numOfBeds;
    }

    private double Price;
    private int NumberOfRoom;
    private int NumOfBeds;
}
