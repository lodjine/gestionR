package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.DisponibiliteDao;
import com.talan.entities.Confidentialite;
import com.talan.entities.Disponibilite;
import com.talan.service.DisponibiliteService;


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

	public int merge(Disponibilite disp) {
		// TODO Auto-generated method stub
		return disponibiliteDaoImpl.merge(disp);
	}


}
