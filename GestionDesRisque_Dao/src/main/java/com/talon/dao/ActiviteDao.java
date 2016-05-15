package com.talon.dao;

import java.util.List;

import com.talon.entities.Action;
import com.talon.entities.Activité;

public interface ActiviteDao {

	public List<Activité> getAll();
	public Activité getById(int id);
	public void persist(Activité activité);
	public void update(Activité activité);
	public void delete(Activité activité);
	public void save(Activité activité);
}
