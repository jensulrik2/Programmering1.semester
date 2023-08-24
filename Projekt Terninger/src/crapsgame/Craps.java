package crapsgame;

import java.util.Arrays;
import java.util.Scanner;

public class Craps {
    private static int first = 0;
    private static int newRoll = 0;
    private static boolean win = false;
    private static boolean lose = false;
    private static int wins = 0;
    private static int loses = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the game of Craps");
        System.out.println();
        System.out.println("Type 'y' to play");
        String keepPlaying = scanner.next();

        while(!keepPlaying.equals("no")){
            playCraps();
            win = false;
            lose = false;
            System.out.println("If you want to play again type 'y' and type no to quit");
            keepPlaying = scanner.next();
        }
        System.out.println(wins + "wins");
        System.out.println(loses + "loses");
        System.out.println();
        System.out.println("Thank you for playing Craps");
    }

    private static void playCraps() {
        System.out.println("Come on roll bud");
        firstRoll(); //første slag
        System.out.println("Your first roll is " + first);
        if( win == true){
            System.out.println("You win");
            wins++;
        }
        else if( lose == true) {
            System.out.println("You lose");
            loses++;
        }
        //hvis spilleren hverken har tabt eller vundet efter første roll
        //fortsætter spilleren indtil han har vundet eller tabt
        while(win == false && lose == false){
            System.out.println("Roll again(try to hit " + first + " )");
            rollforPoint();
            System.out.println(newRoll);
            if(newRoll == first){
                win = true;
                System.out.println("You win");
                wins++;
            }
            else if(newRoll == 7){
                lose = true;
                System.out.println("You lose");
                loses++;
            }
        }
    }

    private static void firstRoll() {
        //2 elementer blive genereret - et tal mellem 1 og 6 for hver terning
        int[] Dices = {(int)(Math.random() * 6 + 1), (int)(Math.random() * 6 + 1)};
        first = Dices[0] + Dices[1];

        //vinder hvis spiller slår 7 eller 11
        if(first == 7 || first == 11){
            win = true;
        }
        //taber hvis spiller slår 2,3 eller 12
        else if(first == 2 || first == 3 || first == 12){
            lose = true;
        }

    }
    private static void rollforPoint(){
        int[] Dices = {(int)(Math.random() * 6 + 1), (int)(Math.random() * 6 + 1)};
        newRoll = Dices[0] + Dices[1];
    }
}
