package com.talan.controlleur.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.Alerte;
import com.talan.entities.Utilisateur;
import com.talan.service.AlerteService;
import com.talan.service.UtilisateurService;

@Controller
public class AlerteController {
	@Autowired
	AlerteService alerteServiceImpl;
	@Autowired
	UtilisateurService utilisateurServiceImpl;
	
	@RequestMapping(value = "/alerte" ,method = RequestMethod.GET)
	public ModelAndView adDConf(){
		ModelAndView model = new ModelAndView("Risk/Alerte") ; 
		List<Alerte> alertes=alerteServiceImpl.getAllRisque();	
		alertes.addAll(alerteServiceImpl.getAllAction());
		
		System.out.println(alertes.size());
		model.addObject("alertes", alertes);
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
