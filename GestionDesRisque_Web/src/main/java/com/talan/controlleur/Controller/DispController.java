package com.talan.controlleur.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.Confidentialite;
import com.talan.entities.Disponibilite;
import com.talan.entities.ImpactC;
import com.talan.entities.MesureEx;
import com.talan.entities.Processus;
import com.talan.entities.Risque;
import com.talan.entities.Vulnerabilite;
import com.talan.service.ConfidentialiteService;
import com.talan.service.DisponibiliteService;
import com.talan.service.ImpactCService;
import com.talan.service.MesureExService;
import com.talan.service.ProcessService;
import com.talan.service.RisqueService;
import com.talan.service.VulnerabiliteService;
@Controller
public class DispController {
	
	@Autowired
	DisponibiliteService dispServiceImpl ; ;
	@Autowired
	MesureExService mesureServiceImpl ; 
	@Autowired
	ImpactCService impServiceImpl ; 
	@Autowired
	VulnerabiliteService vulServiceImpl ; 
	@Autowired
	RisqueService risqueServiceImpl ;
	@Autowired
	ProcessService processServiceImpl ; 
	
	
	
	public ProcessService getProcessServiceImpl() {
		return processServiceImpl;
	}
	public void setProcessServiceImpl(ProcessService processServiceImpl) {
		this.processServiceImpl = processServiceImpl;
	}
	public RisqueService getRisqueServiceImpl() {
		return risqueServiceImpl;
	}
	public void setRisqueServiceImpl(RisqueService risqueServiceImpl) {
		this.risqueServiceImpl = risqueServiceImpl;
	}
	public MesureExService getMesureServiceImpl() {
		return mesureServiceImpl;
	}
	public void setMesureServiceImpl(MesureExService mesureServiceImpl) {
		this.mesureServiceImpl = mesureServiceImpl;
	}
	public ImpactCService getImpServiceImpl() {
		return impServiceImpl;
	}
	public void setImpServiceImpl(ImpactCService impServiceImpl) {
		this.impServiceImpl = impServiceImpl;
	}
	public VulnerabiliteService getVulServiceImpl() {
		return vulServiceImpl;
	}
	public void setVulServiceImpl(VulnerabiliteService vulServiceImpl) {
		this.vulServiceImpl = vulServiceImpl;
	}
	public DisponibiliteService getConfidentialiteServiceImpl() {
		return dispServiceImpl;
	}
	public void setConfidentialiteServiceImpl(DisponibiliteService dispServiceImpl) {
		this.dispServiceImpl = dispServiceImpl;
	}
	@RequestMapping(value = "/showdispMenu", method = RequestMethod.GET)
	public ModelAndView ConfMenu(HttpSession session){
		
		ModelAndView model = new ModelAndView("Risk/dispMenu") ; 
		List<Disponibilite> confidentialites=dispServiceImpl.getAll();
	model.addObject("ListConf",confidentialites) ;
		return model ; 
		
		
	}
	@RequestMapping(value = "/updatedisp",params="updateByCode", method = RequestMethod.GET)
	public ModelAndView showConf(@RequestParam("byCode") int id){
		
		ModelAndView model = new ModelAndView("Risk/Showdisp") ; 
	    model.addObject("id", id);
		return model ; 
		
		
	}
	@RequestMapping(value = "/updatedisp",params="newRecord", method = RequestMethod.GET)
	public ModelAndView adDConf(){
		ModelAndView model = new ModelAndView("Risk/Adddisp") ; 
		
		return model ;
		
		
		
	}

	
	@RequestMapping(value = "/SeekDisp/{id}/", method = RequestMethod.GET)
    public @ResponseBody List<Disponibilite> CheckRcode(@PathVariable("id") int id, HttpSession session) {
		if(id== 0){
			 List<Disponibilite> confList = new ArrayList<>();
			 Disponibilite conf = new Disponibilite() ; 
			 conf.setiDisp(0);
			 
			 List<MesureEx> mesList = new ArrayList<>() ;
			 List<ImpactC> impList = new ArrayList<>() ; 
			 List<Vulnerabilite> vuls = new ArrayList<>() ; 
			 conf.setMesures(mesList);
			 conf.setVulnerabs(vuls);
			 conf.setImpacts(impList);
			 confList.add(conf);
			return confList ;
		}else{
			Disponibilite conf = new Disponibilite() ; 
			conf = dispServiceImpl.getById(id) ; 
			
			List<MesureEx> mes = conf.getMesures() ; 
			List<MesureEx> newMes = new ArrayList<>() ; 
			for(MesureEx m:mes){
				MesureEx mess = new MesureEx() ; 
				mess.setMesureId(m.getMesureId());
				mess.setMesureLabel(m.getMesureLabel());
				mess.setValue(m.getValue());
				newMes.add(mess);
			}
			
			List<Vulnerabilite> vul = conf.getVulnerabs() ; 
			List<Vulnerabilite> newVul = new ArrayList<>() ; 
			for(Vulnerabilite v:vul){
				Vulnerabilite vuls = new Vulnerabilite() ; 
				vuls.setValue(v.getValue());
				vuls.setVulnId(v.getVulnId());
				vuls.setVulnLabel(v.getVulnLabel());
				newVul.add(vuls);
			}
			
			List<ImpactC> imp = conf.getImpacts() ; 
			List<ImpactC> newImp = new ArrayList<>() ; 
			for(ImpactC i:imp){
				ImpactC ipms = new ImpactC() ; 
				ipms.setImpactId(i.getImpactId());
				ipms.setImpactLabel(i.getImpactLabel());
				ipms.setValue(i.getValue());
				newImp.add(ipms) ;
			}
			Disponibilite confJson = new Disponibilite() ; 
			confJson.setDispId(conf.getDispId());
			confJson.setImpacts(newImp);
			confJson.setMesures(newMes);
			confJson.setVulnerabs(newVul);
			Risque r = new Risque() ; 
			
			
			r.setRisqueId(conf.getRisque().getRisqueId());
			r.setRisqueLabel(conf.getRisque().getRisqueLabel());
			confJson.setRisque(r);
			
			List<Disponibilite> confList = new ArrayList<>();
			confList.add(confJson) ;
		return confList ; 
		}
		
    }
	@RequestMapping(value = "/deleteObjectdisp/{id}/{type}/{idConf}/", method = RequestMethod.GET)
    public @ResponseBody List<Disponibilite> DeleteMesure(@PathVariable("id") int id,@PathVariable("type") String type,@PathVariable("idConf") int confId, HttpSession session) {
		
		Disponibilite conf = new Disponibilite() ; 
			conf = dispServiceImpl.getById(confId) ; 
			if(type.equals("risk") ){
				
					conf.setRisque(null);
				
			}else
			if(type.equals("Mesure")){
				List<MesureEx> m = new ArrayList<>() ; 
			for(int i =0 ; i<conf.getMesures().size();i++){
				if(conf.getMesures().get(i).getMesureId() != id){
					m.add(conf.getMesures().get(i));
				}
			}
				conf.setMesures(m);
			}else if (type.equals("Vul")){
				List<Vulnerabilite> v= new ArrayList<>() ; 
				for(int i =0 ; i<conf.getVulnerabs().size();i++){
					if(conf.getVulnerabs().get(i).getVulnId() != id){
						v.add(conf.getVulnerabs().get(i));
						
					}
					
				}
				conf.setVulnerabs(v);
			}else {
				List<ImpactC> im = new ArrayList<>() ; 
				for(int i =0 ; i<conf.getImpacts().size();i++){
					if(conf.getImpacts().get(i).getImpactId() != id){
						im.add(conf.getImpacts().get(i));
					}
					
			}
				conf.setImpacts(im);
			}
			int mesTotal = 0 ; 
					for(int i =0 ; i < conf.getMesures().size() ; i++){
						if(conf.getMesures().get(i) != null){
						mesTotal = mesTotal + conf.getMesures().get(i).getValue() ;
						}
					}
			int vulTotal = 0 ; 
			for(int i =0 ; i<conf.getVulnerabs().size(); i++){
				if(conf.getVulnerabs().get(i) != null){
				vulTotal=vulTotal + vulTotal+conf.getVulnerabs().get(i).getValue() ; 
				}
			}
			int impTotal = 0 ; 
			for(int i=0 ; i<conf.getImpacts().size() ;i++){
				if(conf.getImpacts().get(i) != null){
				vulTotal = vulTotal+conf.getImpacts().get(i).getValue() ;
			}
			}
			conf.setResultat(mesTotal+vulTotal+impTotal);
			dispServiceImpl.update(conf);
			conf = dispServiceImpl.getById(confId) ;
			List<MesureEx> mes = conf.getMesures() ; 
			List<MesureEx> newMes = new ArrayList<>() ;
			
			for(MesureEx m:mes){
				
				MesureEx mess = new MesureEx() ; 
				mess.setMesureId(m.getMesureId());
				mess.setMesureLabel(m.getMesureLabel());
				mess.setValue(m.getValue());
				newMes.add(mess);
				}
			
			
			
			List<Vulnerabilite> vul = conf.getVulnerabs() ; 
			List<Vulnerabilite> newVul = new ArrayList<>() ; 
			for(Vulnerabilite v:vul){
				Vulnerabilite vuls = new Vulnerabilite() ; 
				vuls.setValue(v.getValue());
				vuls.setVulnId(v.getVulnId());
				vuls.setVulnLabel(v.getVulnLabel());
				newVul.add(vuls);
			}
			
			List<ImpactC> imp = conf.getImpacts() ; 
			List<ImpactC> newImp = new ArrayList<>() ; 
			for(ImpactC i:imp){
				ImpactC ipms = new ImpactC() ; 
				ipms.setImpactId(i.getImpactId());
				ipms.setImpactLabel(i.getImpactLabel());
				ipms.setValue(i.getValue());
				newImp.add(ipms) ;
			}
			Disponibilite confJson = new Disponibilite() ; 
			confJson.setDispId(conf.getDispId());
			confJson.setImpacts(newImp);
			confJson.setMesures(newMes);
			confJson.setVulnerabs(newVul);
			confJson.setRisque(conf.getRisque());
			
			List<Disponibilite> confList = new ArrayList<>();
			confList.add(confJson) ;
		return confList ; 
		
		
    }
	@RequestMapping(value = "/updateConfdisp/{label}/{confId}/{value}/{type}/", method = RequestMethod.GET)
    public @ResponseBody int SaveConf(@PathVariable("label") String label,@PathVariable("confId") int id,@PathVariable("value") int value , @PathVariable("type") String type, HttpSession session) {
		Disponibilite conf = dispServiceImpl.getById(id);
		if(type.equals("Resultat")){
			conf.setiDisp(value);
		}else
		if(type.equals("risk") ){
			
			Risque ris = new Risque() ; 
			ris.setRisqueLabel(label);
			Processus proc = processServiceImpl.getById(value);
			ris.setProc(proc);
			conf.setRisque(ris);
			
		}else
		if(type.equals("Mesure")){
			MesureEx mes = new MesureEx() ; 
			mes.setMesureLabel(label);
			mes.setValue(value);
			List<MesureEx> mesList = conf.getMesures() ; 
			mesList.add(mes);
			conf.setMesures(mesList);
		}else if(type.equals("Vul")){
			Vulnerabilite vul = new Vulnerabilite() ; 
			vul.setVulnLabel(label);
			vul.setValue(value);
			List<Vulnerabilite> vulList = conf.getVulnerabs() ; 
			vulList.add(vul) ; 
			conf.setVulnerabs(vulList);
		}else{
			ImpactC imp = new ImpactC() ; 
			imp.setImpactLabel(label);
			imp.setValue(value);
			List<ImpactC> impList = conf.getImpacts() ; 
			impList.add(imp) ;
			conf.setImpacts(impList);
		}
		int mesTotal = 0 ; 
		for(int i =0 ; i < conf.getMesures().size() ; i++){
			mesTotal = mesTotal + conf.getMesures().get(i).getValue() ;
		}
int vulTotal = 0 ; 
for(int i =0 ; i<conf.getVulnerabs().size(); i++){
	vulTotal=vulTotal + vulTotal+conf.getVulnerabs().get(i).getValue() ; 
}
int impTotal = 0 ; 
for(int i=0 ; i<conf.getImpacts().size() ;i++){
	vulTotal = vulTotal+conf.getImpacts().get(i).getValue() ;
}
conf.setResultat(mesTotal+vulTotal+impTotal);
		dispServiceImpl.update(conf);
		return conf.getDispId() ; 
		
    }
	
	
	
	
	@RequestMapping(value = "/updateConfWithOldObjectdisp/{confId}/{type}/{id}/", method = RequestMethod.GET)
    public @ResponseBody int UpdateConf(@PathVariable("confId") int id, @PathVariable("type") String type,@PathVariable("id") int idObject,  HttpSession session) {
		Disponibilite conf = dispServiceImpl.getById(id);
		if(type.equals("risk") ){
			
			Risque ris =risqueServiceImpl.getById(id) ; 
			
			
			
			conf.setRisque(ris);
			
		}else
		if(type.equals("Mesure")){
			MesureEx mes = mesureServiceImpl.getMesureById(idObject); 
			MesureEx mesJson = new MesureEx() ; 
			mesJson.setMesureLabel(mes.getMesureLabel());
			mesJson.setValue(mes.getValue());
			mesJson.setMesureId(mes.getMesureId());
			List<MesureEx> mesList = conf.getMesures() ; 
			mesList.add(mesJson);
			conf.setMesures(mesList);
		}else if(type.equals("Vul")){
			Vulnerabilite vul = vulServiceImpl.getById(idObject) ;
			Vulnerabilite vulJson = new Vulnerabilite() ; 
			vulJson.setVulnLabel(vul.getVulnLabel());
			vulJson.setValue(vul.getValue());
			vulJson.setVulnId(vul.getVulnId());
			List<Vulnerabilite> vulList = conf.getVulnerabs() ; 
			vulList.add(vulJson) ; 
			conf.setVulnerabs(vulList);
		}else{
			ImpactC imp = impServiceImpl.getById(idObject) ; 
			ImpactC impJson = new ImpactC() ; 
			
			impJson.setImpactLabel(imp.getImpactLabel());
			impJson.setValue(imp.getValue());
			impJson.setImpactId(imp.getImpactId());
			List<ImpactC> impList = conf.getImpacts() ; 
			impList.add(impJson) ;
			conf.setImpacts(impList);
		}
		int mesTotal = 0 ; 
		for(int i =0 ; i < conf.getMesures().size() ; i++){
			mesTotal = mesTotal + conf.getMesures().get(i).getValue() ;
		}
int vulTotal = 0 ; 
for(int i =0 ; i<conf.getVulnerabs().size(); i++){
	vulTotal=vulTotal + vulTotal+conf.getVulnerabs().get(i).getValue() ; 
}
int impTotal = 0 ; 
for(int i=0 ; i<conf.getImpacts().size() ;i++){
	vulTotal = vulTotal+conf.getImpacts().get(i).getValue() ;
}
conf.setResultat(mesTotal+vulTotal+impTotal);
		dispServiceImpl.update(conf);
		return conf.getDispId() ; 
		
    }
	
	@RequestMapping(value = "/PersisteupdateConfdisp/{label}/{value}/{type}/", method = RequestMethod.GET)
    public @ResponseBody int PersisteupdateConf(@PathVariable("label") String label,@PathVariable("value") int value , @PathVariable("type") String type) {
		Disponibilite conf = new Disponibilite() ;
		if(type.equals("Resultat")){
			conf.setiDisp(value);
		}else
		if(type.equals("risk") ){
			
			Risque ris = new Risque() ; 
			Processus proc = new Processus() ; 
			proc = processServiceImpl.getById(value);
			ris.setRisqueLabel(label);
			ris.setProc(proc);
			
			conf.setRisque(ris);
			
		}else
		if(type.equals("Mesure")){
			MesureEx mes = new MesureEx() ; 
			mes.setMesureLabel(label);
			mes.setValue(value);
			List<MesureEx> mesList = conf.getMesures() ; 
			mesList.add(mes);
			conf.setMesures(mesList);
		}else if(type.equals("Vul")){
			Vulnerabilite vul = new Vulnerabilite() ; 
			vul.setVulnLabel(label);
			vul.setValue(value);
			List<Vulnerabilite> vulList = conf.getVulnerabs() ; 
			vulList.add(vul) ; 
			conf.setVulnerabs(vulList);
		}else{
			ImpactC imp = new ImpactC() ; 
			imp.setImpactLabel(label);
			imp.setValue(value);
			List<ImpactC> impList = conf.getImpacts() ; 
			impList.add(imp) ;
			conf.setImpacts(impList);
		}
		List<MesureEx> mesList = new ArrayList<>() ;
		 List<ImpactC> impList = new ArrayList<>() ; 
		 List<Vulnerabilite> vuls = new ArrayList<>() ;
		 if(conf.getMesures() != null ){
			 conf.setVulnerabs(vuls);
			 conf.setImpacts(impList);
		 }else if(conf.getVulnerabs() != null){
			 conf.setMesures(mesList);
			 conf.setImpacts(impList);
		 }else if(conf.getImpacts() != null){
			 conf.setMesures(mesList);
			 conf.setVulnerabs(vuls);
		 }else{
			 conf.setMesures(mesList);
			 conf.setVulnerabs(vuls);
			 conf.setImpacts(impList);
		 }
		int mesTotal = 0 ; 
		for(int i =0 ; i < conf.getMesures().size() ; i++){
			mesTotal = mesTotal + conf.getMesures().get(i).getValue() ;
		}
int vulTotal = 0 ; 
for(int i =0 ; i<conf.getVulnerabs().size(); i++){
	vulTotal=vulTotal + vulTotal+conf.getVulnerabs().get(i).getValue() ; 
}
int impTotal = 0 ; 
for(int i=0 ; i<conf.getImpacts().size() ;i++){
	vulTotal = vulTotal+conf.getImpacts().get(i).getValue() ;
}

if(!(conf.getiDisp() >= 0)){
conf.setiDisp(0);
}
conf.setResultat(mesTotal+vulTotal+impTotal);
	int x =	dispServiceImpl.merge(conf);
		
		return x ;
    }
	
	
	
	
	@RequestMapping(value = "/PersisteConfWithOldObjectdisp/{type}/{id}", method = RequestMethod.GET)
    public @ResponseBody int PersisteConfWithOldObject( @PathVariable("type") String type,@PathVariable("id") int idObject,  HttpSession session) {
		Disponibilite conf = new Disponibilite();
		if(type.equals("risk") ){
			
			Risque ris =risqueServiceImpl.getById(idObject) ; 
			
			
			
			conf.setRisque(ris);
			
		}else
		if(type.equals("Mesure")){
			MesureEx mes = mesureServiceImpl.getMesureById(idObject); 
			MesureEx mesJson = new MesureEx() ; 
			mesJson.setMesureLabel(mes.getMesureLabel());
			mesJson.setValue(mes.getValue());
			mesJson.setMesureId(mes.getMesureId());
			List<MesureEx> mesList = conf.getMesures() ; 
			mesList.add(mesJson);
			conf.setMesures(mesList);
		}else if(type.equals("Vul")){
			Vulnerabilite vul = vulServiceImpl.getById(idObject) ;
			Vulnerabilite vulJson = new Vulnerabilite() ; 
			vulJson.setVulnLabel(vul.getVulnLabel());
			vulJson.setValue(vul.getValue());
			vulJson.setVulnId(vul.getVulnId());
			List<Vulnerabilite> vulList = conf.getVulnerabs() ; 
			vulList.add(vulJson) ; 
			conf.setVulnerabs(vulList);
		}else{
			ImpactC imp = impServiceImpl.getById(idObject) ; 
			ImpactC impJson = new ImpactC() ; 
			
			impJson.setImpactLabel(imp.getImpactLabel());
			impJson.setValue(imp.getValue());
			impJson.setImpactId(imp.getImpactId());
			List<ImpactC> impList = conf.getImpacts() ; 
			impList.add(impJson) ;
			conf.setImpacts(impList);
		}
		List<MesureEx> mesList = new ArrayList<>() ;
		 List<ImpactC> impList = new ArrayList<>() ; 
		 List<Vulnerabilite> vuls = new ArrayList<>() ;
		 if(conf.getMesures() != null ){
			 conf.setVulnerabs(vuls);
			 conf.setImpacts(impList);
		 }else if(conf.getVulnerabs() != null){
			 conf.setMesures(mesList);
			 conf.setImpacts(impList);
		 }else if(conf.getImpacts() != null){
			 conf.setMesures(mesList);
			 conf.setVulnerabs(vuls);
		 }else{
			 conf.setMesures(mesList);
			 conf.setVulnerabs(vuls);
			 conf.setImpacts(impList);
		 }
		 
		int mesTotal = 0 ; 
		for(int i =0 ; i < conf.getMesures().size() ; i++){
			mesTotal = mesTotal + conf.getMesures().get(i).getValue() ;
		}
int vulTotal = 0 ; 
for(int i =0 ; i<conf.getVulnerabs().size(); i++){
	vulTotal=vulTotal + vulTotal+conf.getVulnerabs().get(i).getValue() ; 
}
int impTotal = 0 ; 
for(int i=0 ; i<conf.getImpacts().size() ;i++){
	vulTotal = vulTotal+conf.getImpacts().get(i).getValue() ;
}
if(!(conf.getiDisp() >= 0)){
conf.setiDisp(0);
}
conf.setResultat(mesTotal+vulTotal+impTotal);
	
int x = dispServiceImpl.merge(conf);
		return x ; 
		
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
