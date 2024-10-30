package lessonator2000;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Client extends lessonator2000.User{
	
	private String firstName; 
	private String lastName;
	private LocalDate dateOfBirth;
	private String userName;
	private String password; 
	ArrayList<lessonator2000.UnderageClient> dependantsCatalog = new ArrayList<lessonator2000.UnderageClient>();
	

	//Constructors
	

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
	
	public void addToDependantsCatalog(lessonator2000.UnderageClient uc) {
		this.dependantsCatalog.add(uc);
	}

	public ArrayList<lessonator2000.UnderageClient> getDependantsCatalog() {
		return dependantsCatalog;
	}

	public void viewDependants(){
		for(lessonator2000.UnderageClient uc : dependantsCatalog){
			System.out.println(uc.toString());
		}
	}

	public lessonator2000.UnderageClient findDependant(String username) {
		lessonator2000.UnderageClient uc = null;
		for(lessonator2000.UnderageClient underage : dependantsCatalog){
			if(underage.getUsername().equals(username))
				uc = underage;
		}
		return uc;
	}

	public String toString(){
		return (this.getfirstName() + " " + this.getlastName() + " username:" + this.getUsername());
	}

}
