package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.IntegriteDao;
import com.talon.entities.Int�grit�;
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
	public List<Int�grit�> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Int�grit� a").list();
	}
	public Int�grit� getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Int�grit�) session.get(Int�grit�.class, id);
	}
	public void persist(Int�grit� integ) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(integ);
		
	}
	public void update(Int�grit� integ) {
		Session session=sessionFactory.getCurrentSession();
		session.update(integ);
		
	}
	public void delete(Int�grit� integ) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(integ);
		
	}
	public void save(Int�grit� integ) {
		Session session=sessionFactory.getCurrentSession();
		session.save(integ);
		
	}
	
	
	
}
