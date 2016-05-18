package com.talon.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Action {
@Id
private int actionId;

private String label ; 

private Date creationDate ; 

private Date modificationDate ; 

private  Date beginDate;

private  Date endDate; 

private int status ; 

@ManyToOne (cascade = CascadeType.ALL)
private Utilisateur user ; 


@OneToOne 
private Risque Risk ; 








public String getLabel() {
	return label;
}



public void setLabel(String label) {
	this.label = label;
}



public Date getCreationDate() {
	return creationDate;
}



public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
}



public Date getModificationDate() {
	return modificationDate;
}



public void setModificationDate(Date modificationDate) {
	this.modificationDate = modificationDate;
}



public Date getBeginDate() {
	return beginDate;
}



public void setBeginDate(Date beginDate) {
	this.beginDate = beginDate;
}



public Date getEndDate() {
	return endDate;
}



public void setEndDate(Date endDate) {
	this.endDate = endDate;
}



public int getStatus() {
	return status;
}



public void setStatus(int status) {
	this.status = status;
}



public Utilisateur getUser() {
	return user;
}



public void setUser(Utilisateur user) {
	this.user = user;
}






public Action() {
	super();
}



public Risque getRisk() {
	return Risk;
}



public void setRisk(Risque risk) {
	Risk = risk;
} 




}


