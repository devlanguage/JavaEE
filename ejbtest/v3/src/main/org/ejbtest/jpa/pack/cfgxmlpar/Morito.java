//$Id: Morito.java,v 1.1 2015/06/30 06:43:20 ygong Exp $
package org.ejbtest.jpa.pack.cfgxmlpar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Morito {
	private Integer id;
	private String power;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}
}
