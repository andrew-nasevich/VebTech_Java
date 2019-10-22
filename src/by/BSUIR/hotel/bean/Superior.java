package by.BSUIR.hotel.bean;

public class Superior extends Room{
    private Boolean isBar;
    private Boolean isCond;

    public Superior(double price, int numberOfRoom, int numOfBeds, Boolean isBar, Boolean isCond) {
        super(price, numberOfRoom, numOfBeds);
        this.isBar = isBar;
        this.isCond = isCond;
    }
    public Superior(){};

    public Boolean getBar() {
        return isBar;
    }

    public void setBar(Boolean bar) {
        isBar = bar;
    }

    public Boolean getCond() {
        return isCond;
    }

    public void setCond(Boolean cond) {
        isCond = cond;
    }


}
