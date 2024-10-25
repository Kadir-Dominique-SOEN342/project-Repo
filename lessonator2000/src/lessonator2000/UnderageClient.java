package lessonator2000;

import java.time.LocalDate;

public class UnderageClient extends Client{
	
	private Client legalguardian;

	//Constructor
	public UnderageClient(String firstn, String lastn, LocalDate birth, String username, String password, Client parent) {
		super(firstn, lastn, birth, username, password);
		this.legalguardian = parent;
		// TODO Auto-generated constructor stub
	}
	
	//Getter
	public Client getLegalGuardian() {
		return legalguardian;
	}
	//Setter
	public void setlegalguardian(Client c) {
		this.legalguardian = c;
	}

}
