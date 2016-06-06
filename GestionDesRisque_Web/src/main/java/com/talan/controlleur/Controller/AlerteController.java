package com.talan.controlleur.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.Alerte;
import com.talan.service.AlerteService;

@Controller
public class AlerteController {
	@Autowired
	AlerteService alerteServiceImpl;
	
	
	@RequestMapping(value = "/alerte" ,method = RequestMethod.GET)
	public ModelAndView adDConf(){
		ModelAndView model = new ModelAndView("Risk/Alerte") ; 
		List<Alerte> alertes=alerteServiceImpl.getAllRisque();	
		alertes.addAll(alerteServiceImpl.getAllAction());
		
		System.out.println(alertes.size());
		model.addObject("alertes", alertes);
		return model ;
		
		
		
	}
	
	
}
