package com.talan.dao;

import java.util.List;

import com.talan.entities.Classification;
import com.talan.entities.Confidentialite;

public interface ConfidentialiteDao {

	
	
	public List<Confidentialite> getAll();
	public Confidentialite getById(int id);
	public void persist(Confidentialite conf);
	public void update(Confidentialite conf);
	public void delete(Confidentialite conf);
	public void save(Confidentialite conf);
}
