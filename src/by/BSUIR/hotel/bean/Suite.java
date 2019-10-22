package by.BSUIR.hotel.bean;

public class Suite extends Room{
    private Boolean isBar;
    private int numOfApartments;

    public Suite(double price, int numberOfRoom, int numOfBeds, Boolean isBar, int numOfApartments) {
        super(price, numberOfRoom, numOfBeds);
        this.isBar = isBar;
        this.numOfApartments = numOfApartments;
    }

    public Boolean getBar() {
        return isBar;
    }

    public void setBar(Boolean bar) {
        isBar = bar;
    }


    public int getNumOfApartments() {
        return numOfApartments;
    }

    public void setNumOfApartments(int numOfApartments) {
        this.numOfApartments = numOfApartments;
    }
}
