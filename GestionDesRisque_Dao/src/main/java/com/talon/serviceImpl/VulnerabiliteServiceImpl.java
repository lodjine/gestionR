package com.talon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talon.dao.UtilisateurDao;
import com.talon.entities.Vulnerabilite;
import com.talon.service.VulnerabiliteService;

public class VulnerabiliteServiceImpl implements VulnerabiliteService{
	@Autowired
	VulnerabiliteService vulnerabiliteServiceImpl;
	
	
	
	
	public VulnerabiliteService getVulnerabiliteServiceImpl() {
		return vulnerabiliteServiceImpl;
	}

	public void setVulnerabiliteServiceImpl(VulnerabiliteService vulnerabiliteServiceImpl) {
		this.vulnerabiliteServiceImpl = vulnerabiliteServiceImpl;
	}

	public List<Vulnerabilite> getAll() {
		// TODO Auto-generated method stub
		return vulnerabiliteServiceImpl.getAll();
	}

	public Vulnerabilite getById(int id) {
		// TODO Auto-generated method stub
		return vulnerabiliteServiceImpl.getById(id);
	}

	public void persist(Vulnerabilite vulner) {
		vulnerabiliteServiceImpl.persist(vulner);
		
	}

	public void update(Vulnerabilite vulner) {
		vulnerabiliteServiceImpl.update(vulner);
		
	}

	public void delete(Vulnerabilite vulner) {
		vulnerabiliteServiceImpl.delete(vulner);
	}

	public void save(Vulnerabilite vulner) {
		vulnerabiliteServiceImpl.save(vulner);
		
	}

}
