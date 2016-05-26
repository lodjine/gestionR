package com.talon.service;

import java.util.List;

import com.talon.entities.ImpactC;

public interface ImpactCService {
	public List<ImpactC> getAll();
	public ImpactC getById(int id);
	public void persist(ImpactC impactC);
	public void update(ImpactC impactC);
	public void delete(ImpactC impactC);
	public void save(ImpactC impactC);
}
