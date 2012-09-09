package external;

import java.util.*;

/**
 * Enumeration for each occassion a package may or must be scanned.
 * 
 * Duncan Willcock
 */
enum ScanEvents {dropOff, pickUp, takeFromVehicle, addToVehicle, delivered, addToBin, takeFromBin, enterFacility, leaveFacility, lost, found};

/**
 * Represents a scan of a package or bin at a certain time, made by an employee at one of the occasions a scan needs to be made.
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
	 * Creates a new scan at the current time, with the input event and scanner.
	 *
	 * Duncan Willcock
	 */
	public Scan(ScanEvents event, Employee scanner) {
		if (scanner == null || event == null)
			throw new IllegalArgumentException();
		this.scanner = scanner;
		this.event = event;
		this.time = new GregorianCalendar();
		this.time.setTime(new Date());
		this.id = NextID;
		NextID++;
	}

	/**
	 * Returns the default String representation of a Scan - time, event and employee id of the scanner.
	 *
	 * Duncan Willcock
	 */
	public String toString() {
		return this.time.getTime().toLocaleString() + "  " + this.event.toString() + "  " + this.scanner.id;
	}
}