package com.sync.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sync.abstracts.AbstractObject;

public class CIF extends AbstractObject {
	
	private String cifNo;

	private String cifName;

	private String age;

	private String residencyStatus;

	public String getCifNo() {
		return cifNo;
	}

	@JsonProperty("CIFNo")
	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
	}

	public String getCifName() {
		return cifName;
	}

	@JsonProperty("CIFName")
	public void setCifName(String cifName) {
		this.cifName = cifName;
	}

	public String getAge() {
		return age;
	}

	@JsonProperty("Age")
	public void setAge(String age) {
		this.age = age;
	}

	public String getResidencyStatus() {
		return residencyStatus;
	}

	@JsonProperty("ResidencyStatus")
	public void setResidencyStatus(String residencyStatus) {
		this.residencyStatus = residencyStatus;
	}

	@Override
	@JsonIgnore
	public void setDetails(String details) {
		// TODO Auto-generated method stub
		System.out.println("CIF: " + details);
		setCifNo(details.substring(0, 10));
		setCifName(details.substring(10, 12));
	}
}
