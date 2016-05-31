package com.talon.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talon.dao.IntegriteDao;
import com.talon.entities.Disponibilite;
import com.talon.entities.Integrite;
import com.talon.service.IntegriteService;
@Transactional
@Service
public class IntegriteServiceImpl implements IntegriteService {
@Autowired
IntegriteDao integriteDaoImpl;







	public IntegriteDao getIntegriteDaoImpl() {
	return integriteDaoImpl;
}

public void setIntegriteDaoImpl(IntegriteDao integriteDaoImpl) {
	this.integriteDaoImpl = integriteDaoImpl;
}

	public List<Integrite> getAll() {
		// TODO Auto-generated method stub
		return integriteDaoImpl.getAll();
	}

	public Integrite getById(int id) {
		// TODO Auto-generated method stub
		return integriteDaoImpl.getById(id);
	}

	public void persist(Integrite integ) {
		// TODO Auto-generated method stub
		integriteDaoImpl.persist(integ);
	}

	public void update(Integrite integ) {
		// TODO Auto-generated method stub
		integriteDaoImpl.update(integ);
	}

	public void delete(Integrite integ) {
		// TODO Auto-generated method stub
		integriteDaoImpl.delete(integ);
	}

	public void save(Integrite integ) {
		// TODO Auto-generated method stub
		integriteDaoImpl.save(integ);
	}

	public int merge(Integrite intg) {
		// TODO Auto-generated method stub
		return integriteDaoImpl.merge(intg);
	}

	
	
}
