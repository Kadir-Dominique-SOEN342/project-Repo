package lessonator2000;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Class Offerings.
 *
 * <p>Offerings is the class that holds the collection of Lessons and that is responsable to create and modify lessons
 * Offerings also holds the BookingCatalog that holds and handles the Bookings</p>
 * 
 * 
 */
public class Offerings {

	private ArrayList<lessonator2000.Lesson> lessons;
	private static Offerings offers = null;

	private lessonator2000.BookingCatalog bookingCatalog;


	/**
	 * Offerings is implemented as a singleton
	 * private constructor of Offerings
	 */
	private Offerings() {
		this.lessons = new ArrayList<lessonator2000.Lesson>();
		this.bookingCatalog = lessonator2000.BookingCatalog.getBookingCatalog();
	}


	//	public void uploadOffering(String type, String id){
	//	this.lessons.add(new Lesson(type, id, false, true));
	//}

	/**
	 * uploadOffering creates the lessons and adds them to lessons collection
	 *
	 * @param type
	 * @param id
	 * @param hasInstructor
	 * @param isAvailable
	 * @param isPublic
	 * @param capacity
	 * @param start
	 * @param end
	 * @param weekDay
	 * @return
	 */
	synchronized lessonator2000.Lesson uploadOffering(String type, String id, Boolean hasInstructor, Boolean isAvailable, Boolean isPublic, int capacity, LocalDate start, LocalDate end, String weekDay) {
		//System.out.println("Offerings: uploadOffering");
		//First create the elsson
		lessonator2000.Lesson myLesson = null;
		if (isPublic) {
			myLesson = new lessonator2000.PublicLesson(capacity, type, id, hasInstructor, isAvailable, start, end, weekDay);
		}
		if (!isPublic) {
			myLesson = new lessonator2000.PrivateLesson(type, id, hasInstructor, isAvailable, start, end, weekDay);
		}

		//Add the lesson to the lesson collection
		lessons.add(myLesson);

		//return the lesson 
		return myLesson;


	}


	//Offerings is implemented as a singleton

	/**
	 * returns the single instance of Offering
	 *
	 * @return
	 */
	public static Offerings getOfferings() {
		if (offers == null) {
			offers = new Offerings();
		}
		return offers;
	}

	/**
	 * returns the bookingCatalog attribute of Offerings
	 *
	 * @return
	 */
	public lessonator2000.BookingCatalog getBookingCatalog() {
		return this.bookingCatalog;
	}


	/**
	 * This method sets the timeSlot and the space attribute of the Lesson. This was done so the lesson has visibility on those objects.
	 *
	 * @param mySpace
	 * @param myTimeSlot
	 * @param myLesson
	 */
	void addSpaceTimeToLesson(lessonator2000.Space mySpace, lessonator2000.Timeslot myTimeSlot, lessonator2000.Lesson myLesson) {
		//System.out.println("Offerings: addSpaceTimeToLEsson");
		myLesson.setSpace(mySpace);
		myLesson.setTime(myTimeSlot);

	}

	/**
	 * This is the method that viewOffering() will use to discriminate between lessons that have an instructor assigned to it or not when showing the lesson to clients.
	 */
	private void listAvailableOffering() {
		for (lessonator2000.Lesson l : lessons) {
			if (l.getHasInstructor()) {
				System.out.println(l.toString());

			}
		}

	}

	/**
	 * This is  method that viewOffering() will use to show lessons without discrimination to instructors
	 */
	private void listAllOffering() {
		for (lessonator2000.Lesson l : lessons) {
			System.out.println(l.toString());
		}
	}

	/**
	 * this method will show details of lessons that have instructors to clients or all the lessons to instructors
	 *
	 * @param u
	 */
	public void viewOffering(lessonator2000.User u) {
		System.out.println("---------------------------------------------------");
		System.out.println("-----------------viewOffering-----------------");
		System.out.println("---------------------------------------------------");

		if (u instanceof lessonator2000.Instructor || u instanceof lessonator2000.Administrator) {
			System.out.println("Here are all the lessons that you can view as an instructor: \n");
			listAllOffering();
		} else {
			System.out.println("Here are all the lessons that you can view: \n");
			listAvailableOffering();

		}
	}

	/**
	 * This is the method that will let an instructor signup to a lesson
	 * the method takes an instructor and a lessonId , it will add the instructor to the lesson and add the lesson to the instructor teaches collection
	 *
	 * @param ins
	 * @param lessonId
	 */
	public synchronized void signupToLesson(lessonator2000.Instructor ins, String lessonId) {
		lessonator2000.Lesson myLesson = null;
		// find the lesson
		for (lessonator2000.Lesson les : lessons) {

			if (les.getID().equals(lessonId)) {
				myLesson = les;
			}
		}
		if(myLesson == null) {System.out.println("There is no lesson with this Id. try again"); return;}
		if(!(myLesson.getype().equals(ins.getSpecialization()))) {System.out.println("Sorry You are not specialized in this type of lesson"); return;}
		
		
		//Checking if the lesson is offered in a city that figures in the instructor availabilities
		Space lessonSpace = myLesson.getSpace();
		String city = lessonSpace.getCity();
		Boolean isInAvailability = false;
		for(String s: ins.getAvailability()){
			if(s.equals(city)){
				isInAvailability = true;
			}
		}
		
		// if the lesson is in the instructor availability , process to signup to the lesson
		if (isInAvailability) {
			ins.addToCollection(myLesson);
			myLesson.addInstructorToLesson(ins);
			myLesson.sethasInstructor(true);
			//make the offering avaialble
			System.out.println("Offerings: signupToLesson() " + myLesson.toString());
		} else System.out.println("There is no lesson with this Id. try again");


	}

	/**
	 * This method is used by makeBooking to find the lesson to create the Booking  association instance with(lesson and Client)
	 * returns a lesson if found
	 *
	 * @param lessonId
	 * @return
	 */
	private lessonator2000.Lesson findLesson(String lessonId) {
		lessonator2000.Lesson myLesson = null;
		for (lessonator2000.Lesson les : lessons) {

			if (les.getID().equals(lessonId)) {
				myLesson = les;
			}

		}
		return myLesson;
	}

	/**
	 * This method lets the user specify if the booking is for an adult or a dependant Client . verifies the age of the client.
	 * Then the user can specify the lesson and the method calls createBooking() to instanciate the new booking
	 *
	 * @param cl
	 */
	public synchronized void makeBooking(lessonator2000.Client cl) {
		if(cl.getAge() < 18 ) {
			System.out.println("You need to be an adult to book, go ask your legal Guardian to book it for you");
			return;}
		
		

		
		Scanner sc = new Scanner(System.in);
		System.out.println("Are you booking for:");
		System.out.println("1. Yourself\n2. Dependant");
		int choice = sc.nextInt();
		System.out.println("Please enter the lesson you want to book: ");
		String lesson = null;
		boolean valid = false;
		while (!valid) {
			try {
				lesson = sc.next();
				valid = true;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid lesson id");
			}
		}
		if(choice == 2){
			
			cl.viewDependants();
			System.out.println("Please enter the username of the dependant you want to book for: ");
			String dependantusername = null;
			valid = false;
			while(!valid) {
				try {
			 dependantusername = sc.next();
			valid = true;
				}
			catch(java.util.InputMismatchException e) {
				System.out.println("Please enter a valid username");
			}
			}
			
			lessonator2000.UnderageClient uc = bookingCatalog.underageBooking(dependantusername, cl);
			if(uc != null) {createBooking(lesson, uc);
			System.out.println("Here is your new booking: ");
			bookingCatalog.viewBooking(uc);
			return;}
			else System.out.println("Sorry there were no dependant with that username, start over");
		}
		if(choice == 1) {
			createBooking(lesson, cl);
			// This is just to test if Bookings are in the Booking catalog
			System.out.println("Here is your new booking: ");
			bookingCatalog.viewBooking(cl);
			return;
		}
		
		else{
			System.out.println("This was not an available choice, please start over");
		}
		
	}
		/**
		 * this method is used by makeBooking() to send a message(to delegate) to bookingCatalog in order to create the booking
		 * The method verifies if the lesson is available(aka there is space) and if it has an instructor
		 * the method then wll make a private lesson unavailable or increase the participant of a public lesson
		 * @param lessonId
		 * @param cl
		 */
		public synchronized void createBooking(String lessonId, lessonator2000.Client cl){
			// Find lesson with lesson id
			lessonator2000.Lesson les = findLesson(lessonId);
			if (les.getisAvailable() && les.getHasInstructor()) {   // Dom 08-11-2024  I added a check to make sure the lesson has an instructor assigned to it. If not they might not see it in view offering but they could still create a booking for it if they had the id
				if (les instanceof lessonator2000.PrivateLesson) {
					bookingCatalog.addBooking(les, cl);
					les.setisAvailable(false);
				} else if (les instanceof lessonator2000.PublicLesson && (((lessonator2000.PublicLesson) les).getParticipants() < ((lessonator2000.PublicLesson) les).getCapacity())) {

					bookingCatalog.addBooking(les, cl);
					((lessonator2000.PublicLesson) les).updateParticipants();
				}

			} else {
				System.out.println("This lesson is not available!");
			}


		}

		/**
		 * this method will delete a lesson that has the argument's lessonId
		 * the lesson will be removed from every day in the schedual of the space it was uploaded to
		 * then , if it had an instructor it will be removed from the instructor's collection
		 * then if it had any booking associated, the booking will be removed 
		 * @param lessonId
		 */
		public void deleteOffering (String lessonId){
			lessonator2000.Lesson lessonToRemove = null;
			for (lessonator2000.Lesson l : lessons) {
				if (l.getID().equals(lessonId)) lessonToRemove = l;
			}
			if (lessonToRemove != null) {
				//remove the timeslot containing the lesson from every day in the schedual
				lessonator2000.Space s = lessonToRemove.getSpace();
				s.removeLessonFromSpace(lessonToRemove);
				//remove the lesson from the instructor's collection of lessons it teaches
				lessonator2000.Instructor i = lessonToRemove.getTeacher();
				if (i != null) {
					i.removeLesson(lessonToRemove);
				}

				//remove the lesson from the Offers
				removeLessonFromOffers(lessonToRemove);

				//remove any booking's associate with that lesson
				lessonator2000.BookingCatalog bc = lessonator2000.BookingCatalog.getBookingCatalog();
				bc.removeBooking(lessonToRemove);


				System.out.println("The lesson was removed from entire system");
			} else System.out.println("This lesson cannot be removed because the lesson ID is not found");

		}

		/**
		 * Used by deleteOffering to remove the lesson from the offers collection
		 * @param lessonToRemove
		 */
		private void removeLessonFromOffers (lessonator2000.Lesson lessonToRemove){
			lessons.removeIf(l -> l == lessonToRemove);
			//for(Lesson l : lessons) {
			//if(l == lessonToRemove) {
			//lessons.remove(lessons.indexOf(lessonToRemove));
			//	System.out.println("lesson removed form OFfering's lessons");
			//}
			//}

		}
		boolean isConflicting(LocalDate startDate ,LocalDate endDate , String weekDay,LocalTime start,  LocalTime end ) {
			
			for(Lesson l : lessons) {
				//both lessons fall on the same day of the week and the dates overlap
				if( l.getDayOfTheWeek().equals(weekDay) && 
				l.getStartDatE().isBefore(endDate) &&
				l.getEndDate().isAfter(startDate) &&
				 // Time ranges overlap
				l.getTimeSlot().getStartTime().isBefore(end) &&
				l.getTimeSlot().getEndTime().isAfter(start)) {
				System.out.println("This time if conflicting with the time of another lesson on that Day");
				return true;}
			}
			
			
			return false;
		}

		
		public ArrayList<Lesson> getLessons() {
			return lessons;
		}
	}
