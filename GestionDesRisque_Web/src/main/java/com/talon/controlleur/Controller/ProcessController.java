package com.talon.controlleur.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.talon.entities.Activite;
import com.talon.entities.Information;
import com.talon.entities.Processus;
import com.talon.entities.SousProcessus;
import com.talon.service.ProcessService;



@Controller
public class ProcessController {
	
	@Autowired
	ProcessService processServiceImpl;
	
	
	
	public ProcessService getProcessServiceImpl() {
		return processServiceImpl;
	}

	public void setProcessServiceImpl(ProcessService processServiceImpl) {
		processServiceImpl = processServiceImpl;
	}

	@RequestMapping(value = "/ProcessAdd", method = RequestMethod.GET)
	public ModelAndView addProcess(){
		
		ModelAndView model = new ModelAndView("Process/processAjout") ; 
		System.out.println("---------------------------------------");
		Processus processus=new Processus();
		model.addObject("processus", processus);
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/ShowProcessus", method = RequestMethod.GET)
	public ModelAndView AfficheProcess(){
		
		ModelAndView model = new ModelAndView("Process/processAffiche") ; 
	
		Processus proc =  processServiceImpl.getById(1);
		List<Integer> activityList = new ArrayList<Integer>() ; 
		List<Integer> infoList = new ArrayList<Integer>() ; 
		List<SousProcessus> sousProcesss = new ArrayList<SousProcessus>();
		
		sousProcesss = proc.getSsProcs() ; 
		List<Activite> activites = new ArrayList<Activite>();
		for(int i = 0 ; i<sousProcesss.size() ; i++){
			activites.addAll(sousProcesss.get(i).getActivites());
			activityList.add(sousProcesss.get(i).getActivites().size()) ;
		}
		List<Information> informations = new ArrayList<Information>() ; 
		for (int i = 0 ; i<activites.size() ; i++ ) {
			informations.addAll(activites.get(i).getInformations());
			infoList.add(activites.get(i).getInformations().size());
		}
		
		int sizeTotal = informations.size() ; 
		model.addObject("infoList",infoList);
		model.addObject("activityList",activityList);
		model.addObject("sizeTotal",sizeTotal);
		model.addObject("proc",proc);
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/AddProcessus", method = RequestMethod.POST)
	public ModelAndView validProcess(@ModelAttribute Processus processus){
		
		ModelAndView model = new ModelAndView("index") ; 
	
		processServiceImpl.save(processus);
		return model ; 
		
		
	}
}
