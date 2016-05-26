package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.VulnerabiliteDao;
import com.talon.entities.Utilisateur;
import com.talon.entities.Vulnerabilite;
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
		return (Vulnerabilite) session.createQuery("select a from Vulnerabilite a where a.vulnId").uniqueResult();
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

}
