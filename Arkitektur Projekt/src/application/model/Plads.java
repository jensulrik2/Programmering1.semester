package application.model;

import enumeration.PladsType;

public class Plads {

    private int række;
    private int nr;
    private int pris;
    private PladsType pladsType;

    public Plads(int række, int nr,int pris,PladsType pladsType) {
        this.række = række;
        this.nr = nr;
        this.pris = pris;
        this.pladsType = pladsType;
    }

    @Override
    public String toString() {
        return
                "rk:" + række +
                ", nr:" + nr +
                ", pris:" + pris +
                ", Type:" + pladsType;
    }

    public int getRække() {
        return række;
    }

    public int getNr() {
        return nr;
    }

    public int getPris() {
        return pris;
    }

    public PladsType getPladsType() {
        return pladsType;
    }
}
