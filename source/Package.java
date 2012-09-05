import java.util.ArrayList;
 
/**
 *
 */
//Package and PackageBin may be able to support a common superclass or interface
class Package {
	static private long NextID = 0;
	public final long id;

	final Client sender;
	final Client addressee; // Can be null if not a client. If non-null address information must be associated with that client.
	String streetAddress;
	String postcode;
	String destinationCity;
	// Human readable repesentation of the sender's return address.
	final String senderAddress;
	public boolean awaitingPickup;
	// Chronological list of each time the package is scanned
	ArrayList<Scan> scanHistory = new ArrayList<Scan>();

	/**
	 *
	 */
	void scan(ScanEvents event, Employee scanner) {
		Scan s = new Scan(event, scanner);
		if (event == ScanEvents.pickUp) {
			assert (this.awaitingPickup);
			this.awaitingPickup = false;
		}
		this.scanHistory.add(s);
		if (event == ScanEvents.lost) {
			assert (this.lastScan().event != ScanEvents.lost);
			DataAdapter.recordLostPackage(this);
		}
	}

	/**
	 *
	 */
	void scan(Scan s) {
		if (s == null)
			throw new IllegalArgumentException();
		this.scanHistory.add(s);
	}

	/*
	 * 
	 */
	public Package(Client sender, Client addressee, String streetAddress, String postcode, String destinationCity, String senderAddress, boolean pickup) {
		if (sender == null || streetAddress == null || postcode == null || destinationCity == null || senderAddress == null
			 || streetAddress.length() == 0 || postcode.length() == 0 || destinationCity.length() == 0 || senderAddress.length() == 0)
			throw new IllegalArgumentException();
	

		this.sender = sender;
		this.addressee = addressee;
		this.streetAddress = streetAddress;
		this.postcode = postcode;
		this.destinationCity = destinationCity;
		this.awaitingPickup = pickup;
		this.senderAddress = senderAddress;
		this.id = NextID;
		NextID++;
		DataAdapter.addPackage(this);
	}

	/**
	 * Changes the recieving address of the package to another associated with the addressee.
	 */
	boolean reroute(String[] address) {
		if (this.addressee.hasAddress(address)) { //hasAddress contains all the necessary checking of the address parameter
			this.streetAddress = address[0];
			this.postcode = address[1];
			this.destinationCity = address[2];
			return true;
		}
		return false;
	}

	/**
	 *
	 */
	public Scan lastScan() {
		if (this.scanHistory.size() == 0)
			return null;
		return this.scanHistory.get(this.scanHistory.size() - 1);
	}

	/**
	 *
	 */
	public String toString() {
		String result = "";
		result += this.id + " ";
		result += "from: " + this.sender.toString() + " to: ";
		// if (this.scanHistory.size() > 0)
		// 	result += "   " + this.lastScan().toString();
		result += this.streetAddress + " " + this.destinationCity + " " + this.postcode;

		return result;
	}
}