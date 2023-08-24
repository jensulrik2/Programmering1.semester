public class Opgave1 {
    public static void main(String[] args) {


        //lægger de 3 drenges alder sammen og dividerer med antallet af drenge, for at finde gennemsnitsalderen
        int gennemsnitDreng = (6 + 6 + 8) / 3;
        System.out.println("gennemsnitsalderen for drengene er " + gennemsnitDreng + " år");
        //samme fremgangsmetode som med drenge
        int gennemsnitPige = (15 + 16 +18) / 3;
        System.out.println("gennemsnitsalderen for pigerne er " + gennemsnitPige + " år");
        //her lægger vi så både piger og drenges alder sammen og dividerer med antallet af personer
        int gennemsnitAlle = (6 + 6 + 8 + 15 + 16 + 18) / 6;
        System.out.println("gennemsnitsalderen for børnene er " + gennemsnitAlle + " år");

    }
}