//$Id: Scooter.java,v 1.1 2015/06/30 06:43:21 ygong Exp $
package org.ejbtest.jpa.pack.externaljar;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Scooter {
	private String model;
	private Long speed;

	@Id
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getSpeed() {
		return speed;
	}

	public void setSpeed(Long speed) {
		this.speed = speed;
	}
}
