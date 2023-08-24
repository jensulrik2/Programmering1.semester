import javax.lang.model.element.ElementKind;
import javax.swing.text.Element;
import java.util.Arrays;
public class arrays {


    public static void main(String[] args){
        int[] x = {0,2,3,4,7,6,15};
        System.out.println(Arrays.toString(x));
        //a
//        Switch(x);
//        System.out.println(Arrays.toString(x));
        //b
//        zReplace(x);
//        System.out.println(Arrays.toString(x));

        //c
//        System.out.println(secHigh(x));

        //d
//        System.out.println(ascending(x));

        //e
//        shift(x);
//        System.out.println(Arrays.toString(x));

        //f
        System.out.println(doublets(x));

    }

    //6a
    public static void Switch(int[] t){
        int temp = t[0];
        int temp2 = t[t.length-1];
        t[0] = temp2;
        t[t.length-1] = temp;
    }
    //6b
    public static void zReplace(int[] t){
        for(int i = 0; i < t.length; i++){
            if(t[i] % 2 == 0){
                t[i] = 0;
            }
        }
    }
    //6c
    public static int secHigh(int[] t){
        return t[t.length-2];
    }
    //6d
    public static boolean ascending(int[] t){
        boolean a = true;
        boolean b = true;
        for(int i = 1; i < t.length - 1; i++){
            if(t[i] < t[i+1] && t[i-1] < t[i]) {
                a = true;
            }
            else{
                a = false;
            }
            if(a == false){
                b = false;
            }
        }
        return b;
    }

    //6e

    public static void shift(int[] t){
        int temp = 0;
        //nyt array med et ekstra felt
        int[] a = new int[t.length];
        //første plads i a[] får det sidste element fra t[]
        a[0] = t[t.length-1];
        //tager et element fra t[i] og smidder hen i a[i+1]
        for(int i = 0; i < t.length-1; i++) {
            temp = t[i];
            a[i+1] = temp;
        }
        //smider elementerne tilbage til t[]
        for(int i = 0; i < t.length; i++){
            t[i] = a[i];
        }
    }

    //6f

    public static boolean doublets(int[] t){
        boolean a = false;
        for(int i = 0; i < t.length-1; i++){
            //sammenligner t[i] med alle andre pladser
            for(int b = 0; b < t.length-1; b++){
                //hvis i ikke er det samme som b, sammenligner den de 2 pladser,
                //det er for at sikre at den ikke sammenligner en plads med sig selv
                // fordi ellers er det altid true
                if(i != b){
                    if(t[i] == t[b]){
                        a = true;
                    }
                }
            }
        }
      return a;
    }








}
