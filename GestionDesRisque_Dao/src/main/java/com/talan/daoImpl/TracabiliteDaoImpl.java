package com.talan.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.TracabiliteDao;
import com.talan.entities.Tracabilite;
@Repository
public class TracabiliteDaoImpl implements TracabiliteDao {
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Tracabilite> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Tracabilite a").list();
	}

	public void persist(Tracabilite trace) {
		Session session=sessionFactory.getCurrentSession();
		 session.persist(trace);
		
	}

}
