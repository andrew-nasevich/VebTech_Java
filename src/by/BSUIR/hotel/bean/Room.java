package by.BSUIR.hotel.bean;

public class Room {
    private double price;
    private int numberOfRoom;
    private int numOfBeds;

    public Room(double price, int numberOfRoom, int numOfBeds) {
        this.price = price;
        this.numberOfRoom = numberOfRoom;
        this.numOfBeds = numOfBeds;
    }

    public Room(){};

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public int getNumOfBeds() {
        return numOfBeds;
    }

    public void setNumOfBeds(int numOfBeds) {
        this.numOfBeds = numOfBeds;
    }


}
