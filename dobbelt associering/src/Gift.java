import java.util.ArrayList;

public class Gift {

    private String description;
    private double price;
    private Person person;

    public Gift(String description) {
        this.description = description;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        if (this.person != person) {
            this.person = person;
        }
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




}
