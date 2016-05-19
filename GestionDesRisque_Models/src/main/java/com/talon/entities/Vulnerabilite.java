package com.talon.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vulnerabilite implements Serializable{

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
