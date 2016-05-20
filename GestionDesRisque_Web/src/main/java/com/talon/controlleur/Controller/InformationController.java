package com.talon.controlleur.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.talon.entities.Information;
import com.talon.entities.Processus;
import com.talon.service.ActiviteService;
import com.talon.service.InformationService;
import com.talon.service.SousProcessusService;

@Controller

public class InformationController {
	
	@Autowired
	ActiviteService activiteServiceImpl;
	
	@Autowired
	InformationService informationServiceImpl;

	@RequestMapping(value = "/InformationAdd", method = RequestMethod.GET)
	public ModelAndView addInformation(){
		
		
		
		ModelAndView model = new ModelAndView("Process/InformationAjout") ; 
		model.addObject("information", new Information());
		model.addObject("activiteList", activiteServiceImpl.getAll());
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/Addinformation", method = RequestMethod.POST)
	public ModelAndView validinf(@ModelAttribute Information info){
		
		ModelAndView model = new ModelAndView("index") ; 
	
		informationServiceImpl.save(info);
		return model ; 
		
		
	}
	@RequestMapping(value = "/AffichInformation", method = RequestMethod.GET)
	public ModelAndView Affichinf(@RequestParam int id){
		
		ModelAndView model = new ModelAndView("Process/informationAffiche") ; 
		
		model.addObject("information", informationServiceImpl.getById(id));
		return model ;
		
		
	}
	
	
	@RequestMapping(value = "/MenuInformation", method = RequestMethod.GET)
	public ModelAndView Menuinf(){
		
		ModelAndView model = new ModelAndView("Process/informationMenu") ; 
		
		model.addObject("listInformation", informationServiceImpl.getAll());
		return model ;
		
		
	}
}
