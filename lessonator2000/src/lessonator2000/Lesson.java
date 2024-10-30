package lessonator2000;

import java.time.LocalDate;

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


    public Lesson(String type, String id, boolean hasInstructor, boolean isAvailable, LocalDate startDate, LocalDate endDate , String weekDay){
        this.type = type;
        this.lessonId = id;
        this.hasInstructor = hasInstructor;
        this.isAvailable = isAvailable;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dayOfTheWeek = weekDay;

    }

    public void addInstructorToLesson(lessonator2000.Instructor ins){
        this.teacher = ins;
    }

    public String toString(){
        return "the lesson ID : " + lessonId + "\n The"  +  space.getTypeOfSpace() + " " + space.getroomNumber() + " , in " + space.getCity() + " , is available for " + type + " on "+ dayOfTheWeek + " From " + time.getStartTime() + " to " + time.getEndTime() + ", from" + startDate.getMonthValue() + " " + startDate.getDayOfYear() + "to " + endDate.getMonthValue() + " " + endDate.getDayOfYear()+ ",  " + endDate.getYear();
        		//" with " + teacher.getFirstName() + " " + teacher.getLastName();       
    }
    
   //Getters
    public String getID() {
    	return this.lessonId;
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

