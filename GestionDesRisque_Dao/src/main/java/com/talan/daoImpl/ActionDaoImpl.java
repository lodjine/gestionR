package com.talan.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.ActionDao;
import com.talan.entities.Action;

@Repository
public class ActionDaoImpl implements ActionDao{

	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Action> getAll() {
		Session session=sessionFactory.getCurrentSession();
		
		return session.createQuery("select a from Action a").list();
	}

	public Action getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Action) session.get(Action.class, id);
	}

	public void persist(Action action) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(action);
	}

	public void update(Action action) {
		Session session=sessionFactory.getCurrentSession();
		session.update(action);
	}

	public void delete(Action action) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(action);
	}

	public void save(Action action) {
		Session session=sessionFactory.getCurrentSession();
		session.save(action);
	}

}
