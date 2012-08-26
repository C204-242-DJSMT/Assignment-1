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

	/*
	 * 
	 */
	public Employee(EmployeeRoles role) {
		this.role = role;
		this.id = NextID;
		NextID++;
	}
}