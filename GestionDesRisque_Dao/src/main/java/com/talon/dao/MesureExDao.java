package com.talon.dao;

import java.util.List;

import com.talon.entities.MesureEx;

public interface MesureExDao {

	
		public List<MesureEx> getAllMesure() ; 
		public MesureEx getMesureById(int id) ; 
		public void updateMuser(MesureEx mesure) ; 
		public void deleteMuser(MesureEx mesure) ; 
		public void persisteMesure(MesureEx mesure) ;
}
