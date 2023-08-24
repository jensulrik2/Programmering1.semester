public class Car {
    private String license;
    private double pricePerDay;
    private int purchaseYear;


    public Car(String license, double pricePerDay, int purchaseYear) {
        this.license = license;
        this.pricePerDay = pricePerDay;
        this.purchaseYear = purchaseYear;
    }

    public String getLicense() {
        return license;
    }

    public double getDayPrice() {
        return pricePerDay;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

    public void setDayPrice(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}


