package lessonator2000;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageSessionFactory {

    private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();




    public static SessionFactory getSf() {
        return sf;
    }

    public static void closeFactory(){
        sf.close();
    }
}
