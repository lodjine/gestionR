package com.talon.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vulnerabilite implements Serializable{

	
	
	@Id
	private int vulnId;
	
	private String VulnLabel;
	
	private int value;

	public int getVulnId() {
		return vulnId;
	}

	public void setVulnId(int vulnId) {
		this.vulnId = vulnId;
	}

	public String getVulnLabel() {
		return VulnLabel;
	}

	public void setVulnLabel(String vulnLabel) {
		VulnLabel = vulnLabel;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}
