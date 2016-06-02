package com.talan.service;

import java.util.List;

import com.talan.entities.Confidentialite;
import com.talan.entities.Integrite;

public interface ConfidentialiteService {

	
	
	public List<Confidentialite> getAll();
	public Confidentialite getById(int id);
	public void persist(Confidentialite conf);
	public void update(Confidentialite conf);
	public void delete(Confidentialite conf);
	public void save(Confidentialite conf);
	public int merge(Confidentialite conf) ; 
	public List<Confidentialite> getAllByProc(int id, int debut , int fin);
}
