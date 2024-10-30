package lessonator2000;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Day {
	
	//private Timeslot[] daySchedual;
	
	private ArrayList<lessonator2000.Timeslot> daySchedual;
	private LocalDate today;
	

	public Day(LocalDate today) {
		daySchedual = new ArrayList();
		this.today = today;
	}
	
	
	//getter
	public ArrayList<lessonator2000.Timeslot> getDaySchedual() {
		return this.daySchedual;
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

	public LocalDate getDate() {
		return this.today;
	}

	public void addToCollection(lessonator2000.Timeslot myTimeSlot) {
		daySchedual.add(myTimeSlot);
		
	}

	//public Timeslot createTimeSlot(LocalTime startTime, LocalTime endTime, Lesson myLesson) {
		//System.out.println("Day :  createTimeSlot");
	//	Timeslot myTimeSlot = new Timeslot(startTime, endTime, myLesson);
	//daySchedual.add(myTimeSlot);
	//return myTimeSlot;
		//TODO: make sure start time is after end time of other time slots.
	}

