import java.util.Date;

/*
 * Enumeration for each occassion a package may or must be scanned.
 */
enum ScanEvents {dropOff, pickUp, removedFromVehicle, putIntoVehicle, delivered, putIntoBin, removedFromBin };

/*
 * 
 */
class Scan {
	static private long NextID = 0;
	final long id;
	public final Date timeOfScan;
	public final Employee scanner;
	ScanEvents event;

	/*
	 * 
	 */
	public Scan(Employee scanner, ScanEvents event) {
		this.scanner = scanner;
		this.event = event;
		this.timeOfScan = new Date();
		this.id = NextID;
		NextID++;
	}
}