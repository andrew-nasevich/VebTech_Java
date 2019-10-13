package by.BSUIR.Hotel.Bean;

public class Suite extends Room{
    public Suite(double price, int numberOfRoom, int numOfBeds, Boolean isBar, int numOfApartments) {
        super(price, numberOfRoom, numOfBeds);
        this.isBar = isBar;
        NumOfApartments = numOfApartments;
    }

    public Boolean getBar() {
        return isBar;
    }

    public void setBar(Boolean bar) {
        isBar = bar;
    }

    public int getNumOfApartments() {
        return NumOfApartments;
    }

    public void setNumOfApartments(int numOfApartments) {
        NumOfApartments = numOfApartments;
    }

    private Boolean isBar;
    private int NumOfApartments;
}
