//$Id: Dog.java,v 1.1 2015/06/30 06:43:05 ygong Exp $
package org.ejbtest.jpa.emops;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class Dog extends Pet {
	private int numBones;

	public int getNumBones() {
		return numBones;
	}

	public void setNumBones(int numBones) {
		this.numBones = numBones;
	}
}
