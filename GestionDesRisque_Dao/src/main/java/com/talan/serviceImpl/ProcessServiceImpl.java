package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.ProcessDao;
import com.talan.entities.Processus;
import com.talan.entities.Utilisateur;
import com.talan.service.ProcessService;


@Service
public class ProcessServiceImpl implements ProcessService{
	
	
@Autowired
ProcessDao processDaoImpl;



	public ProcessDao getProcessDaoImpl() {
	return processDaoImpl;
}

public void setProcessDaoImpl(ProcessDao processDaoImpl) {
	this.processDaoImpl = processDaoImpl;
}

	public List<Processus> getAll(Utilisateur user) {
		// TODO Auto-generated method stub
		return processDaoImpl.getAll(user);
	}

	public Processus getById(int id) {
		// TODO Auto-generated method stub
		return processDaoImpl.getById(id);
	}

	public void persist(Processus ssPro) {
		// TODO Auto-generated method stub
		processDaoImpl.persist(ssPro);
	}

	public void update(Processus ssPro) {
		// TODO Auto-generated method stub
		processDaoImpl.update(ssPro);
	}

	public void delete(Processus ssPro) {
		// TODO Auto-generated method stub
		processDaoImpl.delete(ssPro);
	}

	public int save(Processus ssPro) {
		// TODO Auto-generated method stub
		return processDaoImpl.save(ssPro);
	}

}
