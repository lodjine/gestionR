package com.talan.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Processus implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int procId;
	
	private String processus;
	
	private String description;
	
	@ManyToOne
	private Utilisateur user;
	
	@OneToMany(mappedBy="processus",fetch=FetchType.EAGER ,cascade={CascadeType.PERSIST ,CascadeType.MERGE})
	private List<SousProcessus> ssProcs;

	public int getProcId() {
		return procId;
	}

	public void setProcId(int procId) {
		this.procId = procId;
	}

	public String getProcessus() {
		return processus;
	}

	public void setProcessus(String processus) {
		this.processus = processus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SousProcessus> getSsProcs() {
		return ssProcs;
	}

	public void setSsProcs(List<SousProcessus> ssProcs) {
		this.ssProcs = ssProcs;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	
	
	
}
