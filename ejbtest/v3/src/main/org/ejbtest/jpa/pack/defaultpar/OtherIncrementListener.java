//$Id: OtherIncrementListener.java,v 1.1 2015/06/30 06:43:05 ygong Exp $
package org.ejbtest.jpa.pack.defaultpar;

/**
 * @author Emmanuel Bernard
 */
public class OtherIncrementListener {
	private static int increment;

	public static int getIncrement() {
		return OtherIncrementListener.increment;
	}

	public static void reset() {
		increment = 0;
	}

	public void increment(Object entity) {
		OtherIncrementListener.increment++;
	}
}
