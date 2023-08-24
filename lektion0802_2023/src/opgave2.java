import java.util.Scanner;
public class opgave2
{
    public static void main(String[] args){

        //Lav et program der indlæser et heltal fra tastaturet og udskriver negativ, nul eller
        //positiv, afhængig af om det indlæste tal er <, == eller > end 0.

        Scanner scanner = new Scanner(System.in);

        System.out.println("bruh indtast et tal");
        int tal = scanner.nextInt();

        if(tal > 0){
            System.out.println("Positiv");
        }
        else if(tal == 0){
            System.out.println("nul og niks");
        }
        else if(0 > tal){
            System.out.println("Negativ");
        }






    }






}
