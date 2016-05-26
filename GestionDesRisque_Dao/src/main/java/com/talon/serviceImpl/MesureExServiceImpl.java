package com.talon.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.talon.dao.MesureExDao;
import com.talon.dao.ProcessDao;
import com.talon.entities.MesureEx;
import com.talon.service.MesureExService;
@Service
@Transactional
public class MesureExServiceImpl implements MesureExService {

	
	@Autowired
	MesureExDao mesureExDao;

	

	
	public MesureExDao getMesureExDao() {
		return mesureExDao;
	}

	public void setMesureExDao(MesureExDao mesureExDao) {
		this.mesureExDao = mesureExDao;
	}

	public List<MesureEx> getAllMesure() {
		// TODO Auto-generated method stub
		return mesureExDao.getAllMesure();
	}

	public MesureEx getMesureById(int id) {
		// TODO Auto-generated method stub
		return mesureExDao.getMesureById(id);
	}

	public void updateMuser(MesureEx mesure) {
		// TODO Auto-generated method stub
		mesureExDao.updateMuser(mesure);
	}

	public void deleteMuser(MesureEx mesure) {
		// TODO Auto-generated method stub
		mesureExDao.deleteMuser(mesure);
	}

	public void persisteMesure(MesureEx mesure) {
		// TODO Auto-generated method stub
		mesureExDao.persisteMesure(mesure);
	}

}
