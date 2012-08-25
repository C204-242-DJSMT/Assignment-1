import java.util.Date;

class Scan {
	public final Date timeOfScan;
	public final Employee scanner;

	public Scan(Employee scanner) {
		this.scanner = scanner;
		timeOfScan = new Date();
	}

}