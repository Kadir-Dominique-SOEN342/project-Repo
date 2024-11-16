package lessonator2000;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Class Instructor.
 *
 * <p>This is the class of </p>
 * User that can signupToLesson(making the lesson viewable to the Clients)

 */
@Entity
@Table(name = "Instructor")
public class Instructor extends lessonator2000.User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String specialization;
	private String firstname;
	private String lastname;
	private long phoneNumber;
	@OneToMany
	private List<lessonator2000.Lesson> teaches;
	@ElementCollection
	@CollectionTable(name = "instructor_availability", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "availability")
	private List<String> availability; //TODO: check if we actually make city into a class
	
	public Instructor(){}
	public Instructor(String specialization, String firstname,String lastname,long phonenb, List<String> availabilities) {
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

	public List<String> getAvailability(){
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

	public void setTeaches(List<lessonator2000.Lesson> teaches) {
		this.teaches = teaches;
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
		Session session = lessonator2000.ManageSessionFactory.getSf().openSession();
		Transaction tr = session.beginTransaction();
		teaches.add(l);
		session.update(this);
		session.getTransaction().commit();
		session.close();
		
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
