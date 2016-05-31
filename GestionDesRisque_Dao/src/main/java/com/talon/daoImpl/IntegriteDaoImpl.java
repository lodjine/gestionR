package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.IntegriteDao;
import com.talon.entities.Integrite;
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
	public List<Integrite> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Intégrité a").list();
	}
	public Integrite getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Integrite) session.get(Integrite.class, id);
	}
	public void persist(Integrite integ) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(integ);
		
	}
	public void update(Integrite integ) {
		Session session=sessionFactory.getCurrentSession();
		session.update(integ);
		
	}
	public void delete(Integrite integ) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(integ);
		
	}
	public void save(Integrite integ) {
		Session session=sessionFactory.getCurrentSession();
		session.save(integ);
		
	}
	public int merge(Integrite intg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ; 
		Integrite intg2 = new Integrite() ; 
		intg2 = (Integrite) session.merge(intg) ; 
		return intg2.getIntegId();
	}
	
	
	
}
