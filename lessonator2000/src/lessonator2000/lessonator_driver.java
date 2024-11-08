package lessonator2000;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * This class is the entry point of our system. User sessions threads are created here 
 *
 */
public class lessonator_driver {

	private static lessonator_driver mainDriver = null;
	private lessonator2000.SessionCatalog sessionCatalog;
	private  lessonator2000.Registration registry ;
	private  lessonator2000.Location locationregistry;
	private  lessonator2000.Offerings offers;
	

	/**
	 * Private constructor for the main driver since it is implemented as a singleton
	 */
	private lessonator_driver() {

		registry  = lessonator2000.Registration.getRegistry();
		locationregistry = lessonator2000.Location.getLocationRegistry();
		offers = lessonator2000.Offerings.getOfferings();
		sessionCatalog = lessonator2000.SessionCatalog.getSessionCatalog();
	}
	
	/**
	 * getDriver returns the driver singleton if it exist or creates it if it doesnt.
	 * @return
	 */
	public static lessonator_driver getDriver() {
			if(mainDriver == null) {
				mainDriver = new lessonator_driver();
				}
				return mainDriver;	
			}
	/**
	 * start system method created the new user sessions
	 */
	private void startSystem() {
		
			//start a new session to begin with
			createNewSession();
			
		
			}
	/**
	 * Public createNewSession delegates the creation of the newSesison thread to SesisonCatalog. The session thread is added to the catalog
	 * 
	 */
	public void createNewSession() {
        sessionCatalog.createNewSession(); 
      
    }
	
	/**
	 * Main method for our system
	 * @param args
	 */
	public static void main(String[] args) {
		   lessonator_driver driver = lessonator_driver.getDriver();
		driver.startSystem();

}

}
