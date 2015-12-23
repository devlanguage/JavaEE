//$Id: CommunicationSystem.java,v 1.1 2015/06/30 06:43:12 ygong Exp $
package org.ejbtest.jpa.callbacks;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * @author Emmanuel Bernard
 */
@MappedSuperclass
@EntityListeners(IncreaseListener.class)
public class CommunicationSystem {
	public int communication = 0;
	public boolean isFirst = true;
	public boolean isLast;

	public void init() {
		communication = 0;
		isFirst = true;
		isLast = false;
	}
}
