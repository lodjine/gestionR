package com.talon.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ImpactC implements Serializable{
@Id
private int impactId;

private String impactLabel;

private int value;

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