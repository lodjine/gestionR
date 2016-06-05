package com.talan.entities;

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
public class Integrite {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int integId;
	private int Iintg ; 
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST , CascadeType.MERGE ,CascadeType.ALL})
	@JoinColumn(name="Mesures")
	private List<MesureEx> mesures;
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST , CascadeType.MERGE ,CascadeType.ALL})
	@JoinColumn(name="Vuls")
	private List<Vulnerabilite> vulnerabs;
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST , CascadeType.MERGE ,CascadeType.ALL})
	@JoinColumn(name="Imps")
	private List<ImpactC> impacts;
	@OneToOne(cascade={CascadeType.PERSIST , CascadeType.MERGE})
	@JoinColumn(name="risk")
	private Risque risque ; 
	private String intgLabel ; 
	
	
	public String getIntgLabel() {
		return intgLabel;
	}

	public void setIntgLabel(String intgLabel) {
		this.intgLabel = intgLabel;
	}

	public Risque getRisque() {
		return risque;
	}

	public void setRisque(Risque risque) {
		this.risque = risque;
	}

	public int getIntegId() {
		return integId;
	}

	public void setIntegId(int integId) {
		this.integId = integId;
	}

	public int getIintg() {
		return Iintg;
	}

	public void setIintg(int iintg) {
		Iintg = iintg;
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
		return resultat;
	}

	public void setResultat(int resultat) {
		resultat = resultat;
	}

	private int resultat;
}
