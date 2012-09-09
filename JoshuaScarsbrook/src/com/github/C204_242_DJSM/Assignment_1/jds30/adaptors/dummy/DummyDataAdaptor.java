package com.github.C204_242_DJSM.Assignment_1.jds30.adaptors.dummy;

import com.github.C204_242_DJSM.Assignment_1.jds30.adaptors.DataAdaptor;
import com.github.C204_242_DJSM.Assignment_1.jds30.models.Client;
import com.github.C204_242_DJSM.Assignment_1.jds30.models.ClientPrivilegeLevel;

public class DummyDataAdaptor extends DataAdaptor {

	public DummyDataAdaptor() {
		this.createDummyClient(new Client("Testing", "Testing1", ClientPrivilegeLevel.FULLMANAGER));
		//this.createDummyPackage();
	}
	
	// static methods
	
	private void createDummyClient(Client client) {
		this._clients.add(client);
	}

	private static DummyDataAdaptor _instance;
	
	public static DummyDataAdaptor getInstance() {
		if (_instance == null) {
			_instance = new DummyDataAdaptor();
		}
		return _instance;
	}
	
}
