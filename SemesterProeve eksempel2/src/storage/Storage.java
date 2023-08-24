package storage;


import application.model.Funktion;
import application.model.Medarbejder;
import application.model.Vagt;
import java.util.ArrayList;

public class Storage {

    private static ArrayList<Funktion> funktioner = new ArrayList<>();
    private static ArrayList<Medarbejder> medarbejdere = new ArrayList<>();
    private static ArrayList<Vagt> vagter = new ArrayList<>();

    public static ArrayList<Funktion> getFunktioner() {
        return new ArrayList<Funktion>(funktioner);
    }

    public static ArrayList<Medarbejder> getMedarbejdere() {
        return new ArrayList<Medarbejder>(medarbejdere);
    }

    public static ArrayList<Vagt> getVagter() {
        return new ArrayList<Vagt>(vagter);
    }

    public static void addFunktion(Funktion funktion) { funktioner.add(funktion); }

    public static void addVagt(Vagt vagt) { vagter.add(vagt); }

    public static void addMedarbejder(Medarbejder medarbejder) { medarbejdere.add(medarbejder); }

}
