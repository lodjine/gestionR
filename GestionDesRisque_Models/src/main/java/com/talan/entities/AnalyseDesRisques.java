package com.talan.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnalyseDesRisques {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int analyseId;
}
