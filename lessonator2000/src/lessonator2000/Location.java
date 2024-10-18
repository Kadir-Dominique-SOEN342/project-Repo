package lessonator2000;

import java.util.ArrayList;

public class Location {
	
	private ArrayList<Space> spaceRegistry;
	private static Location organizationLocations = null;
	
	private Location() {
		spaceRegistry = new ArrayList<Space>();
		//a few harcoded spaces
				Space space1 = new Space("rented", "H513","room","Montreal", "Quebec");
				spaceRegistry.add(space1);
				Space space2 = new Space("rented", "H936","room","Montreal", "Quebec");
				spaceRegistry.add(space2);
				Space space3 = new Space("owned", "TY908","gym","Ottawa", "Quebec");
				spaceRegistry.add(space3);
				Space space4 = new Space("rented", "123PM","pool","Ottawa", "Quebec");
				spaceRegistry.add(space4);
				Space space5 = new Space("owned", "123ramsay","garden","Lachute", "Quebec");
				spaceRegistry.add(space5);
		}
	
	public static Location getRegistry() {
		
		if(organizationLocations == null) {
			organizationLocations = new Location();
		}
		return organizationLocations;
	}
	
	
	
}