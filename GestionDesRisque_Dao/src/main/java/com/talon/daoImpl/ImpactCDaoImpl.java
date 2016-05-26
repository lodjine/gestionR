package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.talon.dao.ImpactDao;
import com.talon.entities.ImpactC;
import com.talon.entities.Vulnerabilite;

public class ImpactCDaoImpl implements ImpactDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	public List<ImpactC> getAll() {
		Session session=sessionFactory.getCurrentSession();
		String hql = "select a from ImpactC a" ; 
		Query query = session.createQuery(hql) ;  
		
		return query.list() ; 
	}

	public ImpactC getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (ImpactC) session.createQuery("select a from ImpactC a where a.vulnId").uniqueResult();
	}

	public void persist(ImpactC impactC) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(impactC);
		
	}

	public void update(ImpactC impactC) {
		Session session=sessionFactory.getCurrentSession();
		session.update(impactC);
		
	}

	public void delete(ImpactC impactC) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(impactC);
	}

	public void save(ImpactC impactC) {
		Session session=sessionFactory.getCurrentSession();
		session.save(impactC);
		
	}

}
