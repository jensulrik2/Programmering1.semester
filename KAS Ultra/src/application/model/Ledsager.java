package application.model;

import java.util.ArrayList;
import java.util.Timer;

public class Ledsager extends Person{

    private Deltager deltager;

    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Ledsager(String navn, String tlf, String email, Deltager deltager) {
        super(navn, tlf, email);
        this.deltager = deltager;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    @Override
    public String toString() {
        return getNavn();
    }

    public void addTilmelding(Tilmelding tilmelding){
        if(!this.tilmeldinger.contains(tilmelding)){
            this.tilmeldinger.add(tilmelding);
            tilmelding.setLedsager(this);
        }
    }
    public void removeTilmelding(Tilmelding tilmelding){
        if(this.tilmeldinger.contains(tilmelding)){
            this.tilmeldinger.remove(tilmelding);
            tilmelding.setLedsager(null);
        }
    }
}