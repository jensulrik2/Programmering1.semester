package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Festival {

    private String navn;
    private LocalDate fraDato;
    private LocalDate tilDato;
    private ArrayList<Job> jobs = new ArrayList<>();

    public String getNavn() {
        return navn;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public Festival(String navn, LocalDate fraDato, LocalDate tilDato) {
        this.navn = navn;
        this.fraDato = fraDato;
        this.tilDato = tilDato;
    }

    public Job createJob(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer){
        Job job = new Job(kode,beskrivelse,dato,timeHonorar,antalTimer);
        jobs.add(job);
        return job;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public int budgetterJobUdgift(){
        int samletUdgift = 0;
        for(Job j : jobs){
            samletUdgift += j.getAntalTimer() * j.getTimeHonorar();
        }
        return samletUdgift;
    }

    public int realiseretJobUdgift(){
        int samletUdgift = 0;
        ArrayList<Job> jobs = this.getJobs();
        for(int i = 0; i < jobs.size(); i++){
            for (int j=0; j < jobs.get(i).getVagter().size(); j++)
            if(jobs.get(i).getVagter().get(j).getFrivillig() != null){
                samletUdgift += jobs.get(i).getVagter().get(j).getTimer() * jobs.get(i).getTimeHonorar();
            }
        }
        return samletUdgift;
    }

}
