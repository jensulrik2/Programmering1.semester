package application.model;

import enumeration.DeltagerType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tilmelding {
    private LocalDate ankomst;
    private LocalDate afrejse;
    private boolean foredragsholder;
    private Konference konference;
    private Deltager deltager;
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private ArrayList<Service> services = new ArrayList<>();
    private Hotel hotel;
    private Ledsager ledsager;

    public Ledsager getLedsager() {
        return ledsager;
    }

    public void setLedsager(Ledsager ledsager) {
        if (this.ledsager != ledsager) {
            Ledsager oldLedsager = this.ledsager;
            if (oldLedsager != null) {
                ledsager.removeTilmelding(this);
            }
            this.ledsager = ledsager;
            if (ledsager != null) {
                ledsager.addTilmelding(this);
            }
        }
    }

    public Tilmelding(Deltager deltager, LocalDate ankomst, LocalDate afrejse, boolean foredragsholder, Konference konference) {
        this.deltager = deltager;
        this.ankomst = ankomst;
        this.afrejse = afrejse;
        this.foredragsholder = foredragsholder;
        this.konference = konference;
    }

    public void setKonference(Konference konference) {
        this.konference = konference;
    }
    public Konference getKonference() {
        return konference;
    }

    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
        deltager.addTilmelding(this);


    }
    public Deltager getDeltager() {
        return deltager;
    }

    public LocalDate getAnkomst() {
        return ankomst;
    }

    public LocalDate getAfrejse() {
        return afrejse;
    }

    public boolean isForedragsholder() {
        return foredragsholder;
    }

    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    public void setUdflugter(ArrayList<Udflugt> udflugter) {
        this.udflugter = udflugter;
    }

    public void addService(Service service){
        if (!services.contains(service)) {
            services.add(service);
        }
    }
    public void removeService(Service service){
        if (services.contains(service)) {
            services.remove(service);
        }
    }

    public void addUdflugt(Udflugt udflugt){
        if (!udflugter.contains(udflugt)) {
            udflugter.add(udflugt);
            udflugt.addTilmelding(this);
        }
    }
    public void removeUdflugt(Udflugt udflugt){
        if (udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
            udflugt.removeTilmelding(this);
        }
    }
    public ArrayList<Service> getServices() {
        return services;
    }
    public Hotel getHotel() {
        return hotel;
    }
    public void setHotel(Hotel hotel) {
        if (this.hotel != hotel) {
            Hotel oldHotel = this.hotel;
            if (oldHotel != null) {
                oldHotel.removeTilmelding(this);
            }
            this.hotel = hotel;
            if (hotel != null) {
                hotel.addTilmelding(this);
            }
        }

    }




    //TODO samletPris metode der regner ud, hvad det hele koster tilsammen for en tilmelding
    public double samletPris(){
        ArrayList<Service> services = this.getServices();
        ArrayList<Udflugt> udflugter = this.getUdflugter();
        double samletPris = 0;
        double serviceOmkostninger = 0;
        double udflugtOmkostninger = 0;
        double konferenceOmkostninger = this.getKonference().getPris();
        //beregner pris pr. dag for services, hvis der er booket hotel
        if(this.getHotel() != null) {
            for (Service s : services) {
                serviceOmkostninger += s.getPris();
            }
            if(this.getDeltager().getLedsager()!=null){
                samletPris += (this.getHotel().getPrisDobbelt() + serviceOmkostninger) * this.getAntalNætter();
            }
            else{
                samletPris += (this.getHotel().getPrisEnkelt() + serviceOmkostninger) * this.getAntalNætter();
            }
        }
        //beregner pris for udflugter, hvis deltager har ledsager
        if(!udflugter.isEmpty()) {
            for (Udflugt u : udflugter) {
                udflugtOmkostninger += u.getPris();
            }
            samletPris += udflugtOmkostninger;
        }
        if(this.isForedragsholder() || this.getDeltager().getType() == DeltagerType.FIRMA){
            konferenceOmkostninger = 0;
        }

        return samletPris + (konferenceOmkostninger * (this.getAntalNætter() + 1));
    }
    private int getAntalNætter() {
        return (int) ChronoUnit.DAYS.between(ankomst, afrejse);
    }

    @Override
    public String toString() {
        return deltager + "";
    }
}

