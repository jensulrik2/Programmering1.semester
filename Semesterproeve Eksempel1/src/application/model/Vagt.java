package application.model;

public class Vagt {
    private int timer;
    private Frivillig frivillig;
    private Job job;

    public int getTimer() {
        return timer;
    }

    Vagt(int timer, Job job){
        this.timer = timer;
        this.job = job;
    }

    public void setFrivillig(Frivillig frivillig) {
        this.frivillig = frivillig;
    }

    public Frivillig getFrivillig() {
        return frivillig;
    }


}
