package com.talon.controlleur.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.talon.entities.ImpactC;
import com.talon.entities.MesureEx;
import com.talon.entities.Vulnerabilite;
import com.talon.service.ImpactCService;
import com.talon.service.MesureExService;
import com.talon.service.VulnerabiliteService;

@Controller
public class VulnerabiliteController {

	@Autowired
	VulnerabiliteService vulnerabiliteServiceImpl ;
	

	public VulnerabiliteService getVulnerabiliteServiceImpl() {
		return vulnerabiliteServiceImpl;
	}


	public void setVulnerabiliteServiceImpl(VulnerabiliteService vulnerabiliteServiceImpl) {
		this.vulnerabiliteServiceImpl = vulnerabiliteServiceImpl;
	}





	@RequestMapping(value = "/showVulnerabiliteMenu", method = RequestMethod.GET)
	public ModelAndView showMesure(){
		
		ModelAndView model = new ModelAndView("Risk/Vulnerabilite") ; 
	
		return model ; 
		
		
	}
	
	
		
	
	
	@RequestMapping(value = "/SeekVulnerabilite", method = RequestMethod.GET)
    public @ResponseBody List<Vulnerabilite> seekMesure() {
		
		List<Vulnerabilite> vulnerabilites = vulnerabiliteServiceImpl.getAll() ; 
		
		 
		List<Vulnerabilite> vulnerabilitess = new ArrayList<>()  ;
		for (Vulnerabilite vul:vulnerabilites ){
			Vulnerabilite vulnerabilite = new Vulnerabilite() ; 
			vulnerabilite.setVulnId(vul.getVulnId());
			vulnerabilite.setVulnLabel(vul.getVulnLabel());
			vulnerabilite.setValue(vul.getValue());
			
			vulnerabilitess.add(vulnerabilite) ; 
		}
		
	return vulnerabilitess ; 
		
		}
	
	@RequestMapping(value = "/PersisteVulnerabilite/{label}/{value}/", method = RequestMethod.GET)
    public @ResponseBody Boolean CheckRcode(@PathVariable("label") String label,@PathVariable("value") int value, HttpSession session) {
		
		Vulnerabilite vulnerabilite = new Vulnerabilite() ; 
		
		vulnerabilite.setVulnLabel(label);
		vulnerabilite.setValue(value);
		vulnerabiliteServiceImpl.persist(vulnerabilite);
		
		return true ; 
		
    }
	@RequestMapping(value = "/updateVulnerabilite/{id}/{label}/{value}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("id") int id,@PathVariable("label") String label,@PathVariable("value") int value, HttpSession session) {
		
		Vulnerabilite vulnerabilite = new Vulnerabilite() ; 
		vulnerabilite = vulnerabiliteServiceImpl.getById(id); 
		
		vulnerabilite.setVulnLabel(label);
		vulnerabilite.setValue(value);
		vulnerabiliteServiceImpl.update(vulnerabilite);
		return true ; 
		
    }
	@RequestMapping(value = "/deleteVulnerabilite/{id}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("id") int id, HttpSession session) {
		Vulnerabilite vulnerabilite = new Vulnerabilite() ; 
		vulnerabilite = vulnerabiliteServiceImpl.getById(id);
		vulnerabiliteServiceImpl.delete(vulnerabilite);
		return true ; 
		
    }
}
