import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;


/**
 * 
 * 
 * Duncan Willcock
 */
public class TransportManagerSession extends JFrame {
    private Employee user;
    private JButton btnOldPackages;
    private JButton jButtonSetLost;
    private JButton jButtonSetFound;
    private JButton jButtonShowLost;
    private JButton jButtonExit;
    private JList jListPackages;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JList jListScans;
    private ArrayList<Package> packages;

    /** 
     *
     *
     * Duncan Willcock
     */
    public TransportManagerSession(Employee user) {
        if (user == null || user.role != EmployeeRoles.TransportManager)
            throw new IllegalArgumentException();
        this.user = user;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {
        btnOldPackages = new JButton();
        jButtonSetLost = new JButton();
        jButtonSetFound = new JButton();
        jButtonExit = new JButton();
        jScrollPane1 = new JScrollPane();
        jListScans = new JList();
        jScrollPane2 = new JScrollPane();
        jListPackages = new JList();

        jButtonSetFound.setEnabled(false);
        jButtonSetLost.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnOldPackages.setText("Timed out packages");
        btnOldPackages.addActionListener(new ActionListener() {
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
               buttonSetLostActionPerformed(event);
          }
       });
    jListPackages.addListSelectionListener(listSelectionListener);
        
        jButtonSetLost.setText("List as Lost");
        jButtonSetFound.setText("List as Found");
        jButtonExit.setText("Logout");

        jScrollPane2.setViewportView(jListPackages);
        jScrollPane2.setPreferredSize(new Dimension(200,200));
        jListPackages.setFixedCellWidth(400);

        jScrollPane1.setViewportView(jListScans);

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
                    .addComponent(jButtonSetLost, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOldPackages, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSetFound, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnOldPackages)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSetLost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSetFound)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExit))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     *
     * Duncan Willcock
     */
    private void buttonOldPackagesActionPerformed(ActionEvent event) {
        Calendar c = new GregorianCalendar();
                c.setTime(new Date());
                this.packages = DataAdapter.getOlderPackages(c);
                jListPackages.setListData(new Vector(this.packages)); 
    }

    /**
     *
     *
     * Duncan Willcock
     */
    private void jListPackagesActionPertformed(ListSelectionEvent event) {
        int index = jListPackages.getSelectedIndex();
        if (index >= 0) {
            jListScans.setListData(new Vector(this.packages.get(index).scanHistory));
            this.jButtonSetLost.setEnabled(true);
        }
        else 
            this.jButtonSetLost.setEnabled(true);

    }

    /**
     *
     *
     * Duncan Willcock
     */
    private void buttonSetLostActionPerformed(ActionEvent event) {
        int index = jListPackages.getSelectedIndex();
        if (index >= 0) {
            Package p = this.packages.get(index);
            if(p.lastScan().event != ScanEvents.lost) {
                p.scan(ScanEvents.lost, this.user);
                this.packages.remove(p);
                this.jListPackages.setListData(new Vector(this.packages));
            }
        }
    }

    /**
     *
     *
     * Duncan Willcock
     */
    private void buttonSetFoundActionPerformed(ActionEvent event) {
        int index = jListPackages.getSelectedIndex();
        if (index >= 0) {
            Package p = this.packages.get(index);
            if(p.lastScan().event == ScanEvents.lost)
                p.scan(ScanEvents.found, this.user);
        }
    }
}
