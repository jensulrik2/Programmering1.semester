import java.util.Arrays;
public class Main {
    public static void main(String[] args) {


        Team team1 = new Team("23v","32c");
        Team team2 = new Team("23f", "13a");
        Student student1 = new Student("Anders",true, new int[]{1,3,12});
        Student student2 = new Student("Jens",true, new int[]{1,3,6});
        Student student3 = new Student("Thor",true, new int[]{10,3,12});
        Student student4 = new Student("Ulrik",true, new int[]{2,2,2});
        Student student5 = new Student("Børge",true, new int[]{2,2,2});
        Student student6 = new Student("Brian",true, new int[]{2,2,2});

        team1.addStudent(student1);
        team1.addStudent(student2);
        team1.addStudent(student3);
        team2.addStudent(student4);
        team2.addStudent(student5);
        team2.addStudent(student6);


        System.out.println(Arrays.toString(team1.getAllStudents()));
        System.out.println(Arrays.toString(team2.getAllStudents()));

        System.out.println(student1.higheshGrade());
        System.out.println(student1.averageGrade());

//        team1.removeStudent("Anders");
//        team2.removeStudent("Børge");

        System.out.println("team1's snit ligger i snit på " + team1.teamAverage());



        System.out.println(team2.teamAverage());
        System.out.println(Arrays.toString(team1.highScoreStudents(5)));

        System.out.println(student1.getName() + ": " + Arrays.toString(student1.svarGenerator()));
        student2.svarGenerator();
        student3.svarGenerator();
        System.out.println("Facit: " + Arrays.toString(team1.facitGenerator()));

        System.out.println(student1.getName() + " fik " + student1.correctAnswers(team1.getFacit()) + " rigtige.(wow)");

        System.out.println(Arrays.toString(team1.studentResults()));

        team1.testDiffilculty();






    }


}