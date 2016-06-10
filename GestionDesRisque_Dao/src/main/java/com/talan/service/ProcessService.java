package com.talan.service;

import java.util.List;

import com.talan.entities.Processus;
import com.talan.entities.Utilisateur;

public interface ProcessService {
	public List<Processus> getAll(Utilisateur user);
	public Processus getById(int id);
	public void persist(Processus ssPro);
	public void update(Processus ssPro);
	public void delete(Processus ssPro);
	public int save(Processus ssPro);
}
