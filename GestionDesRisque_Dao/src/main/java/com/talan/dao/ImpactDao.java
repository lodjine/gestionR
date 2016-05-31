package com.talan.dao;

import java.util.List;

import com.talan.entities.ImpactC;
import com.talan.entities.Vulnerabilite;

public interface ImpactDao {
	public List<ImpactC> getAll();
	public ImpactC getById(int id);
	public void persist(ImpactC impactC);
	public void update(ImpactC impactC);
	public void delete(ImpactC impactC);
	public void save(ImpactC impactC);
}
