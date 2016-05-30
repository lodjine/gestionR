package com.talan.service;

import java.util.List;

import com.talan.entities.Integrite;
import com.talan.entities.Responsable;
import com.talan.entities.Utilisateur;

public interface UtilisateurService {
	public List<Utilisateur> getAll();
	public Utilisateur getById(String id);
	public void persist(Utilisateur utili);
	public void update(Utilisateur utili);
	public void delete(Utilisateur utili);
	public void save(Utilisateur utili);
	
	public List<Responsable> getAllResp();
	

}
