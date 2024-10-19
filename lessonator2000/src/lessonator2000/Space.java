package lessonator2000;

import java.time.LocalDate;
import java.time.LocalTime;

public class Space {
	
private String rentedOrOwned;
private String roomNumber;
private String typeOfSpace;
private Schedual openFor;
private String city;
private String province;


public Space(String rentedOrOwned, String roomNumber, String type , String city, String province) {
	this.rentedOrOwned = rentedOrOwned;
	this.roomNumber = roomNumber;
	this.typeOfSpace = type;
	this.openFor = new Schedual();
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

public Timeslot addLessonToSchedual(Lesson myLesson, LocalDate date, LocalTime startTime, LocalTime endTime) {
	//System.out.println("Space: addLessonToSchedual");
Timeslot myTimeslot = 	openFor.addLesson(myLesson,date, startTime,endTime);
	return myTimeslot;
}
}
