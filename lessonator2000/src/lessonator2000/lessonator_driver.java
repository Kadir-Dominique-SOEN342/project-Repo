package lessonator2000;

import java.time.LocalDate;
import java.time.LocalTime;

public class lessonator_driver {

	private static Administrator myadmin = Administrator.getAdministrator();	
	private static Registration registry  = Registration.getRegistry();	
	private static Location locationregistry = Location.getLocationRegistry();
	private static User browsingUser;
	private static Offerings offers = Offerings.getOfferings();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Well, hello There");
		//Registration.register(); //TODO: for iteration 2 finish register
		//Registration.login();
		
		//hardcode a few lessons
		UploadOffering("Judo", "jud101", false, true, LocalDate.of(2024, 1, 13),  LocalTime.of(10,00,00),  LocalTime.of(11,00,00), "TY908", true, 10);
		UploadOffering("SumoWrestling", "sumo900", false, true, LocalDate.of(2025, 6, 28),  LocalTime.of(3,00,00),  LocalTime.of(3,30,00), "H513", false, 0);
		UploadOffering("Aerobics", "aero111", true, true, LocalDate.of(2026, 6, 28),  LocalTime.of(3,00,00),  LocalTime.of(3,30,00), "123ramsay", true, 5);
		
		//browsingUser = new Client("Bobby","Baratheon",LocalDate.of(1600, 1, 13) , "bobb", "westeros"); 
		browsingUser = new Instructor("Sword","Ned" , "Stark", 5128963587L);
		
		viewOffering();
		signupToLesson("jud101");
	}

	public static void UploadOffering(String type, String id , Boolean hasInstructor, Boolean isAvailable, LocalDate date, LocalTime startTime, LocalTime endTime, String roomNb, Boolean isPublic, int capacity) {
	//	System.out.println("Main: UploadOffering()");
		Lesson myLesson = offers.uploadOffering(type, id , hasInstructor, isAvailable,  isPublic,  capacity);
				
		Space mySpace = locationregistry.addLessonToSpace(roomNb, myLesson, date, startTime, endTime);
		Timeslot myTimeSlot = mySpace.addLessonToSchedual(myLesson, date,  startTime,endTime);
		
		
		offers.addSpaceTimeToLesson(mySpace, myTimeSlot, myLesson);
		
		// System.out.println(myLesson.toString());
		
	}
	
	public static void viewOffering() {
				offers.viewOffering(browsingUser);
		
	}
	
	public static void deleteOffering() {
		
	}
	
	public static void signupToLesson(String lesssonID) {
		offers.signupToLesson((Instructor)browsingUser, lesssonID);
	}
	
}


