import java.util.ArrayList;

public class Rental {

    private int number;
    private int days;
    private String date;
    private final ArrayList<Car> cars = new ArrayList<>();


    public Rental(int number, int days, String date) {
        this.number = number;
        this.days = days;
        this.date = date;
    }
    public void addCar(Car car){
        cars.add(car);
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public double getPrice(){
        ArrayList<Car> cars = getCars();
        double price = 0;
        for(int i = 0; i < cars.size();i++){
            price += cars.get(i).getDayPrice() * this.days;
        }
        return price;
    }

    public ArrayList<Car> getCars() {
        return new ArrayList<>(cars);
    }




}