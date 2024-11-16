package lessonator2000;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.time.Period;
import java.util.List;

/**
 * 
 * Class Client.
 *
 * <p>Clients have dependant catalog that holds underage client for whom they will be able to book a lesson.</p>

 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "client_type")
public class Client extends lessonator2000.User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private int age;
	private String userName;
	private String password; 
	@OneToMany
	List<lessonator2000.UnderageClient> dependantsCatalog ;
	

public Client(){}
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
		age = Period.between(dateOfBirth,LocalDate.now()).getYears();
		dependantsCatalog =  new ArrayList<lessonator2000.UnderageClient>();
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
	public int getAge() {
		return age;
	}
	public List<lessonator2000.UnderageClient> getDependantsCatalog() {
		return dependantsCatalog;
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

		 dependantsCatalog.add(uc);

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

	public void setDependants(List<lessonator2000.UnderageClient> u){this.dependantsCatalog = u;}

}

