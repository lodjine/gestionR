package com.talan.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.ActionDao;
import com.talan.entities.Action;
import com.talan.entities.Utilisateur;

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
	
	public List<Action> getAll(Utilisateur user) {
		Session session=sessionFactory.getCurrentSession();
		
		
		String hql ="" ; 
		Query query = null ;
		if(user.getUserType().equals("admin")){
		 hql ="select a from Action a" ; 
		 query = session.createQuery(hql);	
		}else{
			hql ="select a from Action a WHERE a.user.email LIKE :email" ; 
			 query = session.createQuery(hql);	
			 query.setParameter("email",user.getEmail());
		}
	
		
		return query.list();
		
		
		
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

	public List<Action> getAllNonTermine() {
Session session=sessionFactory.getCurrentSession();
		
		return session.createQuery("select a from Action a where a.status < 100").list();
	}

	public List<Action> getAllTermine() {
Session session=sessionFactory.getCurrentSession();
		
		return session.createQuery("select a from Action a where a.status = 100").list();
	}

	

}
