package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.ResponsableDao;
import com.talon.entities.Responsable;

@Repository
public class ResponsableDaoImpl implements ResponsableDao{
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Responsable> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Responsable a").list();
	}
	public Responsable getById(int id) {
		Session session=sessionFactory.getCurrentSession();

		return (Responsable) session.get(Responsable.class, id);
	}
	public void persist(Responsable resp) {
		Session session=sessionFactory.getCurrentSession();

		session.persist(resp);
	}
	public void update(Responsable resp) {
		Session session=sessionFactory.getCurrentSession();
		session.update(resp);
	}
	public void delete(Responsable resp) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(resp);
	}
	public void save(Responsable resp) {
		Session session=sessionFactory.getCurrentSession();
		session.save(resp);
		
	}
}
