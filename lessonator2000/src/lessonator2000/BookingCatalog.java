package lessonator2000;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingCatalog {

    private ArrayList<lessonator2000.Bookings> bookingCatalog;

    public BookingCatalog() {
        bookingCatalog = new ArrayList<lessonator2000.Bookings>();
    }

    public void addBooking(lessonator2000.Lesson l, lessonator2000.Client cl) {
        lessonator2000.Bookings b = new lessonator2000.Bookings(l, cl);
        bookingCatalog.add(b);
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
        this.bookingCatalog = bookingCatalog;
    }

    public ArrayList<lessonator2000.Bookings> getBookingCatalog() {
        return bookingCatalog;
    }

    //Just a method I wrote to test makeBooking
    public void showBookings() {
        for (lessonator2000.Bookings b : bookingCatalog) {
            System.out.println(b.toString());
        }
    }
}