package com.talan.controlleur.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.Information;
import com.talan.entities.Processus;
import com.talan.entities.Utilisateur;
import com.talan.service.ActiviteService;
import com.talan.service.AlerteService;
import com.talan.service.InformationService;
import com.talan.service.SousProcessusService;
import com.talan.service.UtilisateurService;

@Controller

public class InformationController {
	
	@Autowired
	ActiviteService activiteServiceImpl;
	
	@Autowired
	InformationService informationServiceImpl;
	@Autowired
	AlerteService alerteServiceImpl;
	@Autowired
	UtilisateurService utilisateurServiceImpl;

	@RequestMapping(value = "/ShowInformation",params="newRecord", method = RequestMethod.GET)
	public ModelAndView addInformation(){
		
		
		
		ModelAndView model = new ModelAndView("Process/InformationAjout") ; 
		model.addObject("information", new Information());
		model.addObject("activiteList", activiteServiceImpl.getAll());
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/Addinformation", method = RequestMethod.POST)
	public ModelAndView validinf(@ModelAttribute Information info){
		
		ModelAndView model = new ModelAndView("index") ; 
	
		informationServiceImpl.save(info);
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		return model ; 
		
		
	}
	@RequestMapping(value = "/ShowInformation",params="updateByCode", method = RequestMethod.GET)
	public ModelAndView Affichinf(@RequestParam("byCode") int id){
		
		ModelAndView model = new ModelAndView("Process/informationAffiche") ; 
		
		model.addObject("information", informationServiceImpl.getById(id));
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		return model ;
		
		
	}
	
	
	@RequestMapping(value = "/MenuInformation", method = RequestMethod.GET)
	public ModelAndView Menuinf(){
		
		ModelAndView model = new ModelAndView("Process/MenuInformation") ; 
		List<Information> informations=informationServiceImpl.getAll();
		
		model.addObject("ListInf", informations);
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		return model ;
		
		
	}
}
