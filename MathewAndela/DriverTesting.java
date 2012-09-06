
import java.util.*;
 
import org.junit.Test;
import org.junit.Before;

import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class DriverTesting {
		ArrayList<Package> packages = new ArrayList<Package>();
		String VehicleID;
		
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
	 			
	 			
	 			PackageBin bin1 = new PacakgeBin(addresses);
	 			PackageBin bin2 = new PacakgeBin(null);
	 			PackageBin bin3 = new PacakgeBin();	 			
	 			
	 			Driver d1 = new Driver("ABN3422", "test1", "test11");
	 			Driver d2 new Driver("vb2341a", "test2", "0test12");
	 			driver d3 new Driver("123456", "test3, ""44test2");
	 			
	 			packages.get(0).scan(ScanEvents.takeFromVehicle, e1);
	 			packages.get(1).scan(ScanEvents.addToVehicle, e1);
	 			packages.get(2).scan(ScanEvents.pickUp, e1);
	 			packages.get(3).scan(ScanEvents.dropOff, e1);
	 			packages.get(4).scan(ScanEvents.addToBin, e1);
	 			
	 			for(Package p: packages){
	 				bin1.add(p, d1);
	 			}
	 			
	 			
	 		}

	@Test public void test1() {
		
		assertTrue(DataAdapter.getPackageByID(0) != null);
	}

	@Test public void test2() {
		DataAdapter.getBinByVehicleID(vehicleID).size();
	}

	@Test public void test3() {
		DataAdapter.getPackagePickUp().size();
	}

	@Test public void test4() {
		DataAdapter.getBinByVehicleID(vehicleID).get(0).contents.size();
	}

}
