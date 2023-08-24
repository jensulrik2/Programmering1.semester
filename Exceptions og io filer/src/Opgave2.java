import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opgave2 {

    public static void main(String[] args){

        File filein = new File("C:\\Users\\judes\\IdeaProjects\\Programmering 1.semester\\Exceptions og io filer\\src\\hello.txt");

        try (Scanner scan = new Scanner(filein)){
            while (scan.hasNext()) {
                int antal = scan.nextInt()*2;
                System.out.println(antal);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
