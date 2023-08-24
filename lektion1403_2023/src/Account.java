import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.lang.Math;

public class Account {
    private static int nextId;
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated = new Date();
    private static LocalDateTime lastTransaction;
    private double monthlyInterestRate;

    Account(){
        id = nextId;
        nextId++;
    }

    Account(int id, double balance){
        this();
        this.id = id;
        this.balance = balance;


    }

    public int getID(){
        return id;
    }

    public double getBalance(){
        return balance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate/100;
    }
    public void setID(int id){
        this.id = id;
    }
    public void setBalance(){
        this.balance = balance;
    }
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    public Date getDateCreated(){
        this.dateCreated = new Date();
        return dateCreated;
    }

    public double getMonthlyInterestRate(){

        this.monthlyInterestRate = annualInterestRate / 12;

        return monthlyInterestRate;
    }

    public double getMonthlyInterest(){
        
        return monthlyInterestRate * balance;
    }

    public void deposit(int amount){
        balance += amount;


    }

    public void withdraw(int amount) {
        balance -= amount;


    }




}
