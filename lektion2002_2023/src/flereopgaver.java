import java.util.Scanner;
import java.util.Arrays;
public class flereopgaver {


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        //7.5
//
//        int[] a = new int[9];
//        int even = 0;
//        int uneven = 0;
//        System.out.println("Hit me up with 10 numbers");
//        for(int i = 0; i < a.length; i++){
//            a[i] = scanner.nextInt();
//            if(a[i] % 2 == 0){
//                even++;
//            }
//            else{
//                uneven++;
//            }
//        }
//        System.out.println(Arrays.toString(a));
//        System.out.println("even numbers : " + even);
//        System.out.println("uneven numbers : " + uneven);

        //7.3
        int w = 0;
        int[] a = new int[49];
        //indtast tal mellem 1 og 50
        System.out.println("Enter integers between 1 and 50: ");
        for(int i = 0; i < a.length; i++) {
            w = scanner.nextInt();
            if (w > 49) {
                System.out.println("Too high");
                i--;
            }
            else if (w < -1) {
                System.out.print("Too low");
                i--;
            }
            else if (w == 0){
                break;
            }

            else {
                //tæller hvor mange gange tal forekommer
                a[w-1]++;
            }
        }

        for (int x = 0; x < a.length; x++) {
                //printer lortet
                if (a[x] > 0) {
                    System.out.println(x + 1 + " occurs " + a[x] + " times");
                }
            }










    }




}
