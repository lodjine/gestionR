package com.talon.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.ProcessDao;
import com.talon.entities.Processus;
@Repository
@Transactional
public class ProcessusDaoImpl implements ProcessDao {
	
	
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Processus> getAll() {
Session session=sessionFactory.getCurrentSession();
		
		return session.createQuery("select a from Processus a").list();
	}

	public Processus getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		// TODO Auto-generated method stub
		return (Processus) session.get(Processus.class, id);
	}

	public void persist(Processus ssPro) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(ssPro);
		
	}

	public void update(Processus ssPro) {
		Session session=sessionFactory.getCurrentSession();
		session.update(ssPro);
		
	}

	public void delete(Processus ssPro) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(ssPro);
		
	}

	public void save(Processus ssPro) {
		Session session=sessionFactory.getCurrentSession();
		session.save(ssPro);
		
	}

}
