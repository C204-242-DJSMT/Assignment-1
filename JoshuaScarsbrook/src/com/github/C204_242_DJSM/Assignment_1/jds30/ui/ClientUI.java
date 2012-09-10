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
import com.github.C204_242_DJSM.Assignment_1.jds30.session.ClientSession.ClientPrivileges;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.AbstractListModel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2940065613694823984L;
	
	private ClientSession _session;

	/**
	 * ClientUI Constructor
	 */
	public ClientUI(ClientSession ses) {
		super("Client UI"); // TODO better title
		
		_session = ses;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(640, 480);
		this.setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Welcome", null, panel, null);
		panel.setLayout(null);
		
		JTextPane txtpnwelcome = new JTextPane();
		txtpnwelcome.setContentType("text/html");
		txtpnwelcome.setText("<html>\r\n<body>\r\n\t<h1 style=\"font-size: 48px; text-align: center;font-family:sans-serif;\">Welcome</h1>\r\n</body>\r\n</html>");
		txtpnwelcome.setBounds(10, 5, 609, 407);
		panel.add(txtpnwelcome);
		
		JPanel userManagerPane = new JPanel();
		tabbedPane.addTab("User Manager", null, userManagerPane, null);
		userManagerPane.setLayout(null);
		
		JList<String> clientList = new JList<>();
		clientList.setBounds(10, 11, 190, 391);
		userManagerPane.add(clientList);
		
		JButton userCreateUpdateButton = new JButton("Create \\ Update");
		userCreateUpdateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		userCreateUpdateButton.setBounds(210, 379, 116, 23);
		userManagerPane.add(userCreateUpdateButton);
		
		JButton userDeleteButton = new JButton("Delete");
		userDeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		userDeleteButton.setBounds(530, 379, 89, 23);
		userManagerPane.add(userDeleteButton);
		
		JLabel lblUserUsername = new JLabel("Username");
		lblUserUsername.setBounds(210, 12, 66, 14);
		userManagerPane.add(lblUserUsername);
		
		JTextField txtUserUsername = new JTextField();
		txtUserUsername.setBounds(293, 11, 316, 20);
		userManagerPane.add(txtUserUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(210, 190, 66, 14);
		userManagerPane.add(lblPassword);
		
		JLabel lblUserPrivlages = new JLabel("User Privlages");
		lblUserPrivlages.setBounds(210, 218, 89, 14);
		userManagerPane.add(lblUserPrivlages);
		
		JComboBox<String> cboxUserPrivlages = new JComboBox<>();
		cboxUserPrivlages.setModel(new DefaultComboBoxModel<String>(new String[] {"Full Manager", "Manager", "Employee"}));
		cboxUserPrivlages.setBounds(293, 215, 316, 20);
		userManagerPane.add(cboxUserPrivlages);
		
		passUserPassword = new JPasswordField();
		passUserPassword.setBounds(293, 187, 316, 23);
		userManagerPane.add(passUserPassword);
		
		JLabel lblUserAddresses = new JLabel("Addresses");
		lblUserAddresses.setBounds(210, 37, 72, 14);
		userManagerPane.add(lblUserAddresses);
		
		JComboBox<String> cboxUserAddress = new JComboBox<>();
		cboxUserAddress.setBounds(293, 34, 316, 20);
		userManagerPane.add(cboxUserAddress);
		
		JLabel lblUserStreetAddress = new JLabel("Street Address");
		lblUserStreetAddress.setBounds(293, 65, 81, 14);
		userManagerPane.add(lblUserStreetAddress);
		
		JTextField txtUserStreetAddress = new JTextField();
		txtUserStreetAddress.setBounds(384, 59, 225, 20);
		userManagerPane.add(txtUserStreetAddress);
		
		JLabel lblUserPostcode = new JLabel("Postcode");
		lblUserPostcode.setBounds(293, 96, 81, 14);
		userManagerPane.add(lblUserPostcode);
		
		JTextField txtUserPostcode = new JTextField();
		txtUserPostcode.setBounds(384, 90, 225, 20);
		userManagerPane.add(txtUserPostcode);
		
		JLabel lblUserCity = new JLabel("City");
		lblUserCity.setBounds(293, 127, 81, 14);
		userManagerPane.add(lblUserCity);
		
		JTextField txtUserCity = new JTextField();
		txtUserCity.setBounds(384, 121, 225, 20);
		userManagerPane.add(txtUserCity);
		
		JButton btnUserAddressDelete = new JButton("Delete");
		btnUserAddressDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnUserAddressDelete.setBounds(520, 153, 89, 23);
		userManagerPane.add(btnUserAddressDelete);
		
		JButton btnUserAddressUpdate = new JButton("Create \\ Update");
		btnUserAddressUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnUserAddressUpdate.setBounds(394, 153, 116, 23);
		userManagerPane.add(btnUserAddressUpdate);
		
		JPanel passwordManagerPane = new JPanel();
		tabbedPane.addTab("Personal Settings", null, passwordManagerPane, null);
		passwordManagerPane.setLayout(null);
		
		JPanel passwordManagerPane2 = new JPanel();
		passwordManagerPane2.setBounds(191, 137, 252, 118);
		passwordManagerPane.add(passwordManagerPane2);
		passwordManagerPane2.setLayout(null);
		
		JLabel lblPassCurrent = new JLabel("Current Password");
		lblPassCurrent.setBounds(10, 11, 94, 14);
		passwordManagerPane2.add(lblPassCurrent);
		
		JLabel lblPassNew = new JLabel("New Password");
		lblPassNew.setBounds(10, 36, 94, 14);
		passwordManagerPane2.add(lblPassNew);
		
		JLabel lblPassConfirm = new JLabel("Confirm Password");
		lblPassConfirm.setBounds(10, 61, 94, 14);
		passwordManagerPane2.add(lblPassConfirm);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnChangePassword.setBounds(123, 84, 119, 23);
		passwordManagerPane2.add(btnChangePassword);
		
		passPassCurrent = new JPasswordField();
		passPassCurrent.setBounds(114, 8, 128, 20);
		passwordManagerPane2.add(passPassCurrent);
		
		passPassNew = new JPasswordField();
		passPassNew.setBounds(114, 33, 128, 20);
		passwordManagerPane2.add(passPassNew);
		
		passPassConfirm = new JPasswordField();
		passPassConfirm.setBounds(114, 58, 128, 20);
		passwordManagerPane2.add(passPassConfirm);
		
		JPanel packageManagerPane = new JPanel();
		tabbedPane.addTab("Package Manager", null, packageManagerPane, null);
		packageManagerPane.setLayout(null);
		
		JList<String> packageList = new JList<>();
		packageList.setBounds(10, 11, 190, 401);
		packageManagerPane.add(packageList);
		
		JButton btnPackageSend = new JButton("Send");
		btnPackageSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnPackageSend.setBounds(530, 389, 89, 23);
		packageManagerPane.add(btnPackageSend);
		
		JLabel lblPackageReturnAddress = new JLabel("Return Address");
		lblPackageReturnAddress.setBounds(210, 12, 96, 14);
		packageManagerPane.add(lblPackageReturnAddress);
		
		JLabel lblPackageTargetAddress = new JLabel("Target Address");
		lblPackageTargetAddress.setBounds(210, 37, 96, 14);
		packageManagerPane.add(lblPackageTargetAddress);
		
		JLabel lblPackageStreetAddress = new JLabel("Street Address");
		lblPackageStreetAddress.setBounds(316, 37, 78, 14);
		packageManagerPane.add(lblPackageStreetAddress);
		
		txtPackageStreetAddress = new JTextField();
		txtPackageStreetAddress.setBounds(404, 34, 215, 20);
		packageManagerPane.add(txtPackageStreetAddress);
		txtPackageStreetAddress.setColumns(10);
		
		JLabel lblPackagePostCode = new JLabel("Postcode");
		lblPackagePostCode.setBounds(316, 65, 78, 14);
		packageManagerPane.add(lblPackagePostCode);
		
		txtPackagePostCode = new JTextField();
		txtPackagePostCode.setColumns(10);
		txtPackagePostCode.setBounds(404, 62, 215, 20);
		packageManagerPane.add(txtPackagePostCode);
		
		JLabel lblPackageCity = new JLabel("City");
		lblPackageCity.setBounds(316, 93, 78, 14);
		packageManagerPane.add(lblPackageCity);
		
		txtPackageCity = new JTextField();
		txtPackageCity.setColumns(10);
		txtPackageCity.setBounds(404, 90, 215, 20);
		packageManagerPane.add(txtPackageCity);
		
		JComboBox<String> cboxPackageReturnAddress = new JComboBox<>();
		cboxPackageReturnAddress.setBounds(316, 9, 303, 20);
		packageManagerPane.add(cboxPackageReturnAddress);
		
		JLabel lblPackageStatus = new JLabel("Package Status");
		lblPackageStatus.setBounds(210, 123, 96, 14);
		packageManagerPane.add(lblPackageStatus);
		
		JList<String> packageStatusList = new JList<>();
		packageStatusList.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = -5646358450388813726L;
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		packageStatusList.setBounds(316, 122, 303, 254);
		packageManagerPane.add(packageStatusList);
		
		if (!_session.hasPrivilege(ClientPrivileges.CHANGEPASSWORD)) {
			tabbedPane.setEnabledAt(2, false);
		}
		
		if (!_session.hasPrivilege(ClientPrivileges.CHECKPACKAGES)) {
			tabbedPane.setEnabledAt(3, false);
		}
		
		if (!_session.hasPrivilege(ClientPrivileges.LISTUSERS)) {
			tabbedPane.setEnabledAt(1, false);
		}
		
	}
	
	private JPasswordField passUserPassword;
	private JPasswordField passPassCurrent;
	private JPasswordField passPassNew;
	private JPasswordField passPassConfirm;
	private JTextField txtPackageStreetAddress;
	private JTextField txtPackagePostCode;
	private JTextField txtPackageCity;
	
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