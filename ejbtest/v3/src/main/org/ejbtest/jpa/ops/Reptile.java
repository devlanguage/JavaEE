//$Id: Reptile.java,v 1.1 2015/06/30 06:43:06 ygong Exp $
package org.ejbtest.jpa.ops;

import javax.persistence.Entity;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Reptile extends Animal {
	private float temperature;

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
}
