package com.github.C204_242_DJSM.Assignment_1.jds30.ui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.github.C204_242_DJSM.Assignment_1.jds30.adaptors.DataAdaptor;
import com.github.C204_242_DJSM.Assignment_1.jds30.adaptors.dummy.DummyDataAdaptor;
import com.github.C204_242_DJSM.Assignment_1.jds30.models.Client;
import com.github.C204_242_DJSM.Assignment_1.jds30.session.ClientLoginResponce;
import com.github.C204_242_DJSM.Assignment_1.jds30.session.ClientSession;

public class ClientLogin extends JFrame {
	public ClientLogin() {
		
		initControls();
	}
	
	public void initControls() {
		this.setSize(320, 100);
		this.setResizable(false);
		
		paneContent = new JPanel();
		this.setContentPane(paneContent);
		paneContent.setLayout(new GridLayout(3, 2));
		
		paneContent.add(new JLabel("Username: "));
		
		txtUsername = new JTextField();
		paneContent.add(txtUsername);
		
		paneContent.add(new JLabel("Password: "));
		
		txtPassword = new JPasswordField();
		paneContent.add(txtPassword);
		
		btnExit = new JButton();
		btnExit.setText("Exit");
		paneContent.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		btnLogin = new JButton();
		btnLogin.setText("Login");
		paneContent.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				login(txtUsername.getText(), new String(txtPassword.getPassword()));
			}
		});
	}
	
	public void login(String username, String password) {
		if (username.equals("")) {
			loginError("Username is blank.");
			return;
		}
		if (password.equals("")) {
			loginError("Password is blank.");
			return;
		}
		ClientLoginResponce resp = ClientSession.Login(username, password);
		if (resp.isSuccess()) {
			ClientUI ui = new ClientUI(resp.getSession());
			ui.setVisible(true);
			this.setVisible(false);
		} else {
			switch (resp.getState()) {
			case PASSWORDINCORRECT:
				loginError("Password incorrect.");
				break;
			case USERNAMEINCORRECT:
				loginError("Username does not exist.");
				break;
			default:
				break;
			}
		}
	}
	
	private void loginError(String why) {
		JOptionPane.showMessageDialog(this, why, "Blah", JOptionPane.ERROR_MESSAGE);
		txtUsername.setText("");
		txtPassword.setText("");
	}

	private JPanel paneContent;
	
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	
	private JButton btnExit;
	private JButton btnLogin;
	
	// Static Methods
	
	public static void main(String[] args) throws InterruptedException {
		ClientLogin login = new ClientLogin();
		login.setVisible(true);
	}
}
