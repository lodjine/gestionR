package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.DisponibiliteDao;
import com.talon.entities.Disponibilit�;
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
	public List<Disponibilit�> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Disponibilit� a").list();
	}
	public Disponibilit� getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Disponibilit�) session.get(Disponibilit�.class, id);
	}
	public void persist(Disponibilit� dispo) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(dispo);
	}
	public void update(Disponibilit� dispo) {
		Session session=sessionFactory.getCurrentSession();
		session.update(dispo);
		
	}
	public void delete(Disponibilit� dispo) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(dispo);
		
	}
	public void save(Disponibilit� dispo) {
		Session session=sessionFactory.getCurrentSession();
		session.save(dispo);
		
	}
}
