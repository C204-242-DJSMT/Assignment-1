import java.util.EnumMap;

enum scans {one};
class Package {
	

	//Destination destination;
	Client addressee;
	String streetAddress;
	String postcode;
	EnumMap scanHistory = new EnumMap(scans.class);

	public Package(Client addressee, String Address) {

	}
}