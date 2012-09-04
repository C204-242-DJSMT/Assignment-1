package com.github.C204_242_DJSM.Assignment_1.jds30.adaptors;

import com.github.C204_242_DJSM.Assignment_1.jds30.adaptors.dummy.DummyPackagesDataAdaptor;

public class PackagesDataAdaptor {
	
	public PackageDataQuery getPackages() {
		// placeholder
		return new PackageDataQuery();
	}
	
	public static PackagesDataAdaptor getDummyAdaptor() {
		return new DummyPackagesDataAdaptor();
	}
}
