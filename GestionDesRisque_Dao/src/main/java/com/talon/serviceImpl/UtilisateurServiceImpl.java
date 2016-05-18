package com.talon.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talon.dao.UtilisateurDao;
import com.talon.entities.Integrite;

import com.talon.entities.Utilisateur;
import com.talon.service.UtilisateurService;
@Transactional
@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	UtilisateurDao utilisateurDaoImpl;
	
	
	public UtilisateurDao getUtilisateurDaoImpl() {
		return utilisateurDaoImpl;
	}

	public void setUtilisateurDaoImpl(UtilisateurDao utilisateurDaoImpl) {
		this.utilisateurDaoImpl = utilisateurDaoImpl;
	}

	public List<Utilisateur> getAll() {
		// TODO Auto-generated method stub
		return utilisateurDaoImpl.getAll();
	}

	public Utilisateur getById(String id) {
		// TODO Auto-generated method stub
		return utilisateurDaoImpl.getById(id);
	}

	public void persist(Utilisateur utili) {
		// TODO Auto-generated method stub
		utilisateurDaoImpl.persist(utili);
	}

	public void update(Utilisateur utili) {
		// TODO Auto-generated method stub
		utilisateurDaoImpl.update(utili);
	}

	public void delete(Utilisateur utili) {
		// TODO Auto-generated method stub
		utilisateurDaoImpl.delete(utili);
	}

	public void save(Utilisateur utili) {
		// TODO Auto-generated method stub
		utilisateurDaoImpl.save(utili);
	}


	

}
