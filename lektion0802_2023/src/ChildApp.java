public class ChildApp {

   // Metoden skal returnere en tekststreng der beskriver hvilken institution et barn skal gå i, afhængig af barnets alder.
   // Reglerne for dette kan ses på opgavedsedlen
   //
    public static String institution(int age) {
        String i = "";
        if(age==0){
            i = "home";
        }
        else if(age == 1 || age == 2){
            i = "Nursery";
        }
        else if(3 <= age && age <= 5){
            i = "Kindergarten";
        }
        else if(5 < age && age > 17){
            i = "School";
        }
        else if(age >= 17){
            i = "Out of school";
        }
        return i;
    }


    // Metoden skal returenre en tekststreng der beskriver hvilket gymnastikhold et barn skal gå på, afhængig af barnets alder og køn.
    // Reglerne for dette kan ses på opgavedsedlen
    //
   public static String team(boolean isBoy, int age) {

       String t = "";

        if(isBoy == false && age < 8){
            t = "Tumbling girls";
        }
        else if(isBoy == false && age >= 8){
            t = "Springy girls";
        }
        else if(isBoy == true && age < 8){
            t = "Young cubs";
        }
        else if(isBoy == true && age >= 8){
            t = "Cool boys";
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println("Et barn på 5 skal i " + institution(5));
        System.out.println("En dreng på 8 skal i " + team(true,8));
        System.out.println("Et barn på 5 skal i " + institution(5));
        System.out.println("En pige på 12 skal i " + team(false,8));
        System.out.println("En dreng på 6 skal i " + team(true,6));

    }
}
