package com.talon.dao;

import java.util.List;

import com.talon.entities.Action;
import com.talon.entities.Vulnerabilite;

public interface VulnerabiliteDao {
	public List<Vulnerabilite> getAll();
	public Vulnerabilite getById(int id);
	public void persist(Vulnerabilite vulner);
	public void update(Vulnerabilite vulner);
	public void delete(Vulnerabilite vulner);
	public void save(Vulnerabilite vulner);
}
