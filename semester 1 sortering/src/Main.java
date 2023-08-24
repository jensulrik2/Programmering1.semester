import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {



        String[] list =  {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};


       //bubbleSortString(list);
       //selectionSort(list);
       //for(String s : list){
       //      System.out.println(s);
       //}
        //

        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer("Erna","Jensen", 23);
        customers.add(customer1);
        Customer customer2 = new Customer("Arne","Jensen", 23);
        customers.add(customer2);
        Customer customer3 = new Customer("Åge","Jensen", 23);
        customers.add(customer3);

        selectionSortCustomer(customers);
        for(Customer s : customers){
           System.out.println(s.toString());
        }


    }
    private static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private static void swap2(ArrayList<Customer> list, int i, int j) {
        Customer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }


    //opgave 1
    public static void bubbleSortString(String[] list) {
        for (int i = list.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (list[j].compareTo(list[j+1]) > 0)
                    swap(list, j, j + 1);
            }
        }
    }


    public static void selectionSort(String[] list) {
        for (int i = 0; i < list.length; i++) {
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[currentMinIndex]) < 0 ) {
                    currentMinIndex = j;
                }

            }
            swap(list, i, currentMinIndex);
        }
    }

//    benyt denne metode
//    public static void selectionSortCustomer(ArrayList<Customer> list) {
//        for (int i = 0; i < list.size(); i++) {
//            int currentMinIndex = i;
//            for (int j = i + 1; j < list.size(); j++) {
//                if (list.get(j).getName().compareTo(list.get(currentMinIndex).getName()) < 0) {
//                    currentMinIndex = j;
//                }
//            }
//            swap2(list, i, currentMinIndex);
//        }
//    }
    public static void selectionSortCustomer(ArrayList<Customer> customers) {
        for (int i = 0; i < customers.size(); i++) {
            int currentMinIndex = i;
            for (int j = i + 1; j < customers.size(); j++) {
                if (customers.get(j).getFirstName().compareTo(customers.get(currentMinIndex).getFirstName()) < 0 ) {
                    currentMinIndex = j;
                }

            }
            swap2(customers,i, currentMinIndex);
        }
    }

}