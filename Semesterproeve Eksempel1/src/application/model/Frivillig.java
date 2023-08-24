package application.model;

import java.util.ArrayList;

public class Frivillig {
    private String navn;
    private String mobil;
    private int maksAntalTimer;
    private ArrayList<Vagt> vagter;

    public Frivillig(String navn, String mobil, int maksAntalTimer) {
        this.navn = navn;
        this.mobil = mobil;
        this.maksAntalTimer = maksAntalTimer;
    }

    public void addVagt(Vagt vagt){
        if (!vagter.contains(vagt)) {
            vagter.add(vagt);
            vagt.setFrivillig(this);
        }
    }

    public ArrayList<Vagt> getVagter() {
        return vagter;
    }

    public void removeVagt(Vagt vagt){
        if (vagter.contains(vagt)) {
            vagter.remove(vagt);
            vagt.setFrivillig(null);
        }
    }


}
