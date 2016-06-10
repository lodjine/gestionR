package com.talan.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.VulnerabiliteDao;
import com.talan.entities.Utilisateur;
import com.talan.entities.Vulnerabilite;
@Repository
public class VulnerabiliteDaoImpl implements VulnerabiliteDao {
	@Autowired
	SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Vulnerabilite> getAll() {
		Session session=sessionFactory.getCurrentSession();
		String hql = "select a from Vulnerabilite a" ; 
		Query query = session.createQuery(hql) ;  
		
		return query.list() ; 
	}

	public Vulnerabilite getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Vulnerabilite) session.createQuery("select a from Vulnerabilite a where a.vulnId =:id").setParameter("id", id).uniqueResult();
	}

	public void persist(Vulnerabilite vulner) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(vulner);
		
	}

	public void update(Vulnerabilite vulner) {
		Session session=sessionFactory.getCurrentSession();
		session.update(vulner);
		
	}

	public void delete(Vulnerabilite vulner) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(vulner);
		
	}

	public void save(Vulnerabilite vulner) {
		Session session=sessionFactory.getCurrentSession();
		session.save(vulner);
	}
	public List<Vulnerabilite> getVulnerabiliteByRiskAndType(int id, String type) {
		// TODO Auto-generated method stub
Session session=sessionFactory.getCurrentSession();
		
		String hql = "select a from Vulnerabilite a where a.risque.risqueId =:id AND a.risque.critere LIKE :type" ; 
		Query query = session.createQuery(hql) ; 
		query.setParameter("id", id);
		query.setParameter("type", type);
		return query.list() ;
	}

}
