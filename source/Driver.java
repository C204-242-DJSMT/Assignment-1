import java.util.ArrayList;

/*
 * 
 */
class Driver extends Employee {
	/*
	 * 
	 */
	public Driver(String username, String password) {
		super(EmployeeRoles.Driver, username, password);
	}

	/*
	 * 
	 */
	public ArrayList<Package> getVehicleManifest() {
		return null;
	}	
}