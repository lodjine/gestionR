package com.talan.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("resp")
public class Responsable extends Utilisateur{

	
	@OneToMany
	private List<Processus> procs;
}


