package lessonator2000;

import jakarta.persistence.*;

@Entity
@Table(name = "Bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int bookingId;


    @OneToOne
    private lessonator2000.Lesson bookinglesson;
   @OneToOne
    private lessonator2000.Client bookingclient;

    public Bookings(){
        bookingId = 0;
        bookingclient = null;
        bookinglesson = null;

    }

    public Bookings(lessonator2000.Lesson l, lessonator2000.Client cl){
        this.bookingId = id++;
        this.bookinglesson = l;
        this.bookingclient = cl;
    }

    public lessonator2000.Lesson getBookinglesson() {
        return bookinglesson;
    }

    public lessonator2000.Client getBookingclient() {
        return bookingclient;
    }

    
    public int getBookingId() {
    	return this.bookingId;
    }
    public void setBookingclient(lessonator2000.Client bookingclient) {
        this.bookingclient = bookingclient;
    }

    public void setBookinglesson(lessonator2000.Lesson bookinglesson) {
        this.bookinglesson = bookinglesson;
    }

    public String toString(){
        return ("The id of the booking is : "+ getBookingId() + "\nthe client is : " + bookingclient.toString() + "\nthe lesson id is:  " + bookinglesson.getID());
    }
}