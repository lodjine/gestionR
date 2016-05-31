package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.AlerteDao;
import com.talan.entities.Administrateur;
import com.talan.entities.Alerte;
import com.talan.service.AlerteService;

@Service
@Transactional
public class AlerteServiceImpl implements AlerteService {
	@Autowired
	AlerteDao alerteDaoImpl;
	
	
	
	
	public List<Alerte> getAll() {
		// TODO Auto-generated method stub
		return alerteDaoImpl.getAll();
	}

	public Alerte getById(int id) {
		// TODO Auto-generated method stub
		return alerteDaoImpl.getById(id);
	}

	public void persist(Alerte alerte) {
alerteDaoImpl.persist(alerte);		
	}

	public void update(Alerte alerte) {
alerteDaoImpl.update(alerte);		
	}

	public void delete(Alerte alerte) {
alerteDaoImpl.delete(alerte);		
	}

	public void save(Alerte alerte) {
alerteDaoImpl.save(alerte);		
	}

	
	
	
}
