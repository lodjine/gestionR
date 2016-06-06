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
public class MesureEx implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int mesureId;

private String mesureLabel;


private int value;
private String critere ; 
@ManyToOne
@JoinColumn(name="risk")
private Risque risque ; 
public int getMesureId() {
	return mesureId;
}


public String getCritere() {
	return critere;
}


public Risque getRisque() {
	return risque;
}


public void setRisque(Risque risque) {
	this.risque = risque;
}


public void setCritere(String type) {
	this.critere = type;
}


public void setMesureId(int mesureId) {
	this.mesureId = mesureId;
}


public String getMesureLabel() {
	return mesureLabel;
}


public void setMesureLabel(String mesureLabel) {
	this.mesureLabel = mesureLabel;
}


public int getValue() {
	return value;
}


public void setValue(int value) {
	this.value = value;
}





}
