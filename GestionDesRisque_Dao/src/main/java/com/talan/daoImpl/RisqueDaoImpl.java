package com.talan.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.RisqueDao;
import com.talan.entities.Confidentialite;
import com.talan.entities.Disponibilite;
import com.talan.entities.Integrite;
import com.talan.entities.Risque;
import com.talan.entities.Utilisateur;

@Repository
public class RisqueDaoImpl implements RisqueDao{
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Risque> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Risque a").list();
	}
	public Risque getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Risque) session.get(Risque.class, id);
	}
	public int persist(Risque risque) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(risque);	
		return risque.getRisqueId();
	}
	public void update(Risque risque) {
		Session session=sessionFactory.getCurrentSession();
session.update(risque);		
	}
	public void delete(Risque risque) {
		Session session=sessionFactory.getCurrentSession();

		session.delete(risque);
	}
	public void save(Risque risque) {
		Session session=sessionFactory.getCurrentSession();

		session.save(risque);
	}

	
	
	
	public List<Risque> getRiskByProc(int idproc, String user, String userRole, int res) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ; 
		Query query = null ;
		int min = 0 ; 
		int max = 0 ;
		if(res==0){
		min=-9999;
		max=7;
		}else
		if(res == 1){
			min = 8 ; 
			max = 14 ; 
		}else if(res == 2) {
			min = 14 ; 
			max = 19 ; 
		}else{
			min = 20 ; 
			max = 9999999 ;
		}
		if(userRole.equals("admin")){
		String hql = "select e from Risque e WHERE e.proc.procId =:idproc AND e.value >= :min AND e.value <=:max ";
		
		 query= session.createQuery(hql);	
		query.setParameter("idproc", idproc);
		query.setParameter("min", min);
		query.setParameter("max", max);
		}else{
			
			String hql = "select e from Risque e WHERE e.proc.procId =:idproc AND e.proc.user.email =:user AND e.value >= :min AND e.value <=:max";
			
			 query= session.createQuery(hql);	
			query.setParameter("idproc", idproc);
			query.setParameter("user", user);
			query.setParameter("min", min);
			query.setParameter("max", max);
		}
		
		return query.list();
	}


	public List<Risque> getRiskByProc(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ; 
		
		String hql = "SELECT a FROM Risque a WHERE a.proc.procId =:id";
		Query query =session.createQuery(hql);	
		query.setParameter("id", id);
		return query.list();
	}
	public List<Risque> getAllByc(String c) {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Risque a WHERE a.critere =:c").setParameter("c", c).list();
	}

	
}
