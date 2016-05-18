package com.talon.service;

import java.util.List;

import com.talon.entities.Disponibilite;
import com.talon.entities.Integrite;

public interface IntegriteService {

	
	public List<Integrite> getAll();
	public Integrite getById(int id);
	public void persist(Integrite integ);
	public void update(Integrite integ);
	public void delete(Integrite integ);
	public void save(Integrite integ);
}
