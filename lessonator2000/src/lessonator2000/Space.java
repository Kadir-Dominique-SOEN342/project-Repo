package lessonator2000;

public class Space {
	
private String rentedOrOwned;
private String roomNumber;
private String typeOfSpace;
private Schedual openFor;
private String city;
private String province;


public Space(String rentedOrOwned, String roomNumber, String type , String city, String province, Schedual myschedule) {
	this.rentedOrOwned = rentedOrOwned;
	this.roomNumber = roomNumber;
	this.typeOfSpace = type;
	this.openFor = myschedule;
	this.city = city;
	this.province = province;
}

}
