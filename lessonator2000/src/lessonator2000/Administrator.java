package lessonator2000;

//Implemented as a singleton

public class Administrator extends User {
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
	public void viewOffering() {/*TODO: implement */};
}
