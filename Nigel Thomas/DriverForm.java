import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Mathew Andela
 */
public class DriverForm extends javax.swing.JFrame {
    
    /*
     * global variable for this form
     * Stores list info
     * stores driver info
    */
    static Vector<String> data = new Vector<String>();
    static Driver driver;
       
    /**
     * Creates new form DriverForm
     */
    public DriverForm(Driver d) {
        if(d != null){
          driver = d;
          initComponents();  
        }
        else
            throw new IllegalArgumentException("Driver needs to be specified");      
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listbox = new javax.swing.JList();
        buttonUpdate = new javax.swing.JButton();
        buttonfile = new javax.swing.JButton();
        buttonLogOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(listbox);

        buttonUpdate.setText("Update");
        buttonUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUpdateMouseClicked(evt);
            }
        });

        buttonfile.setText("Create File");
        buttonfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonfileMouseClicked(evt);
            }
        });

        buttonLogOut.setText("Log Out");
        buttonLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLogOutMouseClicked(evt);
            }
        });

        jLabel1.setText("Package ID");

        jLabel2.setText("Street Address");

        jLabel3.setText("City");

        jLabel4.setText("Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(buttonfile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonLogOut)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUpdate)
                    .addComponent(buttonfile)
                    .addComponent(buttonLogOut))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 /*
 * Updates the list of packages
 */    
    private void buttonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateMouseClicked
       UpdateTable();
    }//GEN-LAST:event_buttonUpdateMouseClicked

   /*
    * Creates a file of the manifest
    */
    private void buttonfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonfileMouseClicked
       driver.createFile();
    }//GEN-LAST:event_buttonfileMouseClicked

    /*
     * Logs out of the driver section
     */
    private void buttonLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLogOutMouseClicked
        /*         
         * login.show();
         */
        System.exit(0);
    }//GEN-LAST:event_buttonLogOutMouseClicked

    /*
     * Method for updating the list on the UI for the manifest
     */
    private void UpdateTable(){
		try{
                        //Gets all packages scheduled for pickup and delivery
			ArrayList<Package> list = driver.getVehicleManifest();  
                        assert(data != null);
                        data.clear();                       
                        //If no packages to be pickup and delivered displays appropriate message
			if(list == null){				
				listbox.clearSelection();
                                data.add("No Packages");                                
                                listbox.setListData(data);
			}
			else{	
                            //clears things in the Jlist and sets up a counter
                            listbox.clearSelection();
				int n = 0;
                                /*
                                 * goes through each package in the list
                                 * gathers the required information and adds it to an string array 
                                 * increments counter
                                 */
				while(n < list.size()){
					String status = "";
					if(list.get(n).awaitingPickup == true){
						status = "Pick Up";
					}
					else{
						status = "Deliver";
					}
                                        assert(list.get(n).id > 0 && list.get(n).streetAddress != null && list.get(n).destinationCity != null);
					String line = String.valueOf(list.get(n).id) + "\t" + list.get(n).streetAddress + "\t" + list.get(n).destinationCity 
							+ "\t" + status;
					data.add(line);
					n++;
				}
                                //creates a new JList containg the pacakge information
				listbox.setListData(data);
				
			}
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
	
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DriverForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DriverForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DriverForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DriverForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //Creates a new driver and creates the manifest file
        driver = new Driver("ABC123", "bts2", "gds443");
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DriverForm(driver).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogOut;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JButton buttonfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listbox;
    // End of variables declaration//GEN-END:variables
}
