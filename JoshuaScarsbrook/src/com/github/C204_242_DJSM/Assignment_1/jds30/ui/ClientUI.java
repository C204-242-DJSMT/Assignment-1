// ClientUI.java
// Entry point for client application
// Joshua Scarsbrook

package com.github.C204_242_DJSM.Assignment_1.jds30.ui;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;

import com.github.C204_242_DJSM.Assignment_1.jds30.adaptors.CurrentPackagesListModel;
import com.github.C204_242_DJSM.Assignment_1.jds30.adaptors.PackagesDataAdaptor;
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
		this.initControls();
	}
	
	/**
	 * Create all window controls
	 */
	private void initControls() {
		this.setLayout(new GridBagLayout());
		this.setSize(640, 480);
		
		exitButton = new JButton("Exit");
		exitButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) { }
			
			@Override
			public void mousePressed(MouseEvent e) { }
			
			@Override
			public void mouseExited(MouseEvent e) { }
			
			@Override
			public void mouseEntered(MouseEvent e) { }
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// if the button was pressed then close the window
				if (e.getButton() == MouseEvent.BUTTON1) {
					closeWindow();	
				}
			}
		});
		this.add(exitButton);
		
		currentPackagesModel = new CurrentPackagesListModel(PackagesDataAdaptor.getDummyAdaptor());
		currentPackages = new JList(currentPackagesModel);
	}
	
	private void closeWindow() {
		this.setVisible(false);
		System.exit(0);
	}
	
	// controls
	
	private JButton exitButton;
	
	private CurrentPackagesListModel currentPackagesModel;
	private JList currentPackages;
	
	// static methods

	/**
	 * Entry point for client UI
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame app = new ClientUI(ClientSession.CreateDummySession()); // TODO replace dummy session with a login window first
		app.setVisible(true);
	}
}