package com.github.C204_242_DJSM.Assignment_1.jds30.session;

import java.util.HashMap;

public class ClientSession {

	private enum ClientPrivilegeLevel {
		FULLMANAGER,
		DEBUG // TODO REMOVE ME
	}
	
	public enum ClientPrivileges {
		SENDPACKAGE,
		CHANGEPASSWORD
	}
	
	private HashMap<ClientSession.ClientPrivileges, Boolean> _privileges = new HashMap<ClientSession.ClientPrivileges, Boolean>();
	
	private ClientSession(ClientSession.ClientPrivilegeLevel level) {
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
	
	/**
	 * Creates a new session with full privileges
	 * TODO REMOVE ME
	 * @return A valid client session
	 */
	public static ClientSession CreateDummySession() {
		return new ClientSession(ClientSession.ClientPrivilegeLevel.DEBUG);
	}
}
