/*
 * 
 */
enum EmployeeRoles {Driver, AccountManager, Sorter, TransportManager}

/*
 * 
 */
class Employee {
	static private long NextID = 0;

	final long id;
	EmployeeRoles role;
	final String username;

	/*
	 * 
	 */
	public Employee(EmployeeRoles role, String username) {
		if (username == null || username.length == 0) //must also check username is not already in use
			throw new IllegalArgumentException();
		this.role = role;
		this.username = username;
		this.id = NextID;
		NextID++;
		DataAdapter.addEmployee(this);
	}
}