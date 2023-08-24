package application.model;

public class Administrator extends Person{
    private String username;
    private String password;

    public Administrator(String navn, String tlf, String email, String username, String password){
        super(navn,tlf,email);
        this.username = username;
        this.password = password;
    }


}
