package application.model;
import java.util.ArrayList;
import java.time.LocalTime;

public class Medarbejder {

    private String navn;
    private int antalTimerPrDag;
    private LocalTime typiskMødetid;
    private final ArrayList<Vagt> vagter = new ArrayList<>();
    private final ArrayList<Funktion> funktioner = new ArrayList<>();
    public ArrayList<Funktion> getFunktioner() {
        return new ArrayList<>(funktioner);
    }

    public void addFunktion(Funktion funktion) {
        if (!funktioner.contains(funktion)) {
            funktioner.add(funktion);
        }
    }
    public void removeFunktion(Funktion funktion) {
        if (funktioner.contains(funktion)) {
            funktioner.remove(funktion);
        }
    }

    public ArrayList<Vagt> getVagter() {
        return vagter;
    }

    public void addVagt(Vagt vagt) {
        if (!vagter.contains(vagt)) {
            vagter.add(vagt);
            vagt.addMedarbejder(this);
        }
    }

    public void removeVagt(Vagt vagt) {
        if (vagter.contains(vagt)) {
            vagter.remove(vagt);
            vagt.removeMedarbejder(this);
        }
    }

    @Override
    public String toString() {
        return  navn + ", typiskMødetid " + typiskMødetid;
    }

    public Medarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        this.navn = navn;
        this.antalTimerPrDag = antalTimerPrDag;
        this.typiskMødetid = typiskMødetid;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntalTimerPrDag() {
        return antalTimerPrDag;
    }

    public LocalTime getTypiskMødetid() {
        return typiskMødetid;
    }
}
