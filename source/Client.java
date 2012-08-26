import java.util.regex.*;

/*
 * 
 */
class Client {
	static private long NextID = 0;
	static String nameRegex = "^(\\w)+ ((\\w)+)+$"; // Clients must be identified by atleast 2 words
	final long id;
	String name;

	/*
	 * 
	 */
	public Client(String name) {
		if (name != null && Pattern.matches(nameRegex, name))
			this.name = name;
		else
			throw new IllegalArgumentException("\'Name\' must be a String of at least 3 characters");
		this.id = NextID;
		NextID++;
	}
}