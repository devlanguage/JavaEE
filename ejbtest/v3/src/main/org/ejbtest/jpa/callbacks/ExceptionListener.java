//$Id: ExceptionListener.java,v 1.1 2015/06/30 06:43:13 ygong Exp $
package org.ejbtest.jpa.callbacks;

import javax.persistence.PrePersist;

/**
 * @author Emmanuel Bernard
 */
public class ExceptionListener {
	@PrePersist
	public void raiseException(Object e) {
		throw new ArithmeticException( "1/0 impossible" );
	}
}
