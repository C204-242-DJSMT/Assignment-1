import java.util.Date;

/*
 * Enumeration for each occassion a package may or must be scanned.
 */
enum ScanEvents { dropOff, pickUp, takeFromVehicle, addToVehicle, delivered, addToBin, takeFromBin };

/*
 * 
 */
class Scan {
	static private long NextID = 0;
	final long id;
	public final Date time;
	public final Employee scanner;
	final ScanEvents event;

	/*
	 * 
	 */
	public Scan(ScanEvents event, Employee scanner) {
		this.scanner = scanner;
		this.event = event;
		this.time = new Date();
		this.id = NextID;
		NextID++;
	}
}