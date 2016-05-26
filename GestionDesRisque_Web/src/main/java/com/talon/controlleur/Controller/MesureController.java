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
import com.talon.service.MesureExService;

@Controller
public class MesureController {

	@Autowired
	MesureExService mesureExServiceImpl ;
	
	
	
	

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
			
			mesureExs.add(mesure) ; 
		}
		
	return mesureExs ; 
		
		}
	
	@RequestMapping(value = "/PersisteMesure/{id}/{label}/{value}/", method = RequestMethod.GET)
    public @ResponseBody Boolean CheckRcode(@PathVariable("id") int id,@PathVariable("label") String label,@PathVariable("value") int value, HttpSession session) {
		
			MesureEx mesure = new MesureEx() ; 
			mesure.setMesureId(id);
			mesure.setMesureLabel(label);
			mesure.setValue(value);
			mesureExServiceImpl.persisteMesure(mesure);
		
		return true ; 
		
    }
	@RequestMapping(value = "/updateMesure/{id}/{label}/{value}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("id") int id,@PathVariable("label") String label,@PathVariable("value") int value, HttpSession session) {
		
		MesureEx mesure = new MesureEx() ; 
		mesure = mesureExServiceImpl.getMesureById(id); 
		
		mesure.setMesureLabel(label);
		mesure.setValue(value);
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
