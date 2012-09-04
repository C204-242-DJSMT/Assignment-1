package com.github.C204_242_DJSM.Assignment_1.jds30.adaptors.dummy;

import com.github.C204_242_DJSM.Assignment_1.jds30.adaptors.PackageDataQuery;
import com.github.C204_242_DJSM.Assignment_1.jds30.adaptors.PackagesDataAdaptor;

public class DummyPackagesDataAdaptor extends PackagesDataAdaptor {

	
	
	public DummyPackagesDataAdaptor() {
		
	}
	
	@Override
	public PackageDataQuery getPackages() {
		return new DummyPackageDataQuery();
	}
}
