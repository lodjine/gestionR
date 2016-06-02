package com.talan.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Alerte_Action")
public class AlerteAction extends Alerte {

}
