package modelwhile;

public class LoekkerOpgaver {

    public static void main(String[] args) {


//        Kald af metoder der afprøver opgave 1
        // a)
          System.out.println(summerEven(100));
          System.out.println(summerSquare(10));
          System.out.println(sumOdd(3, 19));
          allPowers(20);

    }

   // Metoden returnerer summen af alle lige tal mellem 2 og n
    public static int summerEven(int n) {
        int i = 0;
        int sum = 0;
        while (i <= n){
            if(i % 2 == 0) {
                sum = sum + i;
            }
        i++;
        }
        return sum;
    }
    // Metoden returnerer summen af alle kvdrater mellem 1*1 og n*n
    public static int summerSquare(int n) {
        // TODO Opgave 1.b
        int i = 0;
        int sum = 0;
        while(i <= n){
            sum = i * i + sum;
            i++;
        }
        return sum;
    }

    // Metoden returnerer summen af alle ulige tal mellem a og b
    public static int sumOdd(int a, int b) {
        // TODO Opgave 1.c

        int sum = 0;
        while(a <= b){
            if(a % 2 != 0){
                sum = sum + a;
            }
        a++;
        }
        return sum;
    }

    // Metoden udskriver 2 potenser fra  f
    public static void allPowers(int n) {
        // TODO Opgave 1.d
        int i = 0;

        while( i <= n ){
            if(i == 0){
                i++;
                System.out.println(i);
            }
            else
            System.out.println(i * 2);
            i++;


        }



    }


}
