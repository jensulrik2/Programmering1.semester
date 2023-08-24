package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {

    private int nummer;
    private boolean inde;
    private LocalTime førsteTid;
    private LocalTime sidsteTid;
    private final ArrayList<Booking> bookinger = new ArrayList<>();
    private Kategori kategori;

    public ArrayList<Booking> getBookinger() {
        return new ArrayList<>(bookinger);
    }
    public Kategori getKategori() {
        return kategori;
    }

    public Bane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori) {
        this.nummer = nummer;
        this.inde = inde;
        this.førsteTid = førsteTid;
        this.sidsteTid = sidsteTid;
        this.kategori = kategori;
    }
    public void addBooking(Booking booking) {
        if (!bookinger.contains(booking)) {
            bookinger.add(booking);
            booking.setBane(this);
        }
    }

    public void removeBooking(Booking booking) {
        if (bookinger.contains(booking)) {
            bookinger.remove(booking);
            booking.setBane(null);
        }
    }
    public int getNummer() {
        return nummer;
    }

    public boolean isInde() {
        return inde;
    }

    public LocalTime getFørsteTid() {
        return førsteTid;
    }

    public LocalTime getSidsteTid() {
        return sidsteTid;
    }
    public int bookedeTimerPåDato(LocalDate dato){
        int samletAntalTimer = 0;
        ArrayList<Booking> bookinger = this.getBookinger();
        for(Booking b : bookinger){
            if(b.getDato().equals(dato)){
                samletAntalTimer += 1;
            }
        }
        return samletAntalTimer;
    }

//    public Booking[] antalBookningerPrTime(){
//        ArrayList<Booking> bookinger = this.getBookinger();
//        ArrayList<Booking> temp = new ArrayList<>();
//        int åbningstid = this.getSidsteTid().getHour() - this.getFørsteTid().getHour();
//        for(int i = 0; i<=åbningstid; i++){
//
//        }
//        Booking[] bookingerPrTime = new[];
//        this.getBookinger()
//    }

    public boolean tidLedig(LocalDate dato, LocalTime tid){
        boolean ledig = false;
        ArrayList<Booking> bookinger = this.getBookinger();
        LocalTime baneÅben = this.getFørsteTid();
        LocalTime baneLukket = this.getSidsteTid();

        for(Booking b : bookinger){
            if(b.getDato().equals(dato) && !b.getTid().equals(tid) || b.getTid().isAfter(this.getFørsteTid()) || b.getTid().equals(this.getFørsteTid()) && !b.getTid().isAfter(this.getSidsteTid())){
                if(tid.isAfter(this.førsteTid) || tid.equals(this.førsteTid) && tid.isBefore(this.sidsteTid)){
                    ledig = true;
                }
            }
        }
        return ledig;
    }

    @Override
    public String toString() {
        return "Nr." +
                nummer +
                " " + inde +
                "(" + førsteTid +
                " -> " + sidsteTid +
                "), " + kategori;
    }
}
