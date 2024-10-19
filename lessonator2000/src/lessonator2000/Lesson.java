package lessonator2000;

public class Lesson {

    private String type;
    private String lessonId;
    private boolean hasInstructor;
    private boolean isAvailable;
    private Instructor teacher;
    private Space space;
    private Timeslot time;

    public Lesson(String type, String id, boolean hasInstructor, boolean isAvailable){
        this.type = type;
        this.lessonId = id;
        this.hasInstructor = hasInstructor;
        this.isAvailable = isAvailable;

    }

    public void addInstructorToLesson(Instructor ins){
        this.teacher = ins;
    }

    public String toString(){
        return "the lesson ID : " + lessonId + " "  +  space.getTypeOfSpace() + " " + space.getroomNumber() + " , in " + space.getCity() + " , is available for " + type + " From " + time.getStartTime() + " to " + time.getEndTime() ;
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
    
    public Instructor getInstructor() {
    	return this.teacher;
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
    
    public void setTeacher(Instructor ins) {
    	this.teacher = ins;
    }

	public void setSpace(Space mySpace) {
		this.space = mySpace;
		
	}
	public void setTime(Timeslot time) {
		this.time = time;
		
	}
   
   
    }

