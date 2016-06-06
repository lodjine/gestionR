package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.ImpactDao;
import com.talan.entities.ImpactC;
import com.talan.service.ImpactCService;
@Service
@Transactional
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

	public List<ImpactC> getImpactCByRiskAndType(int id, String type) {
		// TODO Auto-generated method stub
		return impactDaoImpl.getImpactCByRiskAndType(id, type);
	}

}
