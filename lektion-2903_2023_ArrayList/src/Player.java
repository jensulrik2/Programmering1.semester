public class Player {
    private String name = "";
    private int age = 0;
    private int score = 0;

    Player(String name, int age){
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString(){
        return "Player{" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", score = " + score +
                '}';
    }


}
