package com.talon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talon.dao.AdiministrateurDao;
import com.talon.entities.Administrateur;
@Repository
public class AdmistrateurDaoImpl implements AdiministrateurDao{

	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public List<Administrateur> getAll() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select a from Administrateur a").list();
	}

	public Administrateur getById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return (Administrateur) session.get(Administrateur.class, id);
	}

	public void persist(Administrateur admin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.persist(admin);
	}

	public void update(Administrateur admin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(admin);
	}

	public void delete(Administrateur admin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(admin);
	}

	public void save(Administrateur admin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(admin);
	}

}
