import java.util.Scanner;
public class opgave2_6

{

    public static void main(String[] args) {


        //2.6
        Scanner scanner = new Scanner(System.in);

        String tal = scanner.nextLine();

        //tager de første 3 tegn i String inputten til char variabler
        char a = tal.charAt(0);
        char b = tal.charAt(1);
        char c = tal.charAt(2);


        //konvertere hver enkel char til tal
        int ax = a - '0';
        int bx = b - '0';
        int cx = c - '0';

        //sum af de 3 indtastede tal
        int result = ax + bx + cx;

        System.out.println("Summen af tallene er " + result);


        }



}
