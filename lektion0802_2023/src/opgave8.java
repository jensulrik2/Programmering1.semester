import java.util.Scanner;
public class opgave8 {

    public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);
    System.out.println("indtast en måned");
    int maaned = scanner.nextInt();
    System.out.println("indtast en dag");
    int dag = scanner.nextInt();

    String aarstid = aarstid(maaned, dag);
    System.out.println(aarstid);
    }

    public static String aarstid(int maaned, int dag){
        String i = "";
        if(maaned > 0 && maaned <= 3){
            i = "Vinter";
        }
        else if (maaned > 3 && maaned <= 6){
            i = "Forår";
        }
        else if (maaned > 6 && maaned <= 9){
            i = "Sommer";
        }
        else if (maaned > 9 && maaned <= 12){
            i = "Efterår";
        }
        if(maaned % 3 == 0 && dag >= 21){
            if(i.equals("Vinter")){
                i = "Forår";
            }
            else if (i.equals("Forår")){
                i = "Sommer";
            }
            else if (i.equals("Sommer")){
            i = "Efterår";
            }
            else{
            i = "Vinter";
            }
        }

        return i;
        }




}
