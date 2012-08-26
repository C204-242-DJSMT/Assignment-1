import java.util.ArrayList;

/*
 * 
 */
class DataAdapter {
	private static ArrayList<Package> allPackages = new ArrayList<Package>();

	/*
 	* 
 	*/
	public Package getPackageByID(long id) {
		return null;
	}

	/*
 	* 
 	*/
	public ArrayList<Package> getPackages() {
		return allPackages;
	}

	/*
	 * Adds a package to the list if it is a valid object and not conflicting with the current list contets.
	 * Return true if it was successfully added to the list.
	 */
	public boolean addPackage(Package p) {
		return false;
	}

	private static ArrayList<Client> allClients = new ArrayList<Client>();

	/*
 	* 
 	*/
	public Client getClientByID(long id) {
		return null;
	}

	/*
 	* 
 	*/
	public ArrayList<Client> getClients() {
		return allClients;
	}

	/*
	 * 
	 */
	public boolean addClient(Client c) {
		return false;
	}

	private static ArrayList<Employee> allEmployees = new ArrayList<Employee>();

	/*
 	* 
 	*/
	public Employee getEmployeeByID(long id) {
		return null;
	}

	/*
 	* 
 	*/
	public ArrayList<Employee> getEmployees() {
		return allEmployees;
	}

	/*
	 * 
	 */
	public boolean addEmployee(Employee e) {
		return false;
	}

	private static ArrayList<PackageBin> allPackageBins = new ArrayList<PackageBin>();
	/*
 	* 
 	*/
	public PackageBin getBinByID(long id) {
		return null;
	}

	/*
 	* 
 	*/
	public ArrayList<PackageBin> getBins() {
		return allPackageBins;
	}

	/*
	 * 
	 */
	public boolean addBin(PackageBin c) {
		return false;
	}

}