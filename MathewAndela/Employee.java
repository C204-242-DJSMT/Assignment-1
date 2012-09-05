import java.util.regex.*;
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
	private static String regex = "^[\\w]{6,}"; // six or more 'word' characters
	long id;
	EmployeeRoles role;
	String username;



	/**
	 * Instantiates a new employee, adding them to DataAdapter.
	 *
	 * Duncan Willcock
	 */
	public Employee(EmployeeRoles role, String username, String password) {
		if (password == null || !Pattern.matches(regex, password) || username == null || username.length() == 0)
			throw new IllegalArgumentException();
		this.role = role;
		this.username = username;
		this.id = NextID;
		NextID++;
		DataAdapter.addEmployee(this);
		DataAdapter.addPassword(password);
	}

}