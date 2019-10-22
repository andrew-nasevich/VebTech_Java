package by.BSUIR.hotel.bean;

public class Studio extends Room{
    private Boolean isKitchen;

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

}
