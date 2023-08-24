import java.util.Locale;

public class opgaver0602_2023 {

    public static void main(String[] args) {

        int i1, i2, a = 4, b = 11, c = 2;
        double d1, d2, r = 4.0, s = 11.0, t = 2.0;

        //opg.1
        i1 = b / a;
        System.out.println(i1);
        c = (int) (s / r);
        System.out.println(c);
        d1 = b / a;
        System.out.println(d1);
        d2 = s / r;
        System.out.println(d2);
        d1 = b / r;
        System.out.println(d1);
        d2 = 11.0 / 4.0;
        System.out.println(d2);
        d1 = 11.0 / a * c;
        System.out.println(d1);
        i1++;
        System.out.println(i1);
        i1 = b % a;
        System.out.println(i1);
        i1 = 3 + 7 * 2;
        System.out.println(i1);
        i2 = (3 + 7) * 2;
        System.out.println(i2);

        //opg.2

        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";

        // a) Færdiggør programmet så det udskriver ord1 med store bogstaver.

        System.out.println(ord1.toUpperCase());

        // b) Færdiggør programmet så det udskriver ord2 med små bogstaver

        System.out.println(ord2.toLowerCase());

        // c) Færdiggør programmet så det sammensætter ord1 og ord2 med et mellemrum imellem og udskriver resultatet.

        String resultat = ord1 + " " + ord2;
        System.out.println(resultat);

        // d) Færdiggør programmet så det i en ny streng, ord3, sammensætter ord1 og ord2, hvor ord2 er med små bogstaver.
        // Udskriv resultatet.

        String ord3 = ord1 + ord2.toLowerCase();
        System.out.println(ord3);

        // e) Udskriv længden af strengen fra opgave d)

        System.out.println(ord3.length());

        // f) Udskriv de første 7 bogstaver af ord1.

        for (int i = 0; i <= 6; i++) {
            System.out.print(ord3.charAt(i));
        }

        // g) Udskriv bogstav 3-7 fra ord2.
        System.out.println();

        for (int i = 0; i <= 6; i++) {
            if (i >= 2) {
                System.out.print(ord2.charAt(i));
            }

        }

        // h)  Udskriv den sidste halvdel af strengen fra opgave d).
        System.out.println();


        for ( int i = 10; i <= ord3.length(); i++){
            System.out.print(ord3.charAt(i));
        }
        //alternativ løsning ord3.substring(ord3.length()/2)
    }
}
