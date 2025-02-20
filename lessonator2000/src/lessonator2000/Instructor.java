package lessonator2000;

import java.util.ArrayList;

/**
 * 
 * Class Instructor.
 *
 * <p>This is the class of </p>
 * User that can signupToLesson(making the lesson viewable to the Clients)

 */
public class Instructor extends lessonator2000.User {

	
	private String specialization;
	private String firstname;
	private String lastname;
	private long phoneNumber;
	private ArrayList<lessonator2000.Lesson> teaches;
	private ArrayList<String> availability ;
	
	public Instructor(String specialization, String firstname,String lastname,long phonenb, ArrayList<String> availabilities) {
		this.specialization = specialization;
		this.firstname = firstname;
		this.lastname= lastname;
		this.phoneNumber= phonenb;
		this.teaches = new ArrayList<lessonator2000.Lesson>();
		this.availability = availabilities;
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
	
	/**
	 * when a instructor signups to a lesson, the lesson is also added to it's teaches collection. 
	 * @param l
	 */
	public void addToCollection(lessonator2000.Lesson l) {
		teaches.add(l);
		
	}

/**
 * used when a lesson(offer) is delete, it needs to be removed from the instructor teaches collection
 * @param lessonToRemove
 */
	 void removeLesson(lessonator2000.Lesson lessonToRemove) {
		teaches.removeIf(l -> l == lessonToRemove);
		for(lessonator2000.Lesson l : teaches) {
		//	if(l == lessonToRemove) {
		//		//remove the lesson 
		//		teaches.remove(teaches.indexOf(l));

		//	}
		//}
			System.out.println("The lesson has been removed from the instructor's collection");
	}

}
	 //TODO: add functionality so that the instructor can see all it's lessons  (print my schedual or something..)
	}
