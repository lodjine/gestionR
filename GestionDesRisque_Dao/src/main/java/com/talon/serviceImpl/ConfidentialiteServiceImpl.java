package com.talon.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talon.dao.ConfidentialiteDao;
import com.talon.entities.Classification;
import com.talon.entities.Confidentialite;
import com.talon.service.ConfidentialiteService;
@Transactional
@Service
public class ConfidentialiteServiceImpl implements ConfidentialiteService{
@Autowired
ConfidentialiteDao confidentialiteDaoImpl;



public ConfidentialiteDao getConfidentialiteDaoImpl() {
	return confidentialiteDaoImpl;
}

public void setConfidentialiteDaoImpl(ConfidentialiteDao confidentialiteDaoImpl) {
	this.confidentialiteDaoImpl = confidentialiteDaoImpl;
}

public List<Confidentialite> getAll() {
	// TODO Auto-generated method stub
	return confidentialiteDaoImpl.getAll();
}

public Confidentialite getById(int id) {
	// TODO Auto-generated method stub
	return confidentialiteDaoImpl.getById(id);
}

public void persist(Confidentialite conf) {
confidentialiteDaoImpl.persist(conf);	
}

public void update(Confidentialite conf) {
confidentialiteDaoImpl.update(conf);	
}

public void delete(Confidentialite conf) {
confidentialiteDaoImpl.delete(conf);	
}

public void save(Confidentialite conf) {
confidentialiteDaoImpl.save(conf);	
}
	
	
}
