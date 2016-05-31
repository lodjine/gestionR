package com.talon.dao;

import java.util.List;

import com.talon.entities.Risque;
import com.talon.entities.SousProcessus;

public interface RisqueDao {

	
	public List<Risque> getAll();
	public Risque getById(int id);
	public int persist(Risque risque);
	public void update(Risque risque);
	public void delete(Risque risque);
	public void save(Risque risque);
}
