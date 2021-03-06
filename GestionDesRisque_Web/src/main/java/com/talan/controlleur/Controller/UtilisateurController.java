package com.talan.controlleur.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.Administrateur;
import com.talan.entities.Processus;
import com.talan.entities.Responsable;
import com.talan.entities.SousProcessus;
import com.talan.entities.UserRole;
import com.talan.entities.Utilisateur;
import com.talan.service.AlerteService;
import com.talan.service.UtilisateurService;

@Controller
public class UtilisateurController {

	@Autowired
	UtilisateurService utilisateurServiceImpl;
	@Autowired
	AlerteService alerteServiceImpl;
	
	
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
	
	UserDetails user = (UserDetails) SecurityContextHolder.getContext()
			.getAuthentication().getPrincipal();
	Utilisateur myUser = new Utilisateur();
	myUser = utilisateurServiceImpl.getById(user.getUsername());
	model.addObject("firstname", myUser.getFirstName());
	model.addObject("lastname", myUser.getLastName());
	 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/AddAdmin", method = RequestMethod.POST)
	public ModelAndView validProcess(@ModelAttribute Administrateur admin){
		
		ModelAndView model = new ModelAndView("utilisateur/AdministrateurAjout") ; 
	
		utilisateurServiceImpl.save(admin);
		
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/ShowAdmin",params="updateByCode", method = RequestMethod.GET)
	public ModelAndView Affichinf(@RequestParam("byCode") String id){
		
		ModelAndView model = new ModelAndView("utilisateur/AdministrateurAffiche") ; 
		
		model.addObject("admin", utilisateurServiceImpl.getById(id));
		
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		return model ;
		
		
	}
	@RequestMapping(value = "/MenuAdmin", method = RequestMethod.GET)
	public ModelAndView Menuinf(){
		
		ModelAndView model = new ModelAndView("Process/AdminMenu") ; 
		
		model.addObject("ListAdmin", utilisateurServiceImpl.getAll());
		
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		return model ;
		
		
	}
	
	@RequestMapping(value = "/SeekUsers", method = RequestMethod.GET)
    public @ResponseBody List<Utilisateur> seekUsers() {
		
		List<Utilisateur> users = utilisateurServiceImpl.getAll() ; 
		
		 
		List<Utilisateur> userJs = new ArrayList<>()  ;
		for (Utilisateur u:users ){
			Set<UserRole> hset = new HashSet<UserRole>() ;  
			for(UserRole ur:u.getUserRole()){
				UserRole usrr = new UserRole() ; 
				usrr.setRole(ur.getRole());
				usrr.setUserRoleId(ur.getUserRoleId());
				hset.add(usrr);
			}
			Utilisateur user = new Utilisateur() ; 
			user.setUserType(u.getUserType());
			user.setEmail(u.getEmail());
			user.setFirstName(u.getFirstName());
			user.setLastName(u.getLastName());
			user.setUserRole(hset);
			userJs.add(user) ; 
		}
		
	return userJs ; 
		
		}
	
	@RequestMapping(value = "/PersisteUser/{email}/{firstname}/{lastname}/", method = RequestMethod.GET)
    public @ResponseBody Boolean CheckRcode(@PathVariable("email") String email,@PathVariable("firstname") String firstName,@PathVariable("lastname") String lastName, HttpSession session) {
		
		Utilisateur user = new Utilisateur() ; 
		
			user = new Responsable() ; 
	
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.setPwd("123456");
		user.setUserType("Responsable");
		utilisateurServiceImpl.save(user);
		return true ; 
		
    }
	@RequestMapping(value = "/updateUser/{email}/{firstname}/{lastname}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("email") String email,@PathVariable("firstname") String firstName,@PathVariable("lastname") String lastName, HttpSession session) {
		
		Utilisateur user = new Utilisateur() ; 
		user = new Responsable() ;
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.setPwd("123456");
		user.setUserType("Responsable");
		utilisateurServiceImpl.update(user);
		return true ; 
		
    }
	@RequestMapping(value = "/deleteUser/{email}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("email") String email, HttpSession session) {
		
		Utilisateur user = new Utilisateur() ; 
		
		user = utilisateurServiceImpl.getById(email);
		utilisateurServiceImpl.delete(user);
		return true ; 
		
    }
}
