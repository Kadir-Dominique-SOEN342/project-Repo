package lessonator2000;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingCatalog {
	private static BookingCatalog bookingCatalog = null;
	private ArrayList<lessonator2000.Bookings> bookings;

	//implemented as singleton
	private BookingCatalog() {
		
		bookings = new ArrayList<lessonator2000.Bookings>();
	}
	
	//returns the single instance of BookingCatalog if its not null, if it is , it creates it and then returns it
	public static lessonator2000.BookingCatalog getBookingCatalog(){
		if(bookingCatalog == null) {
			bookingCatalog = new lessonator2000.BookingCatalog();
		}  return bookingCatalog;	
	}

	public void addBooking(lessonator2000.Lesson l, lessonator2000.Client cl) {
		lessonator2000.Bookings b = new lessonator2000.Bookings(l, cl); 
		bookings.add(b);
	}

	public lessonator2000.UnderageClient underageBooking(lessonator2000.Client cl) {
		Scanner sc = new Scanner(System.in);
		cl.viewDependants();
		System.out.println("Please enter the username of the dependant you want to book: ");
		String choice = sc.next();
		lessonator2000.UnderageClient uc = cl.findDependant(choice);
		return uc;

	}

	public void setBookingCatalog(ArrayList<lessonator2000.Bookings> bookingCatalog) {
		this.bookings = bookingCatalog;
	}


	//Just a method I wrote to test makeBooking
	public void viewBooking(User user) {
		if(user instanceof lessonator2000.Administrator) {			
			adminViewVooking();
			}
		else if (user instanceof lessonator2000.Client) {
			clientViewVooking((lessonator2000.Client)user);
		}
		}
	

	
	
	public void adminViewVooking() {
		
			for (lessonator2000.Bookings b : bookings) {
				System.out.println(b.toString());
			}
	}
	
	
	public void clientViewVooking(Client client) {
		
			for (lessonator2000.Bookings b : bookings) {
				Client c  = b.getBookingclient();
				if(c == client) {
					System.out.println(b.toString());
					
				}
			}
	}
	
	
	public void cancelBooking(int id) {

		lessonator2000.Bookings bookingToRemove = null; 
		for( lessonator2000.Bookings b : bookings) {
			if (b.getBookingId() == id) {
				bookingToRemove = b;	    				
			}}
			if(bookingToRemove != null) {
				bookings.remove(bookingToRemove);
				System.out.println("the Booking of " + bookingToRemove.getBookingclient().getUsername() + " for " + bookingToRemove.getBookinglesson().getID()+ " has been removed.");
			}
			else {System.out.println("Sorry this booking id was not found");}

		

	}
}