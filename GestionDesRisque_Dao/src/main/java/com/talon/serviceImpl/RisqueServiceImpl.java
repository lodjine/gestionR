package com.talon.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talon.dao.RisqueDao;
import com.talon.entities.Risque;
import com.talon.entities.SousProcessus;
import com.talon.service.RisqueService;
@Transactional
@Service
public class RisqueServiceImpl implements RisqueService {

	@Autowired
	RisqueDao risqueDaoImpl;
	
	
	
	public RisqueDao getRisqueDaoImpl() {
		return risqueDaoImpl;
	}

	public void setRisqueDaoImpl(RisqueDao risqueDaoImpl) {
		this.risqueDaoImpl = risqueDaoImpl;
	}

	public List<Risque> getAll() {
		// TODO Auto-generated method stub
		return risqueDaoImpl.getAll();
	}

	public Risque getById(int id) {
		// TODO Auto-generated method stub
		return risqueDaoImpl.getById(id);
	}

	public void persist(Risque risque) {
		// TODO Auto-generated method stub
		risqueDaoImpl.persist(risque);
	}

	public void update(Risque risque) {
		// TODO Auto-generated method stub
		risqueDaoImpl.update(risque);
	}

	public void delete(Risque risque) {
		// TODO Auto-generated method stub
		risqueDaoImpl.delete(risque);
	}

	public void save(Risque risque) {
		// TODO Auto-generated method stub
		risqueDaoImpl.save(risque);
	}

	
	
}
