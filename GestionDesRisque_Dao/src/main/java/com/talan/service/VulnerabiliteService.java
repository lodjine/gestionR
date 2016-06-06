package com.talan.service;

import java.util.List;

import com.talan.entities.Vulnerabilite;

public interface VulnerabiliteService {
	public List<Vulnerabilite> getAll();
	public Vulnerabilite getById(int id);
	public void persist(Vulnerabilite vulner);
	public void update(Vulnerabilite vulner);
	public void delete(Vulnerabilite vulner);
	public void save(Vulnerabilite vulner);
	public List<Vulnerabilite> getVulnerabiliteByRiskAndType(int id , String type) ;
}
