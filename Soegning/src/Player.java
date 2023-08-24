public class Player
{

    private String name;
    private int højde;
    private int vægt;
    private int scoredMål;

    public Player(String name, int højde, int vægt, int scoredMål){
        this.name = name;
        this.højde = højde;
        this.vægt = vægt;
        this.scoredMål = scoredMål;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", højde=" + højde +
                ", vægt=" + vægt +
                ", scoredMål=" + scoredMål +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHøjde() {
        return højde;
    }

    public void setHøjde(int højde) {
        this.højde = højde;
    }

    public int getVægt() {
        return vægt;
    }

    public void setVægt(int vægt) {
        this.vægt = vægt;
    }

    public int getScoredMål() {
        return scoredMål;
    }

    public void setScoredMål(int scoredMål) {
        this.scoredMål = scoredMål;
    }
}
