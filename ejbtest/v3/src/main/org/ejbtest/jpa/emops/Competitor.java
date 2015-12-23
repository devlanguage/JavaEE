//$Id: Competitor.java,v 1.1 2015/06/30 06:43:05 ygong Exp $
package org.ejbtest.jpa.emops;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Competitor {
	@Id @GeneratedValue public Integer id;
	private String name;


	public Competitor() {
	}

	public Competitor(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
