package lessonator2000;

import java.time.LocalTime;
import java.time.Duration;

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
		return this.startTime;
	}
	
	public Lesson getLesson() {
		return this.timedLesson;
	}
}