import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Opgave5 {

    public static void main(String[] args) {

        String fil = "C:\\Users\\judes\\IdeaProjects\\Programmering 1.semester\\Exceptions og io filer\\src\\tal.txt";
        //	String fileName = "C:/MAD/Ud/tal7.txt";
        //	String fileName = "C:\\MAD\\Workspace\\IntelliJJava\\PRO1_22S\\tal.txt";

        try(Scanner scan = new Scanner(System.in); PrintWriter printWriter = new PrintWriter(fil)) {

            int tal = 0;
            System.out.println("Skriv nogle tal og afslut med -1");

            while(tal != -1){
                tal = scan.nextInt();
                if(tal > 0) {
                    printWriter.println(tal);
                }
                else if(tal != -1){
                    System.out.println("tal skal være over 0");
                }
            }

            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
