package com.talan.dao;

import java.util.List;

import com.talan.entities.Poste;
import com.talan.entities.Responsable;

public interface PosteDao {

	
	public List<Poste> getAll();
	public Poste getById(int id);
	public void persist(Poste poste);
	public void update(Poste poste);
	public void delete(Poste poste);
	public void save(Poste poste);
}
