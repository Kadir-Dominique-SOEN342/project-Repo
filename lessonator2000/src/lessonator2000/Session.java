package lessonator2000;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
/**
 * 
 * Class Session.
 *
 * <p>Session is the main class the users are interacting with. Sesison acts as a controller and offers the main menu of the system
 *  many Session threads can be created
 * The class was introduced as part of the implementation for concurrency
 * </p>
 * 
 * @author Dominique Proulx
 * @version Nov 8, 2024
 */
public class Session extends Thread{
	//class attributes
	
	public  static int sessionIDCounter =1;
	//object attributes
	private String sessionID; 
	private lessonator2000.User browsingUser;
	private  lessonator2000.Registration registry ;
	private  lessonator2000.Location locationregistry;
	private  lessonator2000.Offerings offers;
	private boolean activeSession =true;
	
	
	
	/**
	 * Sesison constructor , sets the User to public, increases the counter and creates the sessionId.
	 */
	public Session() {
		browsingUser = new lessonator2000.Public();
		sessionIDCounter++;
		sessionID = "sess" + sessionIDCounter;
		activeSession =true;
		
		
	//get the registries
		registry  = lessonator2000.Registration.getRegistry();
		locationregistry = lessonator2000.Location.getLocationRegistry();
		offers = lessonator2000.Offerings.getOfferings();

		System.out.println("New browsing session initialized");
	}
	
	/*
	 * Getter for the sesisonID
	 */
	public String getSessionId() {
		return this.sessionID;
	}
	/**
	 * getter for the browsingUSer
	 * @return
	 */
	public lessonator2000.User getBrowsingUser() {
		return this.browsingUser;
	}
	
	/**
	 * This is where the user interacts with the system. 
	 * A menu is printed and users can log in , register, viewOfferings.. depending on the subtype of User the browsingUser is set to , different choices are offered. 
	 */
	public void run() {
		System.out.println("session " + sessionID + " started, User is of type :" + browsingUser.toString());
	



//hardcode a few lessons
//hardcodedLesson1	
//create the new lesson Offering -- uploadOffering(...)
		lessonator2000.Lesson myLesson = offers.uploadOffering("Judo", "jud101", false, false,  true, 10,LocalDate.of(2024, 1, 13), LocalDate.of(2024, 12, 13),"Wednesday");
		//addLessonToSpace(...)
		lessonator2000.Space mySpace = locationregistry.addLessonToSpace("TY908");
		//addLocationToSchedual, this will return the timeslot created for this lesson. Create the timeslot. addLessonToschedual add the timeslot to every day that falls on the dayOfTheWeek between startdate and enddate
		lessonator2000.Timeslot myTimeSlot =	mySpace.addLessonToSchedual(myLesson, LocalDate.of(2024, 1, 13), LocalDate.of(2024, 12, 13),"Wednesday", LocalTime.of(10,00,00),  LocalTime.of(11,00,00));
		// add space and time to lesson
		offers.addSpaceTimeToLesson(mySpace, myTimeSlot, myLesson);

//hardcodedlesson2
		lessonator2000.Lesson myLesson2 = offers.uploadOffering("SumoWrestling", "sumo900", false, true,  true, 10,LocalDate.of(2025, 6, 28), LocalDate.of(2025,12,11),"Monday");
		//addLessonToSpace(...)
		lessonator2000.Space mySpace2 = locationregistry.addLessonToSpace("H513");
		//addLocationToSchedual, this will return the timeslot created for this lesson. Create the timeslot. addLessonToschedual add the timeslot to every day that falls on the dayOfTheWeek between startdate and enddate
		lessonator2000.Timeslot myTimeSlot2 =	mySpace2.addLessonToSchedual(myLesson2, LocalDate.of(2025, 6, 28), LocalDate.of(2025,12,11),"Monday", LocalTime.of(5,00,00),  LocalTime.of(3,30,00));
		// add space and time to lesson
		offers.addSpaceTimeToLesson(mySpace2, myTimeSlot2, myLesson2);


//hardcodedlesson3
		lessonator2000.Lesson myLesson3 = offers.uploadOffering("Aerobics", "aero111", true, true,  true, 1,LocalDate.of(2025, 6, 28), LocalDate.of(2025,10,20),"Saturday");
		//addLessonToSpace(...)
		lessonator2000.Space mySpace3 = locationregistry.addLessonToSpace("H513");
		//addLocationToSchedual, this will return the timeslot created for this lesson. Create the timeslot. addLessonToschedual add the timeslot to every day that falls on the dayOfTheWeek between startdate and enddate
		lessonator2000.Timeslot myTimeSlot3 =	mySpace3.addLessonToSchedual(myLesson3, LocalDate.of(2025, 6, 28), LocalDate.of(2025,10,20),"Saturday", LocalTime.of(3,00,00),  LocalTime.of(5,30,00));
		// add space and time to lesson
		offers.addSpaceTimeToLesson(mySpace3, myTimeSlot3, myLesson3);
		
//hardcoded client and two dependants
		lessonator2000.Client cli = new lessonator2000.Client("Bob", "Baratheon", LocalDate.of(2021, 1,15),"bobby", "123");
		lessonator2000.UnderageClient uc1 = new lessonator2000.UnderageClient("Mark", "Baratheon", LocalDate.of(2012, 2, 21), "mark12", "mark123", cli);
		lessonator2000.UnderageClient uc2 = new lessonator2000.UnderageClient("Michael", "Baratheon", LocalDate.of(2012, 4, 13),"Mike", "mike123", cli);
		cli.addToDependantsCatalog(uc1);
		cli.addToDependantsCatalog(uc2);

		
		
//browsingUser = new lessonator2000.Client("Bobby","Baratheon",LocalDate.of(1600, 1, 13) , "bobb", "westeros");
//browsingUser = new lessonator2000.Instructor("Sword","Ned" , "Stark", 5128963587L);
//browsingUser = new Public();
//browsingUser = lessonator2000.Administrator.getAdministrator();



while(activeSession) {
//print the top menu
int userchoice;
userchoice = printMenu(browsingUser);
switch(userchoice) {

case 1: {browsingUser = register();break;}  //register
case 2:{browsingUser = login(); break;}     // login
case 3: {viewOffering();break;} // viewOFferings
case 4: {if (browsingUser instanceof lessonator2000.Administrator)uploadOffering();else{System.out.println("Sorry this choice is not available to you");}break;} //uploadOffering
case 5: {if (browsingUser instanceof lessonator2000.Instructor)signupToLesson(); else{System.out.println("Sorry this choice is not available to you");}break;}   //signupToLesson
case 6: {if (browsingUser instanceof lessonator2000.Client && (!(browsingUser instanceof lessonator2000.UnderageClient))){makeBooking();} else {System.out.println("Sorry this choice is not available to you");}break;}             //makeOffering
case 7: {if (browsingUser instanceof lessonator2000.Administrator)cancelBooking();else {System.out.println("Sorry this choice is not available to you");} break;} // cancelBooking
case 8: {if ((browsingUser instanceof lessonator2000.Administrator) || (browsingUser instanceof lessonator2000.Client))viewBooking();else{System.out.println("Sorry this choice is not available to you");} break;}
case 9: {if (browsingUser instanceof lessonator2000.Administrator) deleteOffering();else{System.out.println("Sorry this choice is not available to you");} break;}
case 10: browsingUser=logOut();break;
case 11: {System.out.println("Goodbye!"); exitSession();break;} //remove session
default: System.out.println("This was not a valid choice");break;
}


}
}
	/**
	 * removes the sesison from the catalog and sets activeSesison to false, which will stop the thread running
	 */
 private	void exitSession(){
	 SessionCatalog sc = lessonator2000.SessionCatalog.getSessionCatalog();
	 sc.removeSession(sessionID);
		activeSession = false;
	}

 /**
  * register() is the method the user will choose to register to the system. it is a System operation. It returns a user that will be assigned to browsingUser by the run method.
  * @return
  */
public lessonator2000.User register() {

browsingUser = registry.register();
if(browsingUser == null) {
	//browsing user is now assigned public when session is created    
	//browsingUser = new lessonator2000.Public();
System.out.println("Registration failed, you will have to start over.");
}
else System.out.println("Registraiton complete, happy browsing");
return browsingUser;
}

/**
 * login() is the method the user will interact with to login as a Client, Administrator or Instructor. 
 * upon successful login the browsingUser will be set to either CLient, Instructor or Administrator subtype. If not successful the browsingUser will stay Public.
 * @return
 */
public lessonator2000.User login() {
lessonator2000.User browsingUser = registry.login();
return browsingUser;
}

/**
 * logOut() is the method the user will interact with to log out and re-assign browsingUser to Public and not to their Client/Instructor/Admiistrator object.
 * @return
 */
public lessonator2000.User logOut() {
return  new lessonator2000.Public();

}

/**
 * makeBooking() is the method the user will interact with , if logged in as a client, to chose a lesson and create a booking. 
 * the responsability of creating the Booking is delegated to Offering class
 */
public void makeBooking() {
	if (!( browsingUser instanceof lessonator2000.UnderageClient) && (browsingUser instanceof lessonator2000.Client)) {
	offers.makeBooking((lessonator2000.Client) browsingUser);}
	else System.out.println("Sorry you can only book a lesson as an adult client");
	//offers.createBooking(userlesson, (lessonator2000.Client) browsingUser);
}

/**
 * cancelBooking() is the method the user will interact with , if logged in as an administrator, to go an delete a booking 
 */
public  void  cancelBooking() {
	Scanner keyboard = new Scanner(System.in);
	if(browsingUser instanceof lessonator2000.Administrator) {
		System.out.println("Please enter the id of the booking you want to remove");
		int id = keyboard.nextInt();
		offers.getBookingCatalog().cancelBooking(id);	
	}

}

/**
 * viewBooking() is the method the user will interact with if they want to view the existing bookings
 * for clients: they can view their own bookings
 * for administrator : they can view all bookings
 * instructors dont see the bookings
 */
public  void viewBooking() {
	System.out.println("---------------------------------------------------");
	System.out.println("------------------View Bookings--------------------");
	System.out.println("---------------------------------------------------");

	if(browsingUser instanceof lessonator2000.Client || browsingUser instanceof lessonator2000.Administrator ) {
		offers.getBookingCatalog().viewBooking(browsingUser);	

	}
	}




/**
 * This method prints the menu , given the browsingUser type of the Session thread that is running. 
 * it then captures userChoice and  returns it so run() can call  the method associated to that choice.
 * @param u
 * @return int
 */
private static int printMenu(lessonator2000.User u) {

Scanner keyboard = new Scanner(System.in);
int userChoice = 0;
System.out.println();
System.out.println("*****************************************");
System.out.println("***-----------------------------------***");
System.out.println("***----------Lessonator2000-----------***");
System.out.println("***-----------------------------------***");
System.out.println("*****************************************");
System.out.println();
if(u instanceof lessonator2000.Client) {

	System.out.println("Welcome , what would you like to do ?\n You are interacting with this system as a Client");
	System.out.println("3- View Offerings");
	System.out.println("6-  Book a Lesson");
	System.out.println("8-  View Bookings");
	System.out.println("10- Logout");
	System.out.println("11- Exit");
	}
else if(u instanceof lessonator2000.Instructor) {
	
	System.out.println("Welcome , what would you like to do ?\\n You are interacting with this system as an Instructor");
	System.out.println("3- View Offerings");
	System.out.println("5- Signup to Lessons");
	System.out.println("10- Logout");
	System.out.println("11- Exit");
	}
else if(u instanceof lessonator2000.Administrator) {
	
	System.out.println("Welcome , what would you like to do ?\\n You are interacting with this system as an Administrator");
	System.out.println("3- View Offerings");
	System.out.println("4- Upload Offering");
	System.out.println("7- Cancel Bookings");
	System.out.println("8- View Bookings");
	System.out.println("9- delete Offering");
	System.out.println("10- Logout");
	System.out.println("11- Exit");
	}
else {
	
	System.out.println("Welcome , what would you like to do?\n You are not logged in, you will interact with this system as Public");
	System.out.println("1- Register");
	System.out.println("2- Log in");
	System.out.println("3- View Offerings");
	System.out.println("11- Exit");
	

	}

boolean valid = false;
while (!valid) {
	try { userChoice = keyboard.nextInt();
	valid = true;}
	catch (java.util.InputMismatchException e) {
	System.out.println("Please enter a valid integer");
	 keyboard.nextLine();
	}
}

return userChoice ;

}

/**
 * Available to instructor
 * signupToLesson() is the method the user will interact with to satisfy the critical use case where an instructor signs up to a lesson and thus makes the lesson viewable to clients.
 */
public  void signupToLesson() {
System.out.println("---------------------------------------------------");
System.out.println("-----------------Signup To Lessons-----------------");
System.out.println("---------------------------------------------------");
Scanner keyboard = new Scanner(System.in);
System.out.println("Please enter the LessonID");
boolean valid = false;
while (!valid) {
	String lessonId = null;
	try { lessonId = keyboard.next();
	valid = true;}
	catch (java.util.InputMismatchException e) {
		System.out.println("Please enter a valid String");
		
	}
	offers.signupToLesson((lessonator2000.Instructor)browsingUser, lessonId);

}
}



/**
 * available to Admiistrators
 * uploadOffering() is the method the administratorwill interact with to add lessons to the Offering Collections. 
 * The lessons don't have an instructor at first, instructors will then be able to view this lesson but clients will only see them when instructors have used signupToLesson()
 */
public void uploadOffering() {
System.out.println("---------------------------------------------------");
System.out.println("-----------------UploadOffering--------------------");
System.out.println("---------------------------------------------------");
//	System.out.println("Main: UploadOffering()");

Scanner keyboard = new Scanner(System.in);
System.out.println("What type of lesson is it?");
String lessontype = null;
boolean valid = false;
while (!valid) {
	try { lessontype = keyboard.nextLine();
	valid = true;}
	catch (java.util.InputMismatchException e) {
		System.out.println("Please enter a valid String");
	}
}
System.out.println("What is the lesson ID");
String lessonID = null;
valid = false;
while (!valid) {
	try { lessonID = keyboard.nextLine();
	valid = true;}
	catch (java.util.InputMismatchException e) {
	System.out.println("Please enter a valid String");
	}
}





LocalDate startdate =  null;
LocalDate enddate =  null;
String lessonDay = null;
LocalTime startTime = null;
LocalTime endTime = null;
do {
	System.out.println("What is the day of the week the lesson will take place on? Must be eithe r: Monday, Tuesday,Wednesday,Thursday,Friday,Saturday or Sunday");

	valid = false;

	while (!valid) {
        lessonDay = keyboard.nextLine();
        lessonDay = lessonDay.substring(0, 1).toUpperCase() + lessonDay.substring(1);

        // Validate that the input day is one of the valid days
        Set<String> validDays = Set.of("Monday", "Tuesday", "Wednesday", "Thursday", 
                                        "Friday", "Saturday", "Sunday");

        if (validDays.contains(lessonDay)) {
            valid = true;  // Set to true only if lessonDay is valid
        } else {
            System.out.println("Please enter a valid day of the week.");
        }
    }


	System.out.println("What is the start date? must be of the form 2025-mm-dd " );

	valid = false;
	while (!valid) {
		try { startdate = LocalDate.parse(keyboard.nextLine());
		valid = true;}
		catch (DateTimeParseException e) {
			System.err.println("Please enter a valid date, must be of the form 2025-mm-dd" + e.getMessage());
		}
		if(!(startdate.getYear() == 2025)) {
valid = false; System.out.println("You can only upload a lesosn for the year 2025, please enter a new date");}
	}


	System.out.println("What is the end date? must be of the form 2025-mm-dd");

	valid = false;
	while (!valid) {
		try { enddate = LocalDate.parse(keyboard.nextLine());
		valid = true;}
		catch (DateTimeParseException e) {
			System.err.println("Please enter a valid date, must be of the form 2025-mm-dd" + e.getMessage());
		}
		if(enddate.isBefore(startdate)) {valid=false; System.out.println("the end date must be after the startDate, enter a new endDate");}
		if(!(enddate.getYear() == 2025)) { valid = false; System.out.println("You can only upload a lesosn for the year 2025, please enter a new date");}
	}

	//make sure the timeslot will no overlap on another one in that day

	System.out.println("What is the start time? must be of the form 00:00:00 ");

	valid = false;
	while (!valid) {
		try { startTime = LocalTime.parse(keyboard.nextLine());
		valid = true;}
		catch (DateTimeParseException e) {
			System.err.println("Please enter a valid time  must be of the form 00:00:00" + e.getMessage());
		}
	}

	System.out.println("What is the end time? must be of the form 00:00:00 and be after the startTime");

	valid = false;
	while (!valid) {
		try { endTime = LocalTime.parse(keyboard.nextLine());
		valid = true;
		}
		catch (DateTimeParseException e) {
			System.err.println("Please enter a valid time  must be of the form 00:00:00" + e.getMessage());
		}
		if(endTime.isBefore(startTime)) {valid=false; System.out.println("the end time must be after the start time, enter a new end Time");}

	}

}while(offers.isConflicting(startdate, enddate,lessonDay,startTime,endTime));

System.out.println("is it a public lesson?  enter true or false");
Boolean isPublic= false ;
valid = false;
while (!valid) {
	try { isPublic = keyboard.nextBoolean();
	keyboard.nextLine();
	valid = true;}
	catch (java.util.InputMismatchException e) {
	System.out.println("Please enter a valid boolean, must be of the form true / false ");
	}
}


int capacity=0;
if(isPublic) {System.out.println("What is the capacity?");
valid = false;
while (!valid) {
	try { capacity = keyboard.nextInt();
	keyboard.nextLine();
	valid = true;}
	catch (java.util.InputMismatchException e) {
		System.out.println("Please enter a valid integer ");
		 keyboard.nextLine();
	}
}}
else capacity = 1;

//create the new lesson Offering -- uploadOffering(...)
lessonator2000.Lesson myLesson = offers.uploadOffering(lessontype, lessonID , false, true,  isPublic,  capacity,startdate, enddate,lessonDay);


boolean roomNbValid = false; 
lessonator2000.Space mySpace = null;
while(!roomNbValid) {
System.out.println("What is the room number?");
String roomNb= null;
 valid = false;
	while (!valid) {
		try { roomNb = keyboard.nextLine();
		valid = true;}
		catch (java.util.InputMismatchException e) {
		System.out.println("Please enter a valid integer");
		}
		
		//addLessonToSpace(...)
		 mySpace = locationregistry.addLessonToSpace(roomNb);
		 if(mySpace != null) roomNbValid = true;
		 if(mySpace == null) System.out.println("This room number was invalid, please enter another room number ");
	}}



//addLocationToSchedual, this will return the timeslot created for this lesson. Create the timeslot. 
//addLessonToschedual add the timeslot to every day that falls on the dayOfTheWeek between startdate and enddate
lessonator2000.Timeslot myTimeSlot = mySpace.addLessonToSchedual(myLesson, startdate, enddate, lessonDay,startTime, endTime);

// add space and time to lesson

offers.addSpaceTimeToLesson(mySpace, myTimeSlot, myLesson);

System.out.println("You have uploaded the lesson" +  myLesson.toString());


}

/**
 * viewOffering() is the method the user will interact with to view the details of an uploaded Lesson. 
 * Instructors will see all the Lessons
 * Clients will only see the Lessons that an instructor has signup for with signupToLesson()
 */
public void viewOffering() {
	offers.viewOffering(browsingUser);

}

public void deleteOffering() {
	Scanner keyboard = new Scanner(System.in);
	boolean valid = false;
	String lessonId = null;
	System.out.println("Please enter the ID of the lesosn you want to remove. To get the id please chose viewOfferings in the previous menu");
	while (!valid) {
		try { lessonId = keyboard.next();
		valid = true;}
		catch (java.util.InputMismatchException e) {
			System.out.println("Please enter a valid String ");
		}
	}
	offers.deleteOffering(lessonId);
	
	
}

}





