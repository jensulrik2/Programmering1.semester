package application.controller;

import application.model.*;
import enumeration.DeltagerType;
import enumeration.Land;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Konference createKonference(String navn, String beskrivelse, String adresse, double pris, LocalDate startDato, LocalDate slutDato){
        Konference konference = new Konference(navn, beskrivelse, adresse, pris, startDato, slutDato);
        Storage.addKonference(konference);
        return konference;
    }

    public static ArrayList<Konference> getKonferencer(){
        return Storage.getKonferencer();
    }

    //-----------------------------------------------

    public static Hotel createHotel(String navn, String adresse, int prisEnkelt, int prisDobbelt){
        Hotel hotel = new Hotel(navn, adresse, prisEnkelt, prisDobbelt);
        Storage.addHotel(hotel);

        return hotel;
    }
    public static ArrayList<Hotel> getHoteller(){
        return Storage.getHoteller();
    }
    //-----------------------------------------------
    public static Tilmelding createTilmelding(Deltager deltager, LocalDate ankomst, LocalDate afrejse, boolean foredragsholder, Konference konference){
        Tilmelding tilmelding = konference.createTilmelding(deltager, ankomst, afrejse, foredragsholder);
        return tilmelding;
    }

    public static ArrayList<Tilmelding> getTilmeldinger(Konference konference){
        return konference.getTilmeldinger();
    }

    //-----------------------------------------------
    public static Udflugt createUdflugt(Konference konference, String navn, double pris, String beskrivelse, LocalDate dato){
        Udflugt udflugt = konference.createUdflugt(konference,navn, pris, beskrivelse, dato);
        return udflugt;
    }

    //--------------------------------------------------------------------
    public static Service createService( Hotel hotel, String navn, double pris){
        Service service = hotel.createService(navn, pris);
        return service;
    }

    //--------------------------------------------------



    //---------------------------------------------------

    public static Deltager createDeltager(String navn, String tlf, String email, String adresse, Land land, String firma, DeltagerType type){
        Deltager deltager = new Deltager(navn, tlf, email, adresse, land, firma, type);
        Storage.addDeltager(deltager);
        return deltager;
    }

    //---------------------------------------------------
    public static Ledsager createLedsager(Deltager deltager, String navn, String tlf, String email){
        Ledsager ledsager = deltager.createLedsager(navn,tlf,email);
        return ledsager;
    }

    public static ArrayList<Deltager> getDeltagere() {
        return Storage.getDeltagere();
    }

    public static ArrayList<Udflugt> getUdflugter(Konference konference) {
        return konference.getUdflugter();
    }
}
