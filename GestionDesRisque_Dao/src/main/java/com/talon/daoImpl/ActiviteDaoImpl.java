package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.ActionDao;
import com.talon.dao.ActiviteDao;
import com.talon.entities.Activité;

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
	
	public List<Activité> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Activité a").list();
	}

	public Activité getById(int id) {
		Session session=sessionFactory.getCurrentSession();	
		return (Activité) session.get(Activité.class, id);
	}

	public void persist(Activité activité) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.persist(activité);
	}

	public void update(Activité activité) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(activité);
	}

	public void delete(Activité activité) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(activité);
	}

	public void save(Activité activité) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(activité);
	}

}
