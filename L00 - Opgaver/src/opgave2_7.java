import java.util.Scanner;
public class opgave2_7
{
    public static void main(String[] args){

        //2.7

        System.out.println("Indtast et tal");

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        // 60 min * 24 timer * 365 dage = 525600 minutter på 1 år
        //konvertere minutter til år, ved at divideres med hvor mange minutter der går på et år
        int år = i / 525600;

        //overskydende minutter
        int restmin = i % 525600;

        // 60 minutter * 24 timer = 1440 min pr. døgn
        // overskydene minutter omregnes til dage
        int restdage = restmin / 1440;

        System.out.println(år + " år " + restdage + " dage");



        /*



         */







    }



}
