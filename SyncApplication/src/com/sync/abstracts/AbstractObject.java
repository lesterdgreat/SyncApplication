package com.sync.abstracts;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sync.utilities.Constants;

public abstract class AbstractObject {

	protected String action;

	public abstract void setDetails(String details);

	@JsonProperty("Method")
	public void setAction(String details) {
		if (details.startsWith(Constants.METHOD_INSERT)) {
			action = Constants.ACTION_INSERT;
		} else if (details.startsWith(Constants.METHOD_DELETE)) {
			action = Constants.ACTION_DELETE;
		} else if (details.startsWith(Constants.METHOD_UPDATE)) {
			action = Constants.ACTION_UPDATE;
		}
	}

	public String getAction() {
		return action;
	}
}
