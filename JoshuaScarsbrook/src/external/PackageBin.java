package external;

import java.util.*;


/*
 * 
 */
//Package and PackageBin may be able/need to support a common superclass or interface
class PackageBin {
	static private long NextID = 0;
	final long id;
	public String vehicleID;
	public ArrayList<Package> contents = new ArrayList<Package>();
	// List of 1 or more cities contents of the bin are destined for.
	private ArrayList<String> destinationCities;
	// Chronologicl list of each time the bin is scanned
	 ArrayList<Scan> scanHistory = new ArrayList<Scan>();

	/*
	 * 
	 */
	public PackageBin(ArrayList<String> destinations) {
		if(destinations != null && destinations.size() > 0)
			this.destinationCities = new ArrayList<String>(destinations);
		else
			throw new IllegalArgumentException("No destination cities provided");
		this.id = NextID;
		NextID++;
		DataAdapter.addBin(this);
	}

	/**
	 * 
	 */
	void scan(ScanEvents event, Employee scanner) {
		Scan s = new Scan(event, scanner);
		this.scanHistory.add(s);
		// Apply the scan to the bin's contents
		for (Package p: this.contents) {
			p.scan(s);
		}
	}

	/**
	 *
	 */
	boolean addPackage(Package p, Employee e) {
		if (this.contents.contains(p) || p == null)
			throw new IllegalArgumentException();
		if (!this.destinationCities.contains(p.destinationCity))
			return false;
		p.scan(ScanEvents.addToBin, e);
		this.contents.add(p);
		return true;
	}

	/*
	 *
	 */
	boolean contains(Package p) {
		return this.contents.contains(p);
	}

	//Janik
	public String toString() {
		String result = "";
		result += this.id + " ";
		result += this.destinationCities +" " + this.vehicleID + " " + this.contents + " " + this.scanHistory;

		return result;
	}

	//Janik
	public Scan lastScan() {
		if (this.scanHistory.size() == 0)
			return null;
		return this.scanHistory.get(this.scanHistory.size() - 1);
	}
}