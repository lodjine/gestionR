package com.talan.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Disponibilite {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int DispId;
	
	@OneToMany
	private List<MesureEx> mesures;
	@OneToMany
	private List<Vulnerabilite> vulnerabs;
	@OneToMany
	private List<ImpactC> impacts;
	
	private int Resultat;
}
