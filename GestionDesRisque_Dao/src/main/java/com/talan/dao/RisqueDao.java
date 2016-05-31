package com.talan.dao;

import java.util.List;

import com.talan.entities.Risque;

public interface RisqueDao {

	
	public List<Risque> getAll();
	public Risque getById(int id);
	public int persist(Risque risque);
	public void update(Risque risque);
	public void delete(Risque risque);
	public void save(Risque risque);
}
