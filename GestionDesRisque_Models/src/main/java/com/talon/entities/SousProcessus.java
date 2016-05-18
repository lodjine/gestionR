package com.talon.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SousProcessus {
	@Id
	private int sspId;
	private String subProcess ;
	public int getSspId() {
		return sspId;
	}
	public void setSspId(int sspId) {
		this.sspId = sspId;
	}
	public String getSubProcess() {
		return subProcess;
	}
	public void setSubProcess(String subProcess) {
		this.subProcess = subProcess;
	} 
	
	
	
	
}
