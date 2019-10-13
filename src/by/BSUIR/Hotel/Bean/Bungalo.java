package by.BSUIR.Hotel.Bean;

public class Bungalo extends Room {
    public Bungalo(double price, int numberOfRoom, int numOfBeds, Boolean isPool) {
        super(price, numberOfRoom, numOfBeds);
        this.isPool = isPool;
    }

    public Boolean getPool() {
        return isPool;
    }

    public void setPool(Boolean pool) {
        isPool = pool;
    }

    private Boolean isPool;

}
