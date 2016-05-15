package com.talon.dao;

import java.util.List;

import com.talon.entities.AnalyseDesRisques;
import com.talon.entities.Classification;

public interface ClassificationDao {
	
	
	public List<Classification> getAll();
	public Classification getById(int id);
	public void persist(Classification classi);
	public void update(Classification classi);
	public void delete(Classification classi);
	public void save(Classification classi);
}
