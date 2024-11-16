package lessonator2000;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.management.ManagementFactory;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Class Schedual.
 *
 * <p>This class holds the calendar for a space. Each schedual has a calendar of 5 years , each has a day that can hold timeslots each with a lesson attribute</p>

 */
@Entity
@Table(name = "Schedual")
public class Schedual {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int year;

	@OneToMany(mappedBy = "schedual")
	private List<lessonator2000.Day> mySchedual = new ArrayList<>();

	
	public Schedual(){}
	public Schedual(int year) {
		



			this.year = year;









		}





	/**
	 * used from uploadOffering()
	 * creates a timeslot that has a lesson attribute
	 * adds the timeslot to every Day that falls on a dayOfTheWeekn between startDate and endate
	 * @param myLesson
	 * @param startdate
	 * @param enddate
	 * @param dayOfTheWeek
	 * @param startTime
	 * @param endTime
	 * @return
	 */

	public lessonator2000.Timeslot addLesson(lessonator2000.Lesson myLesson, LocalDate startdate, LocalDate enddate, String dayOfTheWeek, LocalTime startTime, LocalTime endTime) {
		// Create a new timeslot
		Session session = lessonator2000.ManageSessionFactory.getSf().openSession();
		Transaction transaction = session.beginTransaction();
		lessonator2000.Timeslot myTimeSlot = new lessonator2000.Timeslot(startTime, endTime, myLesson);
		List<lessonator2000.Day> d = session.createQuery("from Day ", lessonator2000.Day.class).getResultList();
		mySchedual = d;
		// Find every date between startDate and endDate where the day of the week matches
		ArrayList<LocalDate> matchingDates = findAllDateBetween(startdate, enddate, dayOfTheWeek);

		// Add the timeslot to each matching day in the schedule
		for (LocalDate date : matchingDates) {
			for (lessonator2000.Day day : mySchedual) { // Iterate over the one-dimensional array
				if (date.isEqual(day.getDate())) {
					day.addToCollection(myTimeSlot); // Add the timeslot to the matching day
					break; // Break to avoid unnecessary iterations once the match is found
				}
			}
		}

		return myTimeSlot;
	}



	public List<lessonator2000.Day> getMySchedual(){return this.mySchedual;}

	public void setDay(List<lessonator2000.Day> d){this.mySchedual = d;}
	
	private ArrayList<LocalDate> findAllDateBetween(LocalDate startdate, LocalDate enddate , String dayOfTheWeek) {
		ArrayList<LocalDate> myDateArray = new ArrayList<LocalDate>();
		//it's a bit much but I havent found another way to do this more elegantly.. 
		if(dayOfTheWeek.equals("Monday")) {
			for(LocalDate date = startdate; date.isBefore(enddate)  ; date= date.plusDays(1)) {
				if(date.getDayOfWeek() == DayOfWeek.MONDAY) {
					myDateArray.add(date);
				}
			}
		}
		else if(dayOfTheWeek.equals("Tuesday")) {
			for(LocalDate date = startdate; date.isBefore(enddate)  ; date= date.plusDays(1)) {
				if(date.getDayOfWeek() == DayOfWeek.TUESDAY) {
					myDateArray.add(date);
				}
			}
	}
		else if(dayOfTheWeek.equals("Wednesday")) {
			for(LocalDate date = startdate; date.isBefore(enddate)  ; date= date.plusDays(1)) {
				if(date.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
					myDateArray.add(date);
				}
			}
	}
		else if(dayOfTheWeek.equals("Thursday")) {
			for(LocalDate date = startdate; date.isBefore(enddate)  ; date= date.plusDays(1)) {
				if(date.getDayOfWeek() == DayOfWeek.THURSDAY) {
					myDateArray.add(date);
				}
			}
	}
		else if(dayOfTheWeek.equals("Friday")) {
			for(LocalDate date = startdate; date.isBefore(enddate)  ; date= date.plusDays(1)) {
				if(date.getDayOfWeek() == DayOfWeek.FRIDAY) {
					myDateArray.add(date);
				}
			}
	}
		else if(dayOfTheWeek.equals("Saturday")) {
			for(LocalDate date = startdate; date.isBefore(enddate)  ; date= date.plusDays(1)) {
				if(date.getDayOfWeek() == DayOfWeek.SATURDAY) {
					myDateArray.add(date);
				}
			}
	}
		else if(dayOfTheWeek.equals("Sunday")) {
			for(LocalDate date = startdate; date.isBefore(enddate)  ; date= date.plusDays(1)) {
				if(date.getDayOfWeek() == DayOfWeek.SUNDAY) {
					myDateArray.add(date);
				}
			}
	}
		
		return myDateArray;
	}
	
	//removeLesson removes each timeslot that has the lessonToRemove as attribute from every day between the lesosn startDate and endDate that fall's on dayOfTheWeek
	public void removeLesson(lessonator2000.Lesson lessonToRemove) {
		// Find all dates between the start and end dates of the lesson that match the specified day of the week

		ArrayList<LocalDate> matchingDates = findAllDateBetween(lessonToRemove.getStartDatE(), lessonToRemove.getEndDate(), lessonToRemove.getDayOfTheWeek());

		// Remove the timeslot for each matching date
		for (LocalDate date : matchingDates) {
			for (lessonator2000.Day day : mySchedual) { // Iterate over the one-dimensional array of days
				if (date.isEqual(day.getDate())) {
					day.removeTimeSlot(lessonToRemove); // Remove the timeslot associated with the lesson
					break; // Break to avoid unnecessary iterations once the match is found
				}
			}
		}
	}

}
	

	


	

