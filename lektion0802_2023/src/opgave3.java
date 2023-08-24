import java.util.Scanner;
public class opgave3 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("kom med 1 tal");
        int tal1 = scanner.nextInt();
        System.out.println("1 mere");
        int tal2 = scanner.nextInt();
        System.out.println("Sidste, jeg lover");
        int tal3 = scanner.nextInt();

        if(tal1 < tal2 && tal2 < tal3){
            System.out.println("Voksende");
        }
        else if(tal1 > tal2 && tal2 > tal3){
            System.out.println("Aftagende");
        }
        else{
            System.out.println("Hverken eller");
        }




    }


}
