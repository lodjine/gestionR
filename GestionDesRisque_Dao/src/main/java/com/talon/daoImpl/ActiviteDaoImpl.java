package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.ActionDao;
import com.talon.dao.ActiviteDao;
import com.talon.entities.Activit�;

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
	
	public List<Activit�> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Activit� a").list();
	}

	public Activit� getById(int id) {
		Session session=sessionFactory.getCurrentSession();	
		return (Activit�) session.get(Activit�.class, id);
	}

	public void persist(Activit� activit�) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.persist(activit�);
	}

	public void update(Activit� activit�) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(activit�);
	}

	public void delete(Activit� activit�) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(activit�);
	}

	public void save(Activit� activit�) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(activit�);
	}

}
