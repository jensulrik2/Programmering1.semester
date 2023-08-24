import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ArrayList<Player> players = new ArrayList<>();

        Player player1 = new Player("Jens", 180,70,10);
        players.add(player1);

        Player player2 = new Player("Ulrik", 181,45,1);
        players.add(player2);

        Player player3 = new Player("Nicklas", 178,90,0);
        players.add(player3);

        Player player4 = new Player("Niklas", 160,130,3);
        players.add(player4);

        Player player5 = new Player("Niclas", 230,100,4);
        players.add(player5);

        Player player6 = new Player("Benjamin", 110,50,5);
        players.add(player6);

        Player player7 = new Player("Patrick", 200,110,11);
        players.add(player7);

        Player player8 = new Player("Esben", 150,65,15);
        players.add(player8);

        System.out.println(findPlayerLinear(players, 11));

        ArrayList<Player> players2 = new ArrayList<>();
        players2.add(player1);
        players2.add(player3);
        System.out.println(unevenGoals((players2)));
        players2.add(player2);
        System.out.println(unevenGoals((players2)));


        int[] numbers = {7, 56, 34, 3, 7, 14, 13, 4};
        System.out.println(first(numbers));
        int[] numbers2 = {7, 56, 34, 3, 7, 14, 4, 4};
        System.out.println(adjacent(numbers));
        System.out.println(adjacent(numbers2));


        System.out.println();
        int[] numbers3 = {7, 7, 14, 14, 14, 9, 9, 9, 9};
        System.out.println(adjacentN(numbers3,2));
        System.out.println(adjacentN(numbers3,3));
        System.out.println(adjacentN(numbers3,4));
        System.out.println(adjacentN(numbers3,5));
        System.out.println(adjacentN(numbers3,6));

        ArrayList<String> list = new ArrayList<>();
        list.add("Jens");
        list.add("Pizza");
        list.add("Meteor");
        list.add("Haj");
        System.out.println(findAllIndices(list,"Haj"));
        System.out.println(findAllIndices(list,"Pizza"));







    }

    public static Player findPlayerLinear(ArrayList<Player> players, int score){
        Player player = null;
        int i = 0;
        while(player == null && i < players.size()){
            Player p = players.get(i);
            if(p.getScoredMål() == score)
                player = p;
            else
                i++;
        }
        return player;
    }

    public static Player binarySearchPlayer(ArrayList<Player> players, int mål){
        Player player = null;
        int left = 0;
        int right = players.size() - 1;
        while( player == null && left <= right){
            int middle = (left + right) / 2;
            Player p = players.get(middle);
            if(p.getScoredMål() == mål && mål == 0)
                player = p;
            else if (p.getScoredMål() == mål && mål > 0)
                right = middle - 1;
            else
                left = middle + 1;
        }
    return player;
    }


    public static boolean unevenGoals(ArrayList<Player> players){
        boolean found = false;
        int i = 0;
        while(!found && i < players.size()){
            if(players.get(i).getScoredMål() % 2 != 0)
                found = true;
            else
                i++;
        }
        return found;
    }

    public static int first(int [] numbers){
        int number = 0;
        int i = 0;
        while(i < numbers.length && number == 0){
            if(numbers[i] > 9 && numbers[i] < 16){
                number = numbers[i];
            }
            else
                i++;
        }

        return number;
    }

    public static boolean adjacent(int [] numbers){
        boolean adj = false;
        int i = 1;
        while(i < numbers.length && !adj){
            if(numbers[i] == numbers[i-1]){
                adj = true;
            }
            else
                i++;
        }
        return adj;
    }

    public static boolean adjacentN(int [] numbers, int n){
        boolean adj = false;
        int m = 1;
        int i = 0;
        // while(i < numbers.length && !adj ){
        //while(!adj && i+1 < numbers.length){
        while (!adj && i < numbers.length - 1) {
            while (i < numbers.length - 1 && numbers[i] == numbers[i+1]) {
                m++;
                i++;
                if (m == n) {
                    adj = true;
                    break;
                }
            }
            m = 1; // Reset m to 1 when a non-adjacent number is encountered
            i++;
        }
        return adj;
    }

    public static ArrayList<Integer> findAllIndices(ArrayList<String> list, String target){

        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                indexes.add(i);
            }
        }
        return indexes;
    }






}