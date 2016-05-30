package com.talan.dao;

import java.util.List;

import com.talan.entities.Administrateur;
import com.talan.entities.Alerte;

public interface AlerteDao {

	
	
	public List<Alerte> getAll();
	public Alerte getById(int id);
	public void persist(Alerte alerte);
	public void update(Alerte alerte);
	public void delete(Alerte alerte);
	public void save(Alerte alerte);
}
