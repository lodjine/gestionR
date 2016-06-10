package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.ActionDao;
import com.talan.dao.ActiviteDao;
import com.talan.entities.Action;
import com.talan.entities.Activite;
import com.talan.service.ActiviteService;

@Service
@Transactional
public class ActiviteServiceImpl implements ActiviteService {

	@Autowired
	ActiviteDao activiteDaoImpl;
	
	
	
	public ActiviteDao getActiviteDaoImpl() {
		return activiteDaoImpl;
	}

	public void setActiviteDaoImpl(ActiviteDao activiteDaoImpl) {
		this.activiteDaoImpl = activiteDaoImpl;
	}

	public List<Activite> getAll() {
		// TODO Auto-generated method stub
		return activiteDaoImpl.getAll();
	}

	public Activite getById(int id) {
		// TODO Auto-generated method stub
		return activiteDaoImpl.getById(id);
	}

	public void persist(Activite activit�) {
		// TODO Auto-generated method stub
		activiteDaoImpl.persist(activit�);
	}

	public void update(Activite activit�) {
		// TODO Auto-generated method stub
		activiteDaoImpl.update(activit�);
	}

	public void delete(Activite activit�) {
		// TODO Auto-generated method stub
		activiteDaoImpl.delete(activit�);
	}

	public int save(Activite activit�) {
		// TODO Auto-generated method stub
		return activiteDaoImpl.save(activit�);
	}

	
}
