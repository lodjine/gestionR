package com.talon.service;

import java.util.List;

import com.talon.entities.Confidentialit�;
import com.talon.entities.Disponibilit�;

public interface DisponibiliteService {

	
	public List<Disponibilit�> getAll();
	public Disponibilit� getById(int id);
	public void persist(Disponibilit� dispo);
	public void update(Disponibilit� dispo);
	public void delete(Disponibilit� dispo);
	public void save(Disponibilit� dispo);
}
