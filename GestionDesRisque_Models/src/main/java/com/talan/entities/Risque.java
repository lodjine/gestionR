package com.talan.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Risque implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int risqueId;
	private int value ;
	private int totalMesure ;
	private int totalVuls ;
	private int totalImp ;
	private int total ; 
	private String critere ;
	private String risqueLabel;
	@OneToOne
	@JoinColumn(name="proc")
	private Processus proc ;
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST , CascadeType.MERGE ,CascadeType.ALL})
	@JoinColumn(name="Mesures")
	private List<MesureEx> mesures;
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST , CascadeType.MERGE,CascadeType.ALL})
	@JoinColumn(name="Vuls")
	private List<Vulnerabilite> vulnerabs;
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST , CascadeType.MERGE,CascadeType.ALL})
	@JoinColumn(name="Imps")
	private List<ImpactC> impacts;
	public int getRisqueId() {
		return risqueId;
	}
	
	public String getCritere() {
		return critere;
	}

	public void setCritere(String critere) {
		this.critere = critere;
	}

	public int getTotalMesure() {
		return totalMesure;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setTotalMesure(int totalMesure) {
		this.totalMesure = totalMesure;
	}

	public int getTotalVuls() {
		return totalVuls;
	}

	public void setTotalVuls(int totalVuls) {
		this.totalVuls = totalVuls;
	}

	public int getTotalImp() {
		return totalImp;
	}

	public void setTotalImp(int totalImp) {
		this.totalImp = totalImp;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setRisqueId(int risqueId) {
		this.risqueId = risqueId;
	}
	public String getRisqueLabel() {
		return risqueLabel;
	}
	public void setRisqueLabel(String risqueLabel) {
		this.risqueLabel = risqueLabel;
	}
	public Processus getProc() {
		return proc;
	}
	public void setProc(Processus proc) {
		this.proc = proc;
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
	
}
