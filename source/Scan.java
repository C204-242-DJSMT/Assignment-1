import java.util.Date;

class Scan {
	static long NextID;
	long id;
	public final Date timeOfScan;
	public final Employee scanner;

	public Scan(Employee scanner) {
		this.scanner = scanner;
		timeOfScan = new Date();
	}

}