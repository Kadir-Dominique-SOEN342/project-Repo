package lessonator2000;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 * Class Registration.
 *
 * <p>This class holds all the registries for Client and instructors and takes care of the login, logout , register functionalities</p>

 */
public class Registration {

	//Registrator holds the registries for the organisation
	private ArrayList<lessonator2000.Client> clientRegistry = new ArrayList<lessonator2000.Client>();
	private ArrayList<lessonator2000.Instructor> instructorRegistry = new ArrayList<lessonator2000.Instructor>();
	private lessonator2000.Administrator myAdmin = lessonator2000.Administrator.getAdministrator();
	private static Registration registry = null;


	/**
	 * Registration is implemented as a singleton
	 * private constructor
	 */
	private  Registration() {
		// Remove this after persistance is achieved through the database is completed. These are hardcoded clients/ instructors
		lessonator2000.Client e = new lessonator2000.Client("Bernard", "Summer",LocalDate.of(1956, 01, 4), "bsum" , "neworder");
		clientRegistry.add(e);
		lessonator2000.Client f = new lessonator2000.Client("Steven", "Morris",LocalDate.of(1957, 10, 28), "smor" , "neworder");
		clientRegistry.add(f);
		lessonator2000.Client g = new lessonator2000.Client("Peter", "Hook",LocalDate.of(1956, 02, 13), "phoo" , "neworder");
		clientRegistry.add(g);
		lessonator2000.Client h = new lessonator2000.Client("Gillian", "Gilbert",LocalDate.of(1961, 01, 27), "ggil" , "neworder");
		clientRegistry.add(h);


		lessonator2000.Instructor a = new lessonator2000.Instructor("Aerobie", "Julie", "Samson", 5148659658L);
		instructorRegistry.add(a);
		lessonator2000.Instructor b = new lessonator2000.Instructor("Sumo", "Ura", "Kazuki", 5148659658L);
		instructorRegistry.add(b);
		lessonator2000.Instructor c = new lessonator2000.Instructor("Judo", "Hajime", "Isogai", 5148659658L);
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

	/**
	 * captures user input on the type of user they want to login as and their credentials
	 * returns a client , instructor or administrator if it is found in the registry
	 * @return
	 */
	public lessonator2000.User login() {

		Scanner keyboard = new Scanner(System.in);


		System.out.println("Hello There, are you a :");
		System.out.println("1- Client or underageClient");
		System.out.println("2- Instructor");
		System.out.println("3- Administrator");
		System.out.println("4 - I want to keep browsing without logging in ");

		int userChoice = 0;
		boolean valid = false;
		while (!valid) {
			try { userChoice = keyboard.nextInt();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid int");
				keyboard.nextLine();
			}
		}

		//Returns a client if it's found, returns a public if not
		if(userChoice == 1) {
			System.out.println("What is your username");
			String username = null;
			valid = false;
			while (!valid) {
				try { username =  keyboard.next();
				keyboard.nextLine();
				valid = true;}
				catch (java.util.InputMismatchException e) {
					System.out.println("Please enter a valid String");
				}
			}
			lessonator2000.Client myClient = registry.searchClient(username);
			if(myClient == null ) {
	System.out.println("You are not registered, you will browse as public for now until you do.");
	return new lessonator2000.Public();

}
			System.out.println("What is your password ? ");
			String password = null;
			valid = false;
			while (!valid) {
				try { password =  keyboard.next();
				keyboard.nextLine();
				valid = true;}
				catch (java.util.InputMismatchException e) {
					System.out.println("Please enter a valid String");
				}
			}
			if(password.equals(myClient.getPassword())) {
				System.out.println("You are logged in" + username);
				return myClient;}
			
			else {System.out.println("Wrong password, try again");
			}
			
			


		}

		//Returns an instructor if it's found, returns a public if not
		if(userChoice == 2) {
			System.out.println("What is your phoneNumber");
			long phoneNumber = 000000;
			valid = false;
			while (!valid) {
				try { phoneNumber  = keyboard.nextLong();
				valid = true;}
				catch (java.util.InputMismatchException e) {
					System.out.println("Please enter a valid Long");
				}
			}




			lessonator2000.Instructor myInstructor = registry.searchInstructor(phoneNumber);

			if(myInstructor == null ) {
				System.out.println("You are not registered, you will browse as public for now until you do.");
				return new lessonator2000.Public();
			}
			else {  System.out.println("You are now logged in " + myInstructor.getFirstName());
			return myInstructor;}
		}

		//Returns the admin if it's found, returns a public if not
		if(userChoice == 3) {
			System.out.println("username");
			String userName = null;
			valid = false;
			while (!valid) {
				try { userName = keyboard.next();
				keyboard.nextLine();
				valid = true;}
				catch (java.util.InputMismatchException e) {
					System.out.println("Please enter a valid String");
				}
			}


			if(registry.myAdmin.getUsername().equals(userName)){
				System.out.println("you are now logged in as admin");
				return registry.myAdmin ; 
			}

			else {
				System.out.println("wrong username, you will browse as public for now .");
				return new lessonator2000.Public();
			}
		}
		return null;
	}


	/**
	 * This method let's you create a new user or returns a User of type public to keep browsing without registering.
	 *
	 * @return a User
	 */
	public   lessonator2000.User register() {

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
			lessonator2000.Public p  = new lessonator2000.Public();
			return p;
		}

		else if (userChoice == 2) {
			
				lessonator2000.Client c =getRegistry().createClient(); // create the Client and return it to the driver
				if(c != null) { //Registration successful
					return c;
				}
			return null; // Registration fail


		}

		else if (userChoice == 3) {
			
				lessonator2000.UnderageClient uc = getRegistry().createUnderageClient();   // create the underageClient and return it to the driver
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

/**
 * This method verifies the age of the client ,because underage clients cannot book lessons 
 * @param birth
 * @return
 */
	private static Boolean underageCheck(LocalDate birth) {

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
	private  lessonator2000.Client searchClient(String username) {
		System.out.println("Searching for client with username " + username);
		for(lessonator2000.Client c : clientRegistry) {
			String clientusername = c.getUsername();
			//	System.out.println(clientusername);
			if(clientusername.equals(username))
				return c;
		}
		return null;
	}

	private  lessonator2000.Instructor searchInstructor(long phone) {
		for(lessonator2000.Instructor ins : instructorRegistry) {
			long phoneNumber = ins.getPhone();
			System.out.println(phoneNumber);
			if(phoneNumber == phone)
				return ins;
		}
		return null;
	}
	/**
	 * helper method to create a new client when user registers via register()
	 * will capture user information and then verify the client's age and add it to the Client's registry after creation
	 * @return a client
	 */
	private synchronized  lessonator2000.Client createClient() {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("What is your first name:");
		String firstn = null;
		boolean valid = false;
		while (!valid) {
			try { firstn = keyboard.next();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid String");
			}
		}


		System.out.println("\n What is your last name:");
		String lastn = null;
		valid = false;
		while (!valid) {
			try { lastn = keyboard.next();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid String");
			}
		}

		System.out.println("\n What is your year of birth");
		int year = 0;
		valid = false;
		while (!valid) {
			try { year = keyboard.nextInt();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid integer");
				keyboard.nextLine();
			}
		}
		System.out.println("\n What is your month of birth");
		int month = 0 ;
		valid = false;
		while (!valid) {
			try { month = keyboard.nextInt();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid integer");
				keyboard.nextLine();
			}
		}

		System.out.println("\n What is your day of birth");
		int day = 0;
		valid = false;
		while (!valid) {
			try { day = keyboard.nextInt();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid int");
				keyboard.nextLine();
			}
		}


		LocalDate birth = null;
		try{birth = LocalDate.of(year, month, day);}
		catch(java.time.DateTimeException e) {
			System.out.println("This was not a valid birthdate, please start over");
			return null;
			
		}

		Boolean isUnderage = underageCheck(birth);

		if(!isUnderage) {
			System.out.println("\n What is your username");
			String username = keyboard.next();
			valid = false;
			while (!valid) {
				try { username = keyboard.next();
				valid = true;}
				catch (java.util.InputMismatchException e) {
					System.out.println("Please enter a valid String");
				}
			}
			System.out.println("\n What is your password");
			String password = keyboard.next();
			valid = false;
			while (!valid) {
				try { password = keyboard.next();
				valid = true;}
				catch (java.util.InputMismatchException e) {
					System.out.println("Please enter a valid String");
				}
			}

			lessonator2000.Client c = new lessonator2000.Client(firstn, lastn, birth, username, password);  //create new client
			getRegistry().clientRegistry.add(c);//add client to Clientregistry
			System.out.println("Successfull registration, you can now browser as Client");
			return c;
		}
		else{
			System.out.println("Failed registration. You need to register as an underage client. Make sure you create an adult client first.");
			return null;} // Registraiton failed
	}

	/**
	 * helper method to create an underageClient when user registers via register()
	 * captures user input, verifies age and then creates the client and adds it to the client registry
	 * @return
	 */
	private synchronized lessonator2000.UnderageClient createUnderageClient() {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("What is the username of your parent?");
		String parentUsername = null;
		boolean valid = false;
		while (!valid) {
			try { parentUsername = keyboard.next();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid String");
			}
		}
		System.out.println("Searching for parent username " + parentUsername);
		lessonator2000.Client parent  = getRegistry().searchClient(parentUsername);  // find the parent Client
		if(parent == null){
			System.out.println("Please go back and create a parent client, this username was not found"); 
			return null;}


		System.out.println("What is your first name:");
		String firstn = keyboard.next();
		valid = false;
		while (!valid) {
			try { firstn = keyboard.next();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid String");
			}
		}
		System.out.println("\n What is your last name:");
		String lastn = keyboard.next();
		valid = false;
		while (!valid) {
			try { lastn = keyboard.next();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid String");
			}
		}
		System.out.println("\n What is your year of birth");
		int year = 0;
		valid = false;
		while (!valid) {
			try { year = keyboard.nextInt();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid integer");
				keyboard.nextLine();
			}
		}
		System.out.println("\n What is your month of birth");
		int month = 0 ;
		valid = false;
		while (!valid) {
			try { month = keyboard.nextInt();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid integer");
				keyboard.nextLine();
				
			}
			
		}
		System.out.println("\n What is your day of birth");
		int day =0 ;
		valid = false;
		while (!valid) {
			try { day = keyboard.nextInt();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid integer");
				keyboard.nextLine();
				
			}
		}
		LocalDate birth = null;
		try{birth = LocalDate.of(year, month, day);}
		catch(java.time.DateTimeException e) {
			System.out.println("This was not a valid birthdate, please start over");
			return null;
			
		}
		
		
		System.out.println("\n What is your username");
		String username = null;
		valid = false;
		while (!valid) {
			try { username = keyboard.next();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid String");
			}
		}
		System.out.println("\n What is your password");
		String password = null;
		valid = false;
		while (!valid) {
			try { password = keyboard.next();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid String");
			}
		}


		Boolean isUnderage = underageCheck(birth);

		if(isUnderage) {
			lessonator2000.UnderageClient uc = new lessonator2000.UnderageClient(firstn, lastn, birth, username, password,parent);  //create new underageClient
			parent.addToDependantsCatalog(uc);    // add the underageClient to the parent's dependant catalog
			getRegistry().clientRegistry.add(uc); //add underageclient to client's catalog 
			System.out.println("Successfull registration, you can now browser as an underage Client. To book a lesson, ask your parent");
			return uc;}
		else {
			System.out.println("Failed registration. You need to register as a Client.");
			return null;} // Registraiton failed
	}

/**
 * helper method for when a user wants to register as an instructor.
 * will capture user input for the credentals and then create an instrcutor and add it to the instructor registry
 * @return
 */
	private synchronized lessonator2000.Instructor createInstructor() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is your specialization:");
		String specialization =null;
		boolean valid = false;
		while (!valid) {
			try { specialization = keyboard.next();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid String");
			}
		}
		System.out.println("What is your first name:");
		String firstn =null;
		valid = false;
		while (!valid) {
			try { firstn = keyboard.next();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid String");
			}
		}
		System.out.println("\n What is your last name:");
		String lastn =null;
		valid = false;
		while (!valid) {
			try { lastn = keyboard.next();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid String");
			}
		}
		System.out.println("What is your phoneNumber");
		long phone = 0 ;
		valid = false;
		while (!valid) {
			try { phone = keyboard.nextLong();
			valid = true;}
			catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid long");
			}
		}

		lessonator2000.Instructor i = new lessonator2000.Instructor(specialization, firstn, lastn, phone);
		return i;

	}


}
