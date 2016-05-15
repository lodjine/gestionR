package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.IntegriteDao;
import com.talon.entities.Intégrité;
@Repository
public class IntegriteDaoImpl implements IntegriteDao{
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Intégrité> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Intégrité a").list();
	}
	public Intégrité getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Intégrité) session.get(Intégrité.class, id);
	}
	public void persist(Intégrité integ) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(integ);
		
	}
	public void update(Intégrité integ) {
		Session session=sessionFactory.getCurrentSession();
		session.update(integ);
		
	}
	public void delete(Intégrité integ) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(integ);
		
	}
	public void save(Intégrité integ) {
		Session session=sessionFactory.getCurrentSession();
		session.save(integ);
		
	}
	
	
	
}
