package com.talan.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.SousProcessusDao;
import com.talan.entities.SousProcessus;

@Repository
public class SousProcessusDaoImpl implements SousProcessusDao{

@Autowired
SessionFactory sessionFactory;
public SessionFactory getSessionFactory() {
	return sessionFactory;
}
public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
public List<SousProcessus> getAll() {
	Session session=sessionFactory.getCurrentSession();
	return session.createQuery("select a from SousProcessus a").list();
}
public SousProcessus getById(int id) {
	Session session=sessionFactory.getCurrentSession();
	return (SousProcessus) session.get(SousProcessus.class, id);
}
public void persist(SousProcessus ssPro) {
	Session session=sessionFactory.getCurrentSession();

	session.persist(ssPro);
}
public void update(SousProcessus ssPro) {
	Session session=sessionFactory.getCurrentSession();

	session.update(ssPro);
}
public void delete(SousProcessus ssPro) {
	// TODO Auto-generated method stub
	Session session=sessionFactory.getCurrentSession();

	session.delete(ssPro);
}
public int save(SousProcessus ssPro) {
	// TODO Auto-generated method stub
	Session session=sessionFactory.getCurrentSession();

	SousProcessus p = (SousProcessus) session.merge(ssPro);
	return p.getSspId() ; 
}
}