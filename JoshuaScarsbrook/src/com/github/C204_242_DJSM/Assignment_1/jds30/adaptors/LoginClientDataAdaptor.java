package com.github.C204_242_DJSM.Assignment_1.jds30.adaptors;

import java.util.ArrayList;

import external.*;

import com.github.C204_242_DJSM.Assignment_1.jds30.models.ClientLoginSupport;
import com.github.C204_242_DJSM.Assignment_1.jds30.models.ClientPrivilegeLevel;

public class LoginClientDataAdaptor {
	
	ArrayList<ClientLoginSupport> _loginClients = new ArrayList<>();
	
	public LoginClientDataAdaptor() {
		ArrayList<String[]> clientAddressTest = new ArrayList<>();
		clientAddressTest.add(new String[] {
			"Testing",
			"1231",
			"Hello World"
		});
		Client testingCli = new Client("Hello World", clientAddressTest, false);
		DataAdapter.addClient(testingCli);
		linkClientToLoginClient(testingCli, "testing", ClientPrivilegeLevel.FULLMANAGER);
	}
	
	// static methods
	
	public ArrayList<ClientLoginSupport> getLoginClientsByName(String _username) {
		ArrayList<ClientLoginSupport> ret = new ArrayList<>();
		for (ClientLoginSupport client : _loginClients) {
			if (client.getName().equals(_username)) {
				ret.add(client);
			}
		}
		return ret;
	}
	
	public void linkClientToLoginClient(Client cli, String password, ClientPrivilegeLevel level) {
		System.out.println("Linking Clients");
		_loginClients.add(new ClientLoginSupport(cli.getName(), cli.getAddresses(), password, level));
	}
	
	private static LoginClientDataAdaptor _instance;
	
	public static LoginClientDataAdaptor getInstance() {
		if (_instance == null) {
			_instance = new LoginClientDataAdaptor();
		}
		return _instance;
	}
	
}
