package com.talan.service;

import java.util.List;

import com.talan.entities.ImpactC;

public interface ImpactCService {
	public List<ImpactC> getAll();
	public ImpactC getById(int id);
	public void persist(ImpactC impactC);
	public void update(ImpactC impactC);
	public void delete(ImpactC impactC);
	public void save(ImpactC impactC);
	public List<ImpactC> getImpactCByRiskAndType(int id , String type) ;
}
