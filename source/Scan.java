import java.util.*;

/*
 * Enumeration for each occassion a package may or must be scanned.
 */
enum ScanEvents { dropOff, pickUp, takeFromVehicle, addToVehicle, delivered, addToBin, takeFromBin, enterFacility, leaveFacility };

/*
 * 
 */
class Scan {
	static private long NextID = 0;
	final long id;
	public final Calendar time;
	public final Employee scanner;
	final ScanEvents event;

	/*
	 * 
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

	public String toString() {
		String formattedTime = "";
		formattedTime += this.time.DAY_OF_MONTH + "/";
		formattedTime += this.time.MONTH + "/";
		formattedTime += this.time.YEAR + "   ";
		formattedTime += this.time.HOUR + ":";
		formattedTime += this.time.MINUTE;

		return formattedTime + "  " + this.event.toString();
	}
}