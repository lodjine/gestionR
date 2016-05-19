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
	@ManyToOne
	private Confidentialite conf;
	@ManyToOne
	private Integrite integ;
	@ManyToOne
	private Disponibilite dispo;
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
	public Confidentialite getConf() {
		return conf;
	}
	public void setConf(Confidentialite conf) {
		this.conf = conf;
	}
	public Integrite getInteg() {
		return integ;
	}
	public void setInteg(Integrite integ) {
		this.integ = integ;
	}
	public Disponibilite getDispo() {
		return dispo;
	}
	public void setDispo(Disponibilite dispo) {
		this.dispo = dispo;
	}
	
}
