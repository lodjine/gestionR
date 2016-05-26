package com.talon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talon.dao.ImpactDao;
import com.talon.entities.ImpactC;
import com.talon.service.ImpactCService;

public class ImpactCServiceImpl implements ImpactCService {

	
	@Autowired
	ImpactDao impactDaoImpl;
	
	public ImpactDao getImpactDaoImpl() {
		return impactDaoImpl;
	}

	public void setImpactDaoImpl(ImpactDao impactDaoImpl) {
		this.impactDaoImpl = impactDaoImpl;
	}

	public List<ImpactC> getAll() {
		// TODO Auto-generated method stub
		return impactDaoImpl.getAll();
	}

	public ImpactC getById(int id) {
		// TODO Auto-generated method stub
		return impactDaoImpl.getById(id);
	}

	public void persist(ImpactC impactC) {
		impactDaoImpl.persist(impactC);
		
	}

	public void update(ImpactC impactC) {
		impactDaoImpl.update(impactC);
		
	}

	public void delete(ImpactC impactC) {
		impactDaoImpl.delete(impactC);
		
	}

	public void save(ImpactC impactC) {
		impactDaoImpl.save(impactC);
	}

}
