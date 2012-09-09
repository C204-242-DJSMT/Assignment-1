package com.github.C204_242_DJSM.Assignment_1.jds30.adaptors;

import java.util.ArrayList;

import com.github.C204_242_DJSM.Assignment_1.jds30.models.Client;
import com.github.C204_242_DJSM.Assignment_1.jds30.models.Package;
import com.github.C204_242_DJSM.Assignment_1.jds30.models.Package;

public class DataAdaptor {
	
	protected ArrayList<Package> _packages = new ArrayList<>();
	protected ArrayList<Client> _clients = new ArrayList<>();

	public ArrayList<Package> getPackagesByStatus(Package.PackageState status) {
		ArrayList<Package> ret = new ArrayList<>();
		for (Package package1 : _packages) {
			if (package1.getStatus() == status) {
				ret.add(package1);
			}
		}
		return ret;
	}
	
	public ArrayList<Client> getClientByName(String name) {
		ArrayList<Client> ret = new ArrayList<>();
		for (Client client1 : _clients) {
			if (client1.getUsername().equals(name)) {
				ret.add(client1);
			}
		}
		return ret;
	}
	
	private static DataAdaptor _instance;
	
	public static DataAdaptor getInstance() {
		if (_instance == null) {
			_instance = new DataAdaptor();
		}
		return _instance;
	}
}
