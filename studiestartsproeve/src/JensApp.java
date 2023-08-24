import java.util.Scanner;
public class JensApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indtast navn:");
        String navn = scanner.next();
        System.out.println("Indtast løn:");
        int løn = scanner.nextInt();
        System.out.println("Indtast alder:");
        int alder = scanner.nextInt();
        double lønstigning50plus = 1.1; //10 procent
        double lønstigning35minus = 1.05;
        double lønstigning = 1.08;
        double newLøn = 0;

        if(alder >= 50){
            newLøn = løn * lønstigning50plus;
        }
        else if(alder < 35){
            newLøn = løn * lønstigning35minus;
        }
        else{
            newLøn = løn * lønstigning;
        }

        System.out.println(navn + " din nye løn er: " + newLøn);
    }
}