package application.model;

import java.util.ArrayList;

public class Bil {

    private int regNr;
    private Mærke mærke;
    private int model;
    private boolean status;
    private ArrayList<Værkstedbesøg> værkstedsBesøg;

    Bil(int regNr, Mærke mærke, int model){
        this.regNr = regNr;
        this.mærke = mærke;
        this.model = model;
        this.status = true;
    }

    public ArrayList<Værkstedbesøg> getVærkstedsBesøg(){
        return new ArrayList<>(værkstedsBesøg);
    }

    public int getRegNr() {
        return regNr;
    }

    public void setRegNr(int regNr) {
        this.regNr = regNr;
    }

    public Mærke getMærke() {
        return mærke;
    }

    public void setMærke(Mærke mærke) {
        this.mærke = mærke;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
