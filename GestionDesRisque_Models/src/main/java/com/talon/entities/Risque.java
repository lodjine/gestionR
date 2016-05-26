package com.talon.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Risque implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int risqueId;
	
	private String risqueLabel;

	public int getRisqueId() {
		return risqueId;
	}
	public void setRisqueId(int risqueId) {
		this.risqueId = risqueId;
	}
	public String getRisqueLabel() {
		return risqueLabel;
	}
	public void setRisqueLabel(String risqueLabel) {
		this.risqueLabel = risqueLabel;
	}
	
}
