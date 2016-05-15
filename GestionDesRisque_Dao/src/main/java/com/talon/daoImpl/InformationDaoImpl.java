package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.InformationDao;
import com.talon.entities.Information;

@Repository
public class InformationDaoImpl implements InformationDao{

	
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Information> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Information a").list();
	}
	public Information getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Information) session.get(Information.class, id);
	}
	public void persist(Information info) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(info);
	}
	public void update(Information info) {
		Session session=sessionFactory.getCurrentSession();
		session.update(info);
	}
	public void delete(Information info) {
		Session session=sessionFactory.getCurrentSession();
session.delete(info);		
	}
	public void save(Information info) {
		Session session=sessionFactory.getCurrentSession();
		session.save(info);
	}
	
	
	
}
