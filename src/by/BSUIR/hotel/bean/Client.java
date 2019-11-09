package by.BSUIR.hotel.bean;

import java.util.Objects;

public class Client {

    private String name;
    private String surname;
    private String mobilePhone;
    private double payCheque;
    private Room room;
    private int id;

    public Client(int id) {
        this.id = id;
    }

    public Client(int id, String name, String surname, String mobilePhone, double payCheque, Room room) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mobilePhone = mobilePhone;
        this.payCheque = payCheque;
        this.room = room;
    }

    public Client(int id, String name, String surname, String mobilePhone, double payCheque, int numroom) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
