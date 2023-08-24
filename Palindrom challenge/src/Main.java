import java.time.Instant;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String a = "bob";
        String b = "red rum, sir, is murder";
        String c = "gfdsedsdasbhdas";

        System.out.println(isPalindromString(a));
        System.out.println(isPalindromString(b));
        System.out.println(isPalindromString(c));

        LocalDate d1 = LocalDate.of(1001, 10, 01);


//        System.out.println(isPalindromDate(d1));


    }


    public static boolean isPalindromString(String s) {
        System.out.println(s);
        String a = "";
        String b = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Checking whether is white space or not
            if (Character.isAlphabetic(ch)) {
                a += ch;
            }
        }
        for (int i = a.length() - 1; i >= 0; i--) {
            char ch = a.charAt(i);
            b += ch;
        }
        if(a.equalsIgnoreCase(b))
        return true;
        else{
            return false;
        }
    }

//    public static boolean isPalindromDate(LocalDate date){
//        String s = date + "";
//        String r = "";
//        for(int i = s.length()-1; i >= 0; i-- ){
//            char ch = s.charAt(i);
//            if(Character.isDigit(ch)){
//                r += ch;
//            }
//        }
//        String reverseS = r.charAt(0) + r.charAt(1)+r.charAt(2)+r.charAt(3)+","+r.charAt(4)+r.charAt(5)+","+r.charAt(6)+r.charAt(7)+",";
//        LocalDate date2 = LocalDate.parse(reverseS);
//        return date.isEqual(date2);
}

