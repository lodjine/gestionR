package com.talan.dao;

import java.util.List;

import com.talan.entities.Processus;
import com.talan.entities.Utilisateur;


public interface ProcessDao {
	public List<Processus> getAll(Utilisateur user);
	public Processus getById(int id);
	public void persist(Processus ssPro);
	public void update(Processus ssPro);
	public void delete(Processus ssPro);
	public void save(Processus ssPro);
}
