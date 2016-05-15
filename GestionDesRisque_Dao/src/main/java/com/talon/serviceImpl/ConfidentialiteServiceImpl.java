package com.talon.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talon.dao.ConfidentialiteDao;
import com.talon.entities.Classification;
import com.talon.entities.Confidentialité;
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

public List<Confidentialité> getAll() {
	// TODO Auto-generated method stub
	return confidentialiteDaoImpl.getAll();
}

public Confidentialité getById(int id) {
	// TODO Auto-generated method stub
	return confidentialiteDaoImpl.getById(id);
}

public void persist(Confidentialité conf) {
confidentialiteDaoImpl.persist(conf);	
}

public void update(Confidentialité conf) {
confidentialiteDaoImpl.update(conf);	
}

public void delete(Confidentialité conf) {
confidentialiteDaoImpl.delete(conf);	
}

public void save(Confidentialité conf) {
confidentialiteDaoImpl.save(conf);	
}
	
	
}
