package com.talan.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.AlerteDao;
import com.talan.entities.Alerte;
import com.talan.entities.AlerteAction;
import com.talan.entities.AlerteRisqueFort;
@Repository
public class AlerteDaoImpl implements AlerteDao{
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

	public Alerte getById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return (Alerte) session.get(Alerte.class, id);
	}

	public void persist(Alerte alerte) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(alerte);
	}

	public void update(Alerte alerte) {
		Session session=sessionFactory.getCurrentSession();
		session.update(alerte);
	}

	public void delete(Alerte alerte) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(alerte);
	}

	public void save(Alerte alerte) {
		Session session=sessionFactory.getCurrentSession();
		session.save(alerte);
	}
	
	public List<AlerteRisqueFort> getAllRisque() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from AlerteRisqueFort a").list();
	}

	public List<AlerteAction> getAllAction() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from AlerteAction a").list();
	}
}
