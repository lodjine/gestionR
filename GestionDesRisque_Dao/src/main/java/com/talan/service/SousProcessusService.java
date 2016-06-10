package com.talan.service;

import java.util.List;

import com.talan.entities.SousProcessus;
import com.talan.entities.Utilisateur;

public interface SousProcessusService {

	
	public List<SousProcessus> getAll();
	public SousProcessus getById(int id);
	public void persist(SousProcessus ssPro);
	public void update(SousProcessus ssPro);
	public void delete(SousProcessus ssPro);
	public int save(SousProcessus ssPro);
}
