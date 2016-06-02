package com.talan.metierAlerte;

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
import com.talan.entities.Risque;
import com.talan.service.ActionService;
import com.talan.service.RisqueService;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class JobAlerte implements Job{
@Autowired
ActionService actionServiceImpl;

@Autowired 
RisqueService risqueServiceImpl;
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		List<Action> actions=actionServiceImpl.getAll();
		List<Risque> risques=risqueServiceImpl.getAll();
		
		for (Action action:actions){
			if(action.getBeginDate().compareTo(new Date())>0 && action.getEndDate().compareTo(new Date())>0 && action.getStatus()<100){
				AlerteAction alerte= new AlerteAction();
				alerte.setAlerte("l'action "+action.getLabel()+"affecter a "+action.getUser().getFirstName()+" "+action.getUser().getLastName() +"a atteint la date limite et l'evolution est de "+action.getStatus());
				actionServiceImpl.persist(action);
			}
		}
		
		
		
	}

	
}
