package lessonator2000;

import java.time.LocalDate;

public class PublicLesson extends lessonator2000.Lesson {

    private int capacity;
    private int participants;

    public PublicLesson(int capacity, String type,String lessonId,  Boolean hasInstructor, Boolean isAvailable, LocalDate start, LocalDate end, String weekDay){
    	super(type, lessonId, hasInstructor, isAvailable, start, end ,weekDay);
        this.capacity = capacity;
        this.participants = 0;
    }

    /**
     * used when a booking is made, the number of participants is increased. 
     */
     void updateParticipants(){
        this.participants++;
    }

    /**
     * sets the capacity
     * @param cap
     */
    public void setCapacity(int cap){
        this.capacity = cap;
    }

    /**
     * get the capacity 
     * @return
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * get the numbe rof participants
     * @return
     */
    public int getParticipants(){
        return this.participants;
    }


}