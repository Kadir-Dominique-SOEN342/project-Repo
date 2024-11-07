package lessonator2000;

import java.util.ArrayList;

public class Instructor extends lessonator2000.User {

	
	private String specialization;
	private String firstname;
	private String lastname;
	private long phoneNumber;
	private ArrayList<lessonator2000.Lesson> teaches;
	ArrayList<String> availability = new ArrayList<String>(); //TODO: check if we actually make city into a class
	
	public Instructor(String specialization, String firstname,String lastname,long phonenb) {
		this.specialization = specialization;
		this.firstname = firstname;
		this.lastname= lastname;
		this.phoneNumber= phonenb;
		this.teaches = new ArrayList<lessonator2000.Lesson>();
	}
	
	
	//Getters
	public String getSpecialization() {
		return this.specialization;
	}
	
	public String getFirstName() {
		return this.firstname;
	}
	public String getLastName() {
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
	
	public void addToCollection(lessonator2000.Lesson l) {
		teaches.add(l);
		
	}


	public void removeLesson(Lesson lessonToRemove) {
		teaches.removeIf(l -> l == lessonToRemove);
		for(Lesson l : teaches) {
		//	if(l == lessonToRemove) {
		//		//remove the lesson 
		//		teaches.remove(teaches.indexOf(l));

		//	}
		//}
			System.out.println("The lesson has been removed from the instructor's collection");
	}

}
	}
