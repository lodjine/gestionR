package com.talon.dao;

import java.util.List;

import com.talon.entities.Classification;
import com.talon.entities.Confidentialité;

public interface ConfidentialiteDao {

	
	
	public List<Confidentialité> getAll();
	public Confidentialité getById(int id);
	public void persist(Confidentialité conf);
	public void update(Confidentialité conf);
	public void delete(Confidentialité conf);
	public void save(Confidentialité conf);
}
