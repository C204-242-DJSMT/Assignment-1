package com.github.C204_242_DJSM.Assignment_1.jds30.exceptions;

import com.github.C204_242_DJSM.Assignment_1.jds30.session.ClientSession;

public class NotPrivException extends Exception {
	private ClientSession.ClientPrivileges _privilege;
	
	public NotPrivException(ClientSession.ClientPrivileges priv) {
		_privilege = priv;
	}
	
	public ClientSession.ClientPrivileges getSource() {
		return _privilege;
	}
}
