package by.BSUIR.hotel.bean;

public class Client {

    private String name;
    private String surname;
    private String mobilePhone;
    private double payCheque;
    private Room room;

    public Client(String name, String surname, String mobilePhone, double payCheque, Room room) {
        this.name = name;
        this.surname = surname;
        this.mobilePhone = mobilePhone;
        this.payCheque = payCheque;
        this.room = room;
    }

    public Client(String name, String surname, String mobilePhone, double payCheque, int numroom) {
        this.name = name;
        this.surname = surname;
        this.mobilePhone = mobilePhone;
        this.payCheque = payCheque;
        this.getRoom().setNumberOfRoom(numroom);
    }

    public Client() {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public double getPayCheque() {
        return payCheque;
    }

    public void setPayCheque(double payCheque) {
        this.payCheque = payCheque;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
