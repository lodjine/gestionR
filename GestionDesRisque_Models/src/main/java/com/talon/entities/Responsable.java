package com.talon.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("resp")
public class Responsable extends Utilisateur{

}
