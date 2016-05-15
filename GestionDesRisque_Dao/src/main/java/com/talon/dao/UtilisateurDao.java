package com.talon.dao;

import java.util.List;

import com.talon.entities.Intégrité;

import com.talon.entities.Utilisateur;

public interface UtilisateurDao {
	public List<Utilisateur> getAll();
	public Utilisateur getById(String id);
	public void persist(Utilisateur utili);
	public void update(Utilisateur utili);
	public void delete(Utilisateur utili);
	public void save(Utilisateur utili);
	
	
	



}
