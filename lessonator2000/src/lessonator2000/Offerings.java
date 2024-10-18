package lessonator2000;

public class Offerings{

    private ArrayList<Lesson> lessons;

    //Constructor
    public Offerings(){
        this.lessons = new ArrayList<Lesson>;
    }

    
    public void uploadOffering(String type, String id){
        this.lessons.add(new Lesson(type, id, false, true));
    }

    public void deleteOffering(Lesson lesson){
        Lesson foundLesson = null;
        for(temp : lessons){
            if(temp.getID.equals(lesson.getID()))
                Lesson foundLesson = temp;
            break;
        }
        if(foundLesson != null){
            lessons.remove(foundLesson);
        }
        
    }
}