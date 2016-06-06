package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.RisqueDao;
import com.talan.entities.Confidentialite;
import com.talan.entities.Disponibilite;
import com.talan.entities.Integrite;
import com.talan.entities.Risque;
import com.talan.entities.SousProcessus;
import com.talan.service.RisqueService;
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

	public int persist(Risque risque) {
		// TODO Auto-generated method stub
		return risqueDaoImpl.persist(risque);
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

	public List<Risque> getRiskByProc(int idproc, String user, String userRole, int res) {
		// TODO Auto-generated method stub
		return risqueDaoImpl.getRiskByProc(idproc, user, userRole, res);
	}

	

	
	
}
