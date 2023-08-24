package application.model;

import java.time.LocalDate;

public class Værkstedbesøg {

    private Bil bil;
    private int kmTal;
    private LocalDate dato;

    public Bil getBil() {
        return bil;
    }

    public void setBil(Bil bil) {
        this.bil = bil;
    }

    public int getKmTal() {
        return kmTal;
    }

    public void setKmTal(int kmTal) {
        this.kmTal = kmTal;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public Værkstedbesøg(Bil bil, int kmTal, LocalDate dato){
        this.bil = bil;
        this.kmTal = kmTal;
        this.dato = dato;
    }


}
