package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.ConfidentialiteDao;
import com.talon.entities.Confidentialit�;

@Repository
public class ConfidentialiteDaoImpl implements ConfidentialiteDao {

	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Confidentialit�> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Confidentialit� a").list();
		
	}
	public Confidentialit� getById(int id) {
		Session session=sessionFactory.getCurrentSession();	
		return (Confidentialit�) session.get(Confidentialit�.class, id);
	}
	public void persist(Confidentialit� conf) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(conf);
	}
	public void update(Confidentialit� conf) {
		Session session=sessionFactory.getCurrentSession();
		session.update(conf);
	}
	public void delete(Confidentialit� conf) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(conf);
	}
	public void save(Confidentialit� conf) {
		Session session=sessionFactory.getCurrentSession();
		session.save(conf);
	}
	
	
}
