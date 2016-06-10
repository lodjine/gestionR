package com.talan.service;

import java.util.List;

import com.talan.entities.Action;
import com.talan.entities.Activite;

public interface ActiviteService {

	public List<Activite> getAll();
	public Activite getById(int id);
	public void persist(Activite activité);
	public void update(Activite activité);
	public void delete(Activite activité);
	public int save(Activite activité);
}
