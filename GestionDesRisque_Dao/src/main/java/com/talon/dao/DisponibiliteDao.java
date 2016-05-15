package com.talon.dao;

import java.util.List;

import com.talon.entities.Confidentialité;
import com.talon.entities.Disponibilité;

public interface DisponibiliteDao {

	
	public List<Disponibilité> getAll();
	public Disponibilité getById(int id);
	public void persist(Disponibilité dispo);
	public void update(Disponibilité dispo);
	public void delete(Disponibilité dispo);
	public void save(Disponibilité dispo);
}
