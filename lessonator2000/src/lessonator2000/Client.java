package lessonator2000;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Client extends User{
	
	private String firstName; 
	private String lastName;
	private LocalDate dateOfBirth;
	private String userName;
	private String password; 
	ArrayList<underageClient> dependantsCatalog = new ArrayList<underageClient>();
	

	//Constructors
	

	public Client(String firstn,String lastn, LocalDate birth, String username, String password) {
		
				
		this.firstName = firstName;
		this.lastName = lastn;
		this.dateOfBirth = birth;
		this.userName = username;
		this.password = password;
		
	}
	

	
//Todo: Getters/ Setters
	public String getUsername() {
		return userName;
	}
	
	public void viewOffering() {/*TODO: implement */};
}
