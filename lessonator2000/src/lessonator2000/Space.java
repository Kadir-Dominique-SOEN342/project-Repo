package lessonator2000;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 
 * Class Space.
 *
 * <p>a Lesson is offered in a space. the spaces are held by the Location class
 * Each space has a schedual
 * each schedual has a 5 year calendar of Days
 * each days has a collection of timeslot that contain a lesson</p>
 */
@Entity
@Table(name = "Space")
public class Space {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
private String rentedOrOwned; //TODO change this to an enum?
private String roomNumber;
private String typeOfSpace;
@OneToOne
@JoinColumn(nullable = true)
private lessonator2000.Schedual openFor;
private String city;
private String province;

/**
 * constructor for Space
 * @param rentedOrOwned
 * @param roomNumber
 * @param type
 * @param city
 * @param province
 */
public Space(String rentedOrOwned, String roomNumber, String type , String city, String province) {
	this.rentedOrOwned = rentedOrOwned;
	this.roomNumber = roomNumber;
	this.typeOfSpace = type;
	this.openFor = new lessonator2000.Schedual();
	this.city = city;
	this.province = province;

}
public Space(){}

public void setSchedual(lessonator2000.Schedual sc){this.openFor = sc;}
public String getRoomNumber() {
	return this.roomNumber;
}

public String getCity() {
	return this.city;
}

public String getroomNumber() {
	return this.roomNumber;
}

public String getTypeOfSpace() {
	return this.typeOfSpace;
}
public lessonator2000.Schedual getSchedual() {
	return this.openFor;
}

public String getprovince() {
	return this.province;
}
//TODO: finish getters and setters

/**
 * takes a lesson and startdate,endate, starttime,endtime and day of the week 
 * creates a timeslot and sends a message to Schedual to add the timeslot to everyday of the calendat that falls between startdate,endate on dayOftheweek
 * @param myLesson
 * @param startdate
 * @param enddate
 * @param dayOfTheWeek
 * @param startTime
 * @param endTime
 * @return
 */



/**
 * used by deleteOffering , sends a message to offerings to remove the lesson from each day where it was held in the shcedual of a space
 * @param lessonToRemove
 */
public void removeLessonFromSpace(lessonator2000.Lesson lessonToRemove) {
	openFor.removeLesson(lessonToRemove);
		
}

	lessonator2000.Timeslot addLessonToSchedual(lessonator2000.Lesson myLesson, LocalDate startdate, LocalDate enddate, String dayOfTheWeek, LocalTime startTime, LocalTime endTime) {
		//System.out.println("Space: addLessonToSchedual");
		lessonator2000.Timeslot myTimeslot = openFor.addLesson( myLesson,  startdate,  enddate,  dayOfTheWeek ,  startTime,  endTime);
		return myTimeslot;
	}
}
