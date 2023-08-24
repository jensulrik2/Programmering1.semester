package application.model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {

    private String navn;
    private String mobil;
    private final ArrayList<Bestilling> bestillinger;
    private Bestilling bestilling;


    @Override
    public String toString() {
        return
                "navn: " + navn +
                ", mobil: " + mobil;
    }

    public Kunde(String navn, String mobil){
        this.navn = navn;
        this.mobil = mobil;
        this.bestillinger = new ArrayList<>();
    }

    public Bestilling getBestilling() {
        return bestilling;
    }

    public ArrayList<Bestilling> getBestillinger(){
        return new ArrayList<>(bestillinger);
    }

    public void addBestilling(Bestilling bestilling){
        if (bestillinger.contains(bestilling)){
            bestillinger.remove(bestilling);
        }
        bestilling.setKunde(this);
    }
    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }


    public ArrayList<Plads> bestiltePladserTilForestillingPåDag(Forestilling forestilling, LocalDate dato) {
        ArrayList<Plads> pladserPåDato = new ArrayList<>();
        for (Bestilling b : bestillinger) {
            if (b.getForestilling().equals(forestilling) && b.getDato().equals(dato)) {
                pladserPåDato.addAll(b.getPladser());
            }
        }
        return pladserPåDato;
    }
}
