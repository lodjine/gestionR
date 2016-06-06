package com.talan.controlleur.Controller;

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

import com.talan.entities.ImpactC;
import com.talan.entities.MesureEx;
import com.talan.entities.Risque;
import com.talan.entities.Vulnerabilite;
import com.talan.service.ImpactCService;
import com.talan.service.MesureExService;
import com.talan.service.RisqueService;
import com.talan.service.VulnerabiliteService;

@Controller
public class VulnerabiliteController {

	@Autowired
	VulnerabiliteService vulnerabiliteServiceImpl ;
	@Autowired
	RisqueService rserviceImpl ; 
	
	
	

	public RisqueService getRserviceImpl() {
		return rserviceImpl;
	}

	public void setRserviceImpl(RisqueService rserviceImpl) {
		this.rserviceImpl = rserviceImpl;
	}

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
			
			vulnerabilite.setCritere(vul.getCritere());
			Risque r = new Risque() ; 
			r.setRisqueLabel(vul.getRisque().getRisqueLabel());
			r.setRisqueId(vul.getRisque().getRisqueId());
			vulnerabilite.setRisque(r);
			
			vulnerabilitess.add(vulnerabilite) ; 
		}
		
	return vulnerabilitess ; 
		
		}
	
	@RequestMapping(value = "/PersisteVulnerabilite/{label}/{value}/{type}/{idrisque}/", method = RequestMethod.GET)
    public @ResponseBody Boolean CheckRcode(@PathVariable("label") String label,@PathVariable("value") int value,@PathVariable("idrisque") int idrisque ,@PathVariable("type") String type , HttpSession session) {
		
		Vulnerabilite vulnerabilite = new Vulnerabilite() ; 
		
		vulnerabilite.setVulnLabel(label);
		vulnerabilite.setValue(value);
		vulnerabilite.setCritere(type);
		Risque r = rserviceImpl.getById(idrisque) ;
		vulnerabilite.setRisque(r);
		vulnerabiliteServiceImpl.persist(vulnerabilite);
		
		return true ; 
		
    }
	@RequestMapping(value = "/updateVulnerabilite/{id}/{label}/{value}/{type}/{idrisque}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("id") int id,@PathVariable("label") String label,@PathVariable("value") int value,@PathVariable("idrisque") int idrisque ,@PathVariable("type") String type , HttpSession session) {
		
		Vulnerabilite vulnerabilite = new Vulnerabilite() ; 
		vulnerabilite = vulnerabiliteServiceImpl.getById(id); 
		
		vulnerabilite.setVulnLabel(label);
		vulnerabilite.setValue(value);
		vulnerabilite.setCritere(type);
		Risque r = rserviceImpl.getById(idrisque) ;
		vulnerabilite.setRisque(r);
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
