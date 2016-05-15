package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.ClassificationDao;
import com.talon.entities.Classification;
@Repository
public class ClassificationDaoImpl implements ClassificationDao{
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Classification> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Classification a").list();
	}
	public Classification getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Classification) session.get(Classification.class,id);
	}
	public void persist(Classification classi) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(classi);
		
	}
	public void update(Classification classi) {
		Session session=sessionFactory.getCurrentSession();
		session.update(classi);
		
	}
	public void delete(Classification classi) {
		Session session=sessionFactory.getCurrentSession();
		session.update(classi);
		
	}
	public void save(Classification classi) {
		Session session=sessionFactory.getCurrentSession();
		session.save(classi);
		
	}
}
