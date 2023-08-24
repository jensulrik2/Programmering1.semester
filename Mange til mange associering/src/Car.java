import java.util.ArrayList;

public class Car {
    private String license;
    private double pricePerDay;
    private int purchaseYear;

    private final ArrayList<Rental> rentals = new ArrayList<>();


    public Car(String license, double pricePerDay, int purchaseYear) {
        this.license = license;
        this.pricePerDay = pricePerDay;
        this.purchaseYear = purchaseYear;
    }

    public void addRental(Rental rental){
        if (!rentals.contains(rental)) {
            rentals.add(rental);
            rental.addCar(this);
        }

    }

    public void removeRental(Rental rental){
        if (rentals.contains(rental)) {
            rentals.remove(rental);
            rental.removeCar(this);
        }

    }

    public ArrayList<Rental> getRentals() {
        return rentals;
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

    public int longestRental(){
        int days = 0;
        getRentals();
        for(int i = 0; i < rentals.size(); i++){
            if(rentals.get(i).getDays() > days){
                days = rentals.get(i).getDays();
            }
        }

        return days;
    }
}


