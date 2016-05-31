package com.talan.dao;

import java.util.List;

import com.talan.entities.Alerte;
import com.talan.entities.AnalyseDesRisques;

public interface AnalyseDesRisqueDao {
	
	
	
	public List<AnalyseDesRisques> getAll();
	public AnalyseDesRisques getById(int id);
	public void persist(AnalyseDesRisques analyseR);
	public void update(AnalyseDesRisques analyseR);
	public void delete(AnalyseDesRisques analyseR);
	public void save(AnalyseDesRisques analyseR);
}
