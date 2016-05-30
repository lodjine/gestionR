package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.PosteDao;
import com.talan.entities.Poste;
import com.talan.entities.Responsable;
import com.talan.service.PosteService;
@Transactional
@Service
public class PosteServiceImpl implements PosteService {
@Autowired
PosteDao posteDaoImpl;


	public PosteDao getPosteDaoImpl() {
	return posteDaoImpl;
}

public void setPosteDaoImpl(PosteDao posteDaoImpl) {
	this.posteDaoImpl = posteDaoImpl;
}

	public List<Poste> getAll() {
		// TODO Auto-generated method stub
		return posteDaoImpl.getAll();
	}

	public Poste getById(int id) {
		// TODO Auto-generated method stub
		return posteDaoImpl.getById(id);
	}

	public void persist(Poste poste) {
		// TODO Auto-generated method stub
		posteDaoImpl.persist(poste);
	}

	public void update(Poste poste) {
		// TODO Auto-generated method stub
		posteDaoImpl.update(poste);
	}

	public void delete(Poste poste) {
		// TODO Auto-generated method stub
		posteDaoImpl.delete(poste);
	}

	public void save(Poste poste) {
		// TODO Auto-generated method stub
		posteDaoImpl.save(poste);
	}

	
	
}
