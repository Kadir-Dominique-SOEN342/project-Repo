package lessonator2000;

import java.time.LocalDate;

public class Day {
	
	private Timeslot[] daySchedual;
	private LocalDate today;
	
	// a day can hold at most 20 time slots ()
	public Day(LocalDate today) {
		daySchedual = new Timeslot[20];
		this.today = today;
	}
	
	
	//getter
	public Timeslot[] getDaySchedual() {
		return this.daySchedual;
	}
	
	//setter
	public void setDaySchedual(Timeslot[] newTimeSlot) {
		this.daySchedual = newTimeSlot;
	}
	
	//Overriding toString
	public String toString() {
		for(Timeslot t : daySchedual) {
			return t.toString();
		}
		return "There are no lessons scheduled today";
	}

}
