package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.AnalyseDesRisqueDao;
import com.talon.entities.AnalyseDesRisques;
@Repository
public class AnalyseDesRisqueDaoImpl implements AnalyseDesRisqueDao{

	
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<AnalyseDesRisques> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from AnalyseDesRisques a").list();
	}

	public AnalyseDesRisques getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (AnalyseDesRisques) session.get(AnalyseDesRisques.class, id);
	}

	public void persist(AnalyseDesRisques analyseR) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(analyseR);
	}

	public void update(AnalyseDesRisques analyseR) {
		Session session=sessionFactory.getCurrentSession();
		session.update(analyseR);
	}

	public void delete(AnalyseDesRisques analyseR) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(analyseR);
		
	}

	public void save(AnalyseDesRisques analyseR) {
		Session session=sessionFactory.getCurrentSession();
		session.save(analyseR);
		
	}
	
	
}
