package com.talon.dao;

import java.util.List;

import com.talon.entities.Action;
import com.talon.entities.Activite;

public interface ActiviteDao {

	public List<Activite> getAll();
	public Activite getById(int id);
	public void persist(Activite activité);
	public void update(Activite activité);
	public void delete(Activite activité);
	public void save(Activite activité);
}
