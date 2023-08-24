public class Main {
    public static void main(String[] args) {

        Account account1 = new Account();
        Account account2 = new Account(1122, 20000);

        account2.setAnnualInterestRate(4.5);
        account2.getMonthlyInterestRate();


        account2.deposit(2500);
        System.out.println("balance:" + (account2.getBalance()) + "$");
        account2.withdraw(3000);
        System.out.println("balance:" + (account2.getBalance()) + "$");
        System.out.println("Monthly Interest: " + (account2.getMonthlyInterest()) + "$");
        System.out.println("Created:" + account2.getDateCreated());
        System.out.println("Created:" + account1.getDateCreated());

    }
}