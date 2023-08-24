public class opgave2
{
    public static void main(String[] args){

        //6_2

        System.out.println(sumOddDigits(32677));


    }

    public static int sumOddDigits(int number){
        int sum = 0;
        int i = 0;
        while(0 < number){
            i = number % 10;
            if(number % 2 != 0){
                sum = sum + i;
                number = number / 10;
            }
            else{
                number = number / 10;
            }
        }
    return sum;
    }





}
