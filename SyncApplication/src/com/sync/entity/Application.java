package com.sync.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sync.abstracts.AbstractObject;

public class Application extends AbstractObject {
	
	private String appNo;

	private String branchCode;

	private String regionCode;

	private String docNo;

	public String getAppNo() {
		return appNo;
	}

	@JsonProperty("ApplicationNo")
	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}

	public String getBranchCode() {
		return branchCode;
	}

	@JsonProperty("BranchCode")
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getRegionCode() {
		return regionCode;
	}

	@JsonProperty("RegionCode")
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getDocNo() {
		return docNo;
	}

	@JsonProperty("DocumentNo")
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	@Override
	@JsonIgnore
	public void setDetails(String details) {
		// TODO Auto-generated method stub
		System.out.println("Application: " + details);
		setAppNo(details.substring(0, 10));
		setBranchCode(details.substring(10, 14));
	}
}
