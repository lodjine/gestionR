package com.talan.controlleur.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.ImpactC;
import com.talan.entities.MesureEx;
import com.talan.entities.Risque;
import com.talan.entities.Tracabilite;
import com.talan.entities.Utilisateur;
import com.talan.service.AlerteService;
import com.talan.service.ImpactCService;
import com.talan.service.MesureExService;
import com.talan.service.RisqueService;
import com.talan.service.TracabiliteService;
import com.talan.service.UtilisateurService;

@Controller
public class ImpactController {

	@Autowired
	ImpactCService impactCServiceImpl ;
	@Autowired
	RisqueService rserviceImpl ; 
	
	@Autowired
	UtilisateurService utilisateurServiceImpl;
	@Autowired
	TracabiliteService tracabiliteServiceImpl;
	@Autowired
	AlerteService alerteServiceImpl;

	public UtilisateurService getUtilisateurServiceImpl() {
		return utilisateurServiceImpl;
	}

	public void setUtilisateurServiceImpl(UtilisateurService utilisateurServiceImpl) {
		this.utilisateurServiceImpl = utilisateurServiceImpl;
	}

	public TracabiliteService getTracabiliteServiceImpl() {
		return tracabiliteServiceImpl;
	}

	public void setTracabiliteServiceImpl(TracabiliteService tracabiliteServiceImpl) {
		this.tracabiliteServiceImpl = tracabiliteServiceImpl;
	}

	
	

	public RisqueService getRserviceImpl() {
		return rserviceImpl;
	}

	public void setRserviceImpl(RisqueService rserviceImpl) {
		this.rserviceImpl = rserviceImpl;
	}
	
	
	

	

	public ImpactCService getImpactCServiceImpl() {
		return impactCServiceImpl;
	}





	public void setImpactCServiceImpl(ImpactCService impactCServiceImpl) {
		this.impactCServiceImpl = impactCServiceImpl;
	}





	@RequestMapping(value = "/showImpactMenu", method = RequestMethod.GET)
	public ModelAndView showMesure(){
		
		ModelAndView model = new ModelAndView("Risk/Impact") ; 
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		return model ; 
		
		
	}
	
	
		
	
	
	@RequestMapping(value = "/SeekImpact", method = RequestMethod.GET)
    public @ResponseBody List<ImpactC> seekMesure() {
		
		List<ImpactC> impactCs = impactCServiceImpl.getAll() ; 
		
		 
		List<ImpactC> impactcss = new ArrayList<>()  ;
		for (ImpactC i:impactCs ){
			ImpactC impactC = new ImpactC() ; 
			impactC.setImpactId(i.getImpactId());
			impactC.setImpactLabel(i.getImpactLabel());
			impactC.setValue(i.getValue());
			
			impactC.setCritere(i.getCritere());
			Risque r = new Risque() ; 
			r.setRisqueLabel(i.getRisque().getRisqueLabel());
			r.setRisqueId(i.getRisque().getRisqueId());
			impactC.setRisque(r);
			
			
			impactcss.add(impactC) ; 
		}
		
	return impactcss ; 
		
		}
	
	@RequestMapping(value = "/PersisteImpact/{label}/{value}/{type}/{idrisque}/", method = RequestMethod.GET)
    public @ResponseBody Boolean CheckRcode(@PathVariable("label") String label,@PathVariable("value") int value,@PathVariable("idrisque") int idrisque ,@PathVariable("type") String type , HttpSession session) {
		
			ImpactC impactC = new ImpactC() ; 
			
			impactC.setImpactLabel(label);
			impactC.setValue(value);
			impactC.setCritere(type);
			Risque r = rserviceImpl.getById(idrisque) ;
			r.setTotalImp(r.getTotalImp()+value);
			rserviceImpl.update(r);
			impactC.setRisque(r);
			impactCServiceImpl.persist(impactC);
////////////tracabilite/////////////
			
	UserDetails user = (UserDetails) SecurityContextHolder.getContext()
			.getAuthentication().getPrincipal();
	String role="";
	Utilisateur myUser = new Utilisateur();
	myUser = utilisateurServiceImpl.getById(user.getUsername());
	
	
Tracabilite trace=new Tracabilite();
trace.setDate(new Date().toString());
trace.setUser(myUser.getEmail());
trace.setEntity("Impact");
trace.setOperation("Ajout");
trace.setLabelEntity(impactC.getImpactLabel());
tracabiliteServiceImpl.persist(trace);
/////////////////////////////////
		return true ; 
		
    }
	@RequestMapping(value = "/updateImpact/{id}/{label}/{value}/{type}/{idrisque}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("id") int id,@PathVariable("label") String label,@PathVariable("value") int value,@PathVariable("idrisque") int idrisque ,@PathVariable("type") String type , HttpSession session) {
		
		ImpactC impactC = new ImpactC() ; 
		impactC = impactCServiceImpl.getById(id); 
		Risque r = rserviceImpl.getById(idrisque) ;
		r.setTotalImp(r.getTotalImp()-impactC.getValue());
		r.setTotalImp(r.getTotalImp()+value);
		rserviceImpl.update(r);
		impactC.setImpactLabel(label);
		impactC.setValue(value);
		impactC.setCritere(type);
		
		impactC.setRisque(r);
		impactCServiceImpl.update(impactC);
////////////tracabilite/////////////
		
UserDetails user = (UserDetails) SecurityContextHolder.getContext()
		.getAuthentication().getPrincipal();
String role="";
Utilisateur myUser = new Utilisateur();
myUser = utilisateurServiceImpl.getById(user.getUsername());


Tracabilite trace=new Tracabilite();
trace.setDate(new Date().toString());
trace.setUser(myUser.getEmail());
trace.setEntity("Impact");
trace.setOperation("Modification");
trace.setLabelEntity(impactC.getImpactLabel());
tracabiliteServiceImpl.persist(trace);
/////////////////////////////////
		return true ; 
		
    }
	@RequestMapping(value = "/deleteImpact/{id}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("id") int id, HttpSession session) {
		ImpactC impactC = new ImpactC() ; 
		impactC = impactCServiceImpl.getById(id);
		
		Risque r = rserviceImpl.getById(impactC.getRisque().getRisqueId()) ;
		r.setTotalImp(r.getTotalImp()-impactC.getValue());
		
		impactCServiceImpl.delete(impactC);
////////////tracabilite/////////////
		
UserDetails user = (UserDetails) SecurityContextHolder.getContext()
		.getAuthentication().getPrincipal();
String role="";
Utilisateur myUser = new Utilisateur();
myUser = utilisateurServiceImpl.getById(user.getUsername());


Tracabilite trace=new Tracabilite();
trace.setDate(new Date().toString());
trace.setUser(myUser.getEmail());
trace.setEntity("Impact");
trace.setLabelEntity(impactC.getImpactLabel());
trace.setOperation("Delete");
tracabiliteServiceImpl.persist(trace);
/////////////////////////////////
		return true ; 
		
    }
}
