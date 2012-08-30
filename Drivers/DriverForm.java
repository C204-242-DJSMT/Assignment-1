import java.util.*;
import java.awt.*;
import javax.swing.*;

class DriverForm{
	
	
	//ArrayList<Package> manifest = new ArrayList<Package>();
	static Driver driver = null;
	static String[] names = {"Package ID", "Street Address", "City", "Status"};
	static String[][] data = null;
	static JPanel panel;
	static JTable table;
	/*
	 * for creating a new form at employee login
	 * n/a in this part of fuctions in main method instead
	public DriverForm(Driver d){
		if(d != null){
			driver = d;
			createGUI();		
		}
		else
			throw new IllegalArgumentException("A driver must be specified");
	}
	*/
	
	/*
	 * creates the UI for the drivers to see their manifests
	 */
	private static void createGUI(){
		try{
		//Creates the frame of the form
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setBackground(Color.WHITE);
		frame.setVisible(true);
		//Creates a panel
		panel = new JPanel();
		
		//Creates the table for the form and adds to frame
		table = new JTable(data, names);
		table.setLocation(10,10);
		panel.add(table);
		frame.add(panel);
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
	
	
	public static void main(String[] args){
		driver = new Driver("ABC1234");
		createGUI();
		UpdateTable();
	}
	
	private static void UpdateTable(){
		ArrayList<Package> list = driver.getVehicleManifest();
		if(list == null){
			table.setVisible(false);
			Label l = new Label("No Packages in Vehicle");
			panel.add(l);
			//l.setLocation(panel.Width/2, panel.Height/2);
			l.setVisible(true);
		}
		else{
			int n = 0;
			while(n < list.size()){
				data[n][0] = String.valueOf(list.get(n).id);
				data[n][1] = list.get(n).streetAddress;
				data[n][2] = list.get(n).destinationCity;
				data[n][3] = list.get(n).status;
				n++;
			}
			table = new JTable(data, names);
			table.setVisible(true);
		}
	}
	
}