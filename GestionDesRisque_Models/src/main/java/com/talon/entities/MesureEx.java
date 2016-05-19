package com.talon.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MesureEx implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int mesureId;

private String mesureLabel;


private int value;


public int getMesureId() {
	return mesureId;
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
