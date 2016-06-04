package com.talan.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talan.dao.DisponibiliteDao;
import com.talan.entities.Disponibilite;
@Repository
public class DisponibiliteDaoImpl implements DisponibiliteDao {

	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Disponibilite> getAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Disponibilite a").list();
	}
	public Disponibilite getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Disponibilite) session.get(Disponibilite.class, id);
	}
	public void persist(Disponibilite dispo) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(dispo);
	}
	public void update(Disponibilite dispo) {
		Session session=sessionFactory.getCurrentSession();
		session.update(dispo);
		
	}
	public void delete(Disponibilite dispo) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(dispo);
		
	}
	public void save(Disponibilite dispo) {
		Session session=sessionFactory.getCurrentSession();
		session.save(dispo);
		
	}
	public int merge(Disponibilite disp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ; 
		Disponibilite disps = new Disponibilite() ; 
		disps = (Disponibilite) session.merge(disp) ; 
		return disps.getDispId() ;
		
	}
	public List<Disponibilite> getAllByProc(int id, int debut , int fin) {
		Session session=sessionFactory.getCurrentSession();	
		return  session.createQuery("select a from Disponibilite a WHERE a.risque.proc.procId =:id and a.resultat >= :debut and a.resultat < :fin ").setParameter("id", id).setParameter("debut", debut).setParameter("fin", fin).list();
	}
}
