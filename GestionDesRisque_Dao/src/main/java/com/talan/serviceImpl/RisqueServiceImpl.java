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

	public  List<Confidentialite> getConfByProc(int idproc, String user, String userRole) {
		// TODO Auto-generated method stub
		return risqueDaoImpl.getConfByProc(idproc, user, userRole);
	}

	public List<Confidentialite> getConfByProcRev(int idproc, String user, String userRole, int res) {
		// TODO Auto-generated method stub
		return risqueDaoImpl.getConfByProcRev(idproc, user, userRole, res);
	}

	public List<Disponibilite> getdispByProc(int idproc, String user, String userRole) {
		// TODO Auto-generated method stub
		return risqueDaoImpl.getdispByProc(idproc, user, userRole);
	}

	public List<Disponibilite> getdispByProcRev(int idproc, String user, String userRole, int res) {
		// TODO Auto-generated method stub
		return risqueDaoImpl.getdispByProcRev(idproc, user, userRole, res);
	}

	public List<Integrite> getIntByProc(int idproc, String user, String userRole) {
		// TODO Auto-generated method stub
		return risqueDaoImpl.getIntByProc(idproc, user, userRole);
	}

	public List<Integrite> getIntByProcRev(int idproc, String user, String userRole, int res) {
		// TODO Auto-generated method stub
		return risqueDaoImpl.getIntByProcRev(idproc, user, userRole, res);
	}

	
	
}
