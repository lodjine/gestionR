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

import com.talan.entities.MesureEx;
import com.talan.entities.Risque;
import com.talan.service.MesureExService;
import com.talan.service.RisqueService;

@Controller
public class MesureController {

	@Autowired
	MesureExService mesureExServiceImpl ;
	@Autowired
	RisqueService rserviceImpl ; 
	
	
	

	public RisqueService getRserviceImpl() {
		return rserviceImpl;
	}

	public void setRserviceImpl(RisqueService rserviceImpl) {
		this.rserviceImpl = rserviceImpl;
	}

	public MesureExService getMesureExServiceImpl() {
		return mesureExServiceImpl;
	}

	public void setMesureExServiceImpl(MesureExService mesureExServiceImpl) {
		this.mesureExServiceImpl = mesureExServiceImpl;
	}

	@RequestMapping(value = "/showMesureMenu", method = RequestMethod.GET)
	public ModelAndView showMesure(){
		
		ModelAndView model = new ModelAndView("Risk/Mesure") ; 
	
		return model ; 
		
		
	}
	
	
		
	
	
	@RequestMapping(value = "/SeekMesure", method = RequestMethod.GET)
    public @ResponseBody List<MesureEx> seekMesure() {
		
		List<MesureEx> mesureEx = mesureExServiceImpl.getAllMesure() ; 
		
		 
		List<MesureEx> mesureExs = new ArrayList<>()  ;
		for (MesureEx m:mesureEx ){
			MesureEx mesure = new MesureEx() ; 
			mesure.setMesureId(m.getMesureId());
			mesure.setMesureLabel(m.getMesureLabel());
			mesure.setValue(m.getValue());
			mesure.setCritere(m.getCritere());
			Risque r = new Risque() ; 
			r.setRisqueLabel(m.getRisque().getRisqueLabel());
			r.setRisqueId(m.getRisque().getRisqueId());
			mesure.setRisque(r);
			mesureExs.add(mesure) ; 
		}
		
	return mesureExs ; 
		
		}
	
	@RequestMapping(value = "/PersisteMesure/{label}/{value}/{type}/{idrisque}/", method = RequestMethod.GET)
    public @ResponseBody Boolean CheckRcode(@PathVariable("label") String label,@PathVariable("value") int value,@PathVariable("idrisque") int idrisque ,@PathVariable("type") String type ,HttpSession session) {
		
			MesureEx mesure = new MesureEx() ; 
			
			mesure.setMesureLabel(label);
			mesure.setValue(value);
			mesure.setCritere(type);
			Risque r = rserviceImpl.getById(idrisque) ;
			mesure.setRisque(r);
			mesureExServiceImpl.persisteMesure(mesure);
		
		return true ; 
		
    }
	@RequestMapping(value = "/updateMesure/{id}/{label}/{value}/{type}/{idrisque}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("id") int id,@PathVariable("label") String label,@PathVariable("value") int value,@PathVariable("idrisque") int idrisque ,@PathVariable("type") String type , HttpSession session) {
		
		MesureEx mesure = new MesureEx() ; 
		mesure = mesureExServiceImpl.getMesureById(id); 
		
		mesure.setMesureLabel(label);
		mesure.setValue(value);
		mesure.setCritere(type);
		Risque r = rserviceImpl.getById(idrisque) ;
		mesure.setRisque(r);
		mesureExServiceImpl.updateMuser(mesure);
		return true ; 
		
    }
	@RequestMapping(value = "/deleteMesure/{id}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("id") int id, HttpSession session) {
		MesureEx mesure = new MesureEx() ; 
		mesure = mesureExServiceImpl.getMesureById(id);
		mesureExServiceImpl.deleteMuser(mesure);
		return true ; 
		
    }
}
