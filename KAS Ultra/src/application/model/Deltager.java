package application.model;


import enumeration.DeltagerType;
import enumeration.Land;

import java.util.ArrayList;

public class Deltager extends Person{
    private String adresse;
    private Land land;
    private String firma;
    private DeltagerType type;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private Ledsager ledsager;
    private ArrayList<Ledsager> ledsagere = new ArrayList<>();

    public Deltager(String navn, String tlf, String email, String adresse, Land land, String firma, DeltagerType type) {
        super(navn, tlf, email);
        this.adresse = adresse;
        this.land = land;
        this.firma = firma;
        this.type = type;
    }

    public DeltagerType getType() {
        return type;
    }
    public String getAdresse() {
        return adresse;
    }

    public Land getLand() {
        return land;
    }

    public String getFirma() {
        return firma;
    }

    public void addTilmelding(Tilmelding tilmelding){
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.setDeltager(this);
        }
    }
    public void removeTilmelding(Tilmelding tilmelding){
        if(tilmeldinger.contains(tilmelding)){
            tilmeldinger.remove(tilmelding);
            tilmelding.setDeltager(null);
        }
    }

    public ArrayList<Tilmelding> getTilmeldinger(){
        return new ArrayList<>(tilmeldinger);
    }

    public Ledsager createLedsager(String navn, String tlf, String email){
        Ledsager ledsager = new Ledsager(navn, tlf, email, this);
        this.ledsager = ledsager;
        ledsagere.add(ledsager);
        return ledsager;
    }

    @Override
    public String toString() {
        if (this.getLedsager() != null){
            return this.getNavn() + this.getLedsager();
    }
        return this.getNavn();
    }

    public Ledsager getLedsager() {
        return ledsager;
    }

    public ArrayList<Ledsager> getLedsagere() {
        return new ArrayList<>(ledsagere);
    }
}


