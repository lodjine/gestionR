package com.talon.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talon.dao.DisponibiliteDao;
import com.talon.entities.Confidentialit�;
import com.talon.entities.Disponibilit�;
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

	public List<Disponibilit�> getAll() {
		// TODO Auto-generated method stub
		return disponibiliteDaoImpl.getAll();
	}

	public Disponibilit� getById(int id) {
		// TODO Auto-generated method stub
		return disponibiliteDaoImpl.getById(id);
	}

	public void persist(Disponibilit� dispo) {
disponibiliteDaoImpl.persist(dispo);		
	}

	public void update(Disponibilit� dispo) {
disponibiliteDaoImpl.update(dispo);		
	}

	public void delete(Disponibilit� dispo) {
		disponibiliteDaoImpl.delete(dispo);		
	}

	public void save(Disponibilit� dispo) {
		disponibiliteDaoImpl.save(dispo);		
	}


}
