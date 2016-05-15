package com.talon.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talon.dao.DisponibiliteDao;
import com.talon.entities.Confidentialité;
import com.talon.entities.Disponibilité;
import com.talon.service.DisponibiliteService;


@Service
@Transactional
public class DisponibiliteServiceImpl implements DisponibiliteService{
@Autowired
DisponibiliteDao disponibiliteDaoImpl;



	public DisponibiliteDao getDisponibiliteDaoImpl() {
	return disponibiliteDaoImpl;
}

public void setDisponibiliteDaoImpl(DisponibiliteDao disponibiliteDaoImpl) {
	this.disponibiliteDaoImpl = disponibiliteDaoImpl;
}

	public List<Disponibilité> getAll() {
		// TODO Auto-generated method stub
		return disponibiliteDaoImpl.getAll();
	}

	public Disponibilité getById(int id) {
		// TODO Auto-generated method stub
		return disponibiliteDaoImpl.getById(id);
	}

	public void persist(Disponibilité dispo) {
disponibiliteDaoImpl.persist(dispo);		
	}

	public void update(Disponibilité dispo) {
disponibiliteDaoImpl.update(dispo);		
	}

	public void delete(Disponibilité dispo) {
		disponibiliteDaoImpl.delete(dispo);		
	}

	public void save(Disponibilité dispo) {
		disponibiliteDaoImpl.save(dispo);		
	}


}
