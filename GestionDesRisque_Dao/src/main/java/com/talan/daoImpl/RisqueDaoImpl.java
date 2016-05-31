package com.talan.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.RisqueDao;
import com.talan.entities.Risque;

@Repository
public class RisqueDaoImpl implements RisqueDao{
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Risque> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Risque a").list();
	}
	public Risque getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Risque) session.get(Risque.class, id);
	}
	public int persist(Risque risque) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(risque);	
		return risque.getRisqueId();
	}
	public void update(Risque risque) {
		Session session=sessionFactory.getCurrentSession();
session.update(risque);		
	}
	public void delete(Risque risque) {
		Session session=sessionFactory.getCurrentSession();

		session.delete(risque);
	}
	public void save(Risque risque) {
		Session session=sessionFactory.getCurrentSession();

		session.save(risque);
	}
}
