//$Id: FirstOneListener.java,v 1.1 2015/06/30 06:43:13 ygong Exp $
package org.ejbtest.jpa.callbacks;

import javax.persistence.PreUpdate;

/**
 * @author Emmanuel Bernard
 */
public class FirstOneListener {
	@PreUpdate
	public void firstOne(CommunicationSystem object) {
		if ( !object.isFirst ) throw new IllegalStateException();
		object.isFirst = true;
		object.isLast = false;
		object.communication++;
	}
}
