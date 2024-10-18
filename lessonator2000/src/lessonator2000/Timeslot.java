package lessonator2000;

import java.time.LocalTime;
import java.time.Duration;

public class Timeslot {
	
	private LocalTime startTime;
	private LocalTime endTime;
	private Duration lessonduration;
	private Lesson timedLesson;
	
	public Timeslot(LocalTime start, LocalTime end, Lesson lesson) {
		this.startTime = start;
		this.endTime = end;
		this.timedLesson = lesson;
		lessonduration = Duration.between(start,end);

}
}