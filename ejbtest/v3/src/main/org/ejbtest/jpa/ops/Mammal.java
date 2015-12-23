//$Id: Mammal.java,v 1.1 2015/06/30 06:43:06 ygong Exp $
package org.ejbtest.jpa.ops;

import javax.persistence.Entity;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Mammal extends Animal {
	private int mamalNbr;

	public int getMamalNbr() {
		return mamalNbr;
	}

	public void setMamalNbr(int mamalNbr) {
		this.mamalNbr = mamalNbr;
	}
}
