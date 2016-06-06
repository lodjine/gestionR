package com.talan.dao;

import java.util.List;

import com.talan.entities.Tracabilite;

public interface TracabiliteDao {

	
	public List<Tracabilite> getAll();
	public void persist(Tracabilite trace);
	
}
