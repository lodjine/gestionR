package com.talan.service;

import java.util.List;

import com.talan.entities.Tracabilite;

public interface TracabiliteService {

	public List<Tracabilite> getAll();
	public void persist(Tracabilite trace);
}
