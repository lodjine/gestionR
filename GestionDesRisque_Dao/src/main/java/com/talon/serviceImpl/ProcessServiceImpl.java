package com.talon.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talon.dao.ProcessDao;
import com.talon.entities.Processus;
import com.talon.service.ProcessService;


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

	public List<Processus> getAll() {
		// TODO Auto-generated method stub
		return processDaoImpl.getAll();
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

	public void save(Processus ssPro) {
		// TODO Auto-generated method stub
		processDaoImpl.save(ssPro);
	}

}
