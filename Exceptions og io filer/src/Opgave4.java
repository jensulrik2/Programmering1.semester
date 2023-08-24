import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Opgave4 {

    public static void main(String[] args){
        String file = "C:\\Users\\judes\\IdeaProjects\\Programmering 1.semester\\Exceptions og io filer\\src\\tal.txt";
        try(Scanner scan = new Scanner(System.in); PrintWriter printWriter = new PrintWriter(file)) {


            for (int i = 1; i <= 100; i++) {
                int tal = 0;
                if(i % 2 != 0){
                   tal = i;
                    printWriter.println(tal);
                }

            }

            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
