import java.util.regex.*;
import java.util.ArrayList;

/**
 * Represents one of the company's customers. Sends and recieves packages.
 *
 * Duncan Willcock
 */
class Client {
	static private long NextID = 0;
	static String nameRegex = "^(\\w)+ ((\\w)+)+$"; // Clients must be identified by at least 2 words
	final long id;
	String name;
	ArrayList<String[]> addresses = new ArrayList<String[]>(); // All address/postcode/city tuples client associates with themself. Must always have 1 or more elements.

	/**
	 *
	 */
	public boolean addNewAddress(String[] address) {
		if (address == null || address.length != 3 || address[0].length() == 0 || address[1].length() == 0 || address[2].length() == 0 || address[0] == null 
			|| address[1] == null || address[2] == null) {
			throw new IllegalArgumentException("Client addresses must have both street address and postcode");
		}
		for (String[] s: this.addresses) { // Check if the address is already asociated with the client
			if (s[0].equals(address[0]) && s[1].equals(address[1]) && s[2].equals(address[2])) {
				return false;
			}
		}
		this.addresses.add(address);
		return true;
	}
	/**
	 * Check if the client has an address associated with them.
	 *
	 * 
	 */
	public boolean hasAddress(String[] address) {
		if (address == null || address.length != 3 || address[0].length() == 0 || address[1].length() == 0 || address[2].length() == 0 || address[0] == null 
			|| address[1] == null || address[2] == null) {
			throw new IllegalArgumentException("Client addresses must have both street address and postcode");
		}

		for (String[] s: this.addresses) { // Check if the address is already asociated with the client
			if (s[0].equals(address[0]) && s[1].equals(address[1]) && s[2].equals(address[2])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 *
	 *
	 */
	public Client(String name, ArrayList<String[]> addresses) {
		if (name != null && Pattern.matches(nameRegex, name))
			this.name = name;
		else
			throw new IllegalArgumentException("Client\'s name must be a String of at least 3 characters");
		if (addresses == null || addresses.size() == 0)
			throw new IllegalArgumentException("Client must have at least 1 associated address");
		
		for (String[] s : addresses) {
			this.addNewAddress(s);
		}
		assert (this.addresses.size() > 0);

		
		this.id = NextID;
		NextID++;
		DataAdapter.addClient(this);
	}

	/**
	* Returns default String representation of the CLient - their name.
	*
	* Duncan Willcock
	*/
	public String toString() {
		return this.name;
	}
}