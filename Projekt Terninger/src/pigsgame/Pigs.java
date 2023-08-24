package pigsgame;
import java.util.Scanner;

public class Pigs {

    private static int player1 = 0; //spillernes nuværende points
    private static int player2 = 0;
    private static int totalPoints = 100; //point de spiller til
    private static double rollCountp1 = 0; //slag i alt pr. spiller
    private static double rollCountp2 = 0;
    private static boolean whichPlayer = true; //bliver brugt til at afgøre, hvilken spillers tur det er
    private static double averagep1 = 0; //gennemsnits slag ud fra antal ture og slag i alt
    private static double averagep2 = 0; //den er global, da jeg benytter den i flere metoder
    private static int[] dices = new int[2]; //terningeslag med de 2 terninger

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Pig");

        System.out.println("Skriv, hvor meget i har lyst til at spille til");
        int totalPoints = scanner.nextInt(); //totalpoint specificeres


        //spil starter
        playPig();


    }

    private static void playPig(){
        int turnCountP1 = 0;
        int turnCountP2 = 0;
        while(player1 != totalPoints || player2 != totalPoints){

            currentStandings(); //spiller 1's tur
            System.out.println("Player 1's turn");
            player1 += playerRound();
            turnCountP1++;
            averagep1 = rollCountp1 / turnCountP1;
            whichPlayer = false;

            if(player1 >= totalPoints){ //tjekker om spiller 1 har vundet efter sin tur
                System.out.println("Player 1 wins");
                player1 = totalPoints;
                break;
            }
            currentStandings(); //spiller 2's tur
            System.out.println("Player 2's turn");
            player2 += playerRound();
            turnCountP2++;
            averagep2 = rollCountp2 / turnCountP2;
            whichPlayer = true;

            if(player2 >= totalPoints){ //tjekker om spiller 2 har vundet efter sin tur
                System.out.println("Player 2 wins");
                player2 = totalPoints;


            }
        }

    }

    private static int rollDie() {
        dices[0] = (int)(Math.random() * 6 + 1);
        dices[1] = (int)(Math.random() * 6 + 1);
        return dices[0] + dices[1];
    }

    private static int playerRound(){
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        int points = 0;
        int roll = 0;
        int totalRolls = 0;
        while(!answer.equals("no") && dices[0] != 1 || !answer.equals("no") && dices[1] != 1){ //så længe man ikke har slået 1 eller skriver "no", fortsætter loopet
            roll = rollDie();
            totalRolls++;
            System.out.println("You rolled " + roll + "( " + dices[0] + " and " + dices[1] + " )");
            if(dices[0] == 1 || dices[1] == 1){ //hvis man ruller 1 taber man
                points = 0;
                System.out.println("Bruh You got nothing this round");
                answer = "no";
            }
            else if(dices[0] == 1 && dices[1] == 1){
                System.out.println("You just lost everything");
                answer = "no";
                if (whichPlayer == true){
                    player1 = 0;
                }
                else{
                    player2 = 0;
                }
            }
            else { //slår for point
                points += roll;
                System.out.println("Type 'y' to continue or 'no' to save " + points + " points");
                answer = scanner.nextLine();
            }
        }
        //tæller slag i alt for hver spiller
        if (whichPlayer == true){
            rollCountp1 += totalRolls;
        }
        else{
            rollCountp2 += totalRolls;
        }

        return points;
    }

    private static void currentStandings() {
        System.out.println("___________________________");
        System.out.println("        Standings");
        System.out.println("___________________________");
        System.out.println("Player 1: " + player1 + " total points");
        System.out.println("---------------------------");
        System.out.println("Average: " + averagep1 + " rolls");
        System.out.println("---------------------------");
        System.out.println("Player 2: " + player2 + " total points");
        System.out.println("---------------------------");
        System.out.println("Average: " + averagep2 + " rolls");
        System.out.println("---------------------------");
    }




}
