import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {



        ArrayList<Kunde> l1 = new ArrayList<Kunde>();ArrayList<Kunde> l2 = new ArrayList<Kunde>();

        Kunde k1 = new Kunde("Adam","Jensen");
        Kunde k2 = new Kunde("Børge", "Petersen");
        Kunde k3 = new Kunde("Emma", "Andersen");
        Kunde k4 = new Kunde("Jens","Ulrik");
        Kunde k5 = new Kunde("Liam", "Mortensen");

        Kunde k6 = new Kunde("Ava", "Larsen");
        Kunde k7 = new Kunde("Isabella", "Christensen");
        Kunde k8 = new Kunde("Noah", "Møller");
        Kunde k9 = new Kunde("Olivia", "Hansen");
        Kunde k10 = new Kunde("William", "Olsen");

        l1.add(k1);
        l1.add(k2);
        l1.add(k3);
        l1.add(k4);
        l1.add(k5);



        Kunde[] arr3 = {k6,k7,k8,k9,k10};

        l2.add(k2);
        l2.add(k7);
        l2.add(k5);
        l2.add(k9);
        l2.add(k4);

        ArrayList<Kunde> l3 = new ArrayList<Kunde>();
        l3.add(k1);
        l3.add(k2);
        l3.add(k3);
        l3.add(k4);
        l3.add(k5);
        l3.add(k6);
        l3.add(k7);
        l3.add(k8);
        l3.add(k9);
        l3.add(k10);

        ArrayList<Kunde> kunder = fletString(l1,l2);
        for(Kunde k : kunder){
            System.out.println(k.toString());
        }

        int[] arr1 = {2,4,6,8,10,12,14};
        int[] arr2 = {1,2,4,5,6,9,12,17};

        ArrayList<Integer> result = fællesInt(arr1,arr2);
        for(int r : result){
            System.out.println(r);
        }

        ArrayList<Kunde> result2 = goodCustomers(l3,arr3);
        for(Kunde r : result2){
            System.out.println(r);
        }






    }

    public static ArrayList<Kunde> fletString(ArrayList<Kunde> s1,
                                          ArrayList<Kunde> s2) {
        ArrayList<Kunde> result = new ArrayList<Kunde>();
        int i1 = 0;
        int i2 = 0;
    // flet sålænge der er noget i begge lister
        while (i1 < s1.size() && i2 < s2.size()) {
            if (s1.get(i1).getLastName().compareTo((s2.get(i2).getLastName())) <= 0) {
    // s1's første tal er mindst
                result.add(s1.get(i1));
                i1++;
            }
            else { // s2's første tal er mindst
                result.add(s2.get(i2));
                i2++;
            }
        }
    // tøm den liste der ikke er tom
        while (i1 < s1.size()) {
            result.add(s1.get(i1));
            i1++;
        }
        while (i2 < s2.size()) {
            result.add(s2.get(i2));
            i2++;
        }
        return result;
    }

    public static ArrayList<Integer> fællesInt(int[] l1,
                                             int[] l2){
        ArrayList<Integer> result = new ArrayList<>();

        int i1 = 0;
        int i2 = 0;

        while (i1 < l1.length && i2 < l2.length) {
            if (l1[i1] == l2[i2]) {
                result.add(l1[i1]);
                i1++;
                i2++;
            } else if (l1[i1] < l2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        return result;
    }

    public static ArrayList goodCustomers(ArrayList<Kunde> l1,
                                          Kunde[] l2){
        ArrayList<Kunde> l3 = new ArrayList<>();

        int i = 0;
        while (!l1.isEmpty() && i < l2.length) {
            if (l1.get(0).compareTo(l2[i]) != 0) {
                l3.add(l1.remove(0));
            }
            else {
                l1.remove(0);
                i++;
            }
        }
        return l3;
    }

    public static <T> ArrayList<T> fletArrayList(ArrayList<T> liste1, ArrayList<T> liste2) {
        ArrayList<T> resultat = new ArrayList<>();

        int lengde1 = liste1.size();
        int lengde2 = liste2.size();
        int lengde = Math.max(lengde1, lengde2);

        for (int i = 0; i < lengde; i++) {
            if (i < lengde1) {
                resultat.add(liste1.get(i));
            }
            if (i < lengde2) {
                resultat.add(liste2.get(i));
            }
        }

        return resultat;
    }



}