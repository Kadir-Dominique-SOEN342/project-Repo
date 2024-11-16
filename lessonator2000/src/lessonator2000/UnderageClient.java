package lessonator2000;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
/**
 * 
 * Class UnderageClient.
 *
 * <p>Underage Client are a subtype of Client but with restricted access to methods lie makeBooking().
 * bookings made for underage CLients need to be made by an adult client</p>
 */
@Entity
public class UnderageClient extends lessonator2000.Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private lessonator2000.Client legalguardian;

	
	

	
	
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
		this.legalguardian = parent;;
		this.dependantsCatalog = null;
		
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
