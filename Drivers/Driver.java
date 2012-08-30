import java.util.ArrayList;

/*
 * 
 */
class Driver extends Employee {
	/*
	 * 
	 */
	public String vehicleID;
	
	public Driver(String v) {
		super(EmployeeRoles.Driver);	
		if(v.length()>7 || v.length()<6){
			throw new IllegalArgumentException("Vehicle ID must be 6 or 7 characters.");
		}
		else{			
		vehicleID = v;
		}
	}

	/*
	 * 
	 */
	public ArrayList<Package> getVehicleManifest() {
		try{
		ArrayList<Package> packages = new ArrayList<Package>();
		ArrayList<PackageBin> bins = DataAdapter.getBinByVehicle(vehicleID);
		if(bins == null){
			return null;
		}
		else{
			ArrayList<Package> temp;
			for(PackageBin b: bins){
				temp = b.contents;
				for(Package p: temp){
					packages.add(p);
				}
			}
			temp = DataAdapter.getPackagePickUp();
			if(temp != null){
				for(Package p: temp){
					packages.add(p);
				}			
			}
			return packages;
		}		
	}	
	catch(Exception e){
		System.err.println(e.getMessage());
		return null;
	}
	}
}