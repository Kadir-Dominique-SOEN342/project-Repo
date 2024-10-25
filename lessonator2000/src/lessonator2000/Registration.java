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
		System.out.println("1- Client or underageClient");
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
		
		System.out.println("---------------------------------------------------");
		System.out.println("-----------------Registration----------------------");
		System.out.println("---------------------------------------------------");
		System.out.println("1. I don't want to register");
		System.out.println("2. Client");
		System.out.println("3. Underage Client");
		System.out.println("4. Instructor");
		 System.out.println("Please enter a number between 1 and 4");
		 
		userChoice = keyboard.nextInt();
	   
	   
	} while (!(userChoice >=1) || !(userChoice <= 4));
	
	if(userChoice == 1) {
		System.out.println("Thank you, keep Browsing as public.");
		Public p  = new Public();
		return p;
	}
	
	else if (userChoice == 2) {
		Client c =getRegistry().createClient(); // create the Client and return it to the driver
		if(c != null) { //Registration successful
			return c;
		}
		return null; // Registration fail
		
		
	}
	
	else if (userChoice == 3) {
		
		UnderageClient uc = getRegistry().createUnderageClient();   // create the underageClient and return it to the driver
		if(uc != null) {  //Registration successful
			return uc;
		}
		return null;  // Registration fail
	}
	
	else if(userChoice == 4) {
		return  getRegistry().createInstructor();   // create the Instructor and return it to the driver
	
	}
	else return null;
	
}


private static Boolean underageCheck(LocalDate birth) {

	Scanner keyboard = new Scanner(System.in);
	 int userChoice;
	System.out.println();
	LocalDate today = LocalDate.now();
	if((today.getYear() - birth.getYear() )< 18) {
	return true;  // return true if underage
	}
	else return false; // return false if adult
	
	
	
	
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
private  Client createClient() {
	Scanner keyboard = new Scanner(System.in);
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
			
			Boolean isUnderage = underageCheck(birth);
			
			if(!isUnderage) {
			System.out.println("\n What is your username");
			String username = keyboard.next();
			System.out.println("\n What is your password");
			String password = keyboard.next();
			Client c = new Client(firstn, lastn, birth, username, password);  //create new client
			getRegistry().clientRegistry.add(c);//add client to Clientregistry
			System.out.println("Successfull registration, you can now browser as Client");
			return c;
			}
			else{
				System.out.println("Failed registration. You need to register as an underage client. Make sure you create an adult client first.");
				return null;} // Registraiton failed
}

private UnderageClient createUnderageClient() {
	
	Scanner keyboard = new Scanner(System.in);
	//TODO: Need to not assume perfect user. 
	System.out.println("What is the username of your parent?");
	String parentUsername = keyboard.next();							
	Client parent  = getRegistry().searchClient(parentUsername);  // find the parent Client
	if(parent == null){
		System.out.println("Please go back and create a parent client, this username was not found"); 
	return null;}
		
	
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
	System.out.println("\n What is your username");
	String username = keyboard.next();
	System.out.println("\n What is your password");
	String password = keyboard.next();
	
	
	Boolean isUnderage = underageCheck(birth);
	
	if(isUnderage) {
	UnderageClient uc = new UnderageClient(firstn, lastn, birth, username, password,parent);  //create new underageClient
	parent.addToDependantsCatalog(uc);    // add the underageClient to the parent's dependant catalog
	getRegistry().clientRegistry.add(uc); //add underageclient to client's catalog 
	System.out.println("Successfull registration, you can now browser as an underage Client. To book a lesson, ask your parent");
	return uc;}
	else {
		System.out.println("Failed registration. You need to register as a Client.");
		return null;} // Registraiton failed
	}
	

private Instructor createInstructor() {
	Scanner keyboard = new Scanner(System.in);
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


}
