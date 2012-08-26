import java.util.EnumMap;
 
/*
 * Enumeration for each occassion a package may or must be scanned.
 */
enum packageScans {placeholder};
//Package and PackageBin may be able to support a common superclass or interface
class Package {
	static private long NextID = 0;
	final long id;

	Client sender;
	Client addressee; //null if not a client
	String streetAddress;
	String postcode;
	EnumMap<packageScans, Scan> scanHistory = new EnumMap<packageScans, Scan>(packageScans.class);

	/*
	 * 
	 */
	public Package(Client sender, Client addressee, String streetAddress, String postcode) {
		if (sender == null || addressee == null || streetAddress == null || postcode == null)
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