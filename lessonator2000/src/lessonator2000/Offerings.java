package lessonator2000;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Offerings{

	private ArrayList<Lesson> lessons;
	private static Offerings offers = null;

	//Constructor
	private Offerings(){
		this.lessons = new ArrayList<Lesson>();
		
				//Some hardcoded lessons


	}


	//	public void uploadOffering(String type, String id){
	//	this.lessons.add(new Lesson(type, id, false, true));
	//TODO:  need to add the creation of a private or public lesson 
	//}
	public Lesson uploadOffering(String type, String id , Boolean hasInstructor, Boolean isAvailable, Boolean isPublic, int capacity) {
		//System.out.println("Offerings: uploadOffering");
		Lesson myLesson = null;
		if(isPublic) {
			myLesson = new PublicLesson(capacity, type, id,  hasInstructor, isAvailable);
		}
		if(!isPublic) {
			myLesson = new PrivateLesson(type, id, hasInstructor, isAvailable);
		}
		
		//add the lesson to the lesson collection
		lessons.add(myLesson);

		return myLesson;
	}

		//Commented out by Dom on 18-10-2024 , I needed it to compile to implement viewOfferings().  
		//   public void deleteOffering(Lesson lesson){
		// Lesson foundLesson = null; 
		// 	Lesson foundLesson;
		//    for(Lesson temp : lessons){
		//        if(temp.getID().equals(lesson.getID()))
		//            Lesson foundLesson = temp;
		//         break;
		//    }
		//      if(foundLesson != null){
		//         lessons.remove(foundLesson);
		//     }

		//   }

		//Offerings is implemented as a singleton 
		public static Offerings getOfferings() {
			if(offers == null) {
				offers = new Offerings();
			}
			return offers;	
		}




		public void addSpaceTimeToLesson(Space mySpace, Timeslot myTimeSlot, Lesson myLesson) {
			//System.out.println("Offerings: addSpaceTimeToLEsson");
			myLesson.setSpace(mySpace);
			myLesson.setTime(myTimeSlot);
			
		}
		
		private void listAvailableOffering() {
			for(Lesson l : lessons) {
				if(l.getHasInstructor()) {
					System.out.println(l.toString());
					
				}
			}

		}
		private void listAllOffering() {
			for(Lesson l : lessons) {
				System.out.println(l.toString());
			}

		}
		public void viewOffering(User u) {
			
			if(u instanceof Instructor) {
				System.out.println("Here are all the lessons that you can view as an instructor: \n");
				listAllOffering();	
			}
			else {System.out.println("Here are all the lessons that you can view: \n");
				listAvailableOffering();
			
			}
		}
		public void signupToLesson(Instructor ins, String lessonId) {
			Lesson myLesson= null;
			for(Lesson l: lessons) {
				
				if(l.getID().equals(lessonId)) {
					myLesson = l;
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
		
}