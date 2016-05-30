package com.talan.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.dao.ClassificationDao;
import com.talan.entities.AnalyseDesRisques;
import com.talan.entities.Classification;
import com.talan.service.ClassificationService;
@Service
@Transactional
public class ClassificationServiceImpl implements ClassificationService {

	
	@Autowired
	ClassificationDao classificationDaoImpl;
	
	public ClassificationDao getClassificationDaoImpl() {
		return classificationDaoImpl;
	}

	public void setClassificationDaoImpl(ClassificationDao classificationDaoImpl) {
		this.classificationDaoImpl = classificationDaoImpl;
	}

	public List<Classification> getAll() {
		// TODO Auto-generated method stub
		return classificationDaoImpl.getAll();
	}

	public Classification getById(int id) {
		// TODO Auto-generated method stub
		return classificationDaoImpl.getById(id);
	}

	public void persist(Classification classi) {
		classificationDaoImpl.persist(classi);		
	}

	public void update(Classification classi) {
		classificationDaoImpl.update(classi);		
	}

	public void delete(Classification classi) {
classificationDaoImpl.delete(classi);		
	}

	public void save(Classification classi) {
classificationDaoImpl.save(classi);		
	}
	
	
	
}
