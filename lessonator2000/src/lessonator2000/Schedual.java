package lessonator2000;

import java.time.LocalDate;

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
		 mySchedual[4] = new Day[365]; //2027 is a leap year	
		 mySchedual[5] = new Day[366]; //2028 is a leap year		
		 

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
	
	//TODO : Method to update the calendar and drop previous years 
	
	

	}

