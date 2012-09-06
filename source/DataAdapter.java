import java.util.*;

/**
 * Static interface class for retrieving/storing data in the system.
 * Internal implementation should in fact be a set of database interactions, but externally this class is complete
 *
 * Duncan Willcock, Nigel Thomas, Mathew Andela
 */
class DataAdapter {
	private static ArrayList<Package> allPackages = new ArrayList<Package>();
	
	/**
	 * Packages that have been officially recorded as lost.
	 */
	private static ArrayList<Package> lostPackages = new ArrayList<Package>();

	/**
 	 * Returns the package with a given ID from any of the collections of Packages.
 	 * Returns null if  package with the supplied id is not found.
 	 *
 	 * Duncan Willcock 
 	 */
	public static Package getPackageByID(long id) {
		for (Package p : allPackages)
			if (p.id == id)
				return p;

		for (Package p : lostPackages)
			if (p.id == id)
				return p;

		return null;
	}

	/**
	 * Returns a list of all packages that have not been scanned as delivered.
	 *
	 * Duncan Willcock
	 */
	public static ArrayList<Package> getUndeliveredPackages() {
		ArrayList<Package> result = new ArrayList<Package>();
		for (Package p:allPackages)
			if(p.scanHistory.get(p.scanHistory.size() - 1).event != ScanEvents.delivered)
				result.add(p);

		return result;
	}

	/**
	 * Returns a list of all packages that have been scanned as delivered.
	 *
	 * Duncan Willcock
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
	 *
	 * Duncan Willcock
	 */
	public static ArrayList<Package> getOlderPackages(Calendar time) {
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

	
	/*
	 * Gets packages by status
	 * used to get packages requiring pickup
	 */
	public static ArrayList<Package> getPackagePickUp(){
		ArrayList<Package> p = new ArrayList<Package>();		
		if(allPackages == null){
			return null;
		}
		else{
			for(Package k: allPackages){
				if(k.awaitingPickup == true){
					p.add(k);
				}
			}
			return p;
		}
	}

	/*
	 * Adds a package to the list if it is a valid object and not conflicting with the current list contets.
	 * Return true if it was successfully added to the list.
	 *
	 * Duncan Willcock
	 */
	public static boolean addPackage(Package p) {
		if (p == null)
			throw new IllegalArgumentException();
		if (allPackages.contains(p))
			return false;
		allPackages.add(p);
		return true;
	}

	/*
	 * 
	 *
	 * Duncan Willcock
	 */
	public static boolean recordLostPackage(Package p) {
		if (p == null || p.lastScan().event != ScanEvents.lost)
			throw new IllegalArgumentException();
		if (!allPackages.contains(p) || lostPackages.contains(p))
			return false;
		allPackages.remove(p);
		lostPackages.add(p);
		return true;
	}

	/*
	 * 
	 *
	 * Duncan Willcock
	 */
	public static boolean recordFoundPackage(Package p) {
		if (p == null || p.lastScan().event != ScanEvents.found)
			throw new IllegalArgumentException();
		if (allPackages.contains(p) || !lostPackages.contains(p))
			return false;
		lostPackages.remove(p);
		allPackages.add(p);
		return true;
	}

	/*
	 * Returns list of all packages recorded as lost.
	 *
	 * Duncan Willcock
	 */
	public static ArrayList<Package> getLostPackages() {
		return lostPackages;
	}


	private static ArrayList<Client> allClients = new ArrayList<Client>();

	


	/**
	 *
	 *
	 * Duncan Willcock 
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
 	*
 	* Duncan Willcock
 	*/
	public static Employee getEmployeeByID(long id) {
		for (Employee e : allEmployees)
			if (e.id == id)
				return e;

		return null;
	}

	public static Client getClientByID(long id) {
		for (Client c : allClients)
			if (c.id == id)
				return c;

		return null;
	}

	/**
	 * 
	 *
	 * Duncan Willcock
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
	
	/**
	 * Gets bins in a specified vehicle
	 */	
	public static ArrayList<PackageBin> getBinByVehicle(String v){
		ArrayList<PackageBin> temp = new ArrayList<PackageBin>();
		for(PackageBin b: allPackageBins){
			if(b.vehicleID == v){
				temp.add(b);
			}			
		}
		return temp;		
	}
	


	/**
	 * 
	 *
	 * Duncan Willcock
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

	/**
	 *
	 *
	 *
	 */

	public static Employee verifyEmployee(String username, String password) {
		if ( username == null || password == null)
			throw new IllegalArgumentException();
		//System.out.println(employeePasswords.size());
		for (int i = 0; i < allEmployees.size();i++) {
			//System.out.println(allEmployees.get(i).username + "  " + employeePasswords.get(i));
			if (username.equals(allEmployees.get(i).username) && password.equals(employeePasswords.get(i)))
				return allEmployees.get(i);
		}
		return null;
	}

	/**
	  *
	  */
	public static void addPassword(String password) {
		employeePasswords.add(password);
		//System.out.println(employeePasswords.size());
	}
	/**
	  *N
	  */ 
	public static ArrayList<Client> findName(String name)
	{	
		if (name == null)
			throw new IllegalArgumentException();
		ArrayList<Client> result = new ArrayList<Client>();
			for(Client c : allClients )
			{
				if (c.name.startsWith(name))
					result.add(c);
				}
	return result;
}
//N
	public static ArrayList<Package> getPackageByAddress(Client c, String[] a){
		if (c == null || a == null || a.length != 3)
		throw new IllegalArgumentException();
		ArrayList<Package> result = new ArrayList<Package>();
		for(Package p: allPackages){
			if(c == p.addressee && a[0].equals(p.streetAddress) && a[1].equals(p.postcode) && a[2].equals(p.destinationCity)){
				result.add(p);
			}			
		}
		return result;	
	}
		



	public static ArrayList<PackageBin> findBin()
	{	
		ArrayList<PackageBin> result = new ArrayList<PackageBin>();
			for(PackageBin d : allPackageBins )
			{
					result.add(d);
			}
	return result;
	}
}
