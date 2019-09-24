package by.BSUIR.Hotel;

public class Superior extends Room{
    public Superior(double price, int numberOfRoom, int numOfBeds, Boolean isBar, Boolean isCond) {
        super(price, numberOfRoom, numOfBeds);
        this.isBar = isBar;
        this.isCond = isCond;
    }

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

    private Boolean isBar;
    private Boolean isCond;
}
