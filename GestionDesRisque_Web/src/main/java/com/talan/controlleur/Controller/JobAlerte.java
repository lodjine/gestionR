package com.talan.controlleur.Controller;



import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.SessionFactoryBuilder;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.talan.entities.Action;
import com.talan.entities.AlerteAction;
import com.talan.entities.AlerteRisqueFort;
import com.talan.entities.Confidentialite;
import com.talan.entities.Disponibilite;
import com.talan.entities.Integrite;
import com.talan.entities.Risque;
import com.talan.service.ActionService;
import com.talan.service.AlerteService;

import com.talan.service.RisqueService;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class JobAlerte implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		MysqlDataSource dataSource = new MysqlDataSource();
	
		dataSource.setUser("root");
	
		 dataSource.setPassword("root");
	
		dataSource.setServerName("localhost");
	
		dataSource.setPort(3306);

		dataSource.setDatabaseName("talangr");
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=(Transaction) session.beginTransaction();
		
		List<Risque> risques=session.createQuery("select a from Risque a").list();
		System.out.println(risques.size());
		List<Action> actions=session.createQuery("select a from Action a").list();
		System.out.println(actions.size());
		for (Action action:actions){
			if(action.getBeginDate().compareTo(new Date())<0 && action.getEndDate().compareTo(new Date())<0 && action.getStatus()<100){
				AlerteAction alerte= new AlerteAction();
				alerte.setAlerte("l'action "+action.getLabel()+"affecter a "+action.getUser().getFirstName()+" "+action.getUser().getLastName() +" a atteint la date limite et l'evolution est de "+action.getStatus()+"%");
				alerte.setDate(new Date().toString());
				alerte.setRisque(action.getRisk().getRisqueLabel());
				session.persist(alerte);
				
			}
			risques.remove(action.getRisk());
		}
		
		for(Risque risque:risques){
			List<Risque> conf=session.createQuery("select a from Risque a WHERE a.risqueId =:id and a.total >= :debut and a.total < :fin ").setParameter("id", risque.getRisqueId()).setParameter("debut", 14).setParameter("fin", 9999).list();
			
			
			AlerteRisqueFort alerte= new AlerteRisqueFort();
			alerte.setAlerte("le risque "+ risque.getRisqueLabel()+" a depass� le seuil avec un resultat de  "+risque.getValue());
			alerte.setDate(new Date().toString());
			alerte.setRisque(risque.getRisqueLabel());
			
			session.persist(alerte);
		}
		
			tx.commit();
		
		
		
	}

	
}
