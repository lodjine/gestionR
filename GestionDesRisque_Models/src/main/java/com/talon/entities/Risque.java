package com.talon.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Risque implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int risqueId;
	
	private String risqueLabel;
	@OneToOne(cascade={CascadeType.PERSIST , CascadeType.MERGE})
	@JoinColumn(name="proc")
	private Processus proc ;
	public int getRisqueId() {
		return risqueId;
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
	
}
