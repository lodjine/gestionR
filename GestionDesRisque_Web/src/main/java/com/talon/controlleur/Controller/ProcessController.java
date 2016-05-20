package com.talon.controlleur.Controller;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.talon.entities.Activite;
import com.talon.entities.Information;
import com.talon.entities.Processus;

import com.talon.entities.Utilisateur;

import com.talon.entities.SousProcessus;

import com.talon.service.ProcessService;

import com.talon.service.UtilisateurService;




@Controller
public class ProcessController {
	
	@Autowired
	ProcessService processServiceImpl;
	@Autowired
	UtilisateurService utilisateurServiceImpl;
	
	
	public ProcessService getProcessServiceImpl() {
		return processServiceImpl;
	}

	public void setProcessServiceImpl(ProcessService processServiceImpl) {
		this.processServiceImpl = processServiceImpl;
	}

	@RequestMapping(value = "/ShowProcessus", params="newRecord",method = RequestMethod.GET)
	public ModelAndView addProcess(){
		
		ModelAndView model = new ModelAndView("Process/processAjout") ; 
		System.out.println("---------------------------------------");
		Processus processus=new Processus();
		List<Utilisateur> users=utilisateurServiceImpl.getAll();
		model.addObject("users", users);
		model.addObject("processus", processus);
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/ShowProcessus",params="updateByCode", method = RequestMethod.GET)
	public ModelAndView AfficheProcess(@RequestParam("byCode") int id){
		int sizeTotal = 0 ; 
		ModelAndView model = new ModelAndView("Process/processAffiche") ; 
		List<List<Activite>> activitys = new ArrayList<List<Activite>>();
		List<List<Information>> infoss = new ArrayList<List<Information>>();
		Processus proc =  processServiceImpl.getById(id);
		List<Integer> infoList = new ArrayList<Integer>() ; 
		List<Integer> intList = new ArrayList<Integer>() ; 
		List<Integer> activitysize = new ArrayList<Integer>();
		List<SousProcessus> sousProcesss = new ArrayList<SousProcessus>();
		
		sousProcesss = proc.getSsProcs() ; 
		
		for(int i = 0 ; i<sousProcesss.size() ; i++){
			activitys.add(i,sousProcesss.get(i).getActivites());
			sizeTotal = 0  ;
			for (int x = 0 ; x<activitys.get(i).size() ; x++ ) {
				infoss.add(activitys.get(i).get(x).getInformations());
				infoList.add(activitys.get(i).get(x).getInformations().size());
				sizeTotal = sizeTotal+activitys.get(i).get(x).getInformations().size() ; 
				
			}
			intList.add(i, sizeTotal);
			activitysize.add(sousProcesss.get(i).getActivites().size());
		}
		
		
		model.addObject("actSize",activitysize);
		model.addObject("intList",intList) ;
		model.addObject("addValue",infoList.size());
		model.addObject("infoList",infoList);
		model.addObject("sizeTotal",sizeTotal);
		model.addObject("activitys",activitys);
		model.addObject("infoss",infoss);
		model.addObject("proc",proc);
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/AddProcessus", method = RequestMethod.POST)
	public ModelAndView validProcess(@ModelAttribute Processus processus){
		
		ModelAndView model = new ModelAndView("index") ; 
	
		processServiceImpl.save(processus);
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/AffichProc", method = RequestMethod.GET)
	public ModelAndView AffichProcess(@ModelAttribute Processus processus){
		
		ModelAndView model = new ModelAndView("Process/processAffich") ; 
		List<Processus> Listprocess=processServiceImpl.getAll();
		model.addObject("Listprocess", Listprocess);
		model.addObject("size",Listprocess.size());
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/MenuProces", method = RequestMethod.GET)
	public ModelAndView MenuProc(){
		
		ModelAndView model = new ModelAndView("Process/ActifMenu") ; 
		
		model.addObject("Listprocess", processServiceImpl.getAll());
		return model ;
		
		
	}
	
}
