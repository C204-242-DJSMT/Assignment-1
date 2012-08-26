import java.util.regex.*;
import java.util.ArrayList;

/**
 * 
 */
class Client {
	static private long NextID = 0;
	static String nameRegex = "^(\\w)+ ((\\w)+)+$"; // Clients must be identified by at least 2 words
	final long id;
	String name;
	ArrayList<String[]> addresses = new ArrayList<String[]>(); // All address/postcode pairs client associates with themself. Must always have 1 or more elements.

	/**
	 *
	 */
	public boolean addNewAddress(String[] address) {
		if (address == null || address.length != 2 || address[0].length() == 0 || address[1].length() == 0 || address[0] == null | address[1] == null) {
			throw new IllegalArgumentException("Client addresses must have both street address and postcode");
		}
		for (String[] s: this.addresses) {
			if (s[0].equals(address[0]) && s[1].equals(address[0])) {
				return false;
			}
		}
		this.addresses.add(address);
		return true;
	}

	/**
	 *
	 */
	public void deleteAddress() {
		// Must not leave the Client with no addresses
		assert (this.addresses.size() > 0);
	}
	/**
	 * 
	 */
	public Client(String name, ArrayList<String[]> addresses) {
		if (name != null && Pattern.matches(nameRegex, name))
			this.name = name;
		else
			throw new IllegalArgumentException("Client\'s name must be a String of at least 3 characters");
		if (addresses.size() == 0)
			throw new IllegalArgumentException("Client must have at least 1 associated address");
		
		for (String[] s : addresses) {
			this.addNewAddress(s);
		}
		assert (this.addresses.size() > 0);

		
		this.id = NextID;
		NextID++;
		DataAdapter.addClient(this);
	}
}