import java.util.ArrayList;

public class Exercise2 {

    public static void main(String[] args){

        ArrayList<Integer> numbers = new ArrayList<Integer> ();

        numbers.add(6);
        numbers.add(2);
        numbers.add(12);
        numbers.add(7);
        numbers.add(10);
        numbers.add(3);
        numbers.add(4);

        System.out.println(sum(numbers));
        System.out.println(minimum(numbers));
        System.out.println(maximum((numbers)));
        System.out.println(average(numbers));
        System.out.println(evens(numbers));
    }

    public static int sum(ArrayList<Integer> list){
        int numbersSum = 0;
        for(int number : list){
            numbersSum += number;
        }
        return numbersSum;
    }

    public static int minimum(ArrayList<Integer> list){
        int min = list.get(0);
        for(int number : list){
            if(min > number){
                min = number;
            }
        }
        return min;
    }

    public static int maximum(ArrayList<Integer> list){
        int max = list.get(0);
        for(int number : list){
            if(max < number){
                max = number;
            }
        }
        return max;
    }

    public static double average(ArrayList<Integer> list){
        double length = list.size();
        double ave = sum(list)/length;

        return ave;
    }

    public static int zeroes(ArrayList<Integer> list){
        int zero = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == 0){
                zero++;
            }
        }


        return zero;
    }

    public static ArrayList<Integer> evens(ArrayList<Integer> list){
        ArrayList<Integer> even = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) % 2 == 0){
                even.add(list.get(i));
            }
        }
        return even;
    }






}
