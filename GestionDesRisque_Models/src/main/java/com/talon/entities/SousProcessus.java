package com.talon.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SousProcessus implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sspId;

	
	

	private String sousProcessus;
	
	private String description;
	
	
	@ManyToOne
	private Processus processus;
	
	@OneToMany(mappedBy="subprocess")
	private List<Activite> activites;

	public int getSspId() {
		return sspId;
	}
	public void setSspId(int sspId) {
		this.sspId = sspId;
	}
	
	public String getSousProcessus() {
		return sousProcessus;
	}
	public void setSousProcessus(String sousProcessus) {
		this.sousProcessus = sousProcessus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Processus getProcessus() {
		return processus;
	}
	public void setProcessus(Processus processus) {
		this.processus = processus;
	}
	public List<Activite> getActivites() {
		return activites;
	}
	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}
	
	

}
