package lessonator2000;

public class PublicLesson extends Lesson {

    private int capacity;
    private int participants;

    public PublicLesson(int capacity, String lessonId, String type, Boolean hasInstructor, Boolean isAvailable){
    	super(type, lessonId, hasInstructor, isAvailable);
        this.capacity = capacity;
        this.participants = 0;
    }

    public void updateParticipants(){
        this.participants++;
    }
}