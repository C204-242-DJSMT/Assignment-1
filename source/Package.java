import java.util.EnumMap;
 
/*
 * Enumeration for each occassion a package may or must be scanned.
 */
enum ScanTypes {placeholder};
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
	EnumMap<ScanTypes, Scan> scanHistory = new EnumMap<ScanTypes, Scan>(ScanTypes.class);

	void scan(ScanTypes scanType, Employee scanner) {
		if (this.scanHistory.get(scanType == null))
			this.scanHistory.put(scanType, new Scan(scanner));
		else
			throw new IllegalArgumentException("Package already contains a record for that scan");
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