package application.model;

import enumeration.PladsType;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {

    private LocalDate dato;
    private ArrayList<Plads> pladser = new ArrayList<>();
    private Kunde kunde;
    private Forestilling forestilling;



    public Bestilling(LocalDate dato, Kunde kunde,Forestilling forestilling){
        this.dato = dato;
        this.kunde = kunde;
        pladser = new ArrayList<>();
        this.forestilling = forestilling;
        kunde.addBestilling((this));
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public ArrayList<Plads> getPladser(){
        return new ArrayList<>(pladser);
    }
    public void addPlads(Plads plads){
        if (!pladser.contains(plads)){
            pladser.add(plads);
        }
    }

    public LocalDate getDato() {
        return dato;
    }
    public Kunde getKunde() {
        return kunde;
    }

    public Forestilling getForestilling() {
        return forestilling;
    }
    public int samletPris() {
        int samletPris = 0;
        for (Plads p : pladser) {
            samletPris += p.getPris();
        }
        return samletPris;
    }
}
