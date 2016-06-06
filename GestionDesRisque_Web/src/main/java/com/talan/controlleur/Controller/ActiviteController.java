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

import com.talan.entities.Activite;
import com.talan.entities.Processus;
import com.talan.entities.SousProcessus;
import com.talan.entities.Utilisateur;
import com.talan.service.ActiviteService;
import com.talan.service.AlerteService;
import com.talan.service.ProcessService;
import com.talan.service.SousProcessusService;
import com.talan.service.UtilisateurService;

@Controller
public class ActiviteController {

	
	
	
	
	@Autowired
	ActiviteService activiteServiceImpl;
	
	@Autowired
	SousProcessusService sousProcessusServiceImpl;
	
	@Autowired
	UtilisateurService utilisateurServiceImpl;
	@Autowired
	AlerteService alerteServiceImpl;
	
	@RequestMapping(value = "/ShowActivity",params="newRecord", method = RequestMethod.GET)
	public ModelAndView addAct(){
		
		ModelAndView model = new ModelAndView("Process/activiteAjout") ; 
		System.out.println("---------------------------------------");
		Activite activite=new Activite();
		model.addObject("activite", activite);
		List<SousProcessus> ssProcessusList=sousProcessusServiceImpl.getAll();
		model.addObject("ssProcessusList", ssProcessusList);
		
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		return model ; 
		
		
	}
	@RequestMapping(value = "/Addactivite", method = RequestMethod.POST)
	public ModelAndView validAct(@ModelAttribute Activite activite){
		
		ModelAndView model = new ModelAndView("Process/ActiviteAffich") ; 
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		activiteServiceImpl.save(activite);
		return model ; 
		
		
	}
	@RequestMapping(value = "/ShowActivity",params="updateByCode", method = RequestMethod.GET)
	public ModelAndView AffichAct(@RequestParam("byCode") int id){
		
		ModelAndView model = new ModelAndView("Process/ActiviteAffich") ; 
	model.addObject("activite", activiteServiceImpl.getById(id));
	UserDetails user = (UserDetails) SecurityContextHolder.getContext()
			.getAuthentication().getPrincipal();
	Utilisateur myUser = new Utilisateur();
	myUser = utilisateurServiceImpl.getById(user.getUsername());
	model.addObject("firstname", myUser.getFirstName());
	model.addObject("lastname", myUser.getLastName());
	 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		return model ; 
		
		
	}
	@RequestMapping(value = "/MenuActivite", method = RequestMethod.GET)
	public ModelAndView Menuact(){
		
		ModelAndView model = new ModelAndView("Process/MenuActivite") ; 
		
		model.addObject("ListActivity", activiteServiceImpl.getAll());
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
