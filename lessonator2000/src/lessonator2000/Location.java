package lessonator2000;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * 
 * Class Location.
 *
 * <p>This class holds the space where lessons will be offered and handles the schedueling activies</p>

 */
public class Location {
	
	private ArrayList<lessonator2000.Space> spaceRegistry;
	private static Location organizationLocations = null;
	
	/**
	 * implemented as a singleton, the constructor is private
	 */
	private Location() {
		spaceRegistry = new ArrayList<lessonator2000.Space>();
		//a few harcoded spaces
				lessonator2000.Space space1 = new lessonator2000.Space("rented", "H513","room","Montreal", "Quebec");
				spaceRegistry.add(space1);
				lessonator2000.Space space2 = new lessonator2000.Space("rented", "H936","room","Montreal", "Quebec");
				spaceRegistry.add(space2);
				lessonator2000.Space space3 = new lessonator2000.Space("owned", "TY908","gym","Ottawa", "Quebec");
				spaceRegistry.add(space3);
				lessonator2000.Space space4 = new lessonator2000.Space("rented", "123PM","pool","Ottawa", "Quebec");
				spaceRegistry.add(space4);
				lessonator2000.Space space5 = new lessonator2000.Space("owned", "123ramsay","garden","Lachute", "Quebec");
				spaceRegistry.add(space5);
		}
	
	/**
	 * returns the single instance of the Location singleton
	 * @return
	 */
	public static Location getLocationRegistry() {
		
		if(organizationLocations == null) {
			organizationLocations = new Location();
		}
		return organizationLocations;
	}

	
	//finds the space we will add the lesson to
	/**
	 * Given a room number, the space is found in the registry and returns the space.
	 * The method's name is a bit misleading, this only finds the space and returns it , it does not add the lesson , 
	 *
	 * @param roomNb
	 * @return
	 */
	//TODO: rename this method
	 lessonator2000.Space addLessonToSpace(String roomNb) {
	//	System.out.println("Location : addLessonToSpace");
		lessonator2000.Space lessonSpace = null; //initialize to 0
		for(lessonator2000.Space s: spaceRegistry) {  // for each space in registry , return the space if the room number is equal
			if(roomNb.equals(s.getRoomNumber())) {
				lessonSpace = s;	
				//System.out.println("Location: found room Number");
			}
			
		}
		
	
		if(lessonSpace != null) {
	      return lessonSpace;
	  } else {
	      System.out.println("Space with room number " + roomNb + " not found.");
      }
		return lessonSpace;

	//    return lessonSpace;
	}


	
	
	
}