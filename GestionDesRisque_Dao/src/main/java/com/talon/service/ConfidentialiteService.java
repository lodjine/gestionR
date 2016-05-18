package com.talon.service;

import java.util.List;

import com.talon.entities.Classification;
import com.talon.entities.Confidentialite;

public interface ConfidentialiteService {

	
	
	public List<Confidentialite> getAll();
	public Confidentialite getById(int id);
	public void persist(Confidentialite conf);
	public void update(Confidentialite conf);
	public void delete(Confidentialite conf);
	public void save(Confidentialite conf);
}
