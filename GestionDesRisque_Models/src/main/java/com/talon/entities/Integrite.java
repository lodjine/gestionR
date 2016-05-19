package com.talon.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Integrite {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int integId;
	
	@OneToMany
	private List<MesureEx> mesures;
	@OneToMany
	private List<Vulnerabilite> vulnerabs;
	@OneToMany
	private List<ImpactC> impacts;
	
	private int Resultat;
}
