import java.util.Scanner;
public class opgave7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("kom med 1 tal");
        int tal1 = scanner.nextInt();

        System.out.println("1 mere");
        int tal2 = scanner.nextInt();

        System.out.println("Sidste, jeg lover");
        int tal3 = scanner.nextInt();


        String i = inorder(tal1, tal2, tal3);
        System.out.println(i);


    }


    public static String inorder(int num1, int num2, int num3) {

        String i;

        if (num1 < num2 && num2 < num3) {
            i = "Voksende";
        } else if (num1 > num2 && num2 > num3) {
            i = "Aftagende";
        } else {
            i = "Hverken eller";
        }
        return i;
    }

}







