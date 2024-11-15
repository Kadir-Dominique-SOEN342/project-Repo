package lessonator2000;

import java.time.LocalDate;

/**
 * 
 * Class Lesson.
 *
 * <p>Lesson is the class that contains all the offering information , the instructors , the space it's offered in , the timeSlot it takes and all the accompanying methods.</p>
 * 
 */
public class Lesson {


    private String type;
    private String lessonId;
    private boolean hasInstructor;
    private boolean isAvailable;
    private lessonator2000.Instructor teacher;
    private lessonator2000.Space space;
    private lessonator2000.Timeslot time;
   private LocalDate startDate;
    private LocalDate endDate;
  private String dayOfTheWeek;

/**
 * Constructor for the lesson , there are no defualt constructors because to exist, these LEssons need all these attributes explicitely given
 * @param type
 * @param id
 * @param hasInstructor
 * @param isAvailable
 * @param startDate
 * @param endDate
 * @param weekDay
 */
    public Lesson(String type, String id, boolean hasInstructor, boolean isAvailable, LocalDate startDate, LocalDate endDate , String weekDay){
        this.type = type;
        this.lessonId = id;
        this.hasInstructor = hasInstructor;
        this.isAvailable = isAvailable;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dayOfTheWeek = weekDay;

    }

    /**
     * This is the method used by signupToLesson() to add the instructor to the Lesson
     * @param ins
     */
     void addInstructorToLesson(lessonator2000.Instructor ins){
        this.teacher = ins;
    }

     /**
      * shows all the lesson information and annotaiton is it's not available.
      */
    public String toString(){

        return "the lesson ID : " + lessonId + "\n " +  (!isAvailable ? "UNAVAILABLE " : "")+ "The"  +  space.getTypeOfSpace() + " " + space.getroomNumber() + " , in " + 
        space.getCity() + " , is available for " + type + " on "+ dayOfTheWeek + 
        		" From " + time.getStartTime() + " to " + time.getEndTime() + ", from " + startDate.getMonth() + " " + startDate.getDayOfMonth() + " to " + endDate.getMonth()+ " " + endDate.getDayOfMonth() +",  " + endDate.getYear();
        		//" with " + teacher.getFirstName() + " " + teacher.getLastName();       
    }
    
   //Getters
    public String getID() {
    	return this.lessonId;
    }
    public Space getSpace() {
    	return this.space;
    }
    public Instructor getTeacher() {
    	return this.teacher;
    }
    public Timeslot getTimeSlot() {
    	return this.time;
    }
    
    public String getype() {
    	return this.type;
    }
    public Boolean getHasInstructor() {
    	return this.hasInstructor;
    }
    public Boolean getisAvailable() {
    	return this.isAvailable;
    }
    
    public lessonator2000.Instructor getInstructor() {
    	return this.teacher;
    }
    public LocalDate getStartDatE() {
    	return startDate;
    }
    public LocalDate getEndDate() {
    	return endDate;
    }
    public String getDayOfTheWeek() {
    	return dayOfTheWeek;
    }
    
    //Setters
    public void setType(String type) {
    	this.type = type;
    }
    
    public void setlessonID(String id) {
    	this.lessonId = id;
    }
    
    public void sethasInstructor(Boolean hasIns) {
    	this.hasInstructor = hasIns;
    }
    
    public void setisAvailable(Boolean isAvail) {
    	this.isAvailable = isAvail;
    	
    }
    
    public void setTeacher(lessonator2000.Instructor ins) {
    	this.teacher = ins;
    }

	public void setSpace(lessonator2000.Space mySpace) {
		this.space = mySpace;
		
	}
	public void setTime(lessonator2000.Timeslot time) {
		this.time = time;
		
	}
	public void setStartDate(LocalDate start) {
		this.startDate = start;
	}
   public  void setEndDate(LocalDate end) {
	   this.endDate = end;
   }
   public void setDayOfTheWeek(String day) {
	   this.dayOfTheWeek = day;
   }
    }

