import java.util.Date;

/*
 * 
 */
class Scan {
	static private long NextID = 0;
	final long id;
	public final Date timeOfScan;
	public final Employee scanner;

	/*
	 * 
	 */
	public Scan(Employee scanner) {
		this.scanner = scanner;
		this.timeOfScan = new Date();
		this.id = NextID;
		NextID++;
	}
}