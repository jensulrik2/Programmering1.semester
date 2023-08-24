package application.guifx;

import application.controller.Controller;
import application.model.*;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        initStorage();
        //Application.launch(Start.class);
    }

    public static void initStorage(){
        Festival f1 = Controller.createFestival("NorthSide", LocalDate.of(2020,06,04),LocalDate.of(2020,06,06));
        Frivillig fri1 = Controller.createFrivillig("Jane Jensen","12345677",20);
    }
}
