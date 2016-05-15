package com.talon.service;

import java.util.List;

import com.talon.entities.Disponibilité;
import com.talon.entities.Intégrité;

public interface IntegriteService {

	
	public List<Intégrité> getAll();
	public Intégrité getById(int id);
	public void persist(Intégrité integ);
	public void update(Intégrité integ);
	public void delete(Intégrité integ);
	public void save(Intégrité integ);
}
