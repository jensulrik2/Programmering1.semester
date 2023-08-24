package application.model;

public class Udlejning {

    private String aktuelUdlPeriode;
    private int depositum;
    private int kmStart;
    private int kmSlut;

    public Udlejning(String aktuelUdlPeriode, int depositum, int kmStart, int kmSlut) {
        this.aktuelUdlPeriode = aktuelUdlPeriode;
        this.depositum = depositum;
        this.kmStart = kmStart;
        this.kmSlut = kmSlut;
    }
}
