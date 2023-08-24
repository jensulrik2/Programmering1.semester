package application.controller;

import application.model.*;
import storage.Storage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Controller {

    public static Spiller createSpiller(String navn, String uddannelse){
        Spiller spiller = new Spiller(navn,uddannelse);
        Storage.addSpiller(spiller);
        return spiller;
    }
    public static Bane createBane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori){
        Bane bane = new Bane(nummer, inde, førsteTid, sidsteTid, kategori);
        Storage.addBane(bane);
        return bane;
    }
    public static Kategori createKategori(String navn, int prisKrSingle, int prisKrDouble){
        Kategori kategori = new Kategori(navn, prisKrSingle, prisKrDouble);
        Storage.addKategori(kategori);
        return kategori;
    }

    public static int samletBookingDoubleTid(String udannelse,Kategori kategori){
        ArrayList<Spiller> spillere = Storage.getSpillere();
        ArrayList<Kategori> kategorier = Storage.getKategorier();
        int samletTid = 0;

        for(Spiller s : spillere){
            if(s.getUddannelse().equals(udannelse)){
                ArrayList<Booking> bookinger = s.getBookinger();
                for(Booking b : bookinger){
                    if(b.getBane().getKategori().equals(kategori) && !b.isSingle()){
                        samletTid += 1;
                    }
                }
            }

        }
        return samletTid;
    }

//    public static void alleBookinger(String file){
    public static void alleBookinger(){
//        String tempFile = file;
        String file = "C:\\Users\\judes\\IdeaProjects\\Programmering 1.semester\\SemesterProeve Jens Ulrik\\src\\bookinger.txt";
        try(Scanner scan = new Scanner(System.in); PrintWriter printWriter = new PrintWriter(file)) {
            ArrayList<Bane> baner = Storage.getBaner();

            for(Bane b : baner){
                ArrayList<Booking> bookinger = b.getBookinger();
                for(Booking bo : bookinger){
                    printWriter.print("Bane nr: " + b.getNummer() + ", dag: " + bo.getDato() + " kl. " + bo.getTid() + ", spil: " + bo.isSingle() + " spiller: " + bo.getSpiller().getNavn() + "\n");
                }

            }
            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
