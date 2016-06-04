package com.talan.controlleur.Controller;



import java.util.Date;
import java.util.List;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;

import com.talan.entities.Action;
import com.talan.entities.AlerteAction;
import com.talan.entities.AlerteRisqueFort;
import com.talan.entities.Confidentialite;
import com.talan.entities.Disponibilite;
import com.talan.entities.Integrite;
import com.talan.entities.Risque;
import com.talan.service.ActionService;
import com.talan.service.AlerteService;
import com.talan.service.ConfidentialiteService;
import com.talan.service.DisponibiliteService;
import com.talan.service.IntegriteService;
import com.talan.service.RisqueService;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class JobAlerte implements Job{
@Autowired
private ActionService actionServiceImpl;

@Autowired 
private RisqueService risqueServiceImpl;
@Autowired
private ConfidentialiteService confidentialiteServiceImpl;
@Autowired
private DisponibiliteService disponibiliteServiceImpl;
@Autowired
private IntegriteService integriteServiceImpl;
@Autowired
private AlerteService alerteServiceImpl;
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		List<Risque> risques=risqueServiceImpl.getAll();
		List<Action> actions=actionServiceImpl.getAll();
		for (Action action:actions){
			if(action.getBeginDate().compareTo(new Date())>0 && action.getEndDate().compareTo(new Date())>0 && action.getStatus()<100){
				AlerteAction alerte= new AlerteAction();
				alerte.setAlerte("l'action "+action.getLabel()+"affecter a "+action.getUser().getFirstName()+" "+action.getUser().getLastName() +"a atteint la date limite et l'evolution est de "+action.getStatus());
				alerteServiceImpl.persist(alerte);
				risques.remove(action.getRisk());
			}
		}
		
		for(Risque risque:risques){
			List<Confidentialite> conf=confidentialiteServiceImpl.getAllByProc(risque.getRisqueId(), 15, 20);
			List<Disponibilite> disp=disponibiliteServiceImpl.getAllByProc(risque.getRisqueId(), 15, 20);
			List<Integrite> integ=integriteServiceImpl.getAllByProc(risque.getRisqueId(), 15, 20);
			
			AlerteRisqueFort alerte= new AlerteRisqueFort();
			alerte.setAlerte("le risque "+ risque.getRisqueLabel()+" a depassé le seuil pour la confidentialité a "+conf.size()+" reprise , pour la disponiblité a "+disp.size()+" reprise et "+ integ.size()+" reprise pour l'integrité ");
			alerteServiceImpl.persist(alerte);
		}
		
	}

	
}
