package application.model;

import java.util.Date;

public class Lejekontrakt {

    private static int kontraktNr = 1;
    private Date kontraktDato;


    Lejekontrakt(int kontraktNr, Date date){
        this.kontraktNr = kontraktNr;
        this.kontraktDato = date;
        this.kontraktNr++;

    }
    Lejekontrakt(int kontraktNr){
        this.kontraktNr = kontraktNr;
        this.kontraktDato = new Date();
        this.kontraktNr++;
    }
    Lejekontrakt() {
        kontraktNr = this.kontraktNr;
        this.kontraktDato = new Date();
        this.kontraktNr++;

    }
}
