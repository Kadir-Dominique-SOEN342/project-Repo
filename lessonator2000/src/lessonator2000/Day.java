package lessonator2000;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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
public class Day {
	//for persistance  
	int id;
	
	//private Timeslot[] daySchedual;
	private ArrayList<lessonator2000.Timeslot> daySchedual;
	private LocalDate today;
	
/**
 * constructor for Day
 * @param today
 */
	public Day(LocalDate today) {
		daySchedual = new ArrayList();
		this.today = today;
	}
	
	
	//getter
	public ArrayList<lessonator2000.Timeslot> getDaySchedual() {
		return this.daySchedual;
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
		daySchedual.add(myTimeSlot);
		
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

	//public Timeslot createTimeSlot(LocalTime startTime, LocalTime endTime, Lesson myLesson) {
		//System.out.println("Day :  createTimeSlot");
	//	Timeslot myTimeSlot = new Timeslot(startTime, endTime, myLesson);
	//daySchedual.add(myTimeSlot);
	//return myTimeSlot;
		//TODO: make sure start time is after end time of other time slots.
	

