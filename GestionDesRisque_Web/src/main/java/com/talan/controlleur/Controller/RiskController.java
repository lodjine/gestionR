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
import com.talan.entities.ListRisque;
import com.talan.entities.MesureEx;
import com.talan.entities.Processus;
import com.talan.entities.Risque;
import com.talan.entities.Utilisateur;
import com.talan.entities.Vulnerabilite;
import com.talan.service.ImpactCService;
import com.talan.service.MesureExService;
import com.talan.service.ProcessService;
import com.talan.service.RisqueService;
import com.talan.service.UtilisateurService;
import com.talan.service.VulnerabiliteService;

@Controller
public class RiskController {

	@Autowired
	RisqueService riskServiceImpl ; ;
	@Autowired
	UtilisateurService utilisateurServiceImpl;
	@Autowired
	MesureExService mesServiceImpl ; 
	@Autowired
	ImpactCService impactCServiceImpl ; 
	@Autowired
	VulnerabiliteService vulServiceImpl ; 
	@Autowired
	ProcessService pServiceImpl ; 
	

	public ImpactCService getImpactCServiceImpl() {
		return impactCServiceImpl;
	}





	public void setImpactCServiceImpl(ImpactCService impactCServiceImpl) {
		this.impactCServiceImpl = impactCServiceImpl;
	}





	public VulnerabiliteService getVulServiceImpl() {
		return vulServiceImpl;
	}





	public void setVulServiceImpl(VulnerabiliteService vulServiceImpl) {
		this.vulServiceImpl = vulServiceImpl;
	}





	public MesureExService getMesServiceImpl() {
		return mesServiceImpl;
	}





	public void setMesServiceImpl(MesureExService mesServiceImpl) {
		this.mesServiceImpl = mesServiceImpl;
	}





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
	
	
	@RequestMapping(value="/seekRisqueByProc/{id}/{type}" , method = RequestMethod.GET)
	public @ResponseBody List<ListRisque> getRisksByProc(@PathVariable("id") int id,@PathVariable("type") String type ,HttpSession session ) {
	List<Risque>rList = riskServiceImpl.getRiskByProc(id) ; 
	List<MesureEx> mesList = new ArrayList<>() ;
	List<ImpactC> impList = new ArrayList<>() ; 
	List<Vulnerabilite> vulList = new ArrayList<>() ; 
	List<ListRisque> listRisque = new ArrayList<>() ; 
			for(int i =0 ; i<rList.size() ; i++) {
				ListRisque lrisque = new ListRisque() ; 
				mesList = mesServiceImpl.getmesureByRiskAndType(rList.get(i).getRisqueId(), type) ;
				for(int j = 0 ; j<mesList.size() ; j++){
					lrisque.setRiskLabel(rList.get(i).getRisqueLabel());
					if(j== 0){
						lrisque.setMesures(mesList.get(j).getMesureLabel());
					}else{
					lrisque.setMesures(lrisque.getMesures()+"\r\n"+mesList.get(j).getMesureLabel());
					}
					lrisque.setTotalmes(lrisque.getTotalmes()+mesList.get(j).getValue() );
				}
				 impList = impactCServiceImpl.getImpactCByRiskAndType(rList.get(i).getRisqueId(), type) ; 
				 for(int j = 0 ; j<impList.size() ; j++){
					 if(j== 0){
							lrisque.setImpacts(impList.get(j).getImpactLabel());
						}else{
						lrisque.setImpacts(lrisque.getImpacts()+"\r\n"+impList.get(j).getImpactLabel());
						}
						lrisque.setTotalimps(lrisque.getTotalimps()+impList.get(j).getValue() );
					}
				 vulList = vulServiceImpl.getVulnerabiliteByRiskAndType(rList.get(i).getRisqueId(), type) ; 
				 for(int j = 0 ; j<vulList.size() ; j++){
					 if(j== 0){
						lrisque.setVuls(vulList.get(j).getVulnLabel());
					 }else{
						 
						 lrisque.setVuls(lrisque.getVuls()+"\r\n"+vulList.get(j).getVulnLabel());
					 }
						lrisque.setTotalvuls(lrisque.getTotalvuls()+vulList.get(j).getValue() );
					 
					}
				lrisque.setTotal((lrisque.getTotalvuls()*lrisque.getTotalimps()*rList.get(i).getValue())-lrisque.getTotalmes());
				listRisque.add(lrisque) ;
			}
			List<ListRisque> riskJson = new ArrayList<>() ; 
			for(int i = 0 ; i< listRisque.size(); i ++ ){
				
				if(listRisque.get(i).getRiskLabel() != null ){
					riskJson.add(listRisque.get(i)) ; 
				}
			}
		
		return riskJson ; 
	}
	
	@RequestMapping(value="/seekRisqueByProc/{id}/{type}/{puis}/" , method = RequestMethod.GET)
	public @ResponseBody List<ListRisque> getRisksByProcAndPuiss(@PathVariable("id") int id,@PathVariable("type") String type ,@PathVariable("puis") int puis ,HttpSession session ) {
	List<Risque>rList = riskServiceImpl.getRiskByProc(id) ; 
	List<MesureEx> mesList = new ArrayList<>() ;
	List<ImpactC> impList = new ArrayList<>() ; 
	List<Vulnerabilite> vulList = new ArrayList<>() ; 
	List<ListRisque> listRisque = new ArrayList<>() ; 
			for(int i =0 ; i<rList.size() ; i++) {
				ListRisque lrisque = new ListRisque() ; 
				mesList = mesServiceImpl.getmesureByRiskAndType(rList.get(i).getRisqueId(), type) ;
				for(int j = 0 ; j<mesList.size() ; j++){
					lrisque.setRiskLabel(rList.get(i).getRisqueLabel());
					if(j== 0){
						lrisque.setMesures(mesList.get(j).getMesureLabel());
					}else{
					lrisque.setMesures(lrisque.getMesures()+"\r\n"+mesList.get(j).getMesureLabel());
					}
					lrisque.setTotalmes(lrisque.getTotalmes()+mesList.get(j).getValue() );
				}
				 impList = impactCServiceImpl.getImpactCByRiskAndType(rList.get(i).getRisqueId(), type) ; 
				 for(int j = 0 ; j<impList.size() ; j++){
					 if(j== 0){
							lrisque.setImpacts(impList.get(j).getImpactLabel());
						}else{
						lrisque.setImpacts(lrisque.getImpacts()+"\r\n"+impList.get(j).getImpactLabel());
						}
						lrisque.setTotalimps(lrisque.getTotalimps()+impList.get(j).getValue() );
					}
				 vulList = vulServiceImpl.getVulnerabiliteByRiskAndType(rList.get(i).getRisqueId(), type) ; 
				 for(int j = 0 ; j<vulList.size() ; j++){
					 if(j== 0){
						lrisque.setVuls(vulList.get(j).getVulnLabel());
					 }else{
						 
						 lrisque.setVuls(lrisque.getVuls()+"\r\n"+vulList.get(j).getVulnLabel());
					 }
						lrisque.setTotalvuls(lrisque.getTotalvuls()+vulList.get(j).getValue() );
					 
					}
				lrisque.setTotal((lrisque.getTotalvuls()*lrisque.getTotalimps()*rList.get(i).getValue())-lrisque.getTotalmes());
				listRisque.add(lrisque) ;
			}
			List<ListRisque> riskJson = new ArrayList<>() ; 
			for (int i = 0 ; i< listRisque.size() ; i++){
				if(puis ==1 ){
					if(listRisque.get(i).getTotal()< 7 && listRisque.get(i).getTotal() >0 ){
						riskJson.add(listRisque.get(i)) ;
					}
				}else if (puis == 2 ){
					if(listRisque.get(i).getTotal() >= 7 && listRisque.get(i).getTotal() <= 14 ){
						riskJson.add(listRisque.get(i)) ;
					}
				}else if (puis == 3){
					if(listRisque.get(i).getTotal() > 14 && listRisque.get(i).getTotal() <= 19 ){
						riskJson.add(listRisque.get(i)) ;
					}
				}else if(puis ==4 ){
					if(listRisque.get(i).getTotal()> 19 ){
						riskJson.add(listRisque.get(i)) ;
					}
				}
			}
		
		return riskJson ; 
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
