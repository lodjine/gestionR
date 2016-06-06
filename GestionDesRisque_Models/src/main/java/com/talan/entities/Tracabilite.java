package com.talan.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Tracabilite implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	
private String user;

private String operation;

private String entity;

private String date;

public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}

public String getOperation() {
	return operation;
}

public void setOperation(String operation) {
	this.operation = operation;
}

public String getEntity() {
	return entity;
}

public void setEntity(String entity) {
	this.entity = entity;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}




}
