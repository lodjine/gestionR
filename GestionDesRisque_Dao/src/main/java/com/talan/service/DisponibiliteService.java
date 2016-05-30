package com.talan.service;

import java.util.List;

import com.talan.entities.Confidentialite;
import com.talan.entities.Disponibilite;

public interface DisponibiliteService {

	
	public List<Disponibilite> getAll();
	public Disponibilite getById(int id);
	public void persist(Disponibilite dispo);
	public void update(Disponibilite dispo);
	public void delete(Disponibilite dispo);
	public void save(Disponibilite dispo);
}
