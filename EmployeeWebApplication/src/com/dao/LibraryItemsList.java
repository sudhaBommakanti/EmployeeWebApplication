package com.dao;

import java.util.ArrayList;
import java.util.List;

public class LibraryItemsList {
	
	List<LibraryList> items = new ArrayList<LibraryList>();

	public List<LibraryList> getItems() {
		return items;
	}

	public void setItems(List<LibraryList> items) {
		this.items = items;
	}

}
