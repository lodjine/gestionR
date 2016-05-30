package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.UtilisateurDao;
import com.talan.dao.VulnerabiliteDao;
import com.talan.entities.Vulnerabilite;
import com.talan.service.VulnerabiliteService;
@Service
@Transactional
public class VulnerabiliteServiceImpl implements VulnerabiliteService{
	@Autowired
	VulnerabiliteDao vulnerabiliteDaoImpl;
	
	
	
	

	public VulnerabiliteDao getVulnerabiliteDaoImpl() {
		return vulnerabiliteDaoImpl;
	}

	public void setVulnerabiliteDaoImpl(VulnerabiliteDao vulnerabiliteDaoImpl) {
		this.vulnerabiliteDaoImpl = vulnerabiliteDaoImpl;
	}

	public List<Vulnerabilite> getAll() {
		// TODO Auto-generated method stub
		return vulnerabiliteDaoImpl.getAll();
	}

	public Vulnerabilite getById(int id) {
		// TODO Auto-generated method stub
		return vulnerabiliteDaoImpl.getById(id);
	}

	public void persist(Vulnerabilite vulner) {
		vulnerabiliteDaoImpl.persist(vulner);
		
	}

	public void update(Vulnerabilite vulner) {
		vulnerabiliteDaoImpl.update(vulner);
		
	}

	public void delete(Vulnerabilite vulner) {
		vulnerabiliteDaoImpl.delete(vulner);
	}

	public void save(Vulnerabilite vulner) {
		vulnerabiliteDaoImpl.save(vulner);
		
	}

}
