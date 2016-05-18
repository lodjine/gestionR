package com.talon.dao;

import java.util.List;

import com.talon.entities.Action;
import com.talon.entities.Activite;

public interface ActiviteDao {

	public List<Activite> getAll();
	public Activite getById(int id);
	public void persist(Activite activit�);
	public void update(Activite activit�);
	public void delete(Activite activit�);
	public void save(Activite activit�);
}
