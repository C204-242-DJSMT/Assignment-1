// ClientUI.java
// Entry point for client application
// Joshua Scarsbrook

package com.github.C204_242_DJSM.Assignment_1.jds30.ui;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

import com.github.C204_242_DJSM.Assignment_1.jds30.adaptors.CurrentPackagesListModel;
import com.github.C204_242_DJSM.Assignment_1.jds30.session.ClientSession;

public class ClientUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2940065613694823984L;

	/**
	 * ClientUI Constructor
	 */
	public ClientUI(ClientSession ses) {
		super("Client UI"); // TODO better title
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("User Manager", null, panel, null);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 11, 190, 391);
		panel.add(list);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBounds(210, 379, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBounds(309, 379, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(210, 12, 66, 14);
		panel.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(293, 11, 316, 20);
		panel.add(textPane);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(210, 38, 66, 14);
		panel.add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("User Privlages");
		lblNewLabel_1.setBounds(210, 63, 89, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Full Manager", "Manager", "Employee"}));
		comboBox.setBounds(293, 60, 316, 20);
		panel.add(comboBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(293, 35, 316, 23);
		panel.add(passwordField);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("My Own Props", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(191, 137, 252, 118);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Current Password");
		lblNewLabel_2.setBounds(10, 11, 94, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(10, 36, 94, 14);
		panel_3.add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(10, 61, 94, 14);
		panel_3.add(lblConfirmPassword);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(123, 84, 119, 23);
		panel_3.add(btnChangePassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(114, 8, 128, 20);
		panel_3.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(114, 33, 128, 20);
		panel_3.add(passwordField_2);
		
		passwordField_3 = new JPasswordField();
		passwordField_3.setBounds(114, 58, 128, 20);
		panel_3.add(passwordField_3);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Package Manager", null, panel_1, null);
		this.initControls();
	}
	
	/**
	 * Create all window controls
	 */
	private void initControls() {
		this.setSize(640, 480);
		
		currentPackagesModel = new CurrentPackagesListModel();
		currentPackages = new JList<String>(currentPackagesModel);
	}
	
	private CurrentPackagesListModel currentPackagesModel;
	private JList<String> currentPackages;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	
	// static methods

	/**
	 * Entry point for client UI
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ClientLogin.main(args); // you should run login anyway
	}
}