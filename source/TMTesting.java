
import java.util.*;
 
import org.junit.Test;
import org.junit.Before;

import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class TMTesting {
	ArrayList<Package> packages = new ArrayList<Package>();
	Date testTime;
	 @Before public void init() {
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
	 			testTime = new Date();
	 			packages.add(new Package(c3, null, "street", "postcode", "CITY", "return", false));
	 			packages.add(new Package(c0, null, "street", "postcode", "CITY", "return", false));
	 	
	 			Employee e1 = new Employee(EmployeeRoles.TransportManager, "dmkw1", "test001");
	 			Employee e2 = new Employee(EmployeeRoles.Sorter, "test0", "0test002");
	 			Employee e3 = new Employee(EmployeeRoles.Sorter, "test1", "1test003");
	 	
	 			packages.get(0).scan(ScanEvents.takeFromVehicle, e1);
	 			packages.get(1).scan(ScanEvents.addToVehicle, e1);
	 			packages.get(2).scan(ScanEvents.pickUp, e1);
	 			packages.get(3).scan(ScanEvents.dropOff, e1);
	 			packages.get(4).scan(ScanEvents.addToBin, e1);

	 		}

	@Test public void test1() {
		
		assertTrue(DataAdapter.getPackageByID(0) != null);
	}

	@Test public void test2() {
		DataAdapter.getOlderPackages(testTime).size();
	}

	@Test public void test3() {
		DataAdapter.getNewerPackages(testTime).size();
	}

	@Test public void test4() {
		DataAdapter.getOlderPackages(new Date()).size();
	}

	@Test public void test5() {
		assertTrue(DataAdapter.getNewerPackages(new Date()).size() == 0);
	}
	// @Test public void test6() {
	// 	//assertTrue(DataAdapter.getNewerPackages(new Date()).size() == 0);
	// 	System.out.println(DataAdapter.getOlderPackages(testTime).size());
	// }
}
