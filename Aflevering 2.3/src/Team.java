public class Team {

    private String name;

    private String room;

    private static final char[] facit = new char[10];

    private Student[] students = new Student[32];

    private int studentCount = 0;

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
    }

    public char[] getFacit(){
        return facit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void addStudent(Student student) {
        students[studentCount] = student;
        studentCount++;
    }

    public Student[] getAllStudents() {
        Student[] currentStudents = new Student[studentCount];
        for (int i = 0; i < studentCount; i++) {
            currentStudents[i] = students[i];
        }
        return currentStudents;
    }

    public void removeStudent(String name) {
        int place = -1;
        for (int i = 0; i < studentCount && place == -1; i++) {
            if (students[i].getName().equals(name)) {
                place = i;
            }
        }
        if (place != -1){
            studentCount--;
            Student [] temp = new Student[studentCount];
            for (int i = 0; i < studentCount; i++){
                if(i < place){
                    temp[i] = students[i];
                }
                else {
                    temp[i] = students[i+1];
                }
            }
            students = temp;
        }
    }

    public double teamAverage(){
        double gradeTeamSum = 0;

        for(int i = 0; i < studentCount; i++){
            if(students != null){
                gradeTeamSum += students[i].averageGrade();
            }

        }
        return (gradeTeamSum / studentCount);
    }

    public Student[] highScoreStudents(double minAverage){
        int egnetCount = 0;
        for(int i =0; i < studentCount; i++){
            if(students[i].averageGrade() >= minAverage && students[i].isActive() == true){
                egnetCount++;
            }
        }
        Student[] egnetStuderende = new Student[egnetCount];
        for(int i = 0; i < egnetCount; i++){
            egnetStuderende[i] = students[i];
        }
        return egnetStuderende;
    }

    public char[] facitGenerator() {

        for (int i = 0; i < facit.length; i++) {
            int r = (int) Math.ceil(Math.random() * 4);

            switch (r) {
                case 1:
                    facit[i] = 'A';
                    break;

                case 2:
                    facit[i] = 'B';
                    break;

                case 3:
                    facit[i] = 'C';
                    break;

                case 4:
                    facit[i] = 'D';
                    break;
            }
        }
        return facit;
    }

    public String[] studentResults(){
        String[] results = new String[studentCount];
        System.out.println("\n" + "Navn:" + "\t" + "Gennemsnit:" + "\t" + "        Korrekte svar:");

        for(int i = 0; i < studentCount; i++){
            results[i] = "\n" + students[i].getName() + "\t" + students[i].averageGrade() + "\t" + students[i].correctAnswers(facit);
        }
        return results;
    }

    public void testDiffilculty(){


        for(int j = 1; j < facit.length+1; j++) {
            int korrektCount = 0;
            for (int i = 0; i < studentCount; i++) {
                char[] temp = students[i].getStudentAnswer();
                if (facit[j-1] == temp[i]) {
                    korrektCount++;
                }
            }
            System.out.println("spørgsmål " + j + "    " + korrektCount);
        }
    }


}
