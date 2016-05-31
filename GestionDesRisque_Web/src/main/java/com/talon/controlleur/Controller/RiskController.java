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

import com.talon.entities.MesureEx;
import com.talon.entities.Risque;
import com.talon.service.MesureExService;
import com.talon.service.RisqueService;

@Controller
public class RiskController {

	@Autowired
	RisqueService riskServiceImpl ; ;
	
	
	
	

	

	public RisqueService getRiskServiceImpl() {
		return riskServiceImpl;
	}





	public void setRiskServiceImpl(RisqueService riskServiceImpl) {
		this.riskServiceImpl = riskServiceImpl;
	}





//	@RequestMapping(value = "/showMesureMenu", method = RequestMethod.GET)
//	public ModelAndView showMesure(){
//		
//		ModelAndView model = new ModelAndView("Risk/Mesure") ; 
//	
//		return model ; 
//		
//		
//	}
	
	
		
	
	
	@RequestMapping(value = "/SeekRisk", method = RequestMethod.GET)
    public @ResponseBody List<Risque> seekRisk() {
		
		List<Risque> risques = riskServiceImpl.getAll() ; 
		
		 
		List<Risque> riskList = new ArrayList<>()  ;
		for (Risque m:risques ){
			Risque ris = new Risque() ; 
			ris.setRisqueId(m.getRisqueId());
			ris.setRisqueLabel(m.getRisqueLabel());
			
			
			riskList.add(ris) ; 
		}
		
	return riskList ; 
		
		}
	
	@RequestMapping(value = "/PersisteRisk/{label}/", method = RequestMethod.GET)
    public @ResponseBody Boolean CheckRcode(@PathVariable("label") String label ,HttpSession session) {
		
		Risque risk = new Risque() ; 
			
			risk.setRisqueLabel(label);
			riskServiceImpl.persist(risk);
		
		return true ; 
		
    }
	@RequestMapping(value = "/updateRisk/{id}/{label}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("id") int id,@PathVariable("label") String label, HttpSession session) {
		
		Risque ris = new Risque() ;
		ris = riskServiceImpl.getById(id) ;
		
		ris.setRisqueLabel(label);
		riskServiceImpl.update(ris);
		return true ; 
		
    }
	@RequestMapping(value = "/deleteRisk/{id}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("id") int id, HttpSession session) {
		Risque ris = new Risque() ; 
		ris = riskServiceImpl.getById(id);
		riskServiceImpl.delete(ris);
		return true ; 
		
    }
}
