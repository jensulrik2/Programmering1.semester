package application.controller;

import application.model.Festival;
import application.model.Frivillig;
import application.model.Job;
import application.model.Vagt;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Festival createFestival(String navn, LocalDate fraDato, LocalDate tilDato){
        Festival festival = new Festival(navn, fraDato, tilDato);
        Storage.addFestival(festival);
        return festival;
    }
    public static ArrayList<Festival> getFestivaller(){
        return Storage.getFestivaller();
    }

    public static Frivillig createFrivillig(String navn, String mobil, int maksAntalTimer){
        Frivillig frivillig = new Frivillig(navn, mobil, maksAntalTimer);
        Storage.addFrivillig(frivillig);
        return frivillig;
    }
    public static ArrayList<Frivillig> getFrivillige(){
        return Storage.getFrivillige();
    }

    public static Job createJob(Festival festival, String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer){
        Job job = festival.createJob(kode, beskrivelse, dato, timeHonorar, antalTimer);
        return job;
    }

    public static Vagt createVagt(Job job, int timer){
        Vagt vagt = job.createVagt(timer);
        return vagt;
    }

}
