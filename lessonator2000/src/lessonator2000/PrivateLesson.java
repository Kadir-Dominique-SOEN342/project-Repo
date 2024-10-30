package lessonator2000;

import java.time.LocalDate;

public class PrivateLesson extends lessonator2000.Lesson{
	
	public PrivateLesson(  String type, String lessonId,Boolean hasInstructor, Boolean isAvailable, LocalDate start, LocalDate end, String weekDay){
    	super(type, lessonId, hasInstructor, isAvailable, start, end, weekDay);
	}


}