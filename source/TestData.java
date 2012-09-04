import java.util.*;
class TestData {

	

	public static ArrayList<Package> packages = new ArrayList<Package>();
	public static ArrayList<PackageBin> packagebins = new ArrayList<PackageBin>();

	public static void init(){
		ArrayList<String[]> addresses = new ArrayList<String[]>();
		String[] address = {"10 sdfsu fhu", "3025", "Hamilton"};
		addresses.add(address);
		Client c0 = new Client("Duncan Willcock",addresses);
		Client c1 = new Client("client one",addresses);
		Client c2 = new Client("client two",addresses);
		Client c3 = new Client("client three",addresses);
		packages.add(new Package(c1, null, "street", "postcode", "CITY", "return", false));
		packages.add(new Package(c0, null, "street", "postcode", "CITY", "return", false));
		packages.add(new Package(c2, null, "street", "postcode", "CITY", "return", true));
		packages.add(new Package(c3, null, "street", "postcode", "CITY", "return", false));
		packages.add(new Package(c0, null, "street", "postcode", "CITY", "return", false));

		//how to take in an array of strings
		//packagebins.add(new PackageBin("The Moon"));

		Employee e1 = new Employee(EmployeeRoles.TransportManager, "dmkw1", "test001");
		Employee e2 = new Employee(EmployeeRoles.Sorter, "test0", "0test002");
		Employee e3 = new Employee(EmployeeRoles.Sorter, "test1", "1test003");
		Employee e4 = new Employee(EmployeeRoles.AccountManager, "test5", "test005");

		packages.get(0).scan(ScanEvents.takeFromVehicle, e1);
		packages.get(1).scan(ScanEvents.addToVehicle, e1);
		packages.get(2).scan(ScanEvents.pickUp, e1);
		packages.get(3).scan(ScanEvents.dropOff, e1);
		packages.get(4).scan(ScanEvents.addToBin, e1);

		//System.out.println("done");
	}
}