package application.model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private String adresse;
    private int prisEnkelt;
    private int prisDobbelt;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private ArrayList<Service> services = new ArrayList<>();

    @Override
    public String toString() {
        return  navn + " ( " + adresse + " )" + '\n' + "Priser: dobbelt/enkelt Kr. " + prisEnkelt + "/" + prisDobbelt;

    }

    public double getPrisEnkelt() {
        return prisEnkelt;
    }

    public double getPrisDobbelt() {
        return prisDobbelt;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public Hotel(String navn, String adresse, int prisEnkelt, int prisDobbelt) {
        this.navn = navn;
        this.adresse = adresse;
        this.prisEnkelt = prisEnkelt;
        this.prisDobbelt = prisDobbelt;
        this.tilmeldinger = tilmeldinger;
    }

    public Service createService(String navn, double pris){
        Service service = new Service(navn,pris,this);
        services.add(service);
        return service;
    }

    public void removeService(Service service) {
        if (services.contains(service)) {
            services.remove(service);
        }
    }
    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.setHotel(this);
        }
    }
    public void removeTilmelding(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
            tilmelding.setHotel(null);
        }
    }


    public ArrayList<Tilmelding> getTilmeldinger() {
    return new ArrayList<>(tilmeldinger);
    }
}
