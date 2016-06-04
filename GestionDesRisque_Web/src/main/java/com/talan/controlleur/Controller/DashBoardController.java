package com.talan.controlleur.Controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talan.service.ActionService;
import com.talan.service.ConfidentialiteService;
import com.talan.service.DisponibiliteService;
import com.talan.service.IntegriteService;

@Controller
public class DashBoardController {

	@Autowired
	ActionService actionServiceImpl;
	@Autowired 
	ConfidentialiteService confidentialiteServiceImpl;
	@Autowired
	IntegriteService integriteServiceImpl;
	@Autowired
	DisponibiliteService disponibiliteServiceImpl;
	
	@RequestMapping(value="/getNTermineAction")
	public @ResponseBody Integer getActionNumberNonTermine(){
		
		
		
		return actionServiceImpl.getAllNonTermine().size();
	}
	
	@RequestMapping(value="/getTermineAction")
public @ResponseBody Integer getActionNumberTermine(){
		
		
		
		return actionServiceImpl.getAllTermine().size();
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/getRisqueByProc/{procId}/",  method = RequestMethod.GET)
	public @ResponseBody List<Integer> getRisqueFaibleByProc(@PathVariable("procId") int procId){
		int number=0;	
		number=number+confidentialiteServiceImpl.getAllByProc(procId, 15, 200).size();
		number=number+disponibiliteServiceImpl.getAllByProc(procId, 15, 200).size();
		number=number+integriteServiceImpl.getAllByProc(procId, 15, 200).size();
			
		int number2=0;
		number2=number2+confidentialiteServiceImpl.getAllByProc(procId, 10, 15).size();
		number2=number2+disponibiliteServiceImpl.getAllByProc(procId, 10, 15).size();
		number2=number2+integriteServiceImpl.getAllByProc(procId, 10, 15).size();
		
		int number3=0;
		number3=number3+confidentialiteServiceImpl.getAllByProc(procId, 5, 10).size();
		number3=number3+disponibiliteServiceImpl.getAllByProc(procId, 5, 10).size();
		number3=number3+integriteServiceImpl.getAllByProc(procId, 5, 10).size();
			
			
			
		int number4=0;
		number4=number4+confidentialiteServiceImpl.getAllByProc(procId,0, 5).size();
		number4=number4+disponibiliteServiceImpl.getAllByProc(procId, 0, 5).size();
		number4=number4+integriteServiceImpl.getAllByProc(procId, 0, 5).size();
			List<Integer> numbers=new ArrayList<Integer>();
			
			
			numbers.add(number);
			numbers.add(number2);
			numbers.add(number3);
			numbers.add(number4);
			
	
			return numbers;
		}
	
}
