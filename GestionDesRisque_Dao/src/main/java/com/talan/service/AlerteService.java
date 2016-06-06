package com.talan.service;

import java.util.List;

import com.talan.entities.Administrateur;
import com.talan.entities.Alerte;
import com.talan.entities.AlerteAction;
import com.talan.entities.AlerteRisqueFort;

public interface AlerteService {

	
	
	public List<Alerte> getAllRisque();
	public List<Alerte> getAllAction();
	public Alerte getById(int id);
	public void persist(Alerte alerte);
	public void update(Alerte alerte);
	public void delete(Alerte alerte);
	public void save(Alerte alerte);
}
