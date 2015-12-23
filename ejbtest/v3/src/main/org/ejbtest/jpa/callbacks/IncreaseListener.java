//$Id: IncreaseListener.java,v 1.1 2015/06/30 06:43:13 ygong Exp $
package org.ejbtest.jpa.callbacks;

import javax.persistence.PreUpdate;

/**
 * @author Emmanuel Bernard
 */
public class IncreaseListener {
	@PreUpdate
	public void increate(CommunicationSystem object) {
		object.communication++;
		object.isFirst = false;
		object.isLast = false;
	}
}
