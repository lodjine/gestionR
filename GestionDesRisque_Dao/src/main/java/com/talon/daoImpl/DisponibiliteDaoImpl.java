package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.DisponibiliteDao;
import com.talon.entities.Disponibilite;
@Repository
public class DisponibiliteDaoImpl implements DisponibiliteDao {

	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Disponibilite> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Disponibilité a").list();
	}
	public Disponibilite getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Disponibilite) session.get(Disponibilite.class, id);
	}
	public void persist(Disponibilite dispo) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(dispo);
	}
	public void update(Disponibilite dispo) {
		Session session=sessionFactory.getCurrentSession();
		session.update(dispo);
		
	}
	public void delete(Disponibilite dispo) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(dispo);
		
	}
	public void save(Disponibilite dispo) {
		Session session=sessionFactory.getCurrentSession();
		session.save(dispo);
		
	}
}
