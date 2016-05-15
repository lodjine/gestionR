package com.talon.daoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.UtilisateurDao;

import com.talon.entities.Utilisateur;

@Repository
public class UtilisateurDaoImpl implements UtilisateurDao{

	
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Utilisateur> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Utilisateur a").list();
	}
	public Utilisateur getById(String id) {
		Session session=sessionFactory.getCurrentSession();
		Query query =session.getNamedQuery("User.findByUsername").setParameter("username", id);
		return (Utilisateur) query.uniqueResult();
	}
	public void persist(Utilisateur utili) {
		Session session=sessionFactory.getCurrentSession();

		session.persist(utili);
	}
	public void update(Utilisateur utili) {
		Session session=sessionFactory.getCurrentSession();

		session.update(utili);
	}
	public void delete(Utilisateur utili) {
		Session session=sessionFactory.getCurrentSession();

		session.delete(utili);
	}
	public void save(Utilisateur utili) {
		Session session=sessionFactory.getCurrentSession();
session.save(utili);		
	}
	
	
	
	
	
	
	
	


	

	
	
	
	
	
 
	
	
	
	
	private boolean isUserExists(String username) {
 
		Session session=sessionFactory.getCurrentSession();

		
		
		
		
	  boolean result = false;
 
	

		//Query query = session.getNamedQuery("User.findByUsername").setParameter("username", username);
	  Utilisateur user = (Utilisateur) session.get(Utilisateur.class, username);
	  
	  if ( user.getEmail() != null) {
		result = true;
	  }
 
	  return result;
	}










	
	
	
}
