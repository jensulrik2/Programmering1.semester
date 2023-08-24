package application.model;

public class Antal {

    private int antal;
    private Funktion funktion;

    public Funktion getFunktion() {
        return funktion;
    }

    public int getAntal() {
        return antal;

    }

    public Antal(int antal, Funktion funktion) {
        this.antal = antal;
        this.funktion = funktion;
    }
}
