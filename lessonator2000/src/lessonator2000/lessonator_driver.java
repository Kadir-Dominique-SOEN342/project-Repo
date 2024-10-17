package lessonator2000;


public class lessonator_driver {

	private Administrator myadmin = Administrator.getAdministrator();	
	private Registration registry  = Registration.getRegistry();	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Well, hello There");
		Registration.register();
	}

}
