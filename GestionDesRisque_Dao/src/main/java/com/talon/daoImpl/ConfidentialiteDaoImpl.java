package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.ConfidentialiteDao;
import com.talon.entities.Confidentialité;

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
	public List<Confidentialité> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Confidentialité a").list();
		
	}
	public Confidentialité getById(int id) {
		Session session=sessionFactory.getCurrentSession();	
		return (Confidentialité) session.get(Confidentialité.class, id);
	}
	public void persist(Confidentialité conf) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(conf);
	}
	public void update(Confidentialité conf) {
		Session session=sessionFactory.getCurrentSession();
		session.update(conf);
	}
	public void delete(Confidentialité conf) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(conf);
	}
	public void save(Confidentialité conf) {
		Session session=sessionFactory.getCurrentSession();
		session.save(conf);
	}
	
	
}
