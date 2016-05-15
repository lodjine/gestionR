package com.talon.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talon.dao.ActionDao;
import com.talon.dao.ActiviteDao;
import com.talon.entities.Action;
import com.talon.entities.Activité;
import com.talon.service.ActiviteService;

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

	public List<Activité> getAll() {
		// TODO Auto-generated method stub
		return activiteDaoImpl.getAll();
	}

	public Activité getById(int id) {
		// TODO Auto-generated method stub
		return activiteDaoImpl.getById(id);
	}

	public void persist(Activité activité) {
		// TODO Auto-generated method stub
		activiteDaoImpl.persist(activité);
	}

	public void update(Activité activité) {
		// TODO Auto-generated method stub
		activiteDaoImpl.update(activité);
	}

	public void delete(Activité activité) {
		// TODO Auto-generated method stub
		activiteDaoImpl.delete(activité);
	}

	public void save(Activité activité) {
		// TODO Auto-generated method stub
		activiteDaoImpl.save(activité);
	}

	
}
