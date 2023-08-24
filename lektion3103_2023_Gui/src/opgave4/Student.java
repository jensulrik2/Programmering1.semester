package opgave4;

public class Student {

    private String name;
    private int age;
    private boolean active;
    Student(String name,int age, boolean active){
        name = this.name;
        age = this.age;
        active = this.active;
    }

    public String toString(){
        String s = "Name: " + this.name + "\n" +
                   "Age: " + this.age + "\n" +
                   "Active: " + this.active;
        return s;
    }



}
