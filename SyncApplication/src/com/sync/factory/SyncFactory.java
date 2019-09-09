package com.sync.factory;

import com.sync.services.DataService;

public class SyncFactory {

	private DataService service;

	public SyncFactory(DataService service) {
		this.service = service;
	}

	public void process() {
		service.convert();
		service.sync();
	}
}
