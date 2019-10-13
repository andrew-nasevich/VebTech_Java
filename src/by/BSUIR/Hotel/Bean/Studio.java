package by.BSUIR.Hotel.Bean;

public class Studio extends Room{
    public Studio(double price, int numberOfRoom, int numOfBeds, Boolean isKitchen) {
        super(price, numberOfRoom, numOfBeds);
        this.isKitchen = isKitchen;
    }

    public Boolean getKitchen() {
        return isKitchen;
    }

    public void setKitchen(Boolean kitchen) {
        isKitchen = kitchen;
    }

    private Boolean isKitchen;
}
