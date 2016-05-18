package com.talon.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SousProcessus implements Serializable {
	@Id
	private int sspId;
	
	
	private String sousProcessus;
	
	private String description;
	
	
	@ManyToOne
	private Processus processus;
	
	@OneToMany(mappedBy="subprocess")
	private List<Activite> activites;
}
