package lessonator2000;

//Implemented as a singleton

public class Administrator extends User {
	private static Administrator myadmin = null;
	private String username = "myadmin";
	private String password = "admin";
	
	//private constructor
	private Administrator() {
	
	}
	
	public static Administrator getAdministrator() {
		if(myadmin == null) {
			myadmin = new Administrator();
		}
		return myadmin;
		
	}

}
