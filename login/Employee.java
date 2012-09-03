/*
 * 
 */
enum EmployeeRoles {Driver, AccountManager, Sorter, TransportManager}

// switch 
//employee role. driver or accountmanage(me) 
 //case 

/*
 * 
 */
class Employee {
	static private long NextID = 0;

	 long id;
	EmployeeRoles role;
	 String username;


		
    
   public void NextPage() {
        switch (role) {
            case Driver:
               //DriverSession page=new DriverSession();
            //page.setVisible(true);

                break;
                    
            case AccountManager:
                //AccountManagerSession page=new AccountManagerSession();
            //page.setVisible(true);
                break;
                         
            case Sorter: 
               // SorterSession page=new SorterSession();
          //  page.setVisible(true);
            break;
                

             case TransportManager: 
             	TransportManagerSession page=new TransportManagerSession();
            page.setVisible(true);
            break;
                        
            
        }
    }
	
	 
	 
	public Employee(EmployeeRoles role, String username) {
		if (username == null || username.length() == 0) //must also check username is not already in use
			throw new IllegalArgumentException();
		this.role = role;
		this.username = username;
		this.id = NextID;
		NextID++;
		DataAdapter.addEmployee(this);
	}

}