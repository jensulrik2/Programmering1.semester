package storage;

import application.model.Forestilling;
import application.model.Bestilling;
import application.model.Kunde;
import application.model.Plads;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Forestilling> forestillinger = new ArrayList<>();
    private static ArrayList<Kunde> kunder = new ArrayList<>();
    private static ArrayList<Bestilling> bestillinger = new ArrayList<>();
    private static ArrayList<Plads> pladser = new ArrayList<>();
    // -------------------------------------------------------------------------
    public static void addForestilling(Forestilling forestilling){
        forestillinger.add(forestilling);
    }
    public static ArrayList<Forestilling> getForestillinger(){
        return new ArrayList<Forestilling>(forestillinger);
    }

    // -------------------------------------------------------------------------
    public static void addKunde(Kunde kunde){
        kunder.add(kunde);
    }
    public static ArrayList<Kunde> getKunder(){
        return new ArrayList<Kunde>(kunder);
    }

    // -------------------------------------------------------------------------

    public static void addBestilling(Bestilling bestilling){
        bestillinger.add(bestilling);
    }
    public static ArrayList<Bestilling> getBestillinger(){
        return new ArrayList<Bestilling>(bestillinger);
    }
    // -------------------------------------------------------------------------
    public static void addPlads(Plads plads){
        pladser.add(plads);
    }
    public static ArrayList<Plads> getPladser(){
        return new ArrayList<Plads>(pladser);
    }



}
