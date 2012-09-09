import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;

/**
 * Gui and associated methods for a transport manager to interact with lost and potentially lost packages
 *
 * Duncan Willcock 1159081
 */
public class TransportManagerSession extends JFrame {
    private Employee user;
    private JTextField jTextDate;
    private JButton jButtonOldPackages;
    private JButton jButtonSetLost;
    private JButton jButtonSetFound;
    private JButton jButtonShowLost;
    private JButton jButtonExit;
    private JButton jButtonReset;
    private JList jListPackages;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JList jListScans;
    private ArrayList<Package> packages;
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("ddMMyyyykkmm");
    private Calendar queryTime = new GregorianCalendar();

    /** 
     * Creates a session associated with a Transport Manager user.
     */
    public TransportManagerSession(Employee user) {
        if (user == null || user.role != EmployeeRoles.TransportManager)
            throw new IllegalArgumentException();
        this.user = user;
        initComponents();
        reset(null);
    }

    /**
    * GUI element creating and arrangment.
    * Partially generated using NetBeans IDE GUI utilities.
    */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jButtonOldPackages = new JButton();
        jTextDate = new JTextField();
        jButtonSetLost = new JButton();
        jButtonSetFound = new JButton();
        jButtonShowLost = new JButton();
        jButtonExit = new JButton();
        jButtonReset = new JButton();
        jScrollPane1 = new JScrollPane();
        jListScans = new JList();
        jScrollPane2 = new JScrollPane();
        jListPackages = new JList();

        jButtonSetFound.setEnabled(false);
        jButtonSetLost.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonOldPackages.setText("Timed out packages");
        jButtonOldPackages.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                buttonOldPackagesActionPerformed(event);
            }
        });

        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                jListPackagesActionPertformed(event);
            }
        };

        jButtonExit.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               System.exit(0);
          }
       });

        jButtonSetLost.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               buttonSetLostActionPerformed(event);
          }
       });

        jButtonSetFound.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               buttonSetFoundActionPerformed(event);
          }
       });

        jButtonShowLost.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               buttonShowLostActionPerformed(event);
          }
       });

        jButtonReset.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               reset(event);
          }
       });
        
    jListPackages.addListSelectionListener(listSelectionListener);
        
        jButtonSetLost.setText("List as Lost");
        jButtonShowLost.setText("Lost Packages");
        jButtonSetFound.setText("List as Found");
        jButtonExit.setText("Logout");
        jButtonReset.setText("Reset");

        jScrollPane2.setViewportView(jListPackages);
        jScrollPane2.setPreferredSize(new Dimension(200,200));
        jListPackages.setFixedCellWidth(400);

        jScrollPane1.setViewportView(jListScans);
        // Layout 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSetLost, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonOldPackages, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonShowLost, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSetFound, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jTextDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOldPackages)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSetLost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSetFound)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonShowLost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExit))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }

    /**
     * Requests and displays all packages older than the date in the text field
     */
    private void buttonOldPackagesActionPerformed(ActionEvent event) {
        try {
            queryTime.setTime(dateFormatter.parse(jTextDate.getText().replace("-", "") + "2359"));
            this.packages = DataAdapter.getOlderPackages(queryTime);
            jListPackages.setListData(new Vector(this.packages)); 
            jButtonSetLost.setEnabled(this.packages.size() > 0);
            jButtonSetFound.setEnabled(false);
            jListScans.setListData(new Vector());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Invalid date entered");
        }

    }

    /**
     * Handles selected index change for the packages Jlist. Dsiplays the scan history of the selected package in the scans JList.
     */
    private void jListPackagesActionPertformed(ListSelectionEvent event) {
        int index = jListPackages.getSelectedIndex();
        if (index >= 0)
            jListScans.setListData(new Vector(this.packages.get(index).scanHistory));            
    }

    /**
     * adds lost scan to a package
     */
    private void buttonSetLostActionPerformed(ActionEvent event) {
        int index = jListPackages.getSelectedIndex();
        if (index >= 0) {
            Package p = this.packages.get(index);
            if(p.lastScan().event != ScanEvents.lost) {
                p.scan(ScanEvents.lost, this.user);
                this.packages.remove(p);
                this.jListPackages.setListData(new Vector(this.packages));
                jListScans.setListData(new Vector());
            }
        }
    }

    /**
     * adds a found scan to a seleceted lost package
     */
    private void buttonSetFoundActionPerformed(ActionEvent event) {
        int index = jListPackages.getSelectedIndex();
        if (index >= 0) {
            Package p = this.packages.get(index);
            if(p.lastScan().event == ScanEvents.lost) {
                p.scan(ScanEvents.found, this.user);
                this.packages.remove(p);
                this.jListPackages.setListData(new Vector(this.packages));
                jListScans.setListData(new Vector());
            }
        }
    }

    /**
     * Requests the list of all lost packages
     */
    private void buttonShowLostActionPerformed(ActionEvent event) {
        this.packages = DataAdapter.getLostPackages();
        this.jListPackages.setListData (new Vector(this.packages));
        jButtonSetLost.setEnabled(false);
        jButtonSetFound.setEnabled(this.packages.size() > 0);
        jListScans.setListData(new Vector());
    }

    /**
     * Resets controls to their initial state
     */
    private void reset (ActionEvent event) {
        this.queryTime.setTime(new Date());
        String day = String.format("%02d", queryTime.get(queryTime.DAY_OF_MONTH));
        String month = String.format("%02d", queryTime.get(queryTime.MONTH) + 1);
        jTextDate.setText(day + "-" + month + "-" + queryTime.get(queryTime.YEAR));

        this.jButtonSetFound.setEnabled(false);
        this.jButtonSetLost.setEnabled(false);
        this.jListPackages.setListData(new Vector());
        this.jListScans.setListData(new Vector());  
    }
}
