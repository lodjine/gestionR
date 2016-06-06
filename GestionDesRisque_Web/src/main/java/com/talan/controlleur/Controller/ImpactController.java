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
import com.talan.service.ImpactCService;
import com.talan.service.MesureExService;
import com.talan.service.RisqueService;

@Controller
public class ImpactController {

	@Autowired
	ImpactCService impactCServiceImpl ;
	@Autowired
	RisqueService rserviceImpl ; 
	
	
	

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
			impactC.setRisque(r);
			impactCServiceImpl.persist(impactC);
		
		return true ; 
		
    }
	@RequestMapping(value = "/updateImpact/{id}/{label}/{value}/{type}/{idrisque}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("id") int id,@PathVariable("label") String label,@PathVariable("value") int value,@PathVariable("idrisque") int idrisque ,@PathVariable("type") String type , HttpSession session) {
		
		ImpactC impactC = new ImpactC() ; 
		impactC = impactCServiceImpl.getById(id); 
		
		impactC.setImpactLabel(label);
		impactC.setValue(value);
		impactC.setCritere(type);
		Risque r = rserviceImpl.getById(idrisque) ;
		impactC.setRisque(r);
		impactCServiceImpl.update(impactC);
		return true ; 
		
    }
	@RequestMapping(value = "/deleteImpact/{id}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("id") int id, HttpSession session) {
		ImpactC impactC = new ImpactC() ; 
		impactC = impactCServiceImpl.getById(id);
		impactCServiceImpl.delete(impactC);
		return true ; 
		
    }
}
