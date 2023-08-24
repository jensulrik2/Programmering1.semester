package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private String beskrivelse;
    private String adresse;
    private double pris;
    private LocalDate startDato;
    private LocalDate slutDato;
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private ArrayList<Hotel> hoteller = new ArrayList<>();
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();


    public double getPris() {
        return pris;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }
    public Konference(String navn, String beskrivelse, String adresse, double pris, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.adresse = adresse;
        this.pris = pris;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public Udflugt createUdflugt(Konference konference,String navn, double pris, String beskrivelse, LocalDate dato){
        Udflugt udflugt = new Udflugt(konference,navn,pris,beskrivelse,dato);
        udflugter.add(udflugt);

        return udflugt;
    }

    @Override
    public String toString() {
        return  navn +
                '\n' + "Starter: " + startDato +
                '\n' + "Slutter: " + slutDato;
    }

    public Tilmelding createTilmelding(Deltager deltager, LocalDate ankomst, LocalDate afrejse, boolean foredragsholder){
        if (ankomst.isBefore(this.getStartDato()) || afrejse.isAfter(this.getSlutDato())) {
            throw new IllegalArgumentException("Tilmeldingens datoer er ikke inden for konferencedatoerne.");
        }
        else {
            Tilmelding tilmelding = new Tilmelding(deltager, ankomst, afrejse, foredragsholder, this);
            tilmeldinger.add(tilmelding);
            return tilmelding;
        }
    }
    public void removeUdflugt(Udflugt udflugt) {
        if (udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
        }
    }
    public void removeTilmelding(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
        }
    }

    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }
    public void addHotel(Hotel hotel) {
        if (!hoteller.contains(hotel)) {
            hoteller.add(hotel);
        }
    }

    public void removeHotel(Hotel hotel) {
        if (hoteller.contains(hotel)) {
            hoteller.remove(hotel);
        }
    }
    public ArrayList<Hotel> getHoteller() {
        return hoteller;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }

    public ArrayList<LocalDate> getDatoer(){
        ArrayList<LocalDate> dates = new ArrayList<>();

        LocalDate start = this.getStartDato();
        LocalDate slut = this.getSlutDato();
        while (!start.isAfter(slut)) {
            dates.add(start);
            start = start.plusDays(1);
        }

        return dates;
    }


    public String getNavn() {
        return navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public String getAdresse() {
        return adresse;
    }
}
