package twodie;
import java.util.Arrays;
import java.util.Scanner;

public class RollTwoDices {
    private static int rollCount = 0;
    private static int totalSum = 0;
    private static int[] occurences = new int [7];
    private static int twoAlike = 0;
    private static int greatest = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the game of RollTwoDices");
        printRules();
        System.out.println();

        playTwoDice();

        System.out.println();
        System.out.println("Thank you for playing RollTwoDices");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of RollTwoDices:");
        System.out.println("The player throws two dices as long as he/she wants.");
        System.out.println("=====================================================");
    }

    private static void playTwoDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll? ('no' stops) ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int [] face = rollDice();
            System.out.println("Dice1: " + face[0]);
            System.out.println("Dice2: " + face[1]);
            System.out.println();

            updateStatistics(face[0]);

            System.out.print("Roll? ('no' stops) ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int[] rollDice() {
        //2 elementer blive genereret - et tal mellem 1 og 6 for hver terning
        int[] Dices = {(int)(Math.random() * 6 + 1), (int)(Math.random() * 6 + 1)};
        int Dice1 = Dices[0];
        int Dice2 = Dices[1];
        //Den totale sum, hvert slag bliver lagt til denne variabel
        totalSum = totalSum + Dices[0] + Dices[1];

        //største terningslag, sammenligner summen af slaget med en som starter på 0
        if((Dice1 + Dice2) > greatest){
            greatest = Dice1 + Dice2;
        }

        //tæller hvor mange gange tallet forekommer
        occurences[Dice1]++;
        occurences[Dice2]++;

        //tæller 2 ens
        if(Dices[0] == Dices[1]){
            twoAlike++;
        }


        return Dices;
    }

    private static void updateStatistics(int face) {
        rollCount++;
    }



    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Roll count:", rollCount);
        System.out.printf("%17s %4d\n", "Total Sum:", totalSum);
        System.out.printf("%17s %4d\n", "2 alike:", twoAlike);
        System.out.printf("%17s %4d\n", "Greatest roll:", greatest);
        System.out.println("----------------------------");
        //printer hvor mange gange terningens øjne forekommer
        for(int i = 1; i < occurences.length; i++) {
            if(i != 1) {
                System.out.printf("%17s %4d\n", i + " Eyes: ", occurences[i]);
            }
            else{
                System.out.printf("%17s %4d\n", "1 Eye : ", occurences[1]);
            }
        }
    }
}

