package application.model;

public class Kunde {

    private String navn;
    private String addresse;
    private int kørekortNr;
    private int telefonNr;


    Kunde(String navn, String addresse, int kørekortNr, int telefonNr){
        this.navn = navn;
        this.addresse = addresse;
        this.kørekortNr = kørekortNr;
        this.telefonNr = telefonNr;
    }
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public int getKørekortNr() {
        return kørekortNr;
    }

    public void setKørekortNr(int kørekortNr) {
        this.kørekortNr = kørekortNr;
    }

    public int getTelefonNr() {
        return telefonNr;
    }

    public void setTelefonNr(int telefonNr) {
        this.telefonNr = telefonNr;
    }






}
