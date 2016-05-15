package com.talon.service;

import java.util.List;

import com.talon.entities.SousProcessus;
import com.talon.entities.Utilisateur;

public interface SousProcessusService {

	
	public List<SousProcessus> getAll();
	public SousProcessus getById(int id);
	public void persist(SousProcessus ssPro);
	public void update(SousProcessus ssPro);
	public void delete(SousProcessus ssPro);
	public void save(SousProcessus ssPro);
}
