import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author Janik
 */
public class SorterSession extends javax.swing.JFrame {

    private ArrayList<PackageBin> packageBins;
    private static Employee user;

    /**
     * Creates new form SorterForm
     */
    public SorterSession(Employee user) {
        if (user == null || user.role != EmployeeRoles.Sorter)
            throw new IllegalArgumentException();
        this.user = user;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        BinsLabel = new javax.swing.JLabel();
        DestinationLabel = new javax.swing.JLabel();
        NewDestinationText = new javax.swing.JTextField();
        CreateButton = new javax.swing.JButton();
        PackagesLabel = new javax.swing.JLabel();
        MovetoVehicleButton = new javax.swing.JButton();
        AddtoBinButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        PackageBinList = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        PackageList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ListSelectionListener listSelectionListener1 = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                PackageListActionPertformed(event);
            }
        };

        ListSelectionListener listSelectionListener2 = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                PackageBinListActionPertformed(event);
            }
        };

        BinsLabel.setText("Bins");

        DestinationLabel.setText("Destination");

        CreateButton.setText("Create New Bin");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        PackagesLabel.setText("Packages");

        MovetoVehicleButton.setText("Move onto Vehicle");
        MovetoVehicleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MovetoVehicleButtonActionPerformed(evt);
            }
        });

        AddtoBinButton.setText("Add to Bin");
        AddtoBinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddtoBinButtonActionPerformed(evt);
            }
        });

        RemoveButton.setText("Remove from Vehicle");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        PackageBinList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "(none)" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(PackageBinList);

        PackageList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "(none)" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(PackageList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RefreshButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(AddtoBinButton))
                                    .addComponent(PackagesLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BinsLabel)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DestinationLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NewDestinationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CreateButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MovetoVehicleButton)
                                .addGap(18, 18, 18)
                                .addComponent(RemoveButton)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AddtoBinButton, CreateButton, MovetoVehicleButton, NewDestinationText, RefreshButton, RemoveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RefreshButton)
                .addGap(18, 18, 18)
                .addComponent(DestinationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewDestinationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RemoveButton)
                    .addComponent(MovetoVehicleButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BinsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(AddtoBinButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PackagesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void PackageListActionPertformed(ListSelectionEvent event) { 
    
    }

    private void PackageBinListActionPertformed(ListSelectionEvent event) { 
    
    }

    private void MovetoVehicleButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        // Moving the bin onto the Delivery vehicle
        // Change the scan history of the Bin and all the packages in it
        int index = PackageBinList.getSelectedIndex();  
        if (index >= 0) {
            PackageBin b = this.packageBins.get(index);
            if(b.lastScan().event != ScanEvents.addToVehicle) {
                b.scan(ScanEvents.addToVehicle, this.user);
                this.packageBins.remove(b);
                this.PackageBinList.setListData(new Vector(this.packageBins));
            }
        }

    }                                              

    private void AddtoBinButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
        // Adding Selected Package to selected Bin

        int indexPackage = PackageList.getSelectedIndex();
        int indexBin = PackageBinList.getSelectedIndex();

        // if (indexPackage >= 0){
        //     this.pid = packagelist.get(indexPackage).id;
        // }
        // if (indexPackageBin >= 0){
        //     this.bid = packagebinlist.get(indexBin).id;
        // }

            
        // add selectedPackage into selectedBin
    }                                                   

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        // Creates new bin with entered destination
    }                                            

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        int index = PackageBinList.getSelectedIndex();  
    }                                            

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        PackageList.setListData(new Vector(DataAdapter.getUndeliveredPackages()));
        PackageBinList.setListData(new Vector(DataAdapter.getAllBin()));
    }                                             

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SorterSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SorterSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SorterSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SorterSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SorterSession(user).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JButton AddtoBinButton;
    private javax.swing.JLabel BinsLabel;
    private javax.swing.JButton CreateButton;
    private javax.swing.JLabel DestinationLabel;
    private javax.swing.JButton MovetoVehicleButton;
    private javax.swing.JTextField NewDestinationText;
    private javax.swing.JList PackageBinList;
    private javax.swing.JList PackageList;
    private javax.swing.JLabel PackagesLabel;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
     private ArrayList<PackageBin> packagebinlist;
     private ArrayList<Package> packagelist;
    // End of variables declaration
}