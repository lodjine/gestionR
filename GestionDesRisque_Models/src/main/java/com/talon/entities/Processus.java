package com.talon.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Processus implements Serializable {

	
	@Id
	private int procId;
	
	private String processus;
	
	private String description;
	
	@OneToMany(mappedBy="processus")
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
	
	
	
	
}
