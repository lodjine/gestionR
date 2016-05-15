package com.talon.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.DiscriminatorType;
@Entity
@DiscriminatorValue("admin")
public class Administrateur extends Utilisateur {

}
