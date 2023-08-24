package application.model;

public class Customer {

    private String name;

    private Company company;



    public Company getCompany() {
        return company;
    }

    public Customer(String name, Company company){
        this.name = name;
        this.company = company;
    }
    public Customer(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }




}
