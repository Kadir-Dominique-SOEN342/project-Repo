package lessonator2000;

import java.util.ArrayList;

public class Location {
	
	private ArrayList<Space> spaceRegistry;
	private static Location organizationLocations = null;
	
	private Location() {
		
		}
	
	public static Location getRegistry() {
		if(organizationLocations == null) {
			organizationLocations = new Location();
		}
		return organizationLocations;
	}
	
}