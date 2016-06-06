package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.TracabiliteDao;
import com.talan.entities.Tracabilite;
import com.talan.service.TracabiliteService;
@Transactional
@Service
public class TracabiliteServiceImpl implements TracabiliteService {
	@Autowired
	TracabiliteDao tracabiliteDaoImpl;
	
	public TracabiliteDao getTracabiliteDaoImpl() {
		return tracabiliteDaoImpl;
	}

	public void setTracabiliteDaoImpl(TracabiliteDao tracabiliteDaoImpl) {
		this.tracabiliteDaoImpl = tracabiliteDaoImpl;
	}

	public List<Tracabilite> getAll() {
		// TODO Auto-generated method stub
		return tracabiliteDaoImpl.getAll();
	}

	public void persist(Tracabilite trace) {
		// TODO Auto-generated method stub
		tracabiliteDaoImpl.persist(trace);
	}

}
