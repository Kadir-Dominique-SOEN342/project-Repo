package lessonator2000;

import java.time.LocalDate;
import java.time.LocalTime;

public class Space {
	
private String rentedOrOwned;
private String roomNumber;
private String typeOfSpace;
private lessonator2000.Schedual openFor;
private String city;
private String province;


public Space(String rentedOrOwned, String roomNumber, String type , String city, String province) {
	this.rentedOrOwned = rentedOrOwned;
	this.roomNumber = roomNumber;
	this.typeOfSpace = type;
	this.openFor = new lessonator2000.Schedual();
	this.city = city;
	this.province = province;
		}



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

public String province() {
	return this.province;
}
//TODO: finish getters and setters

public lessonator2000.Timeslot addLessonToSchedual(lessonator2000.Lesson myLesson, LocalDate startdate, LocalDate enddate, String dayOfTheWeek, LocalTime startTime, LocalTime endTime) {
	//System.out.println("Space: addLessonToSchedual");
	lessonator2000.Timeslot myTimeslot = openFor.addLesson( myLesson,  startdate,  enddate,  dayOfTheWeek ,  startTime,  endTime);
	return myTimeslot;
}
}
