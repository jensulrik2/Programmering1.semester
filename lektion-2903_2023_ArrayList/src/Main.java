import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        //exercise 1
        //1
        ArrayList<String> names = new ArrayList<String>();
        //2
        names.add("Hans");
        names.add("Vigo");
        names.add("Jens");
        names.add("Bente");
        names.add("Bent");
        //3
        int length = names.size();
        System.out.println(length);
        //4
        names.add(2, "Jane");
        //5
        System.out.println(names);
        //6
        names.remove(1);
        System.out.println(names);
        //7
        names.add(0,"Pia");
        //8
        length = names.size();
        names.add((length), "Ib");
        System.out.println(names);
        //9
        length = names.size();
        System.out.println(length);
        //10
        names.set(2, "Hansi");
        //11
        length = names.size();
        System.out.println(length);
        //12
        System.out.println(names);
        //13
        for(int i = length-1; 0 <= i; i--){
            String str = names.get(i);
            int nameLength = str.length();
            System.out.print(nameLength + " ");
        }
        System.out.println();
        //14
        Collections.reverse(names);
        String namesLength = "";
        for(String str : names){
            int nameLength = str.length();
            namesLength = namesLength + nameLength + " ";
        }
        System.out.println(namesLength);
    }
}