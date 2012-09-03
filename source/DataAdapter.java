
import java.util.*;

/*
 * 
 */
class DataAdapter {
	private static ArrayList<Package> allPackages = new ArrayList<Package>();

	/*
 	* 
 	*/
	public static Package getPackageByID(long id) {
		for (Package p : allPackages)
			if (p.id == id)
				return p;
		return null;
	}


	/**
	 * Returns a list of all packages that have not been scanned as delivered.
	 */
	public static ArrayList<Package> getUndeliveredPackages() {
		ArrayList<Package> result = new ArrayList<Package>();
		for (Package p:allPackages)
			if(p.scanHistory.get(p.scanHistory.size() - 1).event != ScanEvents.delivered)
				result.add(p);

		return result;
	}

	/**
	 * Returns a list of all packages that have  been scanned as delivered.
	 */
	public static ArrayList<Package> getDeliveredPackages() {
		ArrayList<Package> result = new ArrayList<Package>();
		for (Package p:allPackages)
			if(p.scanHistory.get(p.scanHistory.size() - 1).event == ScanEvents.delivered)
				result.add(p);

		return result;
	}

	/**
	 * Returns a list of all undelivered packages whose last scan was before a time.
	 */
	public static ArrayList<Package> getOlderPackages(Date time) {
		ArrayList<Package> result = new ArrayList<Package>();
		for (Package p : allPackages) {
			if (p.scanHistory == null)
				result.add(p);
			else {
				if (p.scanHistory.size() == 0) {
					result.add(p);
					continue;
				}
				Scan lastScan = p.scanHistory.get(p.scanHistory.size() - 1);
				if (lastScan.time.before(time) && lastScan.event != ScanEvents.delivered)
					result.add(p);
			}
		}
		return result;
	}

	/**
	 * Returns a list of all undelivered packages whose last scan was after a time.
	 */
	public static ArrayList<Package> getNewerPackages(Date time) {
		ArrayList<Package> result = new ArrayList<Package>();
		for (Package p : allPackages) {
			if (p.scanHistory == null)
				result.add(p);
			else {
				Scan lastScan = p.scanHistory.get(p.scanHistory.size() - 1);
				if (lastScan.time.after(time) && lastScan.event != ScanEvents.delivered)
					result.add(p);
			}
		}
		return result;
	}

	/*
 	* 
 	*/
	// public static ArrayList<Package> getPackages() {
	// 	return allPackages;
	// }

	/*
	 * Adds a package to the list if it is a valid object and not conflicting with the current list contets.
	 * Return true if it was successfully added to the list.
	 */
	public static boolean addPackage(Package p) {
		if (p == null)
			throw new IllegalArgumentException();
		if (allPackages.contains(p))
			return false;
		allPackages.add(p);
		return true;

	}

	private static ArrayList<Client> allClients = new ArrayList<Client>();

	/*
 	* 
 	*/
	public static Client getClientByID(long id) {
		return null;
	}

	/*
 	* 
 	*/
	// public static ArrayList<Client> getClients() {
	// 	return allClients;
	// }

	/*
	 * 
	 */
	public static boolean addClient(Client c) {
		if (c == null)
			throw new IllegalArgumentException();
		if (allClients.contains(c))
			return false;
		allClients.add(c);
		return true;
	}

	private static ArrayList<Employee> allEmployees = new ArrayList<Employee>();

	/*
 	* 
 	*/
	public static Employee getEmployeeByID(long id) {
		return null;
	}

	/*
 	* 
 	*/
	// public static ArrayList<Employee> getEmployees() {
	// 	return allEmployees;
	// }

	/*
	 * 
	 */
	public static boolean addEmployee(Employee e) {
		if (e == null)
			throw new IllegalArgumentException();
		if (allEmployees.contains(e))
			return false;
		allEmployees.add(e);
		return true;
	}

	private static ArrayList<PackageBin> allPackageBins = new ArrayList<PackageBin>();
	/*
 	* 
 	*/
	public static PackageBin getBinByID(long id) {
		return null;
	}

	/*
 	* 
 	*/
	// public static ArrayList<PackageBin> getBins() {
	// 	return allPackageBins;
	// }

	/*
	 * 
	 */
	public static boolean addBin(PackageBin b) {
		if (b == null)
			throw new IllegalArgumentException();
		if (allPackageBins.contains(b))
			return false;
		allPackageBins.add(b);
		return true;
	}

	private static ArrayList<String> employeePasswords = new ArrayList<String>();

	public static Employee verifyEmployee(String username, String password) {
		System.out.println(employeePasswords.size());
		for (int i = 0; i < allEmployees.size();i++) {
			System.out.println(allEmployees.get(i).username + "  " + employeePasswords.get(i));
			if (username.equals(allEmployees.get(i).username) && password.equals(employeePasswords.get(i)))
				return allEmployees.get(i);


		}
		return null;
	}
	public static void addPassword(String password) {
		employeePasswords.add(password);
		System.out.println(employeePasswords.size());
	}

}