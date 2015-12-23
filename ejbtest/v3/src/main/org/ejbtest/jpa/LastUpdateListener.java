//$Id: LastUpdateListener.java,v 1.1 2015/06/30 06:43:12 ygong Exp $
package org.ejbtest.jpa;

import java.util.Date;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author Emmanuel Bernard
 */
public class LastUpdateListener {
	@PreUpdate
	@PrePersist
	public void setLastUpdate(Cat o) {
		o.setLastUpdate( new Date() );
		o.setManualVersion( o.getManualVersion() + 1 );
	}
}
