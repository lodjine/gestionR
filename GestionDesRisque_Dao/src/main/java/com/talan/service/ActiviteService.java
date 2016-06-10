package com.talan.service;

import java.util.List;

import com.talan.entities.Action;
import com.talan.entities.Activite;

public interface ActiviteService {

	public List<Activite> getAll();
	public Activite getById(int id);
	public void persist(Activite activit�);
	public void update(Activite activit�);
	public void delete(Activite activit�);
	public int save(Activite activit�);
}
