//$Id: Strawberry.java,v 1.1 2015/06/30 06:43:21 ygong Exp $
package org.ejbtest.jpa.inheritance;

import javax.persistence.Entity;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Strawberry extends Fruit {
	private Long size;

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
}
