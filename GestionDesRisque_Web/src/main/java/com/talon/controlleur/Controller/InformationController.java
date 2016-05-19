package com.talon.controlleur.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		
		
		ModelAndView model = new ModelAndView("Process/information") ; 
		model.addObject("information", new Information());
		model.addObject("activiteList", activiteServiceImpl.getAll());
		return model ; 
		
		
	}
	@RequestMapping(value = "/addInformation", method = RequestMethod.GET)
	public ModelAndView validInformation(@ModelAttribute Information information){
		
		
		ModelAndView model = new ModelAndView("index") ; 
		
		informationServiceImpl.save(information);
		return model ; 
		
		
	}
}
