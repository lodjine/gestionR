package com.talan.dao;

import java.util.List;

import com.talan.entities.Confidentialite;
import com.talan.entities.Disponibilite;
import com.talan.entities.Integrite;
import com.talan.entities.Risque;
import com.talan.entities.Utilisateur;

public interface RisqueDao {

	
	public List<Risque> getAll();
	public Risque getById(int id);
	public int persist(Risque risque);
	public void update(Risque risque);
	public void delete(Risque risque);
	public void save(Risque risque);

	public List<Risque> getRiskByProc(int idproc, String user, String userRole, int res);

	public List<Risque> getRiskByProc(int id); 
	public List<Risque> getAllByc(String c);
}
