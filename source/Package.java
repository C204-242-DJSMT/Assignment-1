import java.util.ArrayList;
 
/**
 *
 */
//Package and PackageBin may be able to support a common superclass or interface
class Package {
	static private long NextID = 0;
	public final long id;

	final Client sender;
	final Client addressee; // Can be null if not a client
	String streetAddress;
	String postcode;
	String destinationCity;
	final String senderAddress;
	final String senderPostcode;
	// Chronological list of each time the package is scanned
	ArrayList<Scan> scanHistory = new ArrayList<Scan>();

	/**
	 *
	 */
	void scan(ScanEvents event, Employee scanner) {
		Scan s = new Scan(event, scanner);
		this.scanHistory.add(s);
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
	public Package(Client sender, Client addressee, String streetAddress, String postcode, String destinationCity) {
		if (sender == null || streetAddress == null || postcode == null || destinationCity == null)
			throw new IllegalArgumentException();

		this.sender = sender;
		this.addressee = addressee;
		this.streetAddress = streetAddress;
		this.postcode = postcode;
		this.destinationCity = destinationCity;
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
}