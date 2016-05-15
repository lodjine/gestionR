package com.talon.dao;

import java.util.List;

import com.talon.entities.Information;
import com.talon.entities.Poste;

public interface InformationDao {

	
	public List<Information> getAll();
	public Information getById(int id);
	public void persist(Information info);
	public void update(Information info);
	public void delete(Information info);
	public void save(Information info);
}
