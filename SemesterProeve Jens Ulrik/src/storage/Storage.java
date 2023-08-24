package storage;

import application.model.Bane;
import application.model.Kategori;
import application.model.Spiller;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Spiller> spillere = new ArrayList<>();
    private static ArrayList<Bane> baner = new ArrayList<>();
    private static ArrayList<Kategori> kategorier = new ArrayList<>();

    public static void addSpiller(Spiller spiller) { spillere.add(spiller); }
    public static void addBane(Bane bane) { baner.add(bane); }
    public static void addKategori(Kategori kategori) { kategorier.add(kategori); }
    public static ArrayList<Spiller> getSpillere() {
        return new ArrayList<Spiller>(spillere);
    }
    public static ArrayList<Bane> getBaner() {
        return new ArrayList<Bane>(baner);
    }
    public static ArrayList<Kategori> getKategorier() {
        return new ArrayList<Kategori>(kategorier);
    }


}
