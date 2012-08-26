import java.util.Date;

class Scan {
	static long NextID;
	final long id;
	public final Date timeOfScan;
	public final Employee scanner;

	public Scan(Employee scanner) {
		this.scanner = scanner;
		this.timeOfScan = new Date();

		this.id = NextID;
		NextID++:
	}

}