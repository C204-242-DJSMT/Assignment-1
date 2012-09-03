/*
 * 
 */
enum EmployeeRoles {Driver, AccountManager, Sorter, TransportManager}



/**
 * 
 *
 * Duncan Willcock
 */
class Employee {
	static private long NextID = 0;

	long id;
	EmployeeRoles role;
	String username;



	/**
	 * Instantiates a new employee, adding them to DataAdapter.
	 *
	 * Duncan Willcock
	 */
	public Employee(EmployeeRoles role, String username, String password) {
		if (username == null || username.length() == 0) //must also check username is not already in use
			throw new IllegalArgumentException();
		this.role = role;
		this.username = username;
		this.id = NextID;
		NextID++;
		DataAdapter.addEmployee(this);
		DataAdapter.addPassword(password);
	}

}