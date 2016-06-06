package com.talan.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.ProcessDao;
import com.talan.entities.Processus;
import com.talan.entities.Utilisateur;
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
	
	public List<Processus> getAll(Utilisateur user) {
		Session session=sessionFactory.getCurrentSession();
		String hql ="" ; 
		Query query = null ;
		if(user.getUserType().equals("admin")){
		 hql ="select a from Processus a" ; 
		 query = session.createQuery(hql);	
		}else{
			hql ="select a from Processus a WHERE a.user.email LIKE :email" ; 
			 query = session.createQuery(hql);	
			 query.setParameter("email",user.getEmail());
		}
	
		
		return session.createQuery("select a from Processus a").list();
	}

	public Processus getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		// TODO Auto-generated method stub
		
		String hql ="select a from Processus a WHERE a.procId =:id" ; 
		Query query= session.createQuery(hql);	
		 query.setParameter("id",id);
		 return (Processus) query.uniqueResult() ; 
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
