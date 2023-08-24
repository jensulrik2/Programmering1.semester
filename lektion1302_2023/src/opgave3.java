public class opgave3 {

    public static void main(String[] args){



        //reverse(41356344);
        //futureInvestmentValue(1000, 0.09/12, 30);

        displayPattern(10);
    }

    //6.4
    public static void reverse(int n){
        int i = 0;
        while(1 < n){
            i = n % 10;
            System.out.print(i);
            n = n / 10;
            }

    }

    //6.7
    //futureInvestmentValue = investmentAmount * (1 + monthlyInterestRate)^numberOfYears*12
    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate,int years){
        int i = 0;
        double fInvestment = 0;
        while( i <= years){
            i++;
            System.out.println("year : " + i + " = " + fInvestment);
            fInvestment = investmentAmount * Math.pow((1 + monthlyInterestRate),(i*12));


        }
        return fInvestment;
    }

    //6.11

    public static void displayPattern(int a){
        int j = 1;
        int h = 1;
        int col = a;

        while ( j <= col) {
            j++;
            h = 1;
            System.out.println();
            while (h < j) {
                System.out.print(h);
                h++;
            }
        }




    }



}

