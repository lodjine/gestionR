package com.talan.controlleur.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.Confidentialite;
import com.talan.entities.Disponibilite;
import com.talan.entities.ImpactC;
import com.talan.entities.Integrite;
import com.talan.entities.MesureEx;
import com.talan.entities.Risque;
import com.talan.entities.Utilisateur;
import com.talan.entities.Vulnerabilite;
import com.talan.service.MesureExService;
import com.talan.service.RisqueService;
import com.talan.service.UtilisateurService;

@Controller
public class RiskController {

	@Autowired
	RisqueService riskServiceImpl ; ;
	@Autowired
	UtilisateurService utilisateurServiceImpl;
	
	
	

	

	public UtilisateurService getUtilisateurServiceImpl() {
		return utilisateurServiceImpl;
	}





	public void setUtilisateurServiceImpl(UtilisateurService utilisateurServiceImpl) {
		this.utilisateurServiceImpl = utilisateurServiceImpl;
	}





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
	
	
		@RequestMapping(value="/getRisks",method = RequestMethod.GET)
		public ModelAndView showRisks(){
			ModelAndView model = new ModelAndView("Risk/RiskPage");
					return model ;  
		}
	
	
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
	@RequestMapping(value="/seekConfByProc/{id}/" , method = RequestMethod.GET)
	public @ResponseBody List<Confidentialite> getRisks(@PathVariable("id") int id,HttpSession session ) {
		Utilisateur user = new Utilisateur() ; 
		UserDetails userx = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
        
		user = utilisateurServiceImpl.getById(userx.getUsername());
		List<Confidentialite> confList = new ArrayList<>() ; 
		confList=riskServiceImpl.getConfByProc (id,user.getEmail(),user.getUserType()) ; 
		List<Confidentialite> confJson = new ArrayList<>() ; 
		for(Confidentialite c:confList){
			Confidentialite con = new Confidentialite();
			List<Vulnerabilite> vul = new ArrayList<>() ; 
			List<MesureEx> mes = new ArrayList<>() ;
			List<ImpactC> imp = new ArrayList<>() ; 
			List<Vulnerabilite> vuls = new ArrayList<>() ; 
			List<MesureEx> mess = new ArrayList<>() ;
			List<ImpactC> imps = new ArrayList<>() ; 
			vul = c.getVulnerabs() ; 
			for(Vulnerabilite v:vul){
				Vulnerabilite vs =new Vulnerabilite() ; 
				vs.setVulnLabel(v.getVulnLabel());
				vs.setValue(v.getValue());
				vuls.add(vs);
			}
			con.setVulnerabs(vuls);
			mes = c.getMesures() ;
			for(MesureEx m:mes){
				MesureEx me = new MesureEx() ; 
				me.setMesureLabel(m.getMesureLabel());
				me.setValue(m.getValue());
				mess.add(me) ; 
			}
			con.setMesures(mess);
			imp = c.getImpacts() ; 
			for(ImpactC im:imp){
				ImpactC i = new ImpactC() ; 
				i.setImpactLabel(im.getImpactLabel());
				i.setValue(i.getValue());
				imps.add(i) ; 
			}
			con.setImpacts(imps);
			
			con.setiC(c.getiC());
			con.setResultat(c.getResultat());
			Risque r = new Risque() ; 
			r.setRisqueLabel(c.getRisque().getRisqueLabel());
			con.setRisque(r);
			confJson.add(con) ;
		}
		
		
		
		
		return confJson ; 
		
		
		
	}
	
	@RequestMapping(value="/seekConfByProcRev/{id}/{rev}/" , method = RequestMethod.GET)
	public @ResponseBody List<Confidentialite> getConfWithRev(@PathVariable("id") int id,@PathVariable("rev") int rev,HttpSession session ) {
		Utilisateur user = new Utilisateur() ; 
		UserDetails userx = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
        
		user = utilisateurServiceImpl.getById(userx.getUsername());
		List<Confidentialite> confList = new ArrayList<>() ; 
		confList=riskServiceImpl.getConfByProcRev(id,user.getEmail(),user.getUserType(),rev) ; 
		List<Confidentialite> confJson = new ArrayList<>() ; 
		for(Confidentialite c:confList){
			Confidentialite con = new Confidentialite();
			List<Vulnerabilite> vul = new ArrayList<>() ; 
			List<MesureEx> mes = new ArrayList<>() ;
			List<ImpactC> imp = new ArrayList<>() ; 
			List<Vulnerabilite> vuls = new ArrayList<>() ; 
			List<MesureEx> mess = new ArrayList<>() ;
			List<ImpactC> imps = new ArrayList<>() ; 
			vul = c.getVulnerabs() ; 
			for(Vulnerabilite v:vul){
				Vulnerabilite vs =new Vulnerabilite() ; 
				vs.setVulnLabel(v.getVulnLabel());
				vs.setValue(v.getValue());
				vuls.add(vs);
			}
			con.setVulnerabs(vuls);
			mes = c.getMesures() ;
			for(MesureEx m:mes){
				MesureEx me = new MesureEx() ; 
				me.setMesureLabel(m.getMesureLabel());
				me.setValue(m.getValue());
				mess.add(me) ; 
			}
			con.setMesures(mess);
			imp = c.getImpacts() ; 
			for(ImpactC im:imp){
				ImpactC i = new ImpactC() ; 
				i.setImpactLabel(im.getImpactLabel());
				i.setValue(i.getValue());
				imps.add(i) ; 
			}
			con.setImpacts(imps);
			
			con.setiC(c.getiC());
			con.setResultat(c.getResultat());
			Risque r = new Risque() ; 
			r.setRisqueLabel(c.getRisque().getRisqueLabel());
			con.setRisque(r);
			confJson.add(con) ;
		}
		
		
		
		
		return confJson ; 
		
		
		
	}
	
	@RequestMapping(value="/seekDispByProc/{id}/" , method = RequestMethod.GET)
	public @ResponseBody List<Disponibilite> getdisp(@PathVariable("id") int id,HttpSession session ) {
		Utilisateur user = new Utilisateur() ; 
		UserDetails userx = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
        
		user = utilisateurServiceImpl.getById(userx.getUsername());
		List<Disponibilite> confList = new ArrayList<>() ; 
		confList=riskServiceImpl.getdispByProc (id,user.getEmail(),user.getUserType()) ; 
		List<Disponibilite> confJson = new ArrayList<>() ; 
		for(Disponibilite c:confList){
			Disponibilite con = new Disponibilite();
			List<Vulnerabilite> vul = new ArrayList<>() ; 
			List<MesureEx> mes = new ArrayList<>() ;
			List<ImpactC> imp = new ArrayList<>() ; 
			List<Vulnerabilite> vuls = new ArrayList<>() ; 
			List<MesureEx> mess = new ArrayList<>() ;
			List<ImpactC> imps = new ArrayList<>() ; 
			vul = c.getVulnerabs() ; 
			for(Vulnerabilite v:vul){
				Vulnerabilite vs =new Vulnerabilite() ; 
				vs.setVulnLabel(v.getVulnLabel());
				vs.setValue(v.getValue());
				vuls.add(vs);
			}
			con.setVulnerabs(vuls);
			mes = c.getMesures() ;
			for(MesureEx m:mes){
				MesureEx me = new MesureEx() ; 
				me.setMesureLabel(m.getMesureLabel());
				me.setValue(m.getValue());
				mess.add(me) ; 
			}
			con.setMesures(mess);
			imp = c.getImpacts() ; 
			for(ImpactC im:imp){
				ImpactC i = new ImpactC() ; 
				i.setImpactLabel(im.getImpactLabel());
				i.setValue(i.getValue());
				imps.add(i) ; 
			}
			con.setImpacts(imps);
			
			con.setiDisp(c.getiDisp());
			con.setResultat(c.getResultat());
			Risque r = new Risque() ; 
			r.setRisqueLabel(c.getRisque().getRisqueLabel());
			con.setRisque(r);
			confJson.add(con) ;
		}
		
		
		
		
		return confJson ; 
		
		
		
	}
	
	@RequestMapping(value="/seekDispByProcRev/{id}/{rev}/" , method = RequestMethod.GET)
	public @ResponseBody List<Disponibilite> getDispWithRev(@PathVariable("id") int id,@PathVariable("rev") int rev,HttpSession session ) {
		Utilisateur user = new Utilisateur() ; 
		UserDetails userx = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
        
		user = utilisateurServiceImpl.getById(userx.getUsername());
		List<Disponibilite> confList = new ArrayList<>() ; 
		confList=riskServiceImpl.getdispByProcRev(id,user.getEmail(),user.getUserType(),rev) ; 
		List<Disponibilite> confJson = new ArrayList<>() ; 
		for(Disponibilite c:confList){
			Disponibilite con = new Disponibilite();
			List<Vulnerabilite> vul = new ArrayList<>() ; 
			List<MesureEx> mes = new ArrayList<>() ;
			List<ImpactC> imp = new ArrayList<>() ; 
			List<Vulnerabilite> vuls = new ArrayList<>() ; 
			List<MesureEx> mess = new ArrayList<>() ;
			List<ImpactC> imps = new ArrayList<>() ; 
			vul = c.getVulnerabs() ; 
			for(Vulnerabilite v:vul){
				Vulnerabilite vs =new Vulnerabilite() ; 
				vs.setVulnLabel(v.getVulnLabel());
				vs.setValue(v.getValue());
				vuls.add(vs);
			}
			con.setVulnerabs(vuls);
			mes = c.getMesures() ;
			for(MesureEx m:mes){
				MesureEx me = new MesureEx() ; 
				me.setMesureLabel(m.getMesureLabel());
				me.setValue(m.getValue());
				mess.add(me) ; 
			}
			con.setMesures(mess);
			imp = c.getImpacts() ; 
			for(ImpactC im:imp){
				ImpactC i = new ImpactC() ; 
				i.setImpactLabel(im.getImpactLabel());
				i.setValue(i.getValue());
				imps.add(i) ; 
			}
			con.setImpacts(imps);
			
			con.setiDisp(c.getiDisp());
			con.setResultat(c.getResultat());
			Risque r = new Risque() ; 
			r.setRisqueLabel(c.getRisque().getRisqueLabel());
			con.setRisque(r);
			confJson.add(con) ;
		}
		
		
		
		
		return confJson ; 
		
		
		
	}
	
	@RequestMapping(value="/seekIntByProc/{id}/" , method = RequestMethod.GET)
	public @ResponseBody List<Integrite> getInt(@PathVariable("id") int id,HttpSession session ) {
		Utilisateur user = new Utilisateur() ; 
		UserDetails userx = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
        
		user = utilisateurServiceImpl.getById(userx.getUsername());
		List<Integrite> confList = new ArrayList<>() ; 
		confList=riskServiceImpl.getIntByProc (id,user.getEmail(),user.getUserType()) ; 
		List<Integrite> confJson = new ArrayList<>() ; 
		for(Integrite c:confList){
			Integrite con = new Integrite();
			List<Vulnerabilite> vul = new ArrayList<>() ; 
			List<MesureEx> mes = new ArrayList<>() ;
			List<ImpactC> imp = new ArrayList<>() ; 
			List<Vulnerabilite> vuls = new ArrayList<>() ; 
			List<MesureEx> mess = new ArrayList<>() ;
			List<ImpactC> imps = new ArrayList<>() ; 
			vul = c.getVulnerabs() ; 
			for(Vulnerabilite v:vul){
				Vulnerabilite vs =new Vulnerabilite() ; 
				vs.setVulnLabel(v.getVulnLabel());
				vs.setValue(v.getValue());
				vuls.add(vs);
			}
			con.setVulnerabs(vuls);
			mes = c.getMesures() ;
			for(MesureEx m:mes){
				MesureEx me = new MesureEx() ; 
				me.setMesureLabel(m.getMesureLabel());
				me.setValue(m.getValue());
				mess.add(me) ; 
			}
			con.setMesures(mess);
			imp = c.getImpacts() ; 
			for(ImpactC im:imp){
				ImpactC i = new ImpactC() ; 
				i.setImpactLabel(im.getImpactLabel());
				i.setValue(i.getValue());
				imps.add(i) ; 
			}
			con.setImpacts(imps);
			
			con.setIintg(c.getIintg());
			con.setResultat(c.getResultat());
			Risque r = new Risque() ; 
			r.setRisqueLabel(c.getRisque().getRisqueLabel());
			con.setRisque(r);
			confJson.add(con) ;
		}
		
		
		
		
		return confJson ; 
		
		
		
	}
	
	@RequestMapping(value="/seekIntByProcRev/{id}/{rev}/" , method = RequestMethod.GET)
	public @ResponseBody List<Integrite> getIntWithRev(@PathVariable("id") int id,@PathVariable("rev") int rev,HttpSession session ) {
		Utilisateur user = new Utilisateur() ; 
		UserDetails userx = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
        
		user = utilisateurServiceImpl.getById(userx.getUsername());
		List<Integrite> confList = new ArrayList<>() ; 
		confList=riskServiceImpl.getIntByProcRev(id,user.getEmail(),user.getUserType(),rev) ; 
		List<Integrite> confJson = new ArrayList<>() ; 
		for(Integrite c:confList){
			Integrite con = new Integrite();
			List<Vulnerabilite> vul = new ArrayList<>() ; 
			List<MesureEx> mes = new ArrayList<>() ;
			List<ImpactC> imp = new ArrayList<>() ; 
			List<Vulnerabilite> vuls = new ArrayList<>() ; 
			List<MesureEx> mess = new ArrayList<>() ;
			List<ImpactC> imps = new ArrayList<>() ; 
			vul = c.getVulnerabs() ; 
			for(Vulnerabilite v:vul){
				Vulnerabilite vs =new Vulnerabilite() ; 
				vs.setVulnLabel(v.getVulnLabel());
				vs.setValue(v.getValue());
				vuls.add(vs);
			}
			con.setVulnerabs(vuls);
			mes = c.getMesures() ;
			for(MesureEx m:mes){
				MesureEx me = new MesureEx() ; 
				me.setMesureLabel(m.getMesureLabel());
				me.setValue(m.getValue());
				mess.add(me) ; 
			}
			con.setMesures(mess);
			imp = c.getImpacts() ; 
			for(ImpactC im:imp){
				ImpactC i = new ImpactC() ; 
				i.setImpactLabel(im.getImpactLabel());
				i.setValue(i.getValue());
				imps.add(i) ; 
			}
			con.setImpacts(imps);
			
			con.setIintg(c.getIintg());
			con.setResultat(c.getResultat());
			Risque r = new Risque() ; 
			r.setRisqueLabel(c.getRisque().getRisqueLabel());
			con.setRisque(r);
			confJson.add(con) ;
		}
		
		
		
		
		return confJson ; 
		
		
		
	}
	
}
