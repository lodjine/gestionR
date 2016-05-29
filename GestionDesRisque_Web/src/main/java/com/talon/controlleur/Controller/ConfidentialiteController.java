package com.talon.controlleur.Controller;

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

import com.talon.entities.Confidentialite;
import com.talon.entities.ImpactC;
import com.talon.entities.MesureEx;
import com.talon.entities.Risque;
import com.talon.entities.Vulnerabilite;
import com.talon.service.ConfidentialiteService;
import com.talon.service.ImpactCService;
import com.talon.service.MesureExService;
import com.talon.service.VulnerabiliteService;
@Controller
public class ConfidentialiteController {
	
	@Autowired
	ConfidentialiteService confidentialiteServiceImpl;
	@Autowired
	MesureExService mesureServiceImpl ; 
	@Autowired
	ImpactCService impServiceImpl ; 
	@Autowired
	VulnerabiliteService vulServiceImpl ; 
	
	
	
	
	
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
	public ConfidentialiteService getConfidentialiteServiceImpl() {
		return confidentialiteServiceImpl;
	}
	public void setConfidentialiteServiceImpl(ConfidentialiteService confidentialiteServiceImpl) {
		this.confidentialiteServiceImpl = confidentialiteServiceImpl;
	}
	@RequestMapping(value = "/showConfidentialiteMenu", method = RequestMethod.GET)
	public ModelAndView ConfMenu(HttpSession session){
		
		ModelAndView model = new ModelAndView("Risk/ConfidentialiteMenu") ; 
		List<Confidentialite> confidentialites=confidentialiteServiceImpl.getAll();
	model.addObject("ListConf",confidentialites) ;
		return model ; 
		
		
	}
	@RequestMapping(value = "/updateConfidentialite",params="updateByCode", method = RequestMethod.GET)
	public ModelAndView showConf(@RequestParam("byCode") int id){
		
		ModelAndView model = new ModelAndView("Risk/ShowConfidentialite") ; 
	    model.addObject("id", id);
		return model ; 
		
		
	}
	@RequestMapping(value = "/updateConfidentialite", method = RequestMethod.GET)
	public ModelAndView adDConf(@PathVariable("id") int id){
		
		
	return null;	
		
	}
	
	@RequestMapping(value = "/SeekConf/{id}/", method = RequestMethod.GET)
    public @ResponseBody List<Confidentialite> CheckRcode(@PathVariable("id") int id, HttpSession session) {
		if(id== 0){
			 List<Confidentialite> confList = new ArrayList<>();
			return confList ;
		}else{
			Confidentialite conf = new Confidentialite() ; 
			conf = confidentialiteServiceImpl.getById(id) ; 
		
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
			Confidentialite confJson = new Confidentialite() ; 
			confJson.setConfId(conf.getConfId());
			confJson.setImpacts(newImp);
			confJson.setMesures(newMes);
			confJson.setVulnerabs(newVul);
			confJson.setRisque(conf.getRisque());
			
			List<Confidentialite> confList = new ArrayList<>();
			confList.add(confJson) ;
		return confList ; 
		}
		
    }
	@RequestMapping(value = "/deleteObject/{id}/{type}/{idConf}/", method = RequestMethod.GET)
    public @ResponseBody List<Confidentialite> DeleteMesure(@PathVariable("id") int id,@PathVariable("type") String type,@PathVariable("idConf") int confId, HttpSession session) {
		
			Confidentialite conf = new Confidentialite() ; 
			conf = confidentialiteServiceImpl.getById(confId) ; 
			if(type.equals("Mesure")){
			for(int i =0 ; i<conf.getMesures().size();i++){
				if(conf.getMesures().get(i).getMesureId() == id){
					conf.getMesures().set(i, null);
				}
			}}else if (type.equals("Vul")){
				for(int i =0 ; i<conf.getVulnerabs().size();i++){
					if(conf.getVulnerabs().get(i).getVulnId() == id){
						conf.getVulnerabs().set(i, null);
					}
				}
			}else {
				for(int i =0 ; i<conf.getImpacts().size();i++){
					if(conf.getImpacts().get(i).getImpactId() == id){
						conf.getImpacts().set(i, null);
					}
			}
			}
			
			confidentialiteServiceImpl.update(conf);
			conf = confidentialiteServiceImpl.getById(confId) ;
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
			Confidentialite confJson = new Confidentialite() ; 
			confJson.setConfId(conf.getConfId());
			confJson.setImpacts(newImp);
			confJson.setMesures(newMes);
			confJson.setVulnerabs(newVul);
			confJson.setRisque(conf.getRisque());
			
			List<Confidentialite> confList = new ArrayList<>();
			confList.add(confJson) ;
		return confList ; 
		
		
    }
	@RequestMapping(value = "/updateConf/{label}/{confId}/{value}/{type}/", method = RequestMethod.GET)
    public @ResponseBody int SaveConf(@PathVariable("label") String label,@PathVariable("confId") int id,@PathVariable("value") int value , @PathVariable("type") String type, HttpSession session) {
		Confidentialite conf = confidentialiteServiceImpl.getById(id);
		
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
		confidentialiteServiceImpl.update(conf);
		return conf.getConfId() ; 
		
    }
	
	
	
	
	@RequestMapping(value = "/updateConfWithOldObject/{confId}/{type}/{id}", method = RequestMethod.GET)
    public @ResponseBody int UpdateConf(@PathVariable("confId") int id, @PathVariable("type") String type,@PathVariable("id") int idObject,  HttpSession session) {
		Confidentialite conf = confidentialiteServiceImpl.getById(id);
		
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
		confidentialiteServiceImpl.update(conf);
		return conf.getConfId() ; 
		
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
