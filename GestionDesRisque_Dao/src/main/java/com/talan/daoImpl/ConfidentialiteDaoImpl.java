package com.talan.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.ConfidentialiteDao;
import com.talan.entities.Confidentialite;

@Repository
public class ConfidentialiteDaoImpl implements ConfidentialiteDao {

	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Confidentialite> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Confidentialite a").list();
		
	}
	public Confidentialite getById(int id) {
		Session session=sessionFactory.getCurrentSession();	
		return (Confidentialite) session.createQuery("select a from Confidentialite a WHERE ConfId =:id").setParameter("id", id).uniqueResult();
	}
	public void persist(Confidentialite conf) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(conf);
	}
	public void update(Confidentialite conf) {
		Session session=sessionFactory.getCurrentSession();
		session.update(conf);
	}
	public void delete(Confidentialite conf) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(conf);
	}
	public void save(Confidentialite conf) {
		Session session=sessionFactory.getCurrentSession();
		session.save(conf);
	}
	public int merge(Confidentialite conf) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ; 
		Confidentialite conff = (Confidentialite) session.merge(conf);
		
		return conff.getConfId() ;
	}
	
}
