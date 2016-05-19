package com.talon.service;

import java.util.List;

import com.talon.entities.Processus;

public interface ProcessService {
	public List<Processus> getAll();
	public Processus getById(int id);
	public void persist(Processus ssPro);
	public void update(Processus ssPro);
	public void delete(Processus ssPro);
	public void save(Processus ssPro);
}
