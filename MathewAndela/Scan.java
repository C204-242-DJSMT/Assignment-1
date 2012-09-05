import java.util.*;

/**
 * Enumeration for each occassion a package may or must be scanned.
 * 
 * Duncan Willcock
 */
enum ScanEvents { dropOff, pickUp, takeFromVehicle, addToVehicle, delivered, addToBin, takeFromBin, enterFacility, leaveFacility, lost };

/**
 * 
 *
 * Duncan Willcock
 */
class Scan {
	static private long NextID = 0;
	final long id;
	public final Calendar time;
	public final Employee scanner;
	final ScanEvents event;

	/**
	 * 
	 *
	 * Duncan Willcock
	 */
	public Scan(ScanEvents event, Employee scanner) {
		if (scanner == null)
			throw new IllegalArgumentException();
		this.scanner = scanner;
		this.event = event;
		this.time = new GregorianCalendar();
		this.time.setTime(new Date());
		this.id = NextID;
		NextID++;
	}

	/**
	 * 
	 *
	 * Duncan Willcock
	 */
	public String toString() {
		return this.time.getTime().toLocaleString() + "  " + this.event.toString();
	}
}