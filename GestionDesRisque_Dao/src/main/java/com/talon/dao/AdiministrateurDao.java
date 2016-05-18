package com.talon.dao;

import java.util.List;

import com.talon.entities.Activite;
import com.talon.entities.Administrateur;

public interface AdiministrateurDao {
	public List<Administrateur> getAll();
	public Administrateur getById(int id);
	public void persist(Administrateur admin);
	public void update(Administrateur admin);
	public void delete(Administrateur admin);
	public void save(Administrateur admin);
}
