package com.talan.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.ActionDao;
import com.talan.dao.ActiviteDao;
import com.talan.entities.Activite;

@Repository
public class ActiviteDaoImpl implements ActiviteDao{

	
	
	
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Activite> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Activite a").list();
	}
	
	public Activite getById(int id) {
		Session session=sessionFactory.getCurrentSession();	
		return (Activite) session.get(Activite.class, id);
	}

	public void persist(Activite activité) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.persist(activité);
	}

	public void update(Activite activité) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(activité);
	}

	public void delete(Activite activité) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(activité);
	}

	public void save(Activite activité) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(activité);
	}

}
