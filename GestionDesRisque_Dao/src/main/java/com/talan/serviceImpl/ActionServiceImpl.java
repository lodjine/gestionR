package com.talan.serviceImpl;

import java.rmi.activation.ActivationGroupDesc;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.ActionDao;
import com.talan.entities.Action;
import com.talan.entities.Activite;
import com.talan.service.ActionService;

@Service
@Transactional
public class ActionServiceImpl implements ActionService{

	
	@Autowired
	ActionDao actionDaoImpl;
	
	public ActionDao getActionDaoImpl() {
		return actionDaoImpl;
	}

	public void setActionDaoImpl(ActionDao actionDaoImpl) {
		this.actionDaoImpl = actionDaoImpl;
	}

	public List<Action> getAll() {
		// TODO Auto-generated method stub
		return actionDaoImpl.getAll();
	}

	public Action getById(int id) {
		// TODO Auto-generated method stub
		return actionDaoImpl.getById(id);
	}

	public void persist(Action action) {
		actionDaoImpl.persist(action);
		
	}

	public void update(Action action) {
actionDaoImpl.update(action);		
	}

	public void delete(Action action) {
actionDaoImpl.delete(action);		
	}

	public void save(Action action) {
actionDaoImpl.save(action);		
	}

	public List<Action> getAllNonTermine() {
		
		return actionDaoImpl.getAllNonTermine();
	}

	public List<Action> getAllTermine() {
		// TODO Auto-generated method stub
		return actionDaoImpl.getAllTermine();
	}

	
	
	

}
