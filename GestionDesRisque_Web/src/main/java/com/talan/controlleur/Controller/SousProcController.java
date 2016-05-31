package com.talan.controlleur.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.Processus;
import com.talan.entities.SousProcessus;
import com.talan.service.ProcessService;
import com.talan.service.SousProcessusService;

@Controller
public class SousProcController {
	@Autowired
	ProcessService processServiceImpl;
	
	@Autowired
	SousProcessusService sousProcessusServiceImpl;
	
	@RequestMapping(value = "/ShowSubProcess",params="newRecord", method = RequestMethod.GET)
	public ModelAndView addssProcess(){
		
		ModelAndView model = new ModelAndView("Process/sousProcessAjout") ; 
		System.out.println("---------------------------------------");
		SousProcessus ssProcessus=new SousProcessus();
		model.addObject("ssProcessus", ssProcessus);
		List<Processus> processusList=processServiceImpl.getAll();
		model.addObject("processusList", processusList);
		return model ; 
		
		
	}
	@RequestMapping(value = "/ssProcessAdd", method = RequestMethod.POST)
	public ModelAndView validssProcess(@ModelAttribute SousProcessus ssProcessus){
		
		ModelAndView model = new ModelAndView("index") ; 
	
		sousProcessusServiceImpl.save(ssProcessus);
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/ShowSubProcess",params="updateByCode" ,method = RequestMethod.GET)
	public ModelAndView validssProcess(@RequestParam("byCode") int id){
		
		ModelAndView model = new ModelAndView("Process/sousProcessAffiche") ; 
	
		
		model.addObject("ssProcessus", sousProcessusServiceImpl.getById(id));
		return model ; 
		
		
	}
	
	
	@RequestMapping(value = "/MenuSsProcess", method = RequestMethod.GET)
	public ModelAndView Menuinf(){
		
		ModelAndView model = new ModelAndView("Process/MenuSousProcess") ; 
		
		model.addObject("ListSubprocess", sousProcessusServiceImpl.getAll());
		return model ;
		
		
	}
	
}
