package com.talon.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talon.dao.DisponibiliteDao;
import com.talon.entities.Confidentialite;
import com.talon.entities.Disponibilite;
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

	public List<Disponibilite> getAll() {
		// TODO Auto-generated method stub
		return disponibiliteDaoImpl.getAll();
	}

	public Disponibilite getById(int id) {
		// TODO Auto-generated method stub
		return disponibiliteDaoImpl.getById(id);
	}

	public void persist(Disponibilite dispo) {
disponibiliteDaoImpl.persist(dispo);		
	}

	public void update(Disponibilite dispo) {
disponibiliteDaoImpl.update(dispo);		
	}

	public void delete(Disponibilite dispo) {
		disponibiliteDaoImpl.delete(dispo);		
	}

	public void save(Disponibilite dispo) {
		disponibiliteDaoImpl.save(dispo);		
	}


}
