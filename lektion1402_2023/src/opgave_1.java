import java.util.Scanner;
public class opgave_1 {

    public static void main(String[] args){

        //indlæs hele tal mellem 1 og 99, afsluttende med 0

        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[99];
        int stoerst = arr[0];
        int mindst = arr[0];
        int i = 0;
        int lige = 0;
        int ulige = 0;


        //indtast op til 100 tal og afslut med 0, tallene bliver smidt ind i et array
        System.out.println("Indtast nogle tal mellem 0 og 99, afsluttende med 0");
        while(i < arr.length) {
            int a = scanner.nextInt();

            if (0 < a && a > 100) {
                arr[i] = a;
                i++;
            }
            else if (a == 0) {
                i = 100;
            }

        }
        //finder største og mindste tal i array samt tæller ulige og lige tal
        for(int b = 0; b < arr.length; b++ ){
            if (arr[b] > stoerst) {
                stoerst = arr[b];
            }
            else if (arr[b] < mindst) {
                mindst = arr[b];
            }
            if (arr[b] % 2 == 0 && arr[b] > 0) {
                lige = lige + 1;
            }
            else if (arr[b] % 2 != 0) {
                ulige = ulige + 1;
            }
            if(arr[b] > 0) {
                System.out.print(arr[b] + " ");
            }
        }

        System.out.println("Højeste tal er : " + stoerst);
        System.out.println("Mindste tal er : " + mindst);
        System.out.println("Antal lige tal : " + lige);
        System.out.println("Antal ulige tal : " + ulige);

        scanner.close();
        }

}
