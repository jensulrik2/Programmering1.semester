import java.util.ArrayList;

public class Customer {
	private String lastName;
	private String firstName;

	
	public Customer(String lastName, String firstName, int age) {
		this.lastName = lastName;
		this.firstName = firstName;

	}

	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	@Override
    public String toString(){
		return lastName + " " + firstName;
	}
}
