package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.ConfidentialiteDao;
import com.talan.entities.Classification;
import com.talan.entities.Confidentialite;
import com.talan.service.ConfidentialiteService;
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

public int merge(Confidentialite conf) {
	// TODO Auto-generated method stub
	return confidentialiteDaoImpl.merge(conf);
}
	
	
}
