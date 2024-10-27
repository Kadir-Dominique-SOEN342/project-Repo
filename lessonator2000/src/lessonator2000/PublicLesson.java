package lessonator2000;

import java.time.LocalDate;

public class PublicLesson extends Lesson {

    private int capacity;
    private int participants;

    public PublicLesson(int capacity, String type,String lessonId,  Boolean hasInstructor, Boolean isAvailable, LocalDate start, LocalDate end, String weekDay){
    	super(type, lessonId, hasInstructor, isAvailable, start, end ,weekDay);
        this.capacity = capacity;
        this.participants = 0;
    }

    public void updateParticipants(){
        this.participants++;
    }
}