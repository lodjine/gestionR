package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.SousProcessusDao;
import com.talan.entities.SousProcessus;
import com.talan.entities.Utilisateur;
import com.talan.service.SousProcessusService;



@Transactional
@Service
public class SousProcessusServiceImpl implements SousProcessusService {
@Autowired
SousProcessusDao sousProcessusDaoImpl;







	public SousProcessusDao getSousProcessusDaoImpl() {
	return sousProcessusDaoImpl;
}

public void setSousProcessusDaoImpl(SousProcessusDao sousProcessusDaoImpl) {
	this.sousProcessusDaoImpl = sousProcessusDaoImpl;
}

	public List<SousProcessus> getAll() {
		// TODO Auto-generated method stub
		return sousProcessusDaoImpl.getAll();
	}

	public SousProcessus getById(int id) {
		// TODO Auto-generated method stub
		return sousProcessusDaoImpl.getById(id);
	}

	public void persist(SousProcessus ssPro) {
		// TODO Auto-generated method stub
		sousProcessusDaoImpl.persist(ssPro);
	}

	public void update(SousProcessus ssPro) {
		// TODO Auto-generated method stub
		sousProcessusDaoImpl.update(ssPro);
	}

	public void delete(SousProcessus ssPro) {
		// TODO Auto-generated method stub
		sousProcessusDaoImpl.delete(ssPro);
	}

	public void save(SousProcessus ssPro) {
		// TODO Auto-generated method stub
		sousProcessusDaoImpl.save(ssPro);
	}

	
	
}
