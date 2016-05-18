package com.talon.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Information {
	
	
	@Id
	private int InfId;
	
	@ManyToOne
	private Activite activite;
	
	
	private String description;
	
	private List<Risque> risques;

	public int getInfId() {
		return InfId;
	}

	public void setInfId(int infId) {
		InfId = infId;
	}

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Risque> getRisques() {
		return risques;
	}

	public void setRisques(List<Risque> risques) {
		this.risques = risques;
	}
	
	
	
}
