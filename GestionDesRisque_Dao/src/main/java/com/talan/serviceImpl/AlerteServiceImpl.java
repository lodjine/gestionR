package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.AlerteDao;
import com.talan.entities.Administrateur;
import com.talan.entities.Alerte;
import com.talan.entities.AlerteAction;
import com.talan.entities.AlerteRisqueFort;
import com.talan.service.AlerteService;

@Service
@Transactional
public class AlerteServiceImpl implements AlerteService {
	@Autowired
	AlerteDao alerteDaoImpl;
	
	
	
	


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

	public List<AlerteRisqueFort> getAllRisque() {
		// TODO Auto-generated method stub
		return alerteDaoImpl.getAllRisque();
	}

	public List<AlerteAction> getAllAction() {
		// TODO Auto-generated method stub
		return alerteDaoImpl.getAllAction();
	}

	
	
	
}
