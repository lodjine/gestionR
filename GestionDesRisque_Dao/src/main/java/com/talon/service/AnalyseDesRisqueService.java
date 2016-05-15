package com.talon.service;

import java.util.List;

import com.talon.entities.Alerte;
import com.talon.entities.AnalyseDesRisques;

public interface AnalyseDesRisqueService {
	
	
	
	public List<AnalyseDesRisques> getAll();
	public AnalyseDesRisques getById(int id);
	public void persist(AnalyseDesRisques analyseR);
	public void update(AnalyseDesRisques analyseR);
	public void delete(AnalyseDesRisques analyseR);
	public void save(AnalyseDesRisques analyseR);
}
