package com.talon.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talon.dao.IntegriteDao;
import com.talon.entities.Disponibilité;
import com.talon.entities.Intégrité;
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

	public List<Intégrité> getAll() {
		// TODO Auto-generated method stub
		return integriteDaoImpl.getAll();
	}

	public Intégrité getById(int id) {
		// TODO Auto-generated method stub
		return integriteDaoImpl.getById(id);
	}

	public void persist(Intégrité integ) {
		// TODO Auto-generated method stub
		integriteDaoImpl.persist(integ);
	}

	public void update(Intégrité integ) {
		// TODO Auto-generated method stub
		integriteDaoImpl.update(integ);
	}

	public void delete(Intégrité integ) {
		// TODO Auto-generated method stub
		integriteDaoImpl.delete(integ);
	}

	public void save(Intégrité integ) {
		// TODO Auto-generated method stub
		integriteDaoImpl.save(integ);
	}

	
	
}
