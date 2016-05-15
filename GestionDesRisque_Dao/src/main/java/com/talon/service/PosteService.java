package com.talon.service;

import java.util.List;

import com.talon.entities.Poste;
import com.talon.entities.Responsable;

public interface PosteService {

	
	public List<Poste> getAll();
	public Poste getById(int id);
	public void persist(Poste poste);
	public void update(Poste poste);
	public void delete(Poste poste);
	public void save(Poste poste);
}
