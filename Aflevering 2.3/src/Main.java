import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String breaker = "ja";
        String teamName = "";
        String teamRoom = "";
        Team team = null;

        while (breaker.equals("ja")) {
            System.out.println("Vil du oprette et team? (ja / nej)");
            breaker = scan.nextLine().toLowerCase();

            if (breaker.equals("nej")) {
                System.out.println(team.studentResults());
                break;
            } else {
                System.out.println("Hvad skal teamet hedde?");
                teamName = scan.nextLine();

                System.out.println("Hvilket lokale skal teamet være i?");
                teamRoom = scan.nextLine();

                team = new Team(teamName, teamRoom);

                for (int i = 0; i < 2; i++) {
                    System.out.println("Navn på studerende:");
                    String studentName = scan.nextLine();

                    System.out.println("Er den studerende aktiv:");
                    boolean studentActive = scan.nextBoolean();

                    System.out.println("Hvor mange karakterer har den studerende fået:");
                    int studentGradeNumber = scan.nextInt();

                    int[] studentGrades = new int[studentGradeNumber];

                    System.out.println("Den studerendes karakterer adskilt med blanke");
                    for (int j = 0; j < studentGradeNumber; j++) {
                        int grade = scan.nextInt();
                        studentGrades[j] = grade;
                    }

                    scan.nextLine();

                    Student student = new Student(studentName, studentActive, studentGrades);
                    team.addStudent(student);
                }
            }
        }



    }




}




