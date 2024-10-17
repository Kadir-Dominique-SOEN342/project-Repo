package lessonator2000;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Registration {
	
	//Registrator holds the registries for the organisation
	private ArrayList<Client> clientRegistry = new ArrayList<Client>();
	private ArrayList<Instructor> instructorRegistry = new ArrayList<Instructor>();
	private Administrator myAdmin = Administrator.getAdministrator();
	
	private static Registration registry = null;
	//constructor - implemented ad a singleton
	private  Registration() {
	}
	
	
	/**
	 * 
	 * @returns the one and only registry
	 */
	public static Registration getRegistry() {
		if(registry == null) {
			registry = new Registration();
		}
		return registry;
	}
/**
 * 
 * This method let's you create a new user or returns a User of type public to keep browsing without registering.
 * @return a User
 */
public static User register() {
	
	Scanner keyboard = new Scanner(System.in);
	 int userChoice;
	
	do {
		
		System.out.println("What would you like to register as? ");
		System.out.println("1.Keep Browsing public");
		System.out.println("2.Client");
		System.out.println("3.Underage Client");
		System.out.println("4.Instructor");
		 System.out.println("Please enter a number between 1 and 4");
		 
		userChoice = keyboard.nextInt();
	   
	   
	} while (!(userChoice >=1) || !(userChoice <= 4));
	
	if(userChoice == 1) {
		System.out.println("Thank you, keep Browsing.");
		Public p  = new Public();
		return p;
	}
	
	else if (userChoice == 2) {
		//TODO: Need to not assume perfect user. 
		System.out.println("What is your first name:");
		String firstn = keyboard.next();
		System.out.println("\n What is your last name:");
		String lastn = keyboard.next();
		System.out.println("\n What is your year of birth");
		int year = keyboard.nextInt();
		System.out.println("\n What is your month of birth");
		int month = keyboard.nextInt();
		System.out.println("\n What is your day of birth");
		int day = keyboard.nextInt();
		LocalDate birth = LocalDate.of(year, month, day);
		
		underageCheck(birth);
		
		System.out.println("\n What is your username");
		String username = keyboard.next();
		System.out.println("\n What is your password");
		String password = keyboard.next();
		Client c = new Client(firstn, lastn, birth, username, password);		
		return c;
	}
	
	else if (userChoice == 3) {
		// needs to be added to adult
		//needs and adult. 
		underageClient uc = new underageClient(null,null,null,null,null); 	//TODO: fix the arguments.	
		return uc;
	}
	
	else if(userChoice == 4) {
		Instructor i = new Instructor();
		return i;
	}
	else return null;
}


private static void underageCheck(LocalDate birth) {

	Scanner keyboard = new Scanner(System.in);
	 int userChoice;
	System.out.println();
	LocalDate today = LocalDate.now();
	if((today.getYear() - birth.getYear() )< 18) {
		System.out.println("We need to create an underage client. Make sure there is already an adult client registered.");
		
	//TODO : 	System.out.println("What is the parent's username"); 
		// find client in the registry. Add newly created underage client to the client's dependant's catalog.
		
	}
	
	
	
	
}

private void captureDetails() {
	
}
}
