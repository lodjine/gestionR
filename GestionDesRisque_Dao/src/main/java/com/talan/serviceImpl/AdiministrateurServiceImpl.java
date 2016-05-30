package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.AdiministrateurDao;
import com.talan.entities.Activite;
import com.talan.entities.Administrateur;
import com.talan.service.AdiministrateurService;


@Service
@Transactional
public class AdiministrateurServiceImpl implements AdiministrateurService{

	@Autowired
AdiministrateurDao administrateurDaoImpl;
	
	
	
	public AdiministrateurDao getAdministrateurDaoImpl() {
		return administrateurDaoImpl;
	}

	public void setAdministrateurDaoImpl(AdiministrateurDao administrateurDaoImpl) {
		this.administrateurDaoImpl = administrateurDaoImpl;
	}

	public List<Administrateur> getAll() {
		// TODO Auto-generated method stub
		return administrateurDaoImpl.getAll();
	}

	public Administrateur getById(int id) {
		// TODO Auto-generated method stub
		return administrateurDaoImpl.getById(id);
	}

	public void persist(Administrateur admin) {
administrateurDaoImpl.persist(admin);		
	}

	public void update(Administrateur admin) {
administrateurDaoImpl.update(admin);		
	}

	public void delete(Administrateur admin) {
administrateurDaoImpl.delete(admin);		
	}

	public void save(Administrateur admin) {
administrateurDaoImpl.save(admin);		
	}
	
}
