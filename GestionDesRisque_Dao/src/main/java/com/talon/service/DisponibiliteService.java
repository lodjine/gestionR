package com.talon.service;

import java.util.List;

import com.talon.entities.Confidentialite;
import com.talon.entities.Disponibilite;

public interface DisponibiliteService {

	
	public List<Disponibilite> getAll();
	public Disponibilite getById(int id);
	public void persist(Disponibilite dispo);
	public void update(Disponibilite dispo);
	public void delete(Disponibilite dispo);
	public void save(Disponibilite dispo);
	public int merge(Disponibilite disp );
}
