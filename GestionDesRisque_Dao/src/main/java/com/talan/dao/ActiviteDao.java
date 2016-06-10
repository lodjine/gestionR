package com.talan.dao;

import java.util.List;

import com.talan.entities.Action;
import com.talan.entities.Activite;

public interface ActiviteDao {

	public List<Activite> getAll();
	public Activite getById(int id);
	public void persist(Activite activité);
	public void update(Activite activité);
	public void delete(Activite activité);
	public int save(Activite activité);
}
