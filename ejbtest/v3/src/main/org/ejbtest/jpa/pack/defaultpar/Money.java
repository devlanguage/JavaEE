//$Id: Money.java,v 1.1 2015/06/30 06:43:05 ygong Exp $
package org.ejbtest.jpa.pack.defaultpar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Money {
	private Integer id;

	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
