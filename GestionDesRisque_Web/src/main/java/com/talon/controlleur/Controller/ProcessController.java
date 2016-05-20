package com.talon.controlleur.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.talon.entities.Processus;
import com.talon.entities.Utilisateur;
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
		processServiceImpl = processServiceImpl;
	}

	@RequestMapping(value = "/ProcessAdd", method = RequestMethod.GET)
	public ModelAndView addProcess(){
		
		ModelAndView model = new ModelAndView("Process/processAjout") ; 
		System.out.println("---------------------------------------");
		Processus processus=new Processus();
		List<Utilisateur> users=utilisateurServiceImpl.getAll();
		model.addObject("users", users);
		model.addObject("processus", processus);
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
}
