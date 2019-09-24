package by.BSUIR.Hotel;

public class Client {
    public Client(String name, String surname, String mobilePhone, double paycheque, Room clroom) {
        Name = name;
        Surname = surname;
        MobilePhone = mobilePhone;
        PayCheque = paycheque;
        room = clroom;
    }

    public Client() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        MobilePhone = mobilePhone;
    }

    public double getPayCheque() {
        return PayCheque;
    }

    public void setPayCheque(double payCheque) {
        PayCheque = payCheque;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    private String Name;
    private String Surname;
    private String MobilePhone;
    private double PayCheque;
    private Room room;
}
