package com.talon.dao;

import java.util.List;

import com.talon.entities.ImpactC;
import com.talon.entities.Vulnerabilite;

public interface ImpactDao {
	public List<ImpactC> getAll();
	public ImpactC getById(int id);
	public void persist(ImpactC impactC);
	public void update(ImpactC impactC);
	public void delete(ImpactC impactC);
	public void save(ImpactC impactC);
}
