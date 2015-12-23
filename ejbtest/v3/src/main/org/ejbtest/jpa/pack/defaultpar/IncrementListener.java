//$Id: IncrementListener.java,v 1.1 2015/06/30 06:43:05 ygong Exp $
package org.ejbtest.jpa.pack.defaultpar;

import javax.persistence.PrePersist;

/**
 * @author Emmanuel Bernard
 */
public class IncrementListener {
	private static int increment;

	public static int getIncrement() {
		return increment;
	}

	public static void reset() {
		increment = 0;
	}

	@PrePersist
	public void increment(Object entity) {
		increment++;
	}
}
