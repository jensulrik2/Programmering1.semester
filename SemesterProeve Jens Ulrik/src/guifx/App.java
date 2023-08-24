package guifx;

import application.controller.Controller;
import application.model.*;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

import static javafx.application.Application.launch;

public class App {
    public static void main(String[] args) {
//        File file = new File("C:\Users\judes\IdeaProjects\Programmering 1.semester\SemesterProeve Jens Ulrik\src\bookinger.txt)";
        initStorage();
        launch(Start.class);
//        Controller.alleBookinger(file);
        Controller.alleBookinger();
    }

    public static void initStorage() {
        Kategori luksus = Controller.createKategori("Luksus",100,200);
        Kategori mellem = Controller.createKategori("Mellem",50,100);
        Kategori begynder = Controller.createKategori("Begynder",25,50);

        Bane b1 = Controller.createBane(1,true,LocalTime.of(9,0),LocalTime.of(17,0),luksus);
        Bane b2 = Controller.createBane(2,true,LocalTime.of(9,0),LocalTime.of(17,0),luksus);
        Bane b3 = Controller.createBane(3,true,LocalTime.of(9,0),LocalTime.of(17,0),mellem);
        Bane b4 = Controller.createBane(4,false,LocalTime.of(9,0),LocalTime.of(17,0),mellem);
        Bane b5 = Controller.createBane(5,false,LocalTime.of(9,0),LocalTime.of(17,0),begynder);
        Bane b6 = Controller.createBane(6,false,LocalTime.of(9,0),LocalTime.of(17,0),begynder);

        Spiller andreas = Controller.createSpiller("Andreas", "DMU");
        Spiller petra = Controller.createSpiller("Petra", "DMU");
        Spiller henrik = Controller.createSpiller("Henrik", "ITA");
        Spiller ulla = Controller.createSpiller("Ulla", "ITA");

        andreas.createBooking(LocalDate.of(2023,6,20),LocalTime.of(10,0),true,b3);
        andreas.createBooking(LocalDate.of(2023,6,22),LocalTime.of(10,0),false,b2);
        henrik.createBooking(LocalDate.of(2023,6,20),LocalTime.of(11,0),false,b3);
        ulla.createBooking(LocalDate.of(2023,6,20),LocalTime.of(16,0),false,b3);
        ulla.createBooking(LocalDate.of(2023,6,23),LocalTime.of(17,0),true,b5);





    }
}
