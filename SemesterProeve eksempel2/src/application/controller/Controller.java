package application.controller;

import application.model.Antal;
import application.model.Funktion;
import application.model.Medarbejder;
import application.model.Vagt;
import storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    public static Funktion createFunktion(String navn){
        Funktion funktion = new Funktion(navn);
        Storage.addFunktion(funktion);
        return funktion;
    }

    public static ArrayList<Funktion> getFunktioner(){
        return Storage.getFunktioner();
    }

    public static Medarbejder createMedarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid){
        Medarbejder medarbejder = new Medarbejder(navn,antalTimerPrDag,typiskMødetid);
        Storage.addMedarbejder(medarbejder);
        return medarbejder;
    }

    public static ArrayList<Medarbejder> getMedarbejdere(){
        return Storage.getMedarbejdere();
    }

    public static Vagt createVagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil){
        Vagt vagt = new Vagt(navn, tidFra, tidTil);
        Storage.addVagt(vagt);
        return vagt;
    }
    public static ArrayList<Vagt> getVagter(){
        return Storage.getVagter();
    }

    public static void vagtOversigt(Vagt vagt){
        String file = "C:\\Users\\judes\\IdeaProjects\\Programmering 1.semester\\SemesterProeve eksempel2\\src\\vagt oversigt.txt";
        try(Scanner scan = new Scanner(System.in); PrintWriter printWriter = new PrintWriter(file)) {
            ArrayList<Medarbejder> medarbejder = vagt.getMedarbejdere();
            printWriter.println("-------------------------------------------");
            printWriter.println(vagt.getTidFra() + " (" + vagt.getNavn() + ")");
            printWriter.println("-------------------------------------------");
            printWriter.println();
            printWriter.println();
            printWriter.println();
            printWriter.println("Funktioner:");

            for (int i = 1; i <= medarbejder.size(); i++) {
                printWriter.println(medarbejder.get(i).getFunktioner().get(i).getNavn());

            }

            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }





}
