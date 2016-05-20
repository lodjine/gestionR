package com.talon.controlleur.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.talon.entities.Activite;
import com.talon.entities.Processus;
import com.talon.entities.SousProcessus;
import com.talon.service.ActiviteService;
import com.talon.service.ProcessService;
import com.talon.service.SousProcessusService;

@Controller
public class ActiviteController {

	
	
	
	
	@Autowired
	ActiviteService activiteServiceImpl;
	
	@Autowired
	SousProcessusService sousProcessusServiceImpl;
	
	@RequestMapping(value = "/activiteAdd", method = RequestMethod.GET)
	public ModelAndView addAct(){
		
		ModelAndView model = new ModelAndView("Process/activiteAjout") ; 
		System.out.println("---------------------------------------");
		Activite activite=new Activite();
		model.addObject("activite", activite);
		List<SousProcessus> ssProcessusList=sousProcessusServiceImpl.getAll();
		model.addObject("ssProcessusList", ssProcessusList);
		return model ; 
		
		
	}
	@RequestMapping(value = "/Addactivite", method = RequestMethod.POST)
	public ModelAndView validAct(@ModelAttribute Activite activite){
		
		ModelAndView model = new ModelAndView("Process/ActiviteAffich") ; 
	
		activiteServiceImpl.save(activite);
		return model ; 
		
		
	}
	@RequestMapping(value = "/AfficheActivite", method = RequestMethod.GET)
	public ModelAndView AffichAct(@RequestParam int id){
		
		ModelAndView model = new ModelAndView("index") ; 
	model.addObject("activite", activiteServiceImpl.getById(id));
		
		return model ; 
		
		
	}
	@RequestMapping(value = "/MenuActivite", method = RequestMethod.GET)
	public ModelAndView Menuact(){
		
		ModelAndView model = new ModelAndView("Process/activiteMenu") ; 
		
		model.addObject("listActivite", activiteServiceImpl.getAll());
		return model ;
		
		
	}
	
}
