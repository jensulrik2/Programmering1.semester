import java.util.Arrays;

public class Student {

    private String name;

    private boolean active;

    private int[] grades;

    private char[] studentAnswer = new char[10];




    public Student(String name, boolean active, int[] grades) {
        this.name = name;
        this.active = active;
        this.grades = grades;
    }

    public char[] getStudentAnswer() {
        return studentAnswer;
    }

    public char[] svarGenerator(){

        for(int i = 0; i < studentAnswer.length; i++){
            int r = (int) Math.ceil(Math.random() * 4);

            switch(r){
                case 1 :
                    this.studentAnswer[i] = 'A';
                    break;

                case 2 :
                    this.studentAnswer[i] = 'B';
                    break;

                case 3 :
                    this.studentAnswer[i] = 'C';
                    break;

                case 4 :
                    this.studentAnswer[i] = 'D';
                    break;
            }
        }
    return studentAnswer;
    }



    public int correctAnswers(char[] correct){
        int correctNr = 0;

        for(int i = 0; i < correct.length; i++){
            if(correct[i] == studentAnswer[i]){
                correctNr++;
            }
        }

        return correctNr;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public int higheshGrade(){
        int grade = 0;
        for(int i = 0; i < grades.length; i++){
            if(grade < grades[i]){
                grade = grades[i];
            }
        }
        return grade;
    }
    public double averageGrade() {
        double gradeSum = 0;
        for (int i = 0; i < grades.length; i++) {
            gradeSum += grades[i];
        }
        return (gradeSum / grades.length);
    }



    @Override
    public String toString() {
        return "Studerende " +
                " navn: '" + name + '\'' +
                ", aktiv: " + active +
                ", grades: " + Arrays.toString(grades) + " ; ";
    }
}
