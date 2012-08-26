import java.util.ArrayList;
import java.util.Date;

enum BinScans {placeholder};

//Package and PackageBin may be able to support a common superclass or interface
class PackageBin {
	static long NextID;
	final long id;
	ArrayList<Package> contents = new ArrayList<Package>();
	// List of 1 or more cities contents of the bin are destined for.
	ArrayList<String> destinationCities;

	public PackageBin(ArrayList<String> destinations) {
		if(destinations != null && destinations.size() > 0)
			this.destinationCities = new ArrayList<String>(destinations);
		else
			throw new IllegalArgumentException();
		this.id = NextID;
		NextID++;
	}
	

}