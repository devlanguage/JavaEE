//$Id: Carpet.java,v 1.1 2015/06/30 06:43:21 ygong Exp $
package org.ejbtest.jpa.pack.explodedpar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Carpet {
	private Integer id;
	private String country;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
