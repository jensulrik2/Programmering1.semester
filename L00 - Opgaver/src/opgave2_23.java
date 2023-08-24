import java.util.Scanner;
public class opgave2_23 {


    public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the driving distance pall.");
    double dd = scanner.nextDouble();

    System.out.println("Enter miles per gallon dude");
    double mpg = scanner.nextDouble();

    System.out.println("Enter price per gallon m8");
    double ppg = scanner.nextDouble();

    double drivingCost = (dd / mpg) * ppg;
    System.out.println("The cost of driving is $" + drivingCost);



    }




}
