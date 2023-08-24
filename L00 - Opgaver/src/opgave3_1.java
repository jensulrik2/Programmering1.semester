import java.util.Scanner;
public class opgave3_1 {


    public static void main(String[] args){

        //3.1

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter value for a");
        double a = scanner.nextDouble();
        System.out.println("Enter value for b");
        double b = scanner.nextDouble();
        System.out.println("Enter value for c");
        double c = scanner.nextDouble();

        double d = (b*b) - (4 * a * c);
        double r1 = 0;
        double r2 = 0;

        if(d>0){
            r1 = (-b + (Math.sqrt(d)))/(2*a);
            r2 = (-b -(Math.sqrt(d)))/(2*a);
            System.out.println(r1);
            System.out.println(r2);
        }
        else if(d==0){
            r1 = (-b + (Math.sqrt(d)))/(a*a);
            System.out.println(r1);
        }
        else{
            System.out.println("ingen rødder bror");
        }





    }




}
