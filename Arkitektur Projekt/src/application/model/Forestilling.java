package application.model;

import application.controller.Controller;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {

    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private final ArrayList<Bestilling> bestillinger;

    @Override
    public String toString() {
        return
                "navn: " + navn +
                ", startDato: " + startDato +
                ", slutDato: " + slutDato;
    }

    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.bestillinger = new ArrayList<>();
    }
    public ArrayList<Bestilling> getBestillinger(){
        return new ArrayList<>(bestillinger);
    }

    public Bestilling createBestilling(LocalDate dato, Kunde kunde,ArrayList<Plads> pladser) {
        Bestilling bestilling = new Bestilling(dato, kunde,this);
        bestillinger.add(bestilling);
        return bestilling;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public boolean erPladsLedig(int række, int nr, LocalDate dato){
        boolean ledig = true;

        for(int i = 0; i < bestillinger.size(); i++){
            if(bestillinger.get(i).getDato().equals(dato)) {
                ArrayList<Plads> pladser = bestillinger.get(i).getPladser();
                for (int j = 0; j < pladser.size(); j++) {
                    if (pladser.get(j).getNr() == nr && pladser.get(j).getRække() == nr) {
                        ledig = false;
                    }
                }
            }

        }
        return ledig;
    }
    public int antalBestiltePladserPåDag(LocalDate dato) {
        int antalBestiltePladser = 0;
        if (dato.isAfter(startDato) && dato.isBefore(slutDato) ||  dato.isEqual(startDato) || dato.isEqual(slutDato)) {
            for (Bestilling b : bestillinger) {
                antalBestiltePladser += b.getPladser().size();
            }
        }
        return antalBestiltePladser;
    }

    public LocalDate succesDato() {
        LocalDate succesDato = null;
        int flestBestilte = 0;

        LocalDate start = this.getStartDato();
        LocalDate slut = this.getSlutDato();

        LocalDate dato = start;
        while (!dato.equals(slut.plusDays(1))) {
            int antalBestilte = antalBestiltePladserPåDag(dato);
            if (antalBestilte > flestBestilte) {
                flestBestilte = antalBestilte;
                succesDato = dato;
            }
        }
        return succesDato;
    }



}
