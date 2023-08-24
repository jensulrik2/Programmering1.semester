package application.model;

public class Service {
    private String navn;
    private double pris;
    private Hotel hotel;

    public double getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return navn + " Kr. " + pris;
    }

    public Service(String navn, double pris, Hotel hotel){
        this.navn = navn;
        this.pris = pris;
        this.hotel = hotel;
    }


    public String getNavn() {
        return navn;
    }
}
