package com.talan.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ImpactC implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int impactId;

private String impactLabel;

private int value;

private String critere ; 
@ManyToOne
@JoinColumn(name="risk")
private Risque risque ; 

public String getCritere() {
	return critere;
}

public void setCritere(String critere) {
	this.critere = critere;
}

public Risque getRisque() {
	return risque;
}

public void setRisque(Risque risque) {
	this.risque = risque;
}

public int getImpactId() {
	return impactId;
}

public void setImpactId(int impactId) {
	this.impactId = impactId;
}

public String getImpactLabel() {
	return impactLabel;
}

public void setImpactLabel(String impactLabel) {
	this.impactLabel = impactLabel;
}

public int getValue() {
	return value;
}

public void setValue(int value) {
	this.value = value;
}



}
