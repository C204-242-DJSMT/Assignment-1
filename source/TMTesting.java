
import java.util.*;
 
import org.junit.Test;
import org.junit.Before;

import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class TMTesting {
	ArrayList<Package> packages = new ArrayList<Package>();
	Calendar testTime = new GregorianCalendar();

	// setup a small, simple set of data data to run tests on
	 @Before public void init() throws InterruptedException {
	 	if (DataAdapter.getPackageByID(0) == null) {
 			ArrayList<String[]> addresses = new ArrayList<String[]>();
 			String[] address = {"10 foo st", "3025", "Hamilton"};
 			addresses.add(address);
 			Client c0 = new Client("Duncan Willcock",addresses);
 			Client c1 = new Client("client one",addresses);
 			Client c2 = new Client("client two",addresses);
 			Client c3 = new Client("client three",addresses);
 			packages.add(new Package(c1, null, "street1", "postcode1", "CITY1", "return1", false));
 			packages.add(new Package(c0, null, "street2", "postcode3", "CITY2", "return3", false));
 			packages.add(new Package(c2, null, "street3", "postcode3", "CITY4", "return4", true));
 			
 			packages.add(new Package(c3, null, "street6", "postcode5", "CITY4", "return2", false));
 			packages.add(new Package(c0, null, "street4", "postcode5", "CITY6", "return1", false));
 	
 			Employee e1 = new Employee(EmployeeRoles.TransportManager, "dmkw1", "test001");
 			Employee e2 = new Employee(EmployeeRoles.Sorter, "test0", "test002");
 			Employee e3 = new Employee(EmployeeRoles.Sorter, "test1", "test003");
 			
 			//Scans need noticably differnet time stamps so comparisons can be effectively tested
 			packages.get(0).scan(ScanEvents.takeFromVehicle, e1);
 			Thread.sleep(1000);
 			packages.get(1).scan(ScanEvents.addToVehicle, e1);
 			Thread.sleep(1000);
 			packages.get(2).scan(ScanEvents.pickUp, e1);
 			Thread.sleep(1000);
 			packages.get(3).scan(ScanEvents.dropOff, e1);
 			Thread.sleep(1000);
 			packages.get(4).scan(ScanEvents.addToBin, e1);
 			Thread.sleep(1000);

 		}
	 	testTime.setTime(DataAdapter.getPackageByID(3).lastScan().time.getTime());

	}

	 // tests to test normal function of query methods
	 @Test public void test2() {
		DataAdapter.getOlderPackages(testTime);
	}

	// Check the right number packages are returned when using the pre calculated test time and these are the right packages
	@Test public void test3() {
		ArrayList<Package> result = DataAdapter.getOlderPackages(testTime);
		assertTrue(result.size() == 3);
		for (int i = 0; i < result.size(); i++) 
			assertTrue(result.get(i) == DataAdapter.getPackageByID(i));
	}

	// test that all 5 test packages are returned when comapring to the current time
	@Test public void test15() {
		Calendar c = new GregorianCalendar();
		c.setTime(new Date());
		ArrayList<Package> result = DataAdapter.getOlderPackages(c);
		assertTrue(result.size() == 5);
		for (int i = 0; i < result.size(); i++) 
			assertTrue(result.get(i) == DataAdapter.getPackageByID(i));

	}

	@Test public void test1() {
		
		assertTrue(DataAdapter.getPackageByID(0) != null);
	}	

	@Test public void test4() {
		testTime.setTime(new Date());
		DataAdapter.getOlderPackages(testTime);
	}

	// 3 tests to test constructor constraints
	@Test public void test5() {
		new TransportManagerSession(DataAdapter.getEmployeeByID(0));
	}

	@Test (expected=IllegalArgumentException.class) public void test6() {
		new TransportManagerSession(DataAdapter.getEmployeeByID(1));
	}

	@Test (expected=IllegalArgumentException.class) public void test7() {
		new TransportManagerSession(null);
	}

	@Test (expected=IllegalArgumentException.class) public void test10() {
		new TransportManagerSession(null);
	}

	// Test lost/found methods
	@Test (expected=IllegalArgumentException.class) public void test8() {
		DataAdapter.recordLostPackage(DataAdapter.getPackageByID(0));
	}

	@Test (expected=IllegalArgumentException.class) public void test9() {
		DataAdapter.recordFoundPackage(DataAdapter.getPackageByID(0));
	}

	@Test (expected=IllegalArgumentException.class) public void test11() {
		DataAdapter.recordLostPackage(null);
	}

	@Test (expected=IllegalArgumentException.class) public void test12() {
		DataAdapter.recordFoundPackage(null);
	}

	@Test public void test13() {
		Package p = DataAdapter.getPackageByID(1);
		Employee e = DataAdapter.getEmployeeByID(0);
		p.scan(ScanEvents.lost, e);
		DataAdapter.recordLostPackage(p);
	}

	@Test public void test14() {
		Package p = DataAdapter.getPackageByID(1);
		Employee e = DataAdapter.getEmployeeByID(0);
		p.scan(ScanEvents.lost, e);
		p.scan(ScanEvents.found, e);
		DataAdapter.recordFoundPackage(p);
	}

}
