package com.talon.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Integrite {
	@Id
	private int integId;
	
	@OneToMany
	private List<MesureEx> mesures;
	@OneToMany
	private List<Vulnerabilite> vulnerabs;
	@OneToMany
	private List<ImpactC> impacts;
	
	private int Resultat;
}
