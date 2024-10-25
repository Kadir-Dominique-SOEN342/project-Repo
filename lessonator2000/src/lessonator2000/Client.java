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
	ArrayList<UnderageClient> dependantsCatalog = new ArrayList<UnderageClient>();
	

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
	
	public String getfirstName() {
		return firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setfirstName(String firstname) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	public void setuserName(String username) {
		this.userName = username;
	}
	public void setpassword(String pwrd) {
		this.password = pwrd;
	}
	
	public void addToDependantsCatalog(UnderageClient uc) {
		this.dependantsCatalog.add(uc);
	}
	
}
