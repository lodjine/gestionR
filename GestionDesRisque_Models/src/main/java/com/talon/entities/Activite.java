package com.talon.entities;

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
public class Activite implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int activiteId;
	
private  String labelActivity; 
	private String description;
	
	@ManyToOne
	private SousProcessus subprocess ;
	
	@OneToMany (mappedBy="activite", fetch =  FetchType.EAGER)
	List<Information> informations ;
	
	
	

	
	public int getActiviteId() {
		return activiteId;
	}

	public void setActiviteId(int activiteId) {
		this.activiteId = activiteId;
	}

	public Activite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLabelActivity() {
		return labelActivity;
	}

	public void setLabelActivity(String labelActivity) {
		this.labelActivity = labelActivity;
	}

	
	public SousProcessus getSubprocess() {
		return subprocess;
	}

	public void setSubprocess(SousProcessus subprocess) {
		this.subprocess = subprocess;
	}

	public List<Information> getInformations() {
		return informations;
	} 


	public void setInformations(List<Information> informations) {
		this.informations = informations;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
