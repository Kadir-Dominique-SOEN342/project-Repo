package lessonator2000;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class PrivateLesson extends lessonator2000.Lesson{
	/**
	 * Constructor , calls the super constructor Lesson
	 * @param type
	 * @param lessonId
	 * @param hasInstructor
	 * @param isAvailable
	 * @param start
	 * @param end
	 * @param weekDay
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	public PrivateLesson(  String type, String lessonId,Boolean hasInstructor, Boolean isAvailable, LocalDate start, LocalDate end, String weekDay){
    	super(type, lessonId, hasInstructor, isAvailable, start, end, weekDay);
	}


}