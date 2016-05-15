package com.talon.service;

import java.util.List;

import com.talon.entities.Activité;
import com.talon.entities.Administrateur;

public interface AdiministrateurService {
	public List<Administrateur> getAll();
	public Administrateur getById(int id);
	public void persist(Administrateur admin);
	public void update(Administrateur admin);
	public void delete(Administrateur admin);
	public void save(Administrateur admin);
}
