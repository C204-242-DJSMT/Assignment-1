import java.util.ArrayList;
 

//Package and PackageBin may be able to support a common superclass or interface
class Package {
	static private long NextID = 0;
	final long id;

	Client sender;
	Client addressee; // Can be null if not a client
	String streetAddress;
	String postcode;
	String destinationCity;
	String senderAddress;
	String senderPostcode;
	// Chronologicl list of each time the package is scanned
	ArrayList<Scan> scanHistory = new ArrayList<Scan>();

	void scan(ScanEvents event, Employee scanner) {
		
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
}