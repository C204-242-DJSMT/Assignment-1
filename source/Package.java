import java.util.EnumMap;

// enum for each occassion a package may or will be scanned
enum packageScans {placeholder};
//Package and PackageBin may be able to support a common superclass or interface
class Package {
	static long NextID = 0;
	final long id;

	Client addressee;
	String streetAddress;
	String postcode;
	EnumMap<packageScans, Scan> scanHistory = new EnumMap<packageScans, Scan>(packageScans.class);

	public Package(Client addressee, String Address) {


		this.id = NextID;
		NextID ++;
	}
}