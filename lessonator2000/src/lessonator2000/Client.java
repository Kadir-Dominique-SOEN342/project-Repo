package lessonator2000;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * Class Client.
 *
 * <p>Clients have dependant catalog that holds underage client for whom they will be able to book a lesson.</p>

 */
public class Client extends lessonator2000.User{
	
	private String firstName; 
	private String lastName;
	private LocalDate dateOfBirth;
	private String userName;
	private String password; 
	ArrayList<lessonator2000.UnderageClient> dependantsCatalog = new ArrayList<lessonator2000.UnderageClient>();
	


/**
 * 
 * Constructor for the class Client. initiated without dependants.
 * @param firstn
 * @param lastn
 * @param birth
 * @param username
 * @param password
 */
	public Client(String firstn,String lastn, LocalDate birth, String username, String password) {
		
				
		this.firstName = firstn;
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
	
	 void addToDependantsCatalog(lessonator2000.UnderageClient uc) {
		this.dependantsCatalog.add(uc);
	}

	public ArrayList<lessonator2000.UnderageClient> getDependantsCatalog() {
		return dependantsCatalog;
	}

	/**
	 * Prints information about each dependants in the catalog. used when a client wants to book for one of their underage dependants
	 */
	 void viewDependants(){
		for(lessonator2000.UnderageClient uc : dependantsCatalog){
			System.out.println(uc.toString());
		}
	}

	 /**
	  * iterates through the client's catalog to find a dependant, returns the dependant
	  * @param username
	  * @return
	  */
	 lessonator2000.UnderageClient findDependant(String username) {
		lessonator2000.UnderageClient uc = null;
		for(lessonator2000.UnderageClient underage : dependantsCatalog){
			if(underage.getUsername().equals(username))
				uc = underage;
		}
		return uc;
	}
/**
 * Prints out the client's information
 */
	public String toString(){
		return (this.getfirstName() + " " + this.getlastName() + " username:" + this.getUsername());
	}

}
