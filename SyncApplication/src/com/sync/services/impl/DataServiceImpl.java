package com.sync.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sync.abstracts.AbstractObject;
import com.sync.services.DataService;

public class DataServiceImpl implements DataService {

	private AbstractObject object;

	private String jsonMsg;

	/**
	 * 
	 * @param object
	 * @param details
	 */
	public DataServiceImpl(AbstractObject object, String details) {
		this.object = object;
		// Action will be set in Abstract Object
		this.object.setAction(details);
		// Details will be set in Runtime object
		this.object.setDetails(details);
	}

	/**
	 * Send JSON String message to 3rd party via HTTP
	 */
	@Override
	public void sync() {
		System.out.println("sending json message start..." + jsonMsg);
	}

	/**
	 * Method that converts Object to JSON String
	 */
	@Override
	public void convert() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonMsg = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

}
