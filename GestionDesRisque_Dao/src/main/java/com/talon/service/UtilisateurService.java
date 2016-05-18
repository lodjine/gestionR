package com.talon.service;

import java.util.List;

import com.talon.entities.Integrite;

import com.talon.entities.Utilisateur;

public interface UtilisateurService {
	public List<Utilisateur> getAll();
	public Utilisateur getById(String id);
	public void persist(Utilisateur utili);
	public void update(Utilisateur utili);
	public void delete(Utilisateur utili);
	public void save(Utilisateur utili);
	
	
	

}
