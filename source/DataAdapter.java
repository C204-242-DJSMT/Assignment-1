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
	 * Returns a list of all packages whose last scan was before a time.
	 */
	public static ArrayList<Package> getOlderPackages(Date time) {
		ArrayList<Package> result = new ArrayList<Package>();
		for (Package p : allPackages) {
			if (p.scanHistory.get(p.scanHistory.size() - 1).time.before(time))
				result.add(p);
		}
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
		return false;
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
		return false;
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
		return false;
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
	public static boolean addBin(PackageBin c) {
		return false;
	}

}