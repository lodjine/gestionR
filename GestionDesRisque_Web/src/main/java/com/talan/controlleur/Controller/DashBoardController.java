package com.talan.controlleur.Controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talan.entities.Utilisateur;
import com.talan.service.ActionService;
import com.talan.service.ConfidentialiteService;
import com.talan.service.DisponibiliteService;
import com.talan.service.IntegriteService;
import com.talan.service.RisqueService;
import com.talan.service.UtilisateurService;

@Controller
public class DashBoardController {

	@Autowired
	RisqueService risqueServiceImpl;
	@Autowired
	ActionService actionServiceImpl;
	@Autowired 
	ConfidentialiteService confidentialiteServiceImpl;
	@Autowired
	IntegriteService integriteServiceImpl;
	@Autowired
	DisponibiliteService disponibiliteServiceImpl;
	@Autowired
	UtilisateurService utilisateurServiceImpl;
	
	@RequestMapping(value="/getNTermineAction")
	public @ResponseBody Integer getActionNumberNonTermine(){
		
		
		
		return actionServiceImpl.getAllNonTermine().size();
	}
	
	@RequestMapping(value="/getTermineAction")
public @ResponseBody Integer getActionNumberTermine(){
		
		
		
		return actionServiceImpl.getAllTermine().size();
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/getRisqueByProc/{procId}/",  method = RequestMethod.GET)
	public @ResponseBody List<Integer> getRisqueFaibleByProc(@PathVariable("procId") int procId){
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String role="";
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		
		if(user.getAuthorities().isEmpty()){
			
		}else{
			 role="admin";
		}
		
		int number=0;	
		number=risqueServiceImpl.getRiskByProc(procId, myUser.getEmail(), role, 0).size();
		
			
		int number2=0;
		number2=risqueServiceImpl.getRiskByProc(procId, myUser.getEmail(), role, 1).size();
		
		int number3=0;
		number3=risqueServiceImpl.getRiskByProc(procId, myUser.getEmail(), role, 2).size();
			
			
			
		int number4=0;
		number4=risqueServiceImpl.getRiskByProc(procId, myUser.getEmail(), role, 3).size();
			List<Integer> numbers=new ArrayList<Integer>();
			
			
			numbers.add(number);
			numbers.add(number2);
			numbers.add(number3);
			numbers.add(number4);
			
	
			return numbers;
		}
	
}
