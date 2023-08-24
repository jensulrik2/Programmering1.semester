package application.model;

public class FrivilligForening extends Frivillig {
    private String foreningNavn;
    private int antalPersoner;

    public FrivilligForening(String navn, String mobil, int maksAntalTimer,String foreningNavn, int antalPersoner) {
        super(navn,mobil,maksAntalTimer);
        this.foreningNavn = foreningNavn;
        this.antalPersoner = antalPersoner;
    }
}
