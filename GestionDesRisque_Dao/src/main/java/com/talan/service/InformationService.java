package com.talan.service;

import java.util.List;

import com.talan.entities.Information;
import com.talan.entities.Poste;

public interface InformationService {

	
	public List<Information> getAll();
	public Information getById(int id);
	public void persist(Information info);
	public void update(Information info);
	public void delete(Information info);
	public void save(Information info);
}
