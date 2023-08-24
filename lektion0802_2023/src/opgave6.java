import java.util.Scanner;
public class opgave6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("bruh indtast et tal");
        int tal = scanner.nextInt();

        //kalder metoden
        sign(tal);

        //i får tildelt return værdien fra sign(tal)
        String i = sign(tal);

        //printer i
        System.out.println(i);

    }

        //Lav en metode der indlæser et heltal fra tastaturet og udskriver negativ, nul eller
        //positiv, afhængig af om det indlæste tal er <, == eller > end 0
    public static String sign(int tal) {
        String i = "";
        if (tal > 0) {
            i = "Positiv";
        } else if (tal == 0) {
            i = "nul og niks";
        } else if (0 > tal) {
            i = "Negativ";
        }
        return i;
    }


}
