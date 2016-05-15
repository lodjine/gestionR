package com.talon.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talon.dao.AnalyseDesRisqueDao;
import com.talon.entities.Alerte;
import com.talon.entities.AnalyseDesRisques;
import com.talon.service.AnalyseDesRisqueService;


@Service
@Transactional
public class AnalyseDesRisqueServiceImpl implements AnalyseDesRisqueService{
	@Autowired
	AnalyseDesRisqueDao analyseDesRisqueDaoImpl;
	
	
	
	public AnalyseDesRisqueDao getAnalyseDesRisqueDaoImpl() {
		return analyseDesRisqueDaoImpl;
	}

	public void setAnalyseDesRisqueDaoImpl(AnalyseDesRisqueDao analyseDesRisqueDaoImpl) {
		this.analyseDesRisqueDaoImpl = analyseDesRisqueDaoImpl;
	}

	public List<AnalyseDesRisques> getAll() {
		// TODO Auto-generated method stub
		return analyseDesRisqueDaoImpl.getAll();
	}

	public AnalyseDesRisques getById(int id) {
		// TODO Auto-generated method stub
		return analyseDesRisqueDaoImpl.getById(id);
	}

	public void persist(AnalyseDesRisques analyseR) {
analyseDesRisqueDaoImpl.persist(analyseR);		
	}

	public void update(AnalyseDesRisques analyseR) {
analyseDesRisqueDaoImpl.update(analyseR);		
	}

	public void delete(AnalyseDesRisques analyseR) {
analyseDesRisqueDaoImpl.delete(analyseR);		
	}

	public void save(AnalyseDesRisques analyseR) {
analyseDesRisqueDaoImpl.save(analyseR);		
	}
	
	
	

}
