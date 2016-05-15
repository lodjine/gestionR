package com.talon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.talon.dao.InformationDao;
import com.talon.entities.Information;
import com.talon.entities.Poste;
import com.talon.service.InformationService;
@Transactional
@Service
public class InformationServiceImpl implements InformationService{
@Autowired
InformationDao informationDaoImpl;
	
	
	
	
	public List<Information> getAll() {
		// TODO Auto-generated method stub
		return informationDaoImpl.getAll();
	}

	public Information getById(int id) {
		// TODO Auto-generated method stub
		return informationDaoImpl.getById(id);
	}

	public void persist(Information info) {
		informationDaoImpl.persist(info);
	}

	public void update(Information info) {
		informationDaoImpl.update(info);
		
	}

	public void delete(Information info) {
		informationDaoImpl.delete(info);
		
	}

	public void save(Information info) {
		informationDaoImpl.save(info);
		
	}

	public InformationDao getInformationDaoImpl() {
		return informationDaoImpl;
	}

	public void setInformationDaoImpl(InformationDao informationDaoImpl) {
		this.informationDaoImpl = informationDaoImpl;
	}

	
	
}
