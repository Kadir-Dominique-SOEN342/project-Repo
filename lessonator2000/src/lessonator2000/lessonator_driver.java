package lessonator2000;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class lessonator_driver {

	private static lessonator_driver mainDriver;
	private lessonator2000.SessionCatalog sessionCatalog;
	private  lessonator2000.Registration registry ;
	private  lessonator2000.Location locationregistry;
	private  lessonator2000.Offerings offers;
	

	//implement main as a singleton
	private lessonator_driver() {

		registry  = lessonator2000.Registration.getRegistry();
		locationregistry = lessonator2000.Location.getLocationRegistry();
		offers = lessonator2000.Offerings.getOfferings();
		sessionCatalog = lessonator2000.SessionCatalog.getSessionCatalog();
		
		
	
	}
	public static lessonator_driver getDriver() {
			if(mainDriver == null) {
				mainDriver = new lessonator_driver();
				}
				return mainDriver;	
			}

	public void startSystem() {
		
			//start a new session to begin with
			
		 sessionCatalog.createNewSession();
			 sessionCatalog.createNewSession();
			
			System.out.println("waiting for a new session to start");
			}
	
	
	public static void main(String[] args) {
		   lessonator_driver driver = lessonator_driver.getDriver();
		mainDriver.startSystem();

}

}
