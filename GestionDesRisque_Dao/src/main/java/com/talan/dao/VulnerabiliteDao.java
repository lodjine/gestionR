package com.talan.dao;

import java.util.List;

import com.talan.entities.Action;
import com.talan.entities.Vulnerabilite;

public interface VulnerabiliteDao {
	public List<Vulnerabilite> getAll();
	public Vulnerabilite getById(int id);
	public void persist(Vulnerabilite vulner);
	public void update(Vulnerabilite vulner);
	public void delete(Vulnerabilite vulner);
	public void save(Vulnerabilite vulner);
}
