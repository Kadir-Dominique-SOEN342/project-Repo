package lessonator2000;

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
public class Timeslot {
	
	private LocalTime startTime;
	private LocalTime endTime;
	private Duration lessonduration;
	private lessonator2000.Lesson timedLesson;
	
	public Timeslot(LocalTime start, LocalTime end, lessonator2000.Lesson lesson) {
		this.startTime = start;
		this.endTime = end;
		this.timedLesson = lesson;
		lessonduration = Duration.between(start,end);

}
	
	public LocalTime getStartTime() {
		return this.startTime;
	}
	
	public LocalTime getEndTime() {
		return this.endTime;
	}
	
	public lessonator2000.Lesson getLesson() {
		return this.timedLesson;
	}
}