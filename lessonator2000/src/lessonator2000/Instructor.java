package lessonator2000;

import java.util.ArrayList;

public class Instructor extends User{

	
	private String specialization;
	private String firstname;
	private String lastname;
	private long phoneNumber;
	ArrayList<String> availability = new ArrayList<String>(); //TODO: check if we actually make city into a class
	
	public Instructor(String specialization, String firstname,String lastname,long phonenb) {
		this.specialization = specialization;
		this.firstname = firstname;
		this.lastname= lastname;
		this.phoneNumber= phonenb;
	}
	
	
	//Getters
	public String getSpecialization() {
		return this.specialization;
	}
	
	public String firstname() {
		return this.firstname;
	}
	public String lastname() {
		return this.lastname;
	}
	public long getPhone() {
		return this.phoneNumber;
	}
	public ArrayList<String> getAvailability(){
		return availability;
	}

	
	
//Setters
	public void setSpecialization(String spec) {
		this.specialization = spec;
	}
	
	public void setFirstName(String fn) {
		this.firstname = fn;
	}
	
	public void setLastName(String ln) {
		this.lastname = ln;
	}
	
	public void setPhoneNumber(long phone) {
		this.phoneNumber = phone;
	}
	
	
	public void addAvalability(String city) {
		availability.add(city);
		
	}

}
