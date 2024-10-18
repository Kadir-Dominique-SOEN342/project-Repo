package lessonator2000;

public class Lesson {

    private String type;
    private String lessonId;
    private boolean hasInstructor;
    private boolean isAvailable;
    private Instructor teacher;

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
        return (this.type + " class with " + teacher.getFirstName + " " + teacher.getLastName);
    }

}