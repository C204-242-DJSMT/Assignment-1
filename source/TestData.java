import java.util.*;
class TestData {
	public static void init(){
		ArrayList<String[]> addresses = new ArrayList<String[]>();
		String[] address = {"10 sdfsu fhu", "3025", "Hamilton"};
		addresses.add(address);
		Client c1 = new Client("Duncan Willcock",addresses);
		Package p = new Package(c1, null, "jsfdsjhdjhshdj", "sjfdbsjbdjs", "ajjdhbajdahhd", "sjbjsbdjgsgdjsgjdgjgsdjgsdgsjd", false);

		Employee e1 = new Employee(EmployeeRoles.Driver, "dmkw1");

		p.scan(ScanEvents.takeFromVehicle, e1);
	}
}