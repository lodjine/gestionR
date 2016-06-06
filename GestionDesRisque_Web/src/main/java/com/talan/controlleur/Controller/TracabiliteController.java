package com.talan.controlleur.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.Processus;
import com.talan.entities.SousProcessus;
import com.talan.service.TracabiliteService;

@Controller
public class TracabiliteController {
@Autowired
TracabiliteService tracabiliteServiceImpl;


@RequestMapping(value = "/Trace", method = RequestMethod.GET)
public ModelAndView showTrace(){
	
	ModelAndView model = new ModelAndView("Tracabilite") ; 
	System.out.println("---------------------------------------");
	
	model.addObject("traces", tracabiliteServiceImpl.getAll());
	
	return model ; 
	
	
}
}
