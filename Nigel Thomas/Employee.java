import java.util.regex.*;

/**
 * Represents the four different relevant roles of employee users.
 *
 * Duncan Willcock, Nigel Thomas
 */
enum EmployeeRoles {Driver, AccountManager, Sorter, TransportManager}



/**
 * Employee class takes a employee role username and password
 *checks to see if they are null
 * 
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
	 * 
	 */
	public Employee(EmployeeRoles role, String username, String password) {
		if (role == null || password == null || !Pattern.matches(regex, password) || username == null || username.length() == 0)
			throw new IllegalArgumentException();
		this.role = role;
		this.username = username;
		this.id = NextID;
		NextID++;
		DataAdapter.addEmployee(this);
		DataAdapter.addPassword(password);
	}

}