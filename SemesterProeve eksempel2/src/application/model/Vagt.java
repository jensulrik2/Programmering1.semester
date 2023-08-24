package application.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Vagt {

    private String navn;
    private LocalDateTime tidFra;
    private LocalDateTime tidTil;
    private final ArrayList<Antal> antaller = new ArrayList<>();
    private final ArrayList<Medarbejder> medarbejdere = new ArrayList<>();


    public ArrayList<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere);
    }
    public void addMedarbejder(Medarbejder medarbejder) {
        if (!medarbejdere.contains(medarbejder)) {
            medarbejdere.add(medarbejder);
            medarbejder.addVagt(this);
        }
    }

    public void removeMedarbejder(Medarbejder medarbejder) {
        if (medarbejdere.contains(medarbejder)) {
            medarbejdere.remove(medarbejder);
            medarbejder.removeVagt(this);
        }
    }

        public ArrayList<Antal> getAntaller() {
        return new ArrayList<>(antaller);
    }

    public Antal createAntal(int a, Funktion funktion) {
        Antal antal = new Antal(a,funktion);
        antaller.add(antal);
        return antal;
    }


    public String getNavn() {
        return navn;
    }

    public LocalDateTime getTidFra() {
        return tidFra;
    }

    public LocalDateTime getTidTil() {
        return tidTil;
    }

    @Override
    public String toString() {
        return   navn;
    }

    public Vagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        this.navn = navn;
        this.tidFra = tidFra;
        this.tidTil = tidTil;
    }

    public Medarbejder findMedarbejder(LocalTime tidspunkt, int antalTimer){
        Medarbejder medarbejder = null;
            for(Medarbejder m : medarbejdere){
                if(m.getTypiskMødetid()==tidspunkt && m.getAntalTimerPrDag()>=antalTimer){
                    medarbejder = m;
                }
            }
        return medarbejder;
    }

    public int beregnTimeforbrug(){
        int timeforbrug = 0;
        Duration vagtLængde = Duration.between(this.getTidFra(), this.getTidTil());
        long timer = vagtLængde.toHours();
        for(Medarbejder m : medarbejdere){
            timeforbrug += timer;
        }

        return timeforbrug;
    }

    public int antalMedarbejdereMedFunktion(Funktion funktion){
        int antal = 0;
        for(int i = 0; i < medarbejdere.size(); i++){
            if(medarbejdere.get(i).getFunktioner().contains(funktion)){
                antal++;
            }
        }
        return antal;
    }

    public Medarbejder[] skalAdviseresOmMødetid(){
        ArrayList<Medarbejder> temp = new ArrayList<>();
        for(Medarbejder m : medarbejdere){
            if(m.getTypiskMødetid().isAfter(LocalTime.from(this.tidFra))){
                temp.add(m);
            }
        }
        Medarbejder[] arr = new Medarbejder[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            arr[i] = temp.get(i);
        }
        return arr;
    }


}
