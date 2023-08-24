import java.util.Scanner;
import java.util.Arrays;
public class opgaver {

    public static void main(String[] args) {

        //7.30
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array");
        int size = scanner.nextInt();
        int[] x = new int[size];

        for (int i = 0; i < x.length; i++) {
            System.out.println("enter value for x[" + i + "]");
            x[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(x));
        fourConsecutive(x);

    }

        public static boolean fourConsecutive(int[] t){
            boolean a = false;
            for(int i = 0; i < t.length-3; i++){
                        if(t[i] == t[i+1] && t[i] == t[i+2] && t[i] == t[i+3]) {
                            a = true;
                        }
                    }
            if( a == true){
                System.out.println("The list has consecutive fours");
            }
                        else{
                System.out.println("The list has no consecutive fours");
            }
            return a;
        }






}
