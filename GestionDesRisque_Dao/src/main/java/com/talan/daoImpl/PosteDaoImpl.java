package com.talan.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.PosteDao;
import com.talan.entities.Poste;

@Repository


public class PosteDaoImpl implements PosteDao{

	
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Poste> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Poste a").list();
	}
	public Poste getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Poste) session.get(Poste.class, id);
	}
	public void persist(Poste poste) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(poste);
	}
	public void update(Poste poste) {
		Session session=sessionFactory.getCurrentSession();
		session.update(poste);
	}
	public void delete(Poste poste) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(poste);
	}
	public void save(Poste poste) {
		Session session=sessionFactory.getCurrentSession();
		session.save(poste);
	}
	
	
	
}
