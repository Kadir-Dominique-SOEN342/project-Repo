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
		// Remove this after persistance is achieved through the database is completed. These are hardcoded clients/ instructors
		Client e = new Client("Bernard", "Summer",LocalDate.of(1956, 01, 4), "bsum" , "neworder");
		clientRegistry.add(e);
		Client f = new Client("Steven", "Morris",LocalDate.of(1957, 10, 28), "smor" , "neworder");
		clientRegistry.add(f);
		Client g = new Client("Peter", "Hook",LocalDate.of(1956, 02, 13), "phoo" , "neworder");
		clientRegistry.add(g);
		Client h = new Client("Gillian", "Gilbert",LocalDate.of(1961, 01, 27), "ggil" , "neworder");
		clientRegistry.add(h);
		
		
		Instructor a = new Instructor("Aerobie", "Julie", "Samson", 5148659658L);
		instructorRegistry.add(a);
		Instructor b = new Instructor("Sumo", "Ura", "Kazuki", 5148659658L);
		instructorRegistry.add(b);
		Instructor c = new Instructor("Judo", "Hajime", "Isogai", 5148659658L);
		instructorRegistry.add(c);
		
		
		
		//
		
		
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
	
	public static User login() {

		Scanner keyboard = new Scanner(System.in);


		System.out.println("Hello There, are you a :");
		System.out.println("1- Client");
		System.out.println("2- Instructor");
		System.out.println("3- Administrator");
		System.out.println("4 - I want to keep browsing without logging in ");


		//TODO: Need to not assume perfect user. 
		int userChoice = keyboard.nextInt();


		//Returns a client if it's found, returns a public if not
		if(userChoice == 1) {
			System.out.println("What is your username");
			String username = keyboard.next();
			Client myClient = registry.searchClient(username);

			if(myClient == null ) {
				System.out.println("You are not registered, you will browse as public for now until you do.");
				return new Public();
			}
			else {System.out.println("You are logged in" + username); 
			return myClient;
			}
			
		}

		//Returns an instructor if it's found, returns a public if not
		if(userChoice == 2) {
			System.out.println("What is your phoneNumber");
			long phoneNumber = keyboard.nextLong();
			Instructor myInstructor = registry.searchInstructor(phoneNumber);

			if(myInstructor == null ) {
				System.out.println("You are not registered, you will browse as public for now until you do.");
				return new Public();
			}
			else {  System.out.println("You are now logged in " + myInstructor.getFirstName());
			return myInstructor;}
		}

		//Returns the admin if it's found, returns a public if not
		if(userChoice == 3) {
			System.out.println("username");
			String userName = keyboard.next();

			if(registry.myAdmin.getUsername().equals(userName)){
				System.out.println("you are now logged in as admin");
				return registry.myAdmin ; 
			}

			else {
				System.out.println("wrong username, you will browse as public for now .");
				return new Public();
			}
		}
return null;
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
		underageClient uc = new underageClient(null,null,null,null,null, null); 	//TODO: fix the arguments.	
		return uc;
	}
	
	else if(userChoice == 4) {
		
		//TODO: Need to not assume perfect user. 
		System.out.println("What is your specialization:");
		String specialization = keyboard.next();
				System.out.println("What is your first name:");
				String firstn = keyboard.next();
				System.out.println("\n What is your last name:");
				String lastn = keyboard.next();
				System.out.println("What is your phoneNumber");
				long phone = keyboard.nextInt();
		
		Instructor i = new Instructor(specialization, firstn, lastn, phone); 
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
		
		
	System.out.println("What is the parent's username"); 
	String parentUserName = keyboard.next();
	try {
		//Client parent = searchClient(parentUserName);      //TODO : YOU ARE HERE.
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		//TODO: find client in the registry. Add newly created underage client to the client's dependant's catalog.
		
	}
	
	
	
	
}
/**
 * 
 * @param username
 * @return the client object if found. returns null if not found.
 */
private  Client searchClient(String username) {
 for(Client c : clientRegistry) {
	String clientusername = c.getUsername();
//	System.out.println(clientusername);
	 if(clientusername.equals(username))
		 return c;
	 }
 return null;
 }

private  Instructor searchInstructor(long phone) {
	 for(Instructor ins : instructorRegistry) {
		long phoneNumber = ins.getPhone();
		System.out.println(phoneNumber);
		 if(phoneNumber == phone)
			 return ins;
		 }
	 return null;
	 }

}
