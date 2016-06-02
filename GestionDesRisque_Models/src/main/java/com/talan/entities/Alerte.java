package com.talan.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity


@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name="Alerte_Type"
,discriminatorType=DiscriminatorType.STRING)
public class Alerte {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int alerteId;
	
	private String date;
	private String risque;
	@Column(name="Alerte_Type",updatable=false,insertable=false)
	private String typeAlerte;
	private String alerte;


	public int getAlerteId() {
		return alerteId;
	}


	public void setAlerteId(int alerteId) {
		this.alerteId = alerteId;
	}


	public String getAlerte() {
		return alerte;
	}


	public void setAlerte(String alerte) {
		this.alerte = alerte;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTypeAlerte() {
		return typeAlerte;
	}


	public void setTypeAlerte(String typeAlerte) {
		this.typeAlerte = typeAlerte;
	}


	public String getRisque() {
		return risque;
	}


	public void setRisque(String risque) {
		this.risque = risque;
	}
	
	
	
}
