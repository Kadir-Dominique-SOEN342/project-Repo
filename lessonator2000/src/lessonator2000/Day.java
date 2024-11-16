package lessonator2000;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Class Day.
 *
 * <p>Day objects are held in the mySchedual array of Schedual(which are each associated with one space).
 * each day has a date and an array of Timeslots</p>
 * 
 * @author domin
 * @version Nov 9, 2024
 */

@Entity
@Table(name = "Day")
public class Day {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//private Timeslot[] daySchedual;
	@OneToMany
	private List<lessonator2000.Timeslot> daySchedual;

	@ManyToOne
	@JoinColumn(name = "schedual_id")
	private lessonator2000.Schedual schedual;
	private LocalDate today;

	public Day(){}
/**
 * constructor for Day
 * @param today
 */

public Day(LocalDate today) {
		this.today = today;
	}
	
	
	//getter
	public List<lessonator2000.Timeslot> getDaySchedual() {
		return this.daySchedual;
	}

	public void setSchedual(lessonator2000.Schedual schedual) {
		this.schedual = schedual;
	}

	public LocalDate getDate() {
		return this.today;
	}
	//setter
	public void setDaySchedual(ArrayList<lessonator2000.Timeslot> newTimeSlot) {
		this.daySchedual = newTimeSlot;
	}
	
	//Overriding toString
	public String toString() {
		for(lessonator2000.Timeslot t : daySchedual) {
			return t.toString();
		}
		return "There are no lessons scheduled today";
	}

/**
 * this mehtod is used by Schedual addLesson() to add the timesslot to the Day's array
 * @param myTimeSlot
 */
	 void addToCollection(lessonator2000.Timeslot myTimeSlot) {
		 Session session = lessonator2000.ManageSessionFactory.getSf().openSession();
		 Transaction transaction = session.beginTransaction();
		 daySchedual.add(myTimeSlot);
		 session.update(this);
		 session.getTransaction().commit();
		 session.close();
		
	}

/**
 * Used by scedual's removeLesson() when a lesson is deleted. 
 * @param lessonToRemove
 */
	 void removeTimeSlot(lessonator2000.Lesson lessonToRemove) {
		daySchedual.removeIf(ts -> ts.getLesson() == lessonToRemove);
	//	for(Timeslot ts : daySchedual) {
		//	if (ts.getLesson() == lessonToRemove) {
			//	daySchedual.remove(daySchedual.indexOf(ts));
				System.out.println("timeslot containing lesson removed from day " + today.toString());
			}
		
		
	}



