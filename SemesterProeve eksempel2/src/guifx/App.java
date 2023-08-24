package guifx;



import application.controller.Controller;
import application.model.Funktion;
import application.model.Medarbejder;
import application.model.Vagt;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static javafx.application.Application.launch;

public class App {
    public static void main(String[] args) {

        initStorage();

        Start.launch(Start.class);
    }

    public static void initStorage() {
        Funktion f1 = Controller.createFunktion("Filetering");
        Funktion f2 = Controller.createFunktion("Grøntsager");
        Funktion f3 = Controller.createFunktion("Sovs og tilbehør");
        Funktion f4 = Controller.createFunktion("Buffetopfyldning");
        Medarbejder m1 = Controller.createMedarbejder("Peter",6, LocalTime.of(8,0));
        Medarbejder m2 = Controller.createMedarbejder("Anne",8, LocalTime.of(8,0));
        Medarbejder m3 = Controller.createMedarbejder("Marie",6, LocalTime.of(10,0));
        Medarbejder m4 = Controller.createMedarbejder("Torben",8, LocalTime.of(7,0));
        Vagt v1 = Controller.createVagt("Røgede ål til medarbejderne", LocalDateTime.of(2022,6,24,8,0),LocalDateTime.of(2022,6,24,12,30));
        v1.addMedarbejder(m1);
        v1.addMedarbejder(m2);
        v1.addMedarbejder(m3);
        m1.addFunktion(f2);
        m1.addFunktion(f3);
        m1.addFunktion(f4);
        m2.addFunktion(f2);
        m2.addFunktion(f3);
        m2.addFunktion(f4);
        m3.addFunktion(f1);
        m3.addFunktion(f2);
        m3.addFunktion(f4);
        m4.addFunktion(f1);
        m4.addFunktion(f3);

    }
}
