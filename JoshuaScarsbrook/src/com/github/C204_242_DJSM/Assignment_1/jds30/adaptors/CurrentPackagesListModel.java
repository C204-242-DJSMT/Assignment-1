package com.github.C204_242_DJSM.Assignment_1.jds30.adaptors;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import external.*;

public class CurrentPackagesListModel implements ListModel<String> {
	private ArrayList<String> _items = new ArrayList<String>();
	
	public CurrentPackagesListModel() {
		loadAllFromDataAdaptor();
	}
	
	private void loadAllFromDataAdaptor() {
		_items.clear();
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

}
