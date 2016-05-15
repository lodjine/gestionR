package com.talon.service;

import java.util.List;

import com.talon.entities.Administrateur;
import com.talon.entities.Alerte;

public interface AlerteService {

	
	
	public List<Alerte> getAll();
	public Alerte getById(int id);
	public void persist(Alerte alerte);
	public void update(Alerte alerte);
	public void delete(Alerte alerte);
	public void save(Alerte alerte);
}
