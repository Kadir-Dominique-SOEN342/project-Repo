package lessonator2000;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Schedual {
	Day[][] mySchedual;
	
	public Schedual() {
		
		/*We are booking 5 years in advance. 
		We will need a method for updating the schedual when we need more time in advance 
		and flush the old scheduals*/
		
		//Schedual holds an array of days called mySchedual 
		//if the year is a leap year there are 366 days
		//if the year is not a leap year it hold 365 days. 
		//each day has an array of timeslots.
		 mySchedual = new Day[5][];
		 mySchedual[0] = new Day[366]; //2024 is a leap year
		 mySchedual[1] = new Day[365]; //2025 is a normal year
		 mySchedual[2] = new Day[365]; //2026 is a normal year	
		 mySchedual[3] = new Day[365]; //2027 is a normal year	
		 mySchedual[4] = new Day[366]; //2028 is a leap year		
		 

	        // Initialize Day objects for each day in the schedule
	        for (int year = 0; year < mySchedual.length; year++) {
	            int daysInYear = mySchedual[year].length; 
	            for (int day = 0; day < daysInYear; day++) {
	                // Create a LocalDate for the corresponding day
	                LocalDate date = LocalDate.of(2024 + year, 1, 1).plusDays(day);//Startb from the first day of the year and add a day until the end of the year
	                mySchedual[year][day] = new Day(date); // Initialize each Day , passing the date as parameter
	            }
	            }
		 
	        }
	public Timeslot addLesson(Lesson myLesson, LocalDate startdate, LocalDate enddate, String datOfTheWeek , LocalTime startTime, LocalTime endTime) {
		//	System.out.println("Schedual : addLesson");
		//create new timeslot
		Timeslot myTimeSlot =  new Timeslot(startTime, endTime, myLesson);

		//find everyDateBetwee startDate and endDate where dayOfTheWeek equals the day of the week day

		ArrayList<LocalDate> myDateArray = findAllDateBetween(startdate,enddate, datOfTheWeek );
		//add the timeslot to every day in the myDateArray
		for(LocalDate date : myDateArray) {
			Day myDay = null;
			//TODO: refactor this to make it more effecient
			for (int year = 0; year < mySchedual.length; year++) {
				for (Day d : mySchedual[year]) {
					if (date.isEqual(d.getDate())) {
						myDay = d;
						d.addToCollection(myTimeSlot); // For every day that matches, add the timeslot to the day's collection

					}
				}

			}


		}

		return myTimeSlot;
	}
	
	
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
	}
	
	//TODO : Method to update the calendar and drop previous years 
	


	

