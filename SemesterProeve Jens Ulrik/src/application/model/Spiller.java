package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Spiller {

    private String navn;
    private String uddannelse;
    private final ArrayList<Booking> bookinger = new ArrayList<>();



    public Spiller(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
    }

    @Override
    public String toString() {
        return  navn +
                " (" + uddannelse + ")";
    }

    public Booking createBooking(LocalDate dato, LocalTime tid, boolean single, Bane bane) {
        Booking booking = new Booking(dato, tid, single,this,bane);
        bookinger.add(booking);
        return booking;
    }
    public void removeBooking(Booking booking) {
        if (bookinger.contains(booking)) {
            bookinger.remove(booking);
        }
    }

    public ArrayList<Booking> getBookinger() {
        return new ArrayList<>(bookinger);
    }
    public String getNavn() {
        return navn;
    }

    public String getUddannelse() {
        return uddannelse;
    }

    public int samletPris(Kategori kategori){
        int pris = 0;
        ArrayList<Booking> bookinger = this.getBookinger();
        for(Booking b : bookinger){
            if(kategori.equals(b.getBane().getKategori())){
                if(b.isSingle()){
                    pris += b.getBane().getKategori().getPrisKrSingle();
                }
                else{
                    pris += b.getBane().getKategori().getPrisKrDouble();
                }
            }
        }
        return pris;
    }

}
