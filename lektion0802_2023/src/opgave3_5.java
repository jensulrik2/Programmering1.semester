import java.util.Scanner;

public class opgave3_5 {

    public static void main(String[] args) {

        //3.5
		/*
		(Find future dates) Write a program that prompts the user to enter an integer for
		today’s day of the week (Sunday is 0, Monday is 1, . . . , and Saturday is 6). Also
		prompt the user to enter the number of days after today for a future day and display the future day of the week. 
		
		*/
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        String arr[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};


        System.out.println("Which day is it today?");
        System.out.println("0 : Sunday");
        System.out.println("1 : Monday");
        System.out.println("2 : Tuesday");
        System.out.println("3 : Wednesday");
        System.out.println("4 : Thursday");
        System.out.println("5 : Friday");
        System.out.println("6 : Saturday");
        int today = scanner.nextInt();
        System.out.println("Enter a number of days after today");
        int days = scanner.nextInt();

        int futuredate = today + days;
        if(futuredate > 6)
            futuredate = futuredate % 7;

        System.out.println("Today is " + arr[today] + " and the future day is " + arr[futuredate]);





    }
}