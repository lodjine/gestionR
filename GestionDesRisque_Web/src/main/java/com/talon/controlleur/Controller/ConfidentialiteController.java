package com.talon.controlleur.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.talon.entities.Confidentialite;
import com.talon.service.ConfidentialiteService;

public class ConfidentialiteController {
	
	@Autowired
	ConfidentialiteService confidentialiteServiceImpl;
	
	
	
	
	
	public ConfidentialiteService getConfidentialiteServiceImpl() {
		return confidentialiteServiceImpl;
	}
	public void setConfidentialiteServiceImpl(ConfidentialiteService confidentialiteServiceImpl) {
		this.confidentialiteServiceImpl = confidentialiteServiceImpl;
	}
	@RequestMapping(value = "/showConfidentialiteMenu", method = RequestMethod.GET)
	public ModelAndView ConfMenu(){
		
		ModelAndView model = new ModelAndView("Risk/ConfidentialiteMenu") ; 
		List<Confidentialite> confidentialites=confidentialiteServiceImpl.getAll();
	
		return model ; 
		
		
	}
	@RequestMapping(value = "/showConfidentialiteMenu", method = RequestMethod.GET)
	public ModelAndView showConf(@PathVariable("id") int id){
		
		ModelAndView model = new ModelAndView("Risk/ShowConfidentialite") ; 
	    model.addObject("id", id);
		return model ; 
		
		
	}
	@RequestMapping(value = "/addConfidentialiteMenu", method = RequestMethod.GET)
	public ModelAndView adDConf(@PathVariable("id") int id){
		
		
	return null;	
		
	}
	
}
