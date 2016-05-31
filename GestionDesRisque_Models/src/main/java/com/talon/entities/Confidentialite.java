package com.talon.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Confidentialite {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ConfId;
	@OneToOne(cascade={CascadeType.PERSIST , CascadeType.MERGE})
	@JoinColumn(name="risk")
	private Risque risque ; 
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST , CascadeType.MERGE ,CascadeType.ALL})
	@JoinColumn(name="Mesures")
	private List<MesureEx> mesures;
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST , CascadeType.MERGE,CascadeType.ALL})
	@JoinColumn(name="Vuls")
	private List<Vulnerabilite> vulnerabs;
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST , CascadeType.MERGE,CascadeType.ALL})
	@JoinColumn(name="Imps")
	private List<ImpactC> impacts;
	private int iC ; 
	private int Resultat;

	public int getConfId() {
		return ConfId;
	}

	public void setConfId(int confId) {
		ConfId = confId;
	}

	public Risque getRisque() {
		return risque;
	}

	public void setRisque(Risque risque) {
		this.risque = risque;
	}

	public List<MesureEx> getMesures() {
		return mesures;
	}

	public void setMesures(List<MesureEx> mesures) {
		this.mesures = mesures;
	}

	public List<Vulnerabilite> getVulnerabs() {
		return vulnerabs;
	}

	public void setVulnerabs(List<Vulnerabilite> vulnerabs) {
		this.vulnerabs = vulnerabs;
	}

	public List<ImpactC> getImpacts() {
		return impacts;
	}

	public void setImpacts(List<ImpactC> impacts) {
		this.impacts = impacts;
	}

	public int getResultat() {
		return Resultat;
	}

	public void setResultat(int resultat) {
		Resultat = resultat;
	}

	public int getiC() {
		return iC;
	}

	public void setiC(int iC) {
		this.iC = iC;
	}
	
	
	
}
