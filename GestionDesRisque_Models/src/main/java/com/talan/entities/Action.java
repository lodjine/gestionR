package com.talan.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Action {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int actionId;

private String label ; 

private Date creationDate ; 

private Date modificationDate ; 

private  Date beginDate;

private  Date endDate; 

private int status ; 
 


@ManyToOne (cascade = {CascadeType.PERSIST , CascadeType.MERGE})
private Risque risk ; 

  






public int getActionId() {
	return actionId;
}



public void setActionId(int actionId) {
	this.actionId = actionId;
}



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



public Risque getRisk() {
	return risk;
}



public void setRisk(Risque risk) {
	this.risk = risk;
}













 




}


