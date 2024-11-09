package lessonator2000;

//Implemented as a singleton
/**
 * 
 * Class Administrator.
 *
 * <p>This is the class of user that can uploadOffering, deleteOffering , see all bookings and remove them .</p>
 */
public class Administrator extends lessonator2000.User {
	private static Administrator myadmin = null;
	private String username = "myadmin"; //hardcoded
	private String password = "admin"; // hardcoded
	
	//private constructor
	private Administrator() {
	
	}
	
	/**
	 * 
	 * @return a unique administrator instance
	 */
	public static Administrator getAdministrator() {
		if(myadmin == null) {
			myadmin = new Administrator();
		}
		return myadmin;
		
	}
	
	/**
	 * return the username
	 * @return
	 */
	public String getUsername() {
		return this.username;
	}
}