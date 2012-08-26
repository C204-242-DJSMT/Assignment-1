

class Client {
	static long NextID;
	final long id;

	public Client() {
		this.id = NextID;
		NextID++;
	}

}