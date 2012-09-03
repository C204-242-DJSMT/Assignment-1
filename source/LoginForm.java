/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package loginss;

/**
 *
 * @author NT
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
    }
    Employee user;


     public void NextPage() {
        switch (user.role) {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        //test.init.
        label_username = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        button_login = new javax.swing.JButton();
        button_close = new javax.swing.JButton();
        textbox_username = new javax.swing.JTextField();
        textbox_password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_username.setText("Username");

        label_password.setText("Password");

        button_login.setText("Login");
        button_login.setToolTipText("");
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_loginActionPerformed(evt);
            }
        });

        button_close.setText("Close");
        button_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_password)
                                .addGap(18, 18, 18)
                                .addComponent(textbox_password))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_username)
                                .addGap(18, 18, 18)
                                .addComponent(textbox_username, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_close)
                            .addComponent(button_login))))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_username)
                    .addComponent(textbox_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_password)
                    .addComponent(textbox_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addComponent(button_login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(button_close)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>

    private void button_loginActionPerformed(java.awt.event.ActionEvent evt) {
        
        String usrnme=textbox_username.getText();
        String pwd= new String (textbox_password.getPassword());
         Employee user = DataAdapter.verifyEmployee(usrnme, pwd);
       if (user != null){
            if (user.role == EmployeeRoles.TransportManager) {
                //this.setVisible(false);
                new TransportManagerSession().setVisible(true);
            }
            else {System.out.println("s");}
         }
         else 
            System.out.println("not found");
       
    }

    private void button_closeActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        TestData.init();
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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new LoginForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JButton button_close;
    private javax.swing.JButton button_login;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_username;
    private javax.swing.JPasswordField textbox_password;
    private javax.swing.JTextField textbox_username;
    // End of variables declaration
}
