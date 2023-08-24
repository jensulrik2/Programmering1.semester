package application.controller;

import application.model.Bestilling;
import application.model.Forestilling;
import application.model.Kunde;
import application.model.Plads;
import enumeration.PladsType;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Plads createPlads(int række, int nr, int pris, PladsType pladsType){
        Plads plads = new Plads(række,nr,pris,pladsType);
        Storage.addPlads(plads);

        return plads;
    }
    public static ArrayList<Plads> getPladser(){
        return Storage.getPladser();
    }
    //-----------------------------------------------------------------------------------------------------------------

    public static Bestilling createBestilling(LocalDate dato, Kunde kunde, Forestilling forestilling){
        Bestilling bestilling = new Bestilling(dato,kunde,forestilling);
        Storage.addBestilling(bestilling);

        return bestilling;
    }

    //-----------------------------------------------------------------------------------------------------------------

    public static Kunde createKunde(String navn, String mobil){
        Kunde kunde = new Kunde(navn,mobil);
        Storage.addKunde(kunde);
        return kunde;
    }
    public static ArrayList<Kunde> getKunder(){
        return Storage.getKunder();
    }


    //-----------------------------------------------------------------------------------------------------------------

    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato){
        Forestilling forestilling = new Forestilling(navn,startDato,slutDato);
        Storage.addForestilling(forestilling);

        return forestilling;
    }
    public static ArrayList<Forestilling> getForestillinger(){
        return Storage.getForestillinger();
    }

    public static Bestilling opretBestillingMedPladser( Forestilling forestilling, Kunde kunde, LocalDate dato, ArrayList<Plads> pladser){
        Bestilling pladsBestilling = null;
        boolean ledig = true;
        for(int i = 0; i < forestilling.getBestillinger().size(); i++){
            if(!forestilling.erPladsLedig(pladser.get(i).getRække(),pladser.get(i).getNr(),dato)){
                ledig = false;
            }
        }
        if (ledig){
            pladsBestilling = new Bestilling(dato, kunde, forestilling);
        }

        return pladsBestilling;
    }



}
