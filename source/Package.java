import java.util.EnumMap;
 
/*
 * Enumeration for each occassion a package may or must be scanned.
 */
enum PackageScans {placeholder};
//Package and PackageBin may be able to support a common superclass or interface
class Package {
	static private long NextID = 0;
	final long id;

	Client sender;
	Client addressee; // Can be null if not a client
	String streetAddress;
	String postcode;
	String senderAddress;
	String senderPostcode;
	EnumMap<PackageScans, Scan> scanHistory = new EnumMap<PackageScans, Scan>(PackageScans.class);

	void scan(PackageScans scanType, Employee scanner) {
		if (this.scanHistory.get(scanType == null))
			this.scanHistory.put(scanType, new Scan(scanner));
		else
			throw new IllegalArgumentException("Package already contains a record for that scan");
	}

	/*
	 * 
	 */
	public Package(Client sender, Client addressee, String streetAddress, String postcode) {
		if (sender == null || streetAddress == null || postcode == null)
			throw new IllegalArgumentException();

		this.sender = sender;
		this.addressee = addressee;
		this.streetAddress = streetAddress;
		this.postcode = postcode;
		this.id = NextID;
		NextID++;
		DataAdapter.addPackage(this);
	}
}