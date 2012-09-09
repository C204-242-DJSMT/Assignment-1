package com.github.C204_242_DJSM.Assignment_1.jds30.models;

import com.github.C204_242_DJSM.Assignment_1.jds30.models.Package.PackageState;

public class Package {
	public enum PackageState {
		DELIVERED,
		INSTORAGE,
		INTRANSIT,
		ATSOURCE,
		OTHER
	}
	
	private PackageState _state = PackageState.INSTORAGE;

	public PackageState getStatus() {
		return _state;
	}
}
