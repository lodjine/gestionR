package com.talon.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Poste {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int posteId;
}
