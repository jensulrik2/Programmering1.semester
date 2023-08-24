package guifx;

import application.controller.Controller;
import application.model.*;
import enumeration.DeltagerType;
import enumeration.Land;
import javafx.application.Application;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        initStorage();
        Application.launch(Start.class);
    }

    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        Konference k1 = Controller.createKonference("Computer World Summit", "En ny verden af Computere","Kirkesøvej 113, 8000", 1500, LocalDate.of(2023, 5, 18),LocalDate.of(2023,5,20));
        Konference k2 = Controller.createKonference("International Tech Conference","Join us for three days of cutting-edge technology discussions.","San Francisco, CA",750,LocalDate.of(2023, 10, 17),LocalDate.of(2023, 10, 19));
        Hotel h1 = Controller.createHotel("Den Hvide Klat", " Jens Ottos vej 13, 5000",1050,1250);
        Hotel h2 = Controller.createHotel("Scandic Hell","Dan Turells Gade 20, 8000",1000,1500);
        Hotel h3 = Controller.createHotel("Ding Dong Nuns","Kirkesøvej 49, 8000",20,50);
        k1.addHotel(h1);
        k1.addHotel(h2);
        k2.addHotel(h3);
        Service s3 = Controller.createService(h1, "Wifi", 100);
        Service s1 = Controller.createService(h1,"Safebox",50);
        Service s2 = Controller.createService(h1, "Fodmassage", 500);
        Service s4 = Controller.createService(h2, "Aftensmad", 45);
        Deltager d1 = Controller.createDeltager("Finn Madsen","53573007","ju@hotmail.dk","kirkesøvej 3, 5792", Land.DANMARK,null, DeltagerType.PENSIONIST);
        Deltager d2 = Controller.createDeltager("Niels Petersen","8888888","niel@mail.com","jens peters alle 12", Land.DANMARK, null, DeltagerType.PENSIONIST);
        Deltager d3 = Controller.createDeltager("Peter Sommer","12345678","Peter@mail.com","Peter sommers vej 10", Land.DANMARK,null,DeltagerType.PENSIONIST);
        Deltager d4 = Controller.createDeltager("Lone Jensen","65342323","lonejensen@com", "lonevej 10",Land.DANMARK,null,DeltagerType.PENSIONIST);
        Udflugt u1 = Controller.createUdflugt(k1,"Byrundtur Odense",125, "incl. Frokost", LocalDate.of(2023,5,18));
        Udflugt u2 = Controller.createUdflugt(k1,"Egeskov",75,"", LocalDate.of(2023,5,19));
        Udflugt u3 = Controller.createUdflugt(k1,"Trapholt Museum, Kolding",200,"incl. Frokost",LocalDate.of(2023,5,20));
        Tilmelding t1 = Controller.createTilmelding(d1, LocalDate.of(2023, 5, 18),LocalDate.of(2023,5,20),false,k1);
        Tilmelding t2 = Controller.createTilmelding(d2,LocalDate.of(2023,5,18),LocalDate.of(2023,5,20), false,k1);
        t2.setHotel(h1);
        Tilmelding t3 = Controller.createTilmelding(d3,LocalDate.of(2023,5,18),LocalDate.of(2023,5,20),false,k1);
        t3.setHotel(h1);
        Ledsager l1 = Controller.createLedsager(d3,"Mie sommer","54334343","mie@.com");
        t3.addService(s3);
        t3.addUdflugt(u2);
        t3.addUdflugt(u3);

        Tilmelding t4 = Controller.createTilmelding(d4,LocalDate.of(2023,5,18),LocalDate.of(2023,5,20),true,k1);
        t4.setHotel(h1);
        Ledsager l2 = Controller.createLedsager(d4,"Jan Madsen","","");
        t4.setLedsager(l2);
        t3.setLedsager(l1);

        t4.addService(s3);
        t4.addUdflugt(u1);
        t4.addUdflugt(u2);












    }




}


