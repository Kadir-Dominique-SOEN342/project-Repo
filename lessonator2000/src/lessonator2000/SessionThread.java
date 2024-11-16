package lessonator2000;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
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
public class SessionThread extends Thread{
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
	public SessionThread() {
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

        //offers.uploadOffering("Physics","phys284",true, true, true, 10, LocalDate.of(2024, 1, 13), LocalDate.of(2024, 12, 13), "Wednesday");


//hardcode a few lessons
//hardcodedLesson1	
//create the new lesson Offering -- uploadOffering(...)
        //lessonator2000.Lesson myLesson = offers.uploadOffering("Judo", "jud101", false, false,  true, 10,LocalDate.of(2024, 1, 13), LocalDate.of(2024, 12, 13),"Wednesday");
        //addLessonToSpace(...)
        //lessonator2000.Space mySpace = locationregistry.addLessonToSpace("TY908");
        //addLocationToSchedual, this will return the timeslot created for this lesson. Create the timeslot. addLessonToschedual add the timeslot to every day that falls on the dayOfTheWeek between startdate and enddate
        //lessonator2000.Timeslot myTimeSlot =mySpace.addLessonToSchedual(myLesson, LocalDate.of(2024, 1, 13), LocalDate.of(2024, 12, 13),"Wednesday", LocalTime.of(10,00,00),  LocalTime.of(11,00,00));
        // add space and time to lesson
        //offers.addSpaceTimeToLesson(mySpace, myTimeSlot, myLesson);

//hardcodedlesson2
        //lessonator2000.Lesson myLesson2 = offers.uploadOffering("SumoWrestling", "sumo900", false, true,  true, 10,LocalDate.of(2025, 6, 28), LocalDate.of(2025,12,11),"Monday");
        //addLessonToSpace(...)
        //lessonator2000.Space mySpace2 = locationregistry.addLessonToSpace("H513");
        //addLocationToSchedual, this will return the timeslot created for this lesson. Create the timeslot. addLessonToschedual add the timeslot to every day that falls on the dayOfTheWeek between startdate and enddate
        //lessonator2000.Timeslot myTimeSlot2 =	mySpace2.addLessonToSchedual(myLesson2, LocalDate.of(2025, 6, 28), LocalDate.of(2025,12,11),"Monday", LocalTime.of(5,00,00),  LocalTime.of(3,30,00));
        // add space and time to lesson
        //offers.addSpaceTimeToLesson(mySpace2, myTimeSlot2, myLesson2);


//hardcodedlesson3
        //lessonator2000.Lesson myLesson3 = offers.uploadOffering("Aerobics", "aero111", true, true,  true, 1,LocalDate.of(2025, 6, 28), LocalDate.of(2025,10,20),"Saturday");
        //addLessonToSpace(...)
        //lessonator2000.Space mySpace3 = locationregistry.addLessonToSpace("H513");

        //addLocationToSchedual, this will return the timeslot created for this lesson. Create the timeslot. addLessonToschedual add the timeslot to every day that falls on the dayOfTheWeek between startdate and enddate
        //lessonator2000.Timeslot myTimeSlot3 =	mySpace3.addLessonToSchedual(myLesson3, LocalDate.of(2025, 6, 28), LocalDate.of(2025,10,20),"Saturday", LocalTime.of(3,00,00),  LocalTime.of(5,30,00));
        // add space and time to lesson
        //offers.addSpaceTimeToLesson(mySpace3, myTimeSlot3, myLesson3);

//hardcoded client and two dependants

        //lessonator2000.Client cli = new lessonator2000.Client("Bob", "Baratheon", LocalDate.of(2021, 1, 15), "bobby", "123");
		/*
        Session session = lessonator2000.ManageSessionFactory.getSf().openSession();
        Transaction transaction = session.beginTransaction();

        lessonator2000.Schedual sc = new lessonator2000.Schedual(2024);
        session.save(sc);


		lessonator2000.Day  day = new lessonator2000.Day(LocalDate.of(2024, 11, 14));
		sc.getMySchedual().add(day);
		session.save(sc);
		day.setSchedual(sc);
        session.save(day);

        lessonator2000.Space space = new lessonator2000.Space("Rented", "H123", "Classroom", "Montreal", "Quebec");
        space.setSchedual(sc);
        session.save(space);

		lessonator2000.Timeslot timeslot = new lessonator2000.Timeslot(LocalTime.of(10, 0), LocalTime.of(11, 30));
		session.save(timeslot);

		lessonator2000.Timeslot timeslot2 = new lessonator2000.Timeslot(LocalTime.of(9, 0), LocalTime.of(10, 0));
		session.save(timeslot2);

		lessonator2000.Timeslot timeslot3 = new lessonator2000.Timeslot(LocalTime.of(15, 0), LocalTime.of(16, 0));
		session.save(timeslot3);

		//lessonator2000.Instructor instructor = new lessonator2000.Instructor("Physics", "Jane", "Doe", 123);
		//session.save(instructor);
*/
		//offers.uploadOffering("Math", "Math101", false, true, true, 10, LocalDate.of(2023, 9, 1), LocalDate.of(2023, 12, 15), "Monday");
		//offers.uploadOffering("Chemistry", "CHEM101", false, true, true, 15, LocalDate.of(2020, 11, 2), LocalDate.of(2020, 9, 1), "Wednesday");


	/*
        lessonator2000.Lesson lesson = new lessonator2000.Lesson("Math", "Math101", true, true, LocalDate.of(2023, 9, 1), LocalDate.of(2023, 12, 15), "Monday");
        lesson.setInstructor(instructor);
		lesson.setSpace(space);
		lesson.setTimeslot(timeslot);
		session.save(lesson);

		lessonator2000.Lesson lesson2 = new lessonator2000.Lesson("Chemistry", "CHEM101", true, true, LocalDate.of(2020, 11, 2), LocalDate.of(2020, 9, 1), "Wednesday");
		lesson2.setInstructor(instructor);
		lesson2.setSpace(space);
		lesson2.setTimeslot(timeslot2);
		session.save(lesson2);

		lessonator2000.Lesson lesson3 = new lessonator2000.Lesson("Biology", "BIO101", false, false, LocalDate.of(2022, 4, 2), LocalDate.of(2022, 4, 2), "Friday");
		lesson3.setSpace(space);
		lesson3.setTimeslot(timeslot3);
		session.save(lesson3);

		 */



		Session session = lessonator2000.ManageSessionFactory.getSf().openSession();
		Transaction transaction = session.beginTransaction();

		lessonator2000.Schedual sc = new lessonator2000.Schedual(2024);
		session.save(sc);

		lessonator2000.Space space = new lessonator2000.Space("Rented", "TY908", "Classroom", "Ottawa", "Quebec");
		space.setSchedual(sc);
		session.save(space);


		lessonator2000.Day  day = new lessonator2000.Day(LocalDate.of(2024, 11, 14));
		sc.getMySchedual().add(day);
		session.save(sc);
		day.setSchedual(sc);
		session.save(day);

		lessonator2000.Day  day2 = new lessonator2000.Day(LocalDate.of(2024, 11, 15));
		sc.getMySchedual().add(day);
		session.save(sc);
		day.setSchedual(sc);
		session.save(day);

		lessonator2000.Day  day3 = new lessonator2000.Day(LocalDate.of(2024, 11, 16));
		sc.getMySchedual().add(day);
		session.save(sc);
		day.setSchedual(sc);
		session.save(day);

		lessonator2000.Day  day4 = new lessonator2000.Day(LocalDate.of(2024, 11, 17));
		sc.getMySchedual().add(day);
		session.save(sc);
		day.setSchedual(sc);
		session.save(day);

		lessonator2000.Day  day5 = new lessonator2000.Day(LocalDate.of(2024, 11, 18));
		sc.getMySchedual().add(day);
		session.save(sc);
		day.setSchedual(sc);
		session.save(day);

		lessonator2000.Day  day6 = new lessonator2000.Day(LocalDate.of(2024, 11, 18));
		sc.getMySchedual().add(day);
		session.save(sc);
		day.setSchedual(sc);
		session.save(day);




        session.getTransaction().commit();
        session.close();

		/*
        lessonator2000.UnderageClient uc1 = new lessonator2000.UnderageClient("Mark", "Baratheon", LocalDate.of(2012, 2, 21), "mark12", "mark123", cli);
        lessonator2000.UnderageClient uc2 = new lessonator2000.UnderageClient("Michael", "Baratheon", LocalDate.of(2012, 4, 13), "Mike", "mike123", cli);
        cli.addToDependantsCatalog(uc1);
        cli.addToDependantsCatalog(uc2);

		 */


//browsingUser = new lessonator2000.Client("Bobby","Baratheon",LocalDate.of(1600, 1, 13) , "bobb", "westeros");
//browsingUser = new lessonator2000.Instructor("Sword","Ned" , "Stark", 5128963587L);
//browsingUser = new Public();
//browsingUser = lessonator2000.Administrator.getAdministrator();


        while (activeSession) {
//print the top menu
            int userchoice;
            userchoice = printMenu(browsingUser);
            switch (userchoice) {

                case 1: {
                    browsingUser = register();
                    break;
                }  //register
                case 2: {
                    browsingUser = login();
                    break;
                }     // login
                case 3: {
                    viewOffering();
                    break;
                } // viewOFferings
                case 4: {
                    if (browsingUser instanceof lessonator2000.Administrator) uploadOffering();
                    else {
                        System.out.println("Sorry this choice is not available to you");
                    }
                    break;
                } //uploadOffering
                case 5: {
                    if (browsingUser instanceof lessonator2000.Instructor) signupToLesson();
                    else {
                        System.out.println("Sorry this choice is not available to you");
                    }
                    break;
                }   //signupToLesson
                case 6: {
                    if (browsingUser instanceof lessonator2000.Client && (!(browsingUser instanceof lessonator2000.UnderageClient))) {
                        makeBooking();
                    } else {
                        System.out.println("Sorry this choice is not available to you");
                    }
                    break;
                }             //makeOffering
                case 7: {
                    if (browsingUser instanceof lessonator2000.Administrator) cancelBooking();
                    else {
                        System.out.println("Sorry this choice is not available to you");
                    }
                    break;
                } // cancelBooking
                case 8: {
                    if ((browsingUser instanceof lessonator2000.Administrator) || (browsingUser instanceof lessonator2000.Client))
                        viewBooking();
                    else {
                        System.out.println("Sorry this choice is not available to you");
                    }
                    break;
                }
                case 9: {
                    if (browsingUser instanceof lessonator2000.Administrator) deleteOffering();
                    else {
                        System.out.println("Sorry this choice is not available to you");
                    }
                    break;
                }
                case 10:
                    browsingUser = logOut();
                    break;
                case 11: {
                    System.out.println("Goodbye!");
                    exitSession();
                    break;
                } //remove session
                default:
                    System.out.println("This was not a valid choice");
                    break;
            }


        }
    }
	/**
	 * removes the sesison from the catalog and sets activeSesison to false, which will stop the thread running
	 */
 private	void exitSession(){
	 lessonator2000.SessionCatalog sc = lessonator2000.SessionCatalog.getSessionCatalog();
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
	try { lessontype = keyboard.next();
	valid = true;}
	catch (java.util.InputMismatchException e) {
		System.out.println("Please enter a valid String");
	}
}
System.out.println("What is the lesson ID");
String lessonID = null;
valid = false;
while (!valid) {
	try { lessonID = keyboard.next();
	valid = true;}
	catch (java.util.InputMismatchException e) {
	System.out.println("Please enter a valid integer");
	}
}



System.out.println("What is the room number?");
String roomNb= null;
 valid = false;
	while (!valid) {
		try { roomNb = keyboard.next();
		valid = true;}
		catch (java.util.InputMismatchException e) {
		System.out.println("Please enter a valid integer");
		}
	}

System.out.println("What is the day of the week the lesson will take place on?");
String lessonDay = null;
valid = false;
while (!valid) {
	try { lessonDay = keyboard.next();
	valid = true;}
	catch (java.util.InputMismatchException e) {
	System.out.println("Please enter a valid integer");
	}
}



System.out.println("What is the start date? must be of the form yyyy-mm-dd");
LocalDate startdate = null ;
valid = false;
while (!valid) {
	try { startdate = LocalDate.parse(keyboard.next());
	valid = true;}
	catch (java.util.InputMismatchException e) {
	System.out.println("Please enter a valid date, must be of the form yyyy-mm-dd");
	}
}


System.out.println("What is the end date? must be of the form yyyy-mm-dd");
LocalDate enddate =  null ;
valid = false;
while (!valid) {
	try { enddate = LocalDate.parse(keyboard.next());
	valid = true;}
	catch (java.util.InputMismatchException e) {
	System.out.println("Please enter a valid date, must be of the form yyyy-mm-dd");
	}
}
System.out.println("What is the start time? must be of the form 00:00:00 ");
LocalTime startTime= null;
valid = false;
while (!valid) {
	try { startTime = LocalTime.parse(keyboard.next());
	valid = true;}
	catch (java.util.InputMismatchException e) {
	System.out.println("Please enter a valid time, must be of the form 00:00:00 ");
	}
}



System.out.println("What is the end time? must be of the form 00:00:00 ");
LocalTime endTime = null; //LocalTime.parse("00:00:00");
valid = false;
while (!valid) {
	try { endTime = LocalTime.parse(keyboard.next());
	valid = true;}
	catch (java.util.InputMismatchException e) {
	System.out.println("Please enter a valid time, must be of the form 00:00:00 ");
	}
}



System.out.println("is it a public lesson?  enter true or false");
Boolean isPublic= false ;
valid = false;
while (!valid) {
	try { isPublic = keyboard.nextBoolean();
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
	valid = true;}
	catch (java.util.InputMismatchException e) {
		System.out.println("Please enter a valid integer ");
		 keyboard.nextLine();
	}
}}
else capacity = 1;

Session session = lessonator2000.ManageSessionFactory.getSf().openSession();;
Transaction transaction = session.beginTransaction();
//create the new lesson Offering -- uploadOffering(...)
lessonator2000.Lesson myLesson = offers.uploadOffering(lessontype, lessonID , false, true,  isPublic,  capacity,startdate, enddate,lessonDay);
//addLessonToSpace(...)
lessonator2000.Space mySpace = locationregistry.addLessonToSpace(roomNb);
//myLesson.setSpace(mySpace);
//session.save(myLesson);

//addLocationToSchedual, this will return the timeslot created for this lesson. Create the timeslot. addLessonToschedual add the timeslot to every day that falls on the dayOfTheWeek between startdate and enddate
lessonator2000.Timeslot myTimeSlot = mySpace.addLessonToSchedual(myLesson, startdate, enddate, lessonDay,startTime, endTime);
/*
myLesson.setTimeslot(myTimeSlot);
session.save(myLesson);
session.getTransaction().commit();
session.close();

 */

// add space and time to lesson

offers.addSpaceTimeToLesson(mySpace, myTimeSlot, myLesson);

System.out.println("You have uploaded the lesson" +  myLesson.toString());
/*
Space and timeslots should already exists in the system
we create a lesson and connect the space and timeslots with that lesson
 */

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







