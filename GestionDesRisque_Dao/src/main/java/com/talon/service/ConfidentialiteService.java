package com.talon.service;

import java.util.List;

import com.talon.entities.Classification;
import com.talon.entities.Confidentialit�;

public interface ConfidentialiteService {

	
	
	public List<Confidentialit�> getAll();
	public Confidentialit� getById(int id);
	public void persist(Confidentialit� conf);
	public void update(Confidentialit� conf);
	public void delete(Confidentialit� conf);
	public void save(Confidentialit� conf);
}
