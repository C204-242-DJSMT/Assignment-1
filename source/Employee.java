

class Employee {
	static long NextID;
	final long id;

	public Employee() {
		this.id = NextID;
		NextID++;
	}

}