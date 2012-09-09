package com.github.C204_242_DJSM.Assignment_1.jds30.session;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.C204_242_DJSM.Assignment_1.jds30.adaptors.LoginClientDataAdaptor;
import com.github.C204_242_DJSM.Assignment_1.jds30.models.ClientLoginSupport;
import com.github.C204_242_DJSM.Assignment_1.jds30.models.ClientPrivilegeLevel;
import com.github.C204_242_DJSM.Assignment_1.jds30.session.ClientLoginResponce.SuccessState;
import com.github.C204_242_DJSM.Assignment_1.jds30.ui.ClientUI;
import com.sun.org.apache.xpath.internal.operations.Bool;

import external.Client;
import external.DataAdapter;

public class ClientSession {

	private ClientLoginSupport _self;
	
	public enum ClientPrivileges {
		SENDPACKAGE,
		CHANGEPASSWORD
	}
	
	private HashMap<ClientSession.ClientPrivileges, Boolean> _privileges = new HashMap<ClientSession.ClientPrivileges, Boolean>();
	
	private ClientSession(ClientLoginSupport user, ClientPrivilegeLevel level) {
		this._self = user;
		switch (level) {
		case DEBUG:
			this._privileges.put(ClientSession.ClientPrivileges.CHANGEPASSWORD, true);
			this._privileges.put(ClientSession.ClientPrivileges.SENDPACKAGE, true);
			break;
		case FULLMANAGER:
			this._privileges.put(ClientSession.ClientPrivileges.CHANGEPASSWORD, true);
			this._privileges.put(ClientSession.ClientPrivileges.SENDPACKAGE, true);
			break;
		}
	}
	
	public Boolean hasPrivilege(ClientSession.ClientPrivileges priv) {
		return _privileges.containsKey(priv) && _privileges.get(priv);
	}
	
	public ClientLoginSupport getSelf() {
		return _self;
	}
	
	/**
	 * Creates a new session with full privileges
	 * TODO REMOVE ME
	 * @return A valid client session
	 */
	public static ClientSession CreateDummySession() {
		ArrayList<String[]> clientAddressTest = new ArrayList<>();
		clientAddressTest.add(new String[] {
			"Testing",
			"1231",
			"Hello World"
		});
		return new ClientSession(new ClientLoginSupport("ERROR", clientAddressTest, "", ClientPrivilegeLevel.DEBUG), ClientPrivilegeLevel.DEBUG);
	}
	
	public static ClientSession CreateDummySession(ClientLoginSupport client) {
		return new ClientSession(client, client.getPrivLevel());
	}
	
	public static ClientLoginResponce Login(String _username, String _password) {
		LoginClientDataAdaptor ada = LoginClientDataAdaptor.getInstance();
		ArrayList<ClientLoginSupport> clients = ada.getLoginClientsByName(_username);
		if (clients.size() == 0) {
			return new ClientLoginResponce(null, SuccessState.USERNAMEINCORRECT);
		}
		ClientLoginSupport client = clients.get(0);
		if (client.checkPassword(_password)) {
			return new ClientLoginResponce(new ClientSession(client, client.getPrivLevel()), SuccessState.SUCCESS);
		} else {
			return new ClientLoginResponce(null, SuccessState.PASSWORDINCORRECT);
		}	
	}
}
