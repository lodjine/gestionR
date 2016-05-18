package com.talon.controlleur.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class InformationController {

	
	
	@RequestMapping(value = "/InformationAdd", method = RequestMethod.GET)
	public ModelAndView addInformation(){
		
		ModelAndView model = new ModelAndView("Process/Information/Information") ; 
		return model ; 
		
		
	}
}
