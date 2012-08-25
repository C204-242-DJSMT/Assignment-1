import java.util.EnumMap;

// enum for each occassion a package may or will be scanned
enum packageScans {placeholder};
class Package {
	static long NextID = 0;
	long id;

	Client addressee;
	String streetAddress;
	String postcode;
	EnumMap<packageScans, Scan> scanHistory = new EnumMap<packageScans, Scan>(packageScans.class);

	public Package(Client addressee, String Address) {

	}
}