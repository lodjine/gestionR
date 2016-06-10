package com.talan.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.ImpactDao;
import com.talan.entities.ImpactC;
import com.talan.entities.Vulnerabilite;
@Repository
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
		
		String hql = "select a from ImpactC a where a.impactId =:id" ; 
		Query query = session.createQuery(hql) ; 
		query.setParameter("id", id);
		
		return (ImpactC) query.uniqueResult() ;
		
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
	public List<ImpactC> getImpactCByRiskAndType(int id, String type) {
		// TODO Auto-generated method stub
Session session=sessionFactory.getCurrentSession();
		
		String hql = "select a from ImpactC a where a.risque.risqueId =:id AND a.risque.critere LIKE :type" ; 
		Query query = session.createQuery(hql) ; 
		query.setParameter("id", id);
		query.setParameter("type", type);
		return query.list() ;
	}
	
}
