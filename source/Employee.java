/*
 * 
 */
enum EmployeeRoles {Driver, AccountManager, Sorter, TransportManager}

// switch 
//employee role. driver or accountmanage(me) 
 //case 

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