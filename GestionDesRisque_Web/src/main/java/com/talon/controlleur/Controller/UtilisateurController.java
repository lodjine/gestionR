package com.talon.controlleur.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.talon.entities.Administrateur;
import com.talon.entities.Processus;
import com.talon.entities.SousProcessus;
import com.talon.service.UtilisateurService;

@Controller
public class UtilisateurController {

	@Autowired
	UtilisateurService utilisateurServiceImpl;
	
	
	
	public UtilisateurService getUtilisateurServiceImpl() {
		return utilisateurServiceImpl;
	}

	public void setUtilisateurServiceImpl(UtilisateurService utilisateurServiceImpl) {
		this.utilisateurServiceImpl = utilisateurServiceImpl;
	}

	@RequestMapping(value = "/ShowAdmin",params="newRecord", method = RequestMethod.GET)
	public ModelAndView addssProcess(){
		
		ModelAndView model = new ModelAndView("utilisateur/AdministrateurAjout") ; 
	Administrateur admin=new Administrateur();
	model.addObject("admin", admin);
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/AddAdmin", method = RequestMethod.POST)
	public ModelAndView validProcess(@ModelAttribute Administrateur admin){
		
		ModelAndView model = new ModelAndView("index") ; 
	
		utilisateurServiceImpl.save(admin);
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/ShowAdmin",params="updateByCode", method = RequestMethod.GET)
	public ModelAndView Affichinf(@RequestParam("byCode") String id){
		
		ModelAndView model = new ModelAndView("utilisateur/AdministrateurAffiche") ; 
		
		model.addObject("information", utilisateurServiceImpl.getById(id));
		return model ;
		
		
	}
	@RequestMapping(value = "/MenuAdmin", method = RequestMethod.GET)
	public ModelAndView Menuinf(){
		
		ModelAndView model = new ModelAndView("Process/AdminMenu") ; 
		
		model.addObject("ListAdmin", utilisateurServiceImpl.getAll());
		return model ;
		
		
	}
}
