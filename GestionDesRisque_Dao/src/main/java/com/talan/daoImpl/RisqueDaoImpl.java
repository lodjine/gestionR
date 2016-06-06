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
	public List<Confidentialite> getConfByProc(int idproc, String user,String userRole) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ; 
		Query query = null ;
		if(userRole.equals("admin")){
		String hql = "select e from Confidentialite e WHERE e.risque.proc.procId =:idproc";
		
		 query= session.createQuery(hql);	
		query.setParameter("idproc", idproc);
		}else{
			
			String hql = "select e from Confidentialite e WHERE e.risque.proc.procId =:idproc AND e.risque.proc.user.email =:user";
			
			 query= session.createQuery(hql);	
			query.setParameter("idproc", idproc);
			query.setParameter("user", user);
		}
		
		return query.list();
	}
	public List<Confidentialite> getConfByProcRev(int idproc, String user, String userRole, int res) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ; 
		Query query = null ;
		int min = 0 ; 
		int max = 0 ;
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
		String hql = "select e from Confidentialite e WHERE e.risque.proc.procId =:idproc AND e.Resultat >= :min AND e.Resultat <=:max ";
		
		 query= session.createQuery(hql);	
		query.setParameter("idproc", idproc);
		query.setParameter("min", min);
		query.setParameter("max", max);
		}else{
			
			String hql = "select e from Confidentialite e WHERE e.risque.proc.procId =:idproc AND e.risque.proc.user.email =:user AND e.Resultat >= :min AND e.Resultat <=:max";
			
			 query= session.createQuery(hql);	
			query.setParameter("idproc", idproc);
			query.setParameter("user", user);
			query.setParameter("min", min);
			query.setParameter("max", max);
		}
		
		return query.list();
	}
	public List<Disponibilite> getdispByProc(int idproc, String user,String userRole) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ; 
		Query query = null ;
		if(userRole.equals("admin")){
		String hql = "select e from Disponibilite e WHERE e.risque.proc.procId =:idproc";
		
		 query= session.createQuery(hql);	
		query.setParameter("idproc", idproc);
		}else{
			
			String hql = "select e from Disponibilite e WHERE e.risque.proc.procId =:idproc AND e.risque.proc.user.email =:user";
			
			 query= session.createQuery(hql);	
			query.setParameter("idproc", idproc);
			query.setParameter("user", user);
		}
		
		return query.list();
	}
	public List<Disponibilite> getdispByProcRev(int idproc, String user, String userRole, int res) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ; 
		Query query = null ;
		int min = 0 ; 
		int max = 0 ;
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
		String hql = "select e from Disponibilite e WHERE e.risque.proc.procId =:idproc AND e.Resultat >= :min AND e.Resultat <=:max ";
		
		 query= session.createQuery(hql);	
		query.setParameter("idproc", idproc);
		query.setParameter("min", min);
		query.setParameter("max", max);
		}else{
			
			String hql = "select e from Disponibilite e WHERE e.risque.proc.procId =:idproc AND e.risque.proc.user.email =:user AND e.Resultat >= :min AND e.Resultat <=:max";
			
			 query= session.createQuery(hql);	
			query.setParameter("idproc", idproc);
			query.setParameter("user", user);
			query.setParameter("min", min);
			query.setParameter("max", max);
		}
		
		return query.list();
	}
	public List<Integrite> getIntByProc(int idproc, String user, String userRole) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ; 
		Query query = null ;
		if(userRole.equals("admin")){
		String hql = "select e from Integrite e WHERE e.risque.proc.procId =:idproc";
		
		 query= session.createQuery(hql);	
		query.setParameter("idproc", idproc);
		}else{
			
			String hql = "select e from Integrite e WHERE e.risque.proc.procId =:idproc AND e.risque.proc.user.email =:user";
			
			 query= session.createQuery(hql);	
			query.setParameter("idproc", idproc);
			query.setParameter("user", user);
		}
		
		return query.list();
	}
	public List<Integrite> getIntByProcRev(int idproc, String user, String userRole, int res) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ; 
		Query query = null ;
		int min = 0 ; 
		int max = 0 ;
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
		String hql = "select e from Integrite e WHERE e.risque.proc.procId =:idproc AND e.Resultat >= :min AND e.Resultat <=:max ";
		
		 query= session.createQuery(hql);	
		query.setParameter("idproc", idproc);
		query.setParameter("min", min);
		query.setParameter("max", max);
		}else{
			
			String hql = "select e from Integrite e WHERE e.risque.proc.procId =:idproc AND e.risque.proc.user.email =:user AND e.Resultat >= :min AND e.Resultat <=:max";
			
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
	
}
