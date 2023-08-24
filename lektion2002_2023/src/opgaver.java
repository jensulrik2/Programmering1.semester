import java.util.Arrays;
public class opgaver
{

    public static void main(String[] args) {

        //a

        int[] arra = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(arra));

        //b

        int[] arrb = {2, 44, -23, 99, 8, -5, 7, 10, 20, 30};
        System.out.println(Arrays.toString(arrb));

        //c

        int[] arrc = new int[10];

        for (int i = 0; i < arrc.length; i++) {
            arrc[i] = i;
            System.out.print(i + " ");
        }

        //d
        System.out.println();

        int[] arrd = new int[10];
        int num = 2;
        for (int i = 0; i < arrd.length; i++) {
            System.out.print(num + " ");
            num += 2;
        }

        //e

        int[] arre = new int[10];
        int num2 = 1;
        for (int i = 0; i < arre.length; i++) {
            num2 = (i + 1) * (i + 1);
            arre[i] = num2;
        }
        System.out.println(Arrays.toString(arre));

        //f

        int[] arrf = new int[10];

        for (int i = 0; i < arrf.length; i++) {
            if (i % 2 == 0) {
                arrf[i] = 0;
            } else {
                arrf[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arrf));

        //g

        int[] arrg = new int[10];
        int num3 = 0;
        for (int i = 0; i < arrg.length; i++) {
            if (num3 > 4) {
                num3 = 0;
            }
            arrg[i] = num3;
            num3++;
        }
        System.out.println(Arrays.toString(arrg));

        //h
        int[] arrh = new int[10];

        for (int i = 0; i < arrh.length; i++) {
            if (i % 2 == 0) {
                arrh[i] = i * 2;
            } else {
                arrh[i] = i * 2 + 1;
            }
            System.out.println(Arrays.toString(arrh));


            //Exercise2


        }
        int t[] = {4, 2, 6, 8, 1, 8, 10, 18, 42};
        System.out.println(sum(t));


        int a[] = {4,6,7,2,3};
        int b[] = {4,6,8,2,6};


        System.out.println(sumArrays(a,b));
        System.out.println(sumArrays2(a,b));
        System.out.println(hasUneven(t));


    }
    //Exercise2
    public static int sum(int[] t){
      int sum = 0;
      for(int i = 0; i < t.length; i++){
          sum += t[i];
      }

      return sum;
    }
    //EX3a
    public static int sumArrays(int[] a, int[] b){
        int c[] = new int[a.length];
        for(int i = 0; i < a.length; i++){
            c[i] = a[i] + b[i];
            System.out.print(c[i] + " , ");
        }
        System.out.println();
        return 0;
    }
    //EX3b
    public static int sumArrays2(int[] a, int[] b){

        if(a.length == b.length) {
            int c[] = new int[a.length];
            for(int i = 0; i < a.length; i++){
                c[i] = a[i] + b[i];
                System.out.print(c[i] + " , ");
            }
        }
        else if(a.length > b.length){
            int c[] = new int[a.length];
            for(int i = 0; i < a.length; i++){
                c[i] = a[i] + b[i];
                System.out.print(c[i] + " , ");
            }
        }
        else{
            int c[] = new int[b.length];
            for(int i = 0; i < b.length; i++){
                c[i] = a[i] + b[i];
                System.out.print(c[i] + " , ");
            }
        }

        System.out.println();
        return 0;
    }

    //EX4

    public static boolean hasUneven(int[] t){
    boolean a = false;

    for(int i = 0; i < t.length; i++){
        if (t[i] % 2 == 0){
            a = false;
        }
        else{
            a = true;
        }
    }


        return a;
    }








}
