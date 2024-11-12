package lessonator2000;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * Class SessionCatalog.
 *
 * <p>SessionCatalog keeps a collection of all sessions threads. </p>
 * it is responsible for creating and removing the sesisons
 * It is implemented as a singleton
 * 
 * @author Dominique Proulx
 * @version Nov 8, 2024
 */
public class SessionCatalog {
	
	private static SessionCatalog sessionCatalog = null;
	private static int numberOfSessions = 0;
	/**
	 * Collection of Sessions
	 */
	private ConcurrentHashMap<String,Session> userSessions = new ConcurrentHashMap<String,Session>();

	/**
	 * SessionCatalog is implemented as a singleton , the constrcutor is private
	 */
	private SessionCatalog() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * returns the unique instance of sessionCatalog or creates it and returns it
	 * @return
	 */
	public static SessionCatalog getSessionCatalog() {
	if(sessionCatalog == null) {
		sessionCatalog = new SessionCatalog();
		}
		return sessionCatalog;	
	}
	
	/**
	 * create a new session thread and adds it to the collection userSessions
	 */
	public void createNewSession() {
		
		Session s = new Session();
		numberOfSessions++;
		userSessions.put(s.getSessionId(), s);
		Thread sessionThread = new Thread(s);
		sessionThread.start();  
	}
	
	public void removeSession(String sessionId) {
		ConcurrentHashMap<String, Session> userSession;
		userSessions.remove(sessionId);
		numberOfSessions--;
		System.out.println("Session removed");
	}

}
