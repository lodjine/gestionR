package com.talan.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.MesureExDao;
import com.talan.entities.MesureEx;
import com.talan.entities.Processus;
@Repository
public class MesureDaoImpl implements MesureExDao{
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<MesureEx> getAllMesure() {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from MesureEx a").list();
		
	}

	public MesureEx getMesureById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		String hql ="select a from MesureEx a WHERE a.mesureId =:id" ; 
		Query query= session.createQuery(hql);	
		 query.setParameter("id",id);
		 return (MesureEx) query.uniqueResult() ;
	}

	public void updateMuser(MesureEx mesure) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(mesure);
	}

	public void deleteMuser(MesureEx mesure) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(mesure);
	}
	public void persisteMesure(MesureEx mesure) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(mesure);
	}
	public List<MesureEx> getmesureByRiskAndType(int id, String type) {
		// TODO Auto-generated method stub
Session session=sessionFactory.getCurrentSession();
		
		String hql = "select a from MesureEx a where a.risque.risqueId =:id AND a.critere LIKE :type" ; 
		Query query = session.createQuery(hql) ; 
		query.setParameter("id", id);
		query.setParameter("type", type);
		return query.list() ;
	}

}
