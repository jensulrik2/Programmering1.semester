package storage;

import application.model.Kunde;
import application.model.Bil;
import application.model.Lejekontrakt;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Kunde> kunder = new ArrayList<>();
    private static ArrayList<Bil> biler = new ArrayList<>();
    private static ArrayList<Lejekontrakt> lejekontrakter = new ArrayList<>();
    // -------------------------------------------------------------------------
    public static ArrayList<Kunde> getKunder() {
        return new ArrayList<Kunde>(kunder);
    }
    public static void addKunde(Kunde kunde){
        kunder.add(kunde);
    }
    public static void removeKunde(Kunde kunde) {
        kunder.remove(kunde);
    }

    // -------------------------------------------------------------------------
    public static ArrayList<Bil> getBiler() {
        return new ArrayList<Bil>(biler);
    }
    public static void addBil(Bil bil){
        biler.add(bil);
    }
    public static void removeBil(Bil bil) {
        biler.remove(bil);
    }

    // -------------------------------------------------------------------------
    public static ArrayList<Lejekontrakt> getLejekontrakter() {
        return new ArrayList<Lejekontrakt>(lejekontrakter);
    }
    public static void addLejekontrakt(Lejekontrakt lejekontrakt){
        lejekontrakter.add(lejekontrakt);
    }
    public static void removeLejekontrakt(Lejekontrakt lejekontrakt) {
        lejekontrakter.remove(lejekontrakt);
    }

}
