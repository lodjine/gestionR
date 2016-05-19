package com.talon.controlleur.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.talon.entities.Processus;
import com.talon.entities.SousProcessus;
import com.talon.service.ProcessService;
import com.talon.service.SousProcessusService;

@Controller
public class SousProcController {
	@Autowired
	ProcessService processServiceImpl;
	
	@Autowired
	SousProcessusService sousProcessusServiceImpl;
	
	@RequestMapping(value = "/ssProcessAdd", method = RequestMethod.GET)
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
	
}
