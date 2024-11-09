package lessonator2000;

import java.time.LocalDate;
/**
 * 
 * Class UnderageClient.
 *
 * <p>Underage Client are a subtype of Client but with restricted access to methods lie makeBooking().
 * bookings made for underage CLients need to be made by an adult client</p>
 */
public class UnderageClient extends lessonator2000.Client {
	
	private lessonator2000.Client legalguardian;

	
	
	//DP : I remove this as we don't want any client's or underage client created without information
	//Constructor
	//public UnderageClient() {
	//	super();
		//this.legalguardian = null;
		
	//}
	
	
	/**
	 * Constructor for an underage client 
	 * Underage clients are a subtype of client but with restricted access to methods like makeBooking()
	 * @param firstn
	 * @param lastn
	 * @param birth
	 * @param username
	 * @param password
	 * @param parent
	 */
	public UnderageClient(String firstn, String lastn, LocalDate birth, String username, String password, lessonator2000.Client parent) {
		super(firstn, lastn, birth, username, password);
		this.legalguardian = parent;
		
	}
	
	//Getter
	public lessonator2000.Client getLegalGuardian() {
		return legalguardian;
	}
	//Setter
	public void setlegalguardian(lessonator2000.Client c) {
		this.legalguardian = c;
	}



}
