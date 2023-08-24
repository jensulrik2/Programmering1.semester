import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Opgave3 {

    public static void main(String[] args){
//Læs filen fra opgave 2) og indsæt tallene i en ArrayList<Integer> efterhånden som de indlæses.
//Udskriv dernæst tallene fra arraylisten i omvendt rækkefølge, dvs. 285, 177, ..., 34

        ArrayList<Integer> list = new ArrayList<>();
        File filein = new File("C:\\Users\\judes\\IdeaProjects\\Programmering 1.semester\\Exceptions og io filer\\src\\hello.txt");

        try (Scanner scan = new Scanner(filein)){
            while (scan.hasNext()) {
                int tal = scan.nextInt()*2;
                list.add(tal);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        for(int i = list.size()-1; i >= 0; i--){
            System.out.println(list.get(i));
        }




    }
}
