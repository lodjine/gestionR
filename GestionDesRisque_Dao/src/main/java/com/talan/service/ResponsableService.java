package com.talan.service;

import java.util.List;

import com.talan.entities.Responsable;
import com.talan.entities.Risque;

public interface ResponsableService {

	

	public List<Responsable> getAll();
	public Responsable getById(int id);
	public void persist(Responsable resp);
	public void update(Responsable resp);
	public void delete(Responsable resp);
	public void save(Responsable resp);
}
