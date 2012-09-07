import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Mathew Andela
 */
class Driver extends Employee {
    
	//stores the drivers vehicle id 
	private String vehicleID;
	
        /*
         * Creates an instances of the driver
         */
	public Driver(String v, String u, String p) {
		super(EmployeeRoles.Driver,u, p);
                //checks if the vehicle id is between 7 & 6 characters
                //throws exception if it isn't
		setVehicleID(v);
	}

        /*
         * Sets vehicleID if driver changes their vehicle
         */
        public final void setVehicleID(String v){
            assert(v != null);
            if(v.length()>7 || v.length()<6){
			throw new IllegalArgumentException("Vehicle ID must be 6 or 7 characters.");
		}
		else{			
		vehicleID = v;
		}
        }
        
        
        
	/*
	 * Gets all the packages in the drivers vehicle to be delivered and picked up
	 */
	public ArrayList<Package> getVehicleManifest() {
		try{
                //Creates a list of type packages
		ArrayList<Package> packages = new ArrayList<>();
                ArrayList<Package> temp;
                //Gets all the bins that are in the drivers vehicle
		ArrayList<PackageBin> bins = DataAdapter.getBinByVehicle(vehicleID);
                //checks if there is any bins in the vehicle
		if(bins == null || bins.isEmpty()){
			return null;
		}
		else{	
                    /*
                     * Cycles through all packages in the bins
                     * Adds them to our list of packages
                     */
			for(PackageBin b: bins){
                                assert (b.contents.size() > 0);
                                temp = b.contents;
				for(Package p: temp){
					packages.add(p);
				}
			}			
		}	
                /*
                 * Gets a list of packages requiring pick up
                 * And adds them to our list of packages
                 */
                temp = DataAdapter.getPackagePickUp();
			if(temp != null && !temp.isEmpty()){
				for(Package p: temp){
					packages.add(p);
				}			
			}
                        //returns the list of packages
			return packages;
	}	
	catch(Exception e){
		System.err.println(e.getMessage());
		return null;
	}
	}
        
         /*
     * Method for creating the manifest file
     */
	public void createFile(){
		try{
                    //creates a writer and gathers the vehicle information
		BufferedWriter writer = new BufferedWriter(new FileWriter("Manifest.txt"));
		ArrayList<Package> list = getVehicleManifest();
                
                //format for file
		String header = "Package ID" + "\t" + "Street Address" + "\t" + "\t" +  "City" + "\t" + "Status";                
		writer.write("To Deliver:");
                writer.newLine();
		writer.write(header);
                writer.newLine();
                writer.newLine();
                //Writes all packages to be delivered by driver in first section of file
		writefile(writer, false, list);
                writer.newLine();
 		writer.write("To Pick Up:");
                writer.newLine();
 		writer.write(header);
                writer.newLine();
                writer.newLine();
                //Writes all packages to be picked up in second section of file
 		writefile(writer, true, list);
                //Closes writer and flushes data 
                writer.flush();
                writer.close();
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
	
        /*
         * Writes packages in list to the file
         */
	private static void writefile(BufferedWriter w, boolean s, ArrayList<Package> list) throws IOException{
		try{
			//checks if there is stuff in the lists
			if(list != null){
                            /*
                             * Cycles through pacakges in list
                             * gathers required information and writes to file
                             * creates a new line
                             */
				for(Package p: list){
                                       if(p.awaitingPickup == s){
						String status;
						if(s == true){
							status = "Pick Up";
						}
						else{
							status = "Deliver";
						}
                                                assert(p.id > 0 && p.streetAddress != null && p.destinationCity != null);
						String line = String.valueOf(p.id) + "\t" + p.streetAddress + "\t" + p.destinationCity + "\t" + status;
						w.write(line);
						w.newLine();
					}
				}	
			}
			
		}
                //Cathces any IO exceptions and general execptions
		catch(IOException ex){
			System.err.println("Error in writing to file");
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
        
}