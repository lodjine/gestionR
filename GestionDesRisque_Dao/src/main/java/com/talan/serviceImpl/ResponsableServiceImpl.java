package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.ResponsableDao;
import com.talan.entities.Responsable;
import com.talan.entities.Risque;
import com.talan.service.ResponsableService;


@Transactional
@Service
public class ResponsableServiceImpl implements ResponsableService {

	
	@Autowired
	ResponsableDao responsableDaoImpl;
	
	
	public ResponsableDao getResponsableDao() {
		return responsableDaoImpl;
	}

	public void setResponsableDao(ResponsableDao responsableDaoImpl) {
		this.responsableDaoImpl = responsableDaoImpl;
	}

	
	
	
	public List<Responsable> getAll() {
		// TODO Auto-generated method stub
		return responsableDaoImpl.getAll();
	}

	public Responsable getById(int id) {
		// TODO Auto-generated method stub
		return responsableDaoImpl.getById(id);
	}

	public void persist(Responsable resp) {
		responsableDaoImpl.persist(resp);		
	}

	public void update(Responsable resp) {
		responsableDaoImpl.update(resp);		
	}

	public void delete(Responsable resp) {
		responsableDaoImpl.delete(resp);		
	}

	public void save(Responsable resp) {
		responsableDaoImpl.save(resp);		
	}

	


}
