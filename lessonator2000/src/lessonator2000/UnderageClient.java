package lessonator2000;

import java.time.LocalDate;

public class UnderageClient extends lessonator2000.Client {
	
	private lessonator2000.Client legalguardian;

	//Constructor
	public UnderageClient(String firstn, String lastn, LocalDate birth, String username, String password, lessonator2000.Client parent) {
		super(firstn, lastn, birth, username, password);
		this.legalguardian = parent;
		// TODO Auto-generated constructor stub
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
