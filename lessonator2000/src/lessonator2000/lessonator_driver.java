package lessonator2000;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class lessonator_driver {


	private static lessonator2000.Registration registry  = lessonator2000.Registration.getRegistry();
	private static lessonator2000.Location locationregistry = lessonator2000.Location.getLocationRegistry();
	private static lessonator2000.User browsingUser;
	private static lessonator2000.Offerings offers = lessonator2000.Offerings.getOfferings();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
		//hardcode a few lessons
	//hardcodedLesson1	
		//create the new lesson Offering -- uploadOffering(...)
		lessonator2000.Lesson myLesson = offers.uploadOffering("Judo", "jud101", false, true,  true, 10,LocalDate.of(2024, 1, 13), LocalDate.of(2024, 12, 13),"Wednesday");
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
		
		
				//hardcodedlesson2
				
				lessonator2000.Lesson myLesson3 = offers.uploadOffering("Aerobics", "aero111", true, true,  true, 1,LocalDate.of(2025, 6, 28), LocalDate.of(2025,10,20),"Saturday");
				//addLessonToSpace(...)
				lessonator2000.Space mySpace3 = locationregistry.addLessonToSpace("H513");
				//addLocationToSchedual, this will return the timeslot created for this lesson. Create the timeslot. addLessonToschedual add the timeslot to every day that falls on the dayOfTheWeek between startdate and enddate
				lessonator2000.Timeslot myTimeSlot3 =	mySpace3.addLessonToSchedual(myLesson3, LocalDate.of(2025, 6, 28), LocalDate.of(2025,10,20),"Saturday", LocalTime.of(3,00,00),  LocalTime.of(5,30,00));
				// add space and time to lesson
				offers.addSpaceTimeToLesson(mySpace3, myTimeSlot3, myLesson3);
				
				
		//lessonator2000.Client cli = new lessonator2000.Client("Bob", "b", LocalDate.of(2021, 1,15),"bobby", "123");
		browsingUser = new lessonator2000.Client("Bobby","Baratheon",LocalDate.of(1600, 1, 13) , "bobb", "westeros");
		//browsingUser = new lessonator2000.Instructor("Sword","Ned" , "Stark", 5128963587L);
		//browsingUser = new Public();

		lessonator2000.UnderageClient uc1 = new lessonator2000.UnderageClient("Mark", "Baratheon", LocalDate.of(2012, 2, 21), "mark12", "mark123", (lessonator2000.Client) browsingUser);
		lessonator2000.UnderageClient uc2 = new lessonator2000.UnderageClient("Michael", "Baratheon", LocalDate.of(2012, 4, 13),"Mike", "mike123", (lessonator2000.Client) browsingUser);
		((lessonator2000.Client) browsingUser).addToDependantsCatalog(uc1);
		((lessonator2000.Client) browsingUser).addToDependantsCatalog(uc2);
		
		while(true) {
		//print the top menu
		int userchoice;
		userchoice = printMenu(browsingUser);
		switch(userchoice) {
		case 1: {register();break;}  //register
		case 2:{login(); break;}     // login
		case 3: {viewOffering();break;} // viewOFferings
		case 4: {if (browsingUser instanceof lessonator2000.Administrator)uploadOffering();else{System.out.println("Sorry this choice is not available to you");}break;} //uploadOffering
		case 5: {if (browsingUser instanceof lessonator2000.Instructor)signupToLesson(); else{System.out.println("Sorry this choice is not available to you");}break;}   //signupToLesson
		case 6: {if (browsingUser instanceof lessonator2000.Client && (!(browsingUser instanceof lessonator2000.UnderageClient))){makeBooking();} else {System.out.println("Sorry this choice is not available to you");}break;}             //makeOffering
		case 7: {if (browsingUser instanceof lessonator2000.Administrator)cancelBooking();{System.out.println("Sorry this choice is not available to you");} break;} // cancelBooking
		case 8: {if ((browsingUser instanceof lessonator2000.Administrator) || (browsingUser instanceof lessonator2000.Client))viewBooking();{System.out.println("Sorry this choice is not available to you");} break;}
		case 9: {if (browsingUser instanceof lessonator2000.Client)confirmBooking();{System.out.println("Sorry this choice is not available to you");} break;}
		case 10: logOut();
		case 11: {System.out.println("Goodbye!"); System.exit(0);} //exitsystem
		}
		}
		
		
	
	}

	public static void register() {
		
		browsingUser = lessonator2000.Registration.register();
		if(browsingUser == null) {
		browsingUser = new lessonator2000.Public();
		System.out.println("Registration failed, you will have to start over.");
		}
		else System.out.println("Registraiton complete, happy browsing");
	}
	
	public static void login() {
		lessonator2000.Registration.login();
	}
	
	public static void logOut() {
		browsingUser = new lessonator2000.Public();
	}
	
	public static void makeBooking() {
		// ask the user for lessonId
		Scanner sc = new Scanner(System.in);
		offers.makeBooking((lessonator2000.Client) browsingUser);
		//offers.createBooking(userlesson, (lessonator2000.Client) browsingUser);



	}

	public static void confirmBooking() {
		//implementation
	}
	
	public static void cancelBooking() {
		//implementation
	}
	
	public static void viewBooking() {
		//implementation
	}
	
	
	public static void deleteOffering() {  // delete this
		//Offerings.deleteoffering();
	}
	

	private static int printMenu(lessonator2000.User u) {
		//TODO: not assume perfect user
		Scanner keyboard = new Scanner(System.in);
		int userChoice;
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
			System.out.println("9-  Confirm Booking");
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
			System.out.println("4- Upload Offering");
			System.out.println("7- Cancel Bookings");
			System.out.println("8- View Bookings");
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
		return userChoice = keyboard.nextInt();

	}
	
	public static void signupToLesson() {
		System.out.println("---------------------------------------------------");
		System.out.println("-----------------Signup To Lessons-----------------");
		System.out.println("---------------------------------------------------");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the LessonID");
		//TODO : do not assume perfect user
		String lessonId = keyboard.next();
		offers.signupToLesson((lessonator2000.Instructor)browsingUser, lessonId);
	}
	
	public static void uploadOffering() {
		System.out.println("---------------------------------------------------");
		System.out.println("-----------------UploadOffering--------------------");
		System.out.println("---------------------------------------------------");
	//	System.out.println("Main: UploadOffering()");
		//TODO:  not assume perfect user
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What type of lesson is it?");
		String lessontype = keyboard.next();
		System.out.println("What is the lesson ID");
		String lessonID = keyboard.next();
		System.out.println("What is the room number?");
		String roomNb = keyboard.next();
		System.out.println("What is the day of the week the lesson will take place on?");
		String lessonDay = keyboard.next();
		System.out.println("What is the start date? must be of the form yyyy-mm-dd");
		LocalDate startdate = LocalDate.parse(keyboard.next());
		System.out.println("What is the end date? must be of the form yyyy-mm-dd");
		LocalDate enddate = LocalDate.parse(keyboard.next());
		System.out.println("What is the start time? must be of the form 00:00:00 ");
		LocalTime startTime = LocalTime.parse(keyboard.next());
		System.out.println("What is the end time? must be of the form 00:00:00 ");
		LocalTime endTime = LocalTime.parse(keyboard.next());
		System.out.println("is it a public lesson?  enter true or false");
		Boolean isPublic = keyboard.nextBoolean();
		int capacity;
		if(isPublic) {System.out.println("What is the capacity?");
		capacity = keyboard.nextInt();}
		else capacity = 1;
		
		//create the new lesson Offering -- uploadOffering(...)
		lessonator2000.Lesson myLesson = offers.uploadOffering(lessontype, lessonID , false, true,  isPublic,  capacity,startdate, enddate,lessonDay);
		
		//addLessonToSpace(...)
		lessonator2000.Space mySpace = locationregistry.addLessonToSpace(roomNb);
		
		//addLocationToSchedual, this will return the timeslot created for this lesson. Create the timeslot. addLessonToschedual add the timeslot to every day that falls on the dayOfTheWeek between startdate and enddate
		lessonator2000.Timeslot myTimeSlot =	mySpace.addLessonToSchedual(myLesson, startdate, enddate, lessonDay,startTime, endTime);

		// add space and time to lesson
		
		offers.addSpaceTimeToLesson(mySpace, myTimeSlot, myLesson);
				
		System.out.println("You have uploaded the lesson" +  myLesson.toString());
				
	    
	}


	

	public static void viewOffering() {
				offers.viewOffering(browsingUser);
		
	}
}


