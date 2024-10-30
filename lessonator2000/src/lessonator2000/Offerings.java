package lessonator2000;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Offerings{

	private ArrayList<lessonator2000.Lesson> lessons;
	private static Offerings offers = null;

	private lessonator2000.BookingCatalog bookings;



	//Constructor
	private Offerings(){
		this.lessons = new ArrayList<lessonator2000.Lesson>();
		this.bookings = new lessonator2000.BookingCatalog();
		
				//Some hardcoded lessons


	}


	//	public void uploadOffering(String type, String id){
	//	this.lessons.add(new Lesson(type, id, false, true));
	//TODO:  need to add the creation of a private or public lesson 
	//}
	public lessonator2000.Lesson uploadOffering(String type, String id , Boolean hasInstructor, Boolean isAvailable, Boolean isPublic, int capacity, LocalDate start, LocalDate end, String weekDay) {
		//System.out.println("Offerings: uploadOffering");
		//First create the elsson
		lessonator2000.Lesson myLesson = null;
		if(isPublic) {
			myLesson = new lessonator2000.PublicLesson(capacity, type, id,  hasInstructor, isAvailable, start, end, weekDay);
		}
		if(!isPublic) {
			myLesson = new lessonator2000.PrivateLesson(type, id, hasInstructor, isAvailable,start, end, weekDay);
		}
		
		//Add the lesson to the lesson collection
		lessons.add(myLesson);
		
		//return the lesson 
		return myLesson;
		
		
	}


		//Offerings is implemented as a singleton 
		public static Offerings getOfferings() {
			if(offers == null) {
				offers = new Offerings();
			}
			return offers;	
		}




		public void addSpaceTimeToLesson(lessonator2000.Space mySpace, lessonator2000.Timeslot myTimeSlot, lessonator2000.Lesson myLesson) {
			//System.out.println("Offerings: addSpaceTimeToLEsson");
			myLesson.setSpace(mySpace);
			myLesson.setTime(myTimeSlot);
			
		}
		
		private void listAvailableOffering() {
			for(lessonator2000.Lesson l : lessons) {
				if(l.getHasInstructor()) {
					System.out.println(l.toString());
					
				}
			}

		}
		private void listAllOffering() {
			for(lessonator2000.Lesson l : lessons) {
				System.out.println(l.toString());
			}

		}
		public void viewOffering(lessonator2000.User u) {
			System.out.println("---------------------------------------------------");
			System.out.println("-----------------viewOffring-----------------");
			System.out.println("---------------------------------------------------");
			
			if(u instanceof lessonator2000.Instructor) {
				System.out.println("Here are all the lessons that you can view as an instructor: \n");
				listAllOffering();	
			}
			else {System.out.println("Here are all the lessons that you can view: \n");
				listAvailableOffering();
			
			}
		}
		public void signupToLesson(lessonator2000.Instructor ins, String lessonId) {
			lessonator2000.Lesson myLesson= null;
			for(lessonator2000.Lesson les: lessons) {
				
				if(les.getID().equals(lessonId)) {
					myLesson = les;
				}
			}
			
			if(myLesson != null) {
			ins.addToCollection(myLesson);
			myLesson.addInstructorToLesson(ins);
			myLesson.sethasInstructor(true);
			System.out.println("Offerings: signupToLesson() " + myLesson.toString());
			}
			
			else System.out.println("There is no lesson with this Id. try again");
						
		
		}

		public lessonator2000.Lesson findLesson(String lessonId) {
			lessonator2000.Lesson myLesson = null;
			for (lessonator2000.Lesson les : lessons) {

				if (les.getID().equals(lessonId)) {
					myLesson = les;
				}

			}
			return myLesson;
		}

		public void makeBooking(lessonator2000.Client cl){
			Scanner sc = new Scanner(System.in);
			System.out.println("Are you booking for:");
			System.out.println("1. Yourself\n2. Dependant");
			int choice = sc.nextInt();
			System.out.println("Please enter the lesson you want to book: ");
			String lesson = sc.next();

			if(choice == 2){
				lessonator2000.UnderageClient uc = bookings.underageBooking(cl);
				createBooking(lesson, uc);
			}
			else{
				createBooking(lesson, cl);
			}
			// This is just to test if Bookings are in the Booking catalog
			bookings.showBookings();

		}
		public void createBooking(String lessonId, lessonator2000.Client cl){
			// Find lesson with lesson id
			lessonator2000.Lesson les = findLesson(lessonId);
			if(les.getisAvailable()){
				if(les instanceof lessonator2000.PrivateLesson){
					bookings.addBooking(les, cl);
					les.setisAvailable(false);
				}
				else if(les instanceof lessonator2000.PublicLesson && (((lessonator2000.PublicLesson) les).getParticipants() < ((lessonator2000.PublicLesson) les).getCapacity())){

					bookings.addBooking(les,cl);
					((lessonator2000.PublicLesson) les).updateParticipants();
				}

			}
			else{
				System.out.println("This lesson is not available!");
			}


		}
		
}