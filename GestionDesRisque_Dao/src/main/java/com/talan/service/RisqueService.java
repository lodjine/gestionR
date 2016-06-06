package com.talan.service;

import java.util.List;

import com.talan.entities.Confidentialite;
import com.talan.entities.Disponibilite;
import com.talan.entities.Integrite;
import com.talan.entities.Risque;
import com.talan.entities.SousProcessus;
import com.talan.entities.Utilisateur;

public interface RisqueService {

	
	public List<Risque> getAll();
	public Risque getById(int id);
	public int persist(Risque risque);
	public void update(Risque risque);
	public void delete(Risque risque);
	public void save(Risque risque);
	public  List<Confidentialite> getConfByProc(int idproc, String user,String userRole) ;
	public  List<Confidentialite> getConfByProcRev(int idproc, String user,String userRole , int res) ;
	public  List<Disponibilite> getdispByProc(int idproc, String user,String userRole) ;
	public  List<Disponibilite> getdispByProcRev(int idproc, String user,String userRole , int res) ;
	public  List<Integrite> getIntByProc(int idproc, String user,String userRole) ;
	public  List<Integrite> getIntByProcRev(int idproc, String user,String userRole , int res) ;
	public List<Risque> getRiskByProc(int id); 
}
