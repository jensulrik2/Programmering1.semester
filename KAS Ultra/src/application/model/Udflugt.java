package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
    private String navn;
    private double pris;
    private String beskrivelse;
    private LocalDate dato;
    private Konference konference;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();


    public double getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return  navn + " - " + dato + " - Kr. " + pris + " " + beskrivelse;

    }

    public Udflugt(Konference konference, String navn, double pris, String beskrivelse, LocalDate dato) {
        this.navn = navn;
        this.pris = pris;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.konference = konference;
    }

    public Konference getKonference() {
        return konference;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }

    public void addTilmelding(Tilmelding tilmelding){
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.addUdflugt(this);
        }
    }
    public void removeTilmelding(Tilmelding tilmelding){
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
            tilmelding.removeUdflugt(this);
        }
    }



}
