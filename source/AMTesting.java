import java.util.*;

import org.junit.Test;
import org.junit.Before;

import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class AMTesting {
	ArrayList<Package> packages = new ArrayList<Package>();
	private static ArrayList<String> employeePasswords = new ArrayList<String>();
	static String[] address = { "10 foo st", "3025", "Hamilton" };
	static String[] address1 = { "10 foo st 3025 Hamilton" };
	private static ArrayList<Employee> allEmployees = new ArrayList<Employee>();

	// Calendar testTime = new GregorianCalendar();

	// setup a small, simple set of data data to run tests on
	@Before
	public void init() throws InterruptedException {
		if (DataAdapter.getPackageByID(0) == null) {
			ArrayList<String[]> addresses = new ArrayList<String[]>();

			addresses.add(address);
			Client c0 = new Client("Duncan Willcock", addresses);
			Client c1 = new Client("client one", addresses);
			Client c2 = new Client("client two", addresses);
			Client c3 = new Client("client three", addresses);
			packages.add(new Package(c1, null, "street1", "postcode1", "CITY1",
					"return1", false));
			packages.add(new Package(c0, null, "street2", "postcode3", "CITY2",
					"return3", false));
			packages.add(new Package(c2, null, "street3", "postcode3", "CITY4",
					"return4", true));

			packages.add(new Package(c3, null, "street6", "postcode5", "CITY4",
					"return2", false));
			packages.add(new Package(c0, null, "street4", "postcode5", "CITY6",
					"return1", false));

			Employee e1 = new Employee(EmployeeRoles.TransportManager, "dmkw1",
					"test001");
			Employee e2 = new Employee(EmployeeRoles.Sorter, "test0", "test002");
			Employee e3 = new Employee(EmployeeRoles.Sorter, "test1", "test003");

			// Scans need noticably differnet time stamps so comparisons can be
			// effectively tested
			packages.get(0).scan(ScanEvents.takeFromVehicle, e1);
			// Thread.sleep(1000);
			packages.get(1).scan(ScanEvents.addToVehicle, e1);
			// Thread.sleep(1000);
			packages.get(2).scan(ScanEvents.pickUp, e1);
			// Thread.sleep(1000);
			packages.get(3).scan(ScanEvents.dropOff, e1);
			// Thread.sleep(1000);
			packages.get(4).scan(ScanEvents.addToBin, e1);
			// Thread.sleep(1000);

		}
		
	}

	

	// 3 tests for findname method
	@Test(expected = IllegalArgumentException.class)
	public void test2() {

		DataAdapter.findName(null);
	}

	@Test
	public void test4() {
		assertTrue(DataAdapter.findName("c").size() == 3);
	}

	@Test
	public void test5() {
		assertTrue(DataAdapter.findName("M").size() == 0);
	}

	// 4 tests for getPackageByAddress method
	@Test
	public void test6() {

		DataAdapter.getPackageByAddress(DataAdapter.getClientByID(0), address);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test7() {

		DataAdapter.getPackageByAddress(null, address);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test8() {

		DataAdapter.getPackageByAddress(DataAdapter.getClientByID(0), address1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test1() {

		DataAdapter.getPackageByAddress(DataAdapter.getClientByID(0), null);
	}

	// test constructor 
	@Test
	public void test3() {
		new AccountManagerSession();
	}

	// 4 tests for verifyEmployee
	@Test(expected = IllegalArgumentException.class)
	public void test9() {
		DataAdapter.verifyEmployee("dmkw1", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test10() {
		DataAdapter.verifyEmployee(null, "null");
	}

	@Test
	public void test11() {
		assertTrue(DataAdapter.verifyEmployee("dmkw1", "test001") == DataAdapter
				.getEmployeeByID(0));
	}

	@Test
	public void test12() {
		assertTrue(DataAdapter.verifyEmployee("dmkw1", "test0") == null);
	}

}
