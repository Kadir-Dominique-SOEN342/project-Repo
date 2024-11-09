package lessonator2000;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * Class BookingCatalog.
 *
 * <p>This class holds the collection of Bookinds and it the expert on creating Bookig objects
 * it is implemented as a singleton</p>
 */
public class BookingCatalog {
	private static BookingCatalog bookingCatalog = null;
	private ArrayList<lessonator2000.Booking> bookings;

	//implemented as singleton
	/**
	 * The constructor of BookingCatalog is private since it's implemtned as a singleton
	 */
	private BookingCatalog() {
		
		bookings = new ArrayList<lessonator2000.Booking>();
	}
	
	//returns the single instance of BookingCatalog if its not null, if it is , it creates it and then returns it
	/**
	 * Returns the single instance of BookingCatalog
	 * @return
	 */
	public static lessonator2000.BookingCatalog getBookingCatalog(){
		if(bookingCatalog == null) {
			bookingCatalog = new lessonator2000.BookingCatalog();
		}  return bookingCatalog;	
	}

	/**
	 * 
	 * This method creates the Booking between an adult client and a lesson and adds it to the BookingCatalog's collection of Booking bookings
	 * @param l
	 * @param cl
	 */
	 synchronized void addBooking(lessonator2000.Lesson l, lessonator2000.Client cl) {
		lessonator2000.Booking b = new lessonator2000.Booking(l, cl); 
		bookings.add(b);
		System.out.println("booking created between " + cl.toString() + "and " + l.toString()  );
	}
/**
 * This method captures User input to specify which dependant of it's dependants it wants to create a booking for. If found , the underageClient object is returned.
 * @param cl the adult client who's dependant catalog will be searched 
 * @return
 */
	public lessonator2000.UnderageClient underageBooking(lessonator2000.Client cl) {
		Scanner sc = new Scanner(System.in);
		cl.viewDependants();
		System.out.println("Please enter the username of the dependant you want to book: ");
		String choice = sc.next();
		lessonator2000.UnderageClient uc = cl.findDependant(choice);
		return uc;

	}
/**
 * setter for bookingCatalog
 * @param bookingCatalog
 */
	public void setBookingCatalog(ArrayList<lessonator2000.Booking> bookingCatalog) {
		this.bookings = bookingCatalog;
	}

	/**
	 * This method allows Clients to view their own bookings or Administrator to view all the bookings
	 * @param user
	 */
	 void viewBooking(User user) {
		if(user instanceof lessonator2000.Administrator) {			
			adminViewVooking();
			}
		else if (user instanceof lessonator2000.Client) {
			clientViewVooking((lessonator2000.Client)user);
		}
		}
	

	
	/**
	 *Prints all the bookings information
	 */
	private void adminViewVooking() {
		
			for (lessonator2000.Booking b : bookings) {
				System.out.println(b.toString());
			}
	}
	
	/**
	 * prints all the bookings the passed Client as attribute.
	 * @param client
	 */
	private void clientViewVooking(Client client) {
		
			for (lessonator2000.Booking b : bookings) {
				Client c  = b.getBookingclient();
				if(c == client) {
					System.out.println(b.toString());
					
				}
			}
	}
	
	/**
	 * cancel Booking is used by Administrator to cancel a booking by it's ID
	 * @param id
	 */
	 synchronized void cancelBooking(int id) {

		lessonator2000.Booking bookingToRemove = null; 
		for( lessonator2000.Booking b : bookings) {
			if (b.getBookingId() == id) {
				bookingToRemove = b;	    				
			}}
			if(bookingToRemove != null) {
				bookings.remove(bookingToRemove);
				System.out.println("the Booking of " + bookingToRemove.getBookingclient().getUsername() + " for " + bookingToRemove.getBookinglesson().getID()+ " has been removed.");
			}
			else {System.out.println("Sorry this booking id was not found");}

		

	}

	 /**
	  * removebooking() is used when a lesosn is removed as part of delteOffering(), if a booking is assocated to the lesosn, it needs to be removed
	  * @param lessonToRemove
	  */
	 void removeBooking(Lesson lessonToRemove) {
		bookings.removeIf(b -> b.getBookinglesson() == lessonToRemove);
		System.out.println("every booking containg the lesson was removed");
		//for(Booking b : bookings) {
		//	if(b.getBookinglesson() == lessonToRemove) {
		//		bookings.remove(bookings.indexOf(lessonToRemove));
		//		
		}
			
		
		
	}
