package com.talan.service;

import java.util.List;

import com.talan.entities.Risque;
import com.talan.entities.SousProcessus;

public interface RisqueService {

	
	public List<Risque> getAll();
	public Risque getById(int id);
	public int persist(Risque risque);
	public void update(Risque risque);
	public void delete(Risque risque);
	public void save(Risque risque);
}
