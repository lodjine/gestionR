package com.talon.service;

import java.util.List;

import com.talon.entities.Action;
import com.talon.entities.Activit�;

public interface ActiviteService {

	public List<Activit�> getAll();
	public Activit� getById(int id);
	public void persist(Activit� activit�);
	public void update(Activit� activit�);
	public void delete(Activit� activit�);
	public void save(Activit� activit�);
}
