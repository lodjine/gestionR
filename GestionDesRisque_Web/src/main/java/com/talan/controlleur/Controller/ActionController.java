package com.talan.controlleur.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.Action;
import com.talan.entities.Processus;
import com.talan.entities.Risque;
import com.talan.service.ActionService;
import com.talan.service.RisqueService;
import com.talan.service.UtilisateurService;

@Controller
public class ActionController {

	@Autowired
	UtilisateurService utilisateurServiceImpl;
	@Autowired
	ActionService actionServiceImpl ; 
	@Autowired
	RisqueService rServiceImpl ; 
	
	
	
	public RisqueService getrServiceImpl() {
		return rServiceImpl;
	}

	public void setrServiceImpl(RisqueService rServiceImpl) {
		this.rServiceImpl = rServiceImpl;
	}

	public ActionService getActionServiceImpl() {
		return actionServiceImpl;
	}

	public void setActionServiceImpl(ActionService actionServiceImpl) {
		this.actionServiceImpl = actionServiceImpl;
	}

	public UtilisateurService getUtilisateurServiceImpl() {
		return utilisateurServiceImpl;
	}

	public void setUtilisateurServiceImpl(UtilisateurService utilisateurServiceImpl) {
		this.utilisateurServiceImpl = utilisateurServiceImpl;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, "creationDate",
				new CustomDateEditor(formater, false));
		binder.registerCustomEditor(Date.class, "modificationDate",
				new CustomDateEditor(formater, false));
		binder.registerCustomEditor(Date.class, "beginDate",
				new CustomDateEditor(formater, false));
		binder.registerCustomEditor(Date.class, "endDate",
				new CustomDateEditor(formater, false));
	}
	
	
	@RequestMapping(value = "/ShowAction",params="updateByCode", method = RequestMethod.GET)
	public ModelAndView Affichinf(@RequestParam("byCode") String id){
		
		ModelAndView model = new ModelAndView("utilisateur/actionAffiche") ; 
		
		model.addObject("admin", actionServiceImpl.getById(Integer.parseInt(id)));
		return model ;
		
		
	}
	@RequestMapping(value = "/MenuAction", method = RequestMethod.GET)
	public ModelAndView Menuinf(){
		
		ModelAndView model = new ModelAndView("Process/actionMenu") ; 
		
		model.addObject("ListAdmin", actionServiceImpl.getAll());
		return model ;
		
		
	}
	
	@RequestMapping(value = "/SeekAction", method = RequestMethod.GET)
    public @ResponseBody List<Action> seekAction() {
		
		List<Action> action = actionServiceImpl.getAll() ; 
		
		 
		List<Action> actionJs = new ArrayList<>()  ;
		for (Action a:action ){
			Action ac = new Action() ;
			ac.setBeginDate(a.getBeginDate());
			ac.setCreationDate(a.getCreationDate());
			ac.setEndDate(a.getEndDate());
			ac.setModificationDate(a.getModificationDate());
			ac.setLabel(a.getLabel());
			
			ac.setStatus(a.getStatus());
			Processus pr = new Processus() ; 
			pr.setProcessus(a.getRisk().getProc().getProcessus());
			Risque r = new Risque() ; 
			r.setRisqueLabel(a.getRisk().getRisqueLabel());
			r.setProc(pr);
			ac.setRisk(r);
			actionJs.add(ac);
		}
		return actionJs ;
		
		}
	
	@RequestMapping(value = "/PersisteAction/{bDate}/{eDate}/{label}/{status}/{riskId}/", method = RequestMethod.GET)
    public @ResponseBody Boolean CheckRcode(@PathVariable("bDate") String bDate,@PathVariable("eDate") String eDate,@PathVariable("riskId") int rId,@PathVariable("label") String label , @PathVariable("status") int stat, HttpSession session) throws ParseException {
		Risque r = new Risque() ; 
		r= rServiceImpl.getById(rId) ; 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		Action ac = new Action() ; 
		
		ac.setBeginDate(df.parse(bDate));
		ac.setEndDate(df.parse(eDate));
		ac.setCreationDate(new Date());
		ac.setModificationDate(new Date());
		ac.setStatus(stat);
		ac.setRisk(r);
		actionServiceImpl.persist(ac);
		return true ; 
		
    }
	@RequestMapping(value = "/updateAction/{bDate}/{eDate}/{label}/{status}/{riskId}/{acId}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("bDate") String bDate,@PathVariable("eDate") String eDate,@PathVariable("riskId") int rId,@PathVariable("label") String label , @PathVariable("status") int stat,@PathVariable("acId") int acId, HttpSession session) throws ParseException {
		Action ac = actionServiceImpl.getById(acId) ; 
		Risque r = new Risque() ; 
		r= rServiceImpl.getById(rId) ; 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		ac.setBeginDate(df.parse(bDate));
		ac.setEndDate(df.parse(eDate));
		
		ac.setModificationDate(new Date());
		ac.setStatus(stat);
		ac.setRisk(r);
		actionServiceImpl.update(ac);
		return true ; 
		
    }
	@RequestMapping(value = "/deleteAdmin/{idAc}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("idAc") int id, HttpSession session) {
		
		Action user = new Action() ; 
		
		user = actionServiceImpl.getById(id);
		actionServiceImpl.delete(user);
		return true ; 
		
    }
}
