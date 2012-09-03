import java.util.*;
class TestData {
	public static void init(){
		ArrayList<String[]> addresses = new ArrayList<String[]>();
		String[] address = {"10 sdfsu fhu", "3025", "Hamilton"};
		addresses.add(address);
		Client c0 = new Client("Duncan Willcock",addresses);
		Client c1 = new Client("client one",addresses);
		Client c2 = new Client("client two",addresses);
		Client c3 = new Client("client three",addresses);
		Package p0 = new Package(c1, null, "jsfdsjhdjhshdj", "sjfdbsjbdjs", "ajjdhbajdahhd", "sjbjsbdjgsgdjsgjdgjgsdjgsdgsjd", false);
		Package p1 = new Package(c0, null, "jsfdsjhdjhshdj", "sjfdbsjbdjs", "ajjdhbajdahhd", "sjbjsbdjgsgdjsgjdgjgsdjgsdgsjd", false);
		Package p2 = new Package(c2, null, "jsfdsjhdjhshdj", "sjfdbsjbdjs", "ajjdhbajdahhd", "sjbjsbdjgsgdjsgjdgjgsdjgsdgsjd", true);
		Package p3 = new Package(c3, null, "jsfdsjhdjhshdj", "sjfdbsjbdjs", "ajjdhbajdahhd", "sjbjsbdjgsgdjsgjdgjgsdjgsdgsjd", false);
		Package p4 = new Package(c0, null, "jsfdsjhdjhshdj", "sjfdbsjbdjs", "ajjdhbajdahhd", "sjbjsbdjgsgdjsgjdgjgsdjgsdgsjd", false);

		Employee e1 = new Employee(EmployeeRoles.TransportManager, "dmkw1", "test001");
		Employee e2 = new Employee(EmployeeRoles.Sorter, "test0", "0test002");
		Employee e3 = new Employee(EmployeeRoles.Sorter, "test1", "1test003");

		p0.scan(ScanEvents.takeFromVehicle, e1);
		p1.scan(ScanEvents.addToVehicle, e1);
		p2.scan(ScanEvents.pickUp, e1);
		p3.scan(ScanEvents.dropOff, e1);
		p4.scan(ScanEvents.addToBin, e1);

		//System.out.println("done");
	}
}