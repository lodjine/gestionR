package com.talan.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vulnerabilite implements Serializable{

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vulnId;
	
	private String vulnLabel;
	
	private int value;
	
	private String critere ; 
	@ManyToOne
	@JoinColumn(name="risk")
	private Risque risque ; 

	public String getCritere() {
		return critere;
	}

	public void setCritere(String critere) {
		this.critere = critere;
	}

	public Risque getRisque() {
		return risque;
	}

	public void setRisque(Risque risque) {
		this.risque = risque;
	}
	
	
	public int getVulnId() {
		return vulnId;
	}

	public void setVulnId(int vulnId) {
		this.vulnId = vulnId;
	}

	

	public String getVulnLabel() {
		return vulnLabel;
	}

	public void setVulnLabel(String vulnLabel) {
		this.vulnLabel = vulnLabel;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}
