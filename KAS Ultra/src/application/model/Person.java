package application.model;

public class Person {

    private String navn;
    private String tlf;
    private String email;

    public String getNavn() {
        return navn;
    }

    public Person(String navn, String tlf, String email){
        this.navn = navn;
        this.tlf = tlf;
        this.email = email;
    }


}
