import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package loginsssss;

/**
 * 
 * @author Nigel Thomas
 */

/**
 * Gui and associated methods for the Account Manager
 * 
 * 
 */
public class AccountManagerSession extends javax.swing.JFrame {

    /**
     * Creates new form AccountManagerSession
     */
    public AccountManagerSession() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        button_get = new javax.swing.JButton();
        label_clientname = new javax.swing.JLabel();
        textbox_clientname = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        listbox_clients = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        listbox_address = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        listbox_package = new javax.swing.JList();
        label_client = new javax.swing.JLabel();
        label_address = new javax.swing.JLabel();
        label_package = new javax.swing.JLabel();

        // jList1.setModel(new javax.swing.AbstractListModel() {
        // String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5"
        // };
        // public int getSize() { return strings.length; }
        // public Object getElementAt(int i) { return strings[i]; }
        // });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button_get.setText("Get ");
        button_get.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_getActionPerformed(evt);
            }
        });

        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                jListPackagesActionPertformed(event);
            }
        };
        ListSelectionListener listSelectionListener1 = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                listbox_packagesActionPertformed(event);
            }
        };
        listbox_clients.addListSelectionListener(listSelectionListener);
        listbox_address.addListSelectionListener(listSelectionListener1);

        label_clientname.setText("Client Name");

        // listbox_clients.setModel(new javax.swing.AbstractListModel() {
        // String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5"
        // };
        // public int getSize() { return strings.length; }
        // public Object getElementAt(int i) { return strings[i]; }
        // });
        jScrollPane3.setViewportView(listbox_clients);

        // listbox_address.setModel(new javax.swing.AbstractListModel() {
        // String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5"
        // };
        // public int getSize() { return strings.length; }
        // public Object getElementAt(int i) { return strings[i]; }
        // });
        jScrollPane4.setViewportView(listbox_address);

        // listbox_package.setModel(new javax.swing.AbstractListModel() {
        // String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5"
        // };
        // public int getSize() { return strings.length; }
        // public Object getElementAt(int i) { return strings[i]; }
        // });
        jScrollPane5.setViewportView(listbox_package);

        label_client.setText("Clients");

        label_address.setText("Address");

        label_package.setText("Package");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
                getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(
                                                                                        jScrollPane3,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        207,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(
                                                                                        label_client))
                                                                .addGap(18, 18,
                                                                        18)
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(
                                                                                        jScrollPane4,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        194,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(
                                                                                        label_address))
                                                                .addGap(18, 18,
                                                                        18)
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(
                                                                                        jScrollPane5,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        196,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(
                                                                                        label_package)))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGap(38, 38,
                                                                        38)
                                                                .addComponent(
                                                                        label_clientname)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(
                                                                        textbox_clientname,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        65,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(32, 32,
                                                                        32)
                                                                .addComponent(
                                                                        button_get,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        63,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(55, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(label_clientname)
                                                .addComponent(
                                                        textbox_clientname,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button_get))
                                .addGap(59, 59, 59)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(label_package)
                                                .addComponent(label_client)
                                                .addComponent(label_address))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(
                                                        jScrollPane4,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        344,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(
                                                        jScrollPane5,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        354,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(
                                                        jScrollPane3,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        344,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(82, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    /**
     * Gets the Client name or any alphabet from the textbox_clientname and
     * displays all the clients associated in the clients list box
     */
    private void button_getActionPerformed(java.awt.event.ActionEvent evt) {

        String name = textbox_clientname.getText();
        clientlist = DataAdapter.findName(name);
        listbox_clients.setListData(new Vector(this.clientlist));
    }

    /**
     * gets the client name from list box of clients and displays all the
     * addresses that that particular cleint has
     */
    private void jListPackagesActionPertformed(ListSelectionEvent event) {

        Vector v = new Vector();
        // Gets the selected index
        int index = listbox_clients.getSelectedIndex();
        if (index >= 0)

            this.addresses = clientlist.get(index).addresses;
        Vector<String> formattedAddresses = new Vector<String>();
        // Formats
        for (String[] s : this.addresses) {
            String line;
            assert (s.length == 3);
            line = s[0] + " " + s[1] + " " + s[2];
            formattedAddresses.add(line);
            // adds the formattedAddresses into listbox_address
            listbox_address.setListData(formattedAddresses);
        }

    }

    /**
     * gets the address from list box of addresses and displays all the packages
     * that are being sent to that particular address in the listbox packages
     * 
     */
    private void listbox_packagesActionPertformed(ListSelectionEvent event) {

        Vector<Package> temp = new Vector<Package>();
        ArrayList<Package> packagess;
        // gets index
        int index = listbox_address.getSelectedIndex();
        int otherindex = listbox_clients.getSelectedIndex();

        if (index >= 0) {
            // calls getPackagebyAddress method
            String[] address = this.addresses.get(index);
            packagess = DataAdapter.getPackageByAddress(
                    clientlist.get(otherindex), address);

            // loops through packagess and puts it into listbox_package
            for (Package p : packagess) {
                temp.add(p);
            }
            listbox_package.setListData(temp);
        }
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed"
        // desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase
         * /tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(
                    AccountManagerSession.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(
                    AccountManagerSession.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(
                    AccountManagerSession.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(
                    AccountManagerSession.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountManagerSession().setVisible(true);
            }
        });
    }

    /*
     * global variable for this form Stores clientlist info Stores addresses
     * info
     */
    // Variables declaration - do not modify
    private javax.swing.JButton button_get;
    private javax.swing.JButton jButton1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel label_address;
    private javax.swing.JLabel label_client;
    private javax.swing.JLabel label_clientname;
    private javax.swing.JLabel label_package;
    private javax.swing.JList listbox_address;
    private javax.swing.JList listbox_clients;
    private javax.swing.JList listbox_package;
    private javax.swing.JTextField textbox_clientname;
    private ArrayList<Client> clientlist;
    private ArrayList<String[]> addresses;
    // End of variables declaration
}
