package lessonator2000;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.time.Duration;

/**
 * 
 * Class Timeslot.
 *
 * <p>Timeslot objects have a start Time, end Time lessonduration and a lesson. 
 * Timeslots are placed in Days associated with the schedual of a specific space.
 * The list of timeslots for a particular day represent the schedual for that day.
 * The Timeslots class encapsulates properties that define the temporal aspects of a lesson</p>
 */
@Entity
@Table(name = "Timeslot")
public class Timeslot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalTime startTime;
	private LocalTime endTime;
	private Duration lessonduration;
	@OneToOne
	private lessonator2000.Lesson timedLesson;

	@ManyToOne
	private lessonator2000.Day day;
	
	public Timeslot(LocalTime start, LocalTime end, lessonator2000.Lesson l) {
		this.startTime = start;
		this.endTime = end;
		timedLesson = l;
		lessonduration = Duration.between(start,end);
		day = null;

}
	public Timeslot(){}
	public LocalTime getStartTime() {
		return this.startTime;
	}
	
	public LocalTime getEndTime() {
		return this.endTime;
	}
	
	public lessonator2000.Lesson getLesson() {
		return this.timedLesson;
	}

	public lessonator2000.Day getDay() {
		return day;
	}

	public void setDay(lessonator2000.Day day) {
		this.day = day;
	}

	public void setTimedLesson(lessonator2000.Lesson l){
		this.timedLesson = l;
	}
}