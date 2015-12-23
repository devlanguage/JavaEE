//$Id: VideoSystem.java,v 1.1 2015/06/30 06:43:13 ygong Exp $
package org.ejbtest.jpa.callbacks;

import javax.persistence.EntityListeners;
import javax.persistence.ExcludeSuperclassListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.persistence.PrePersist;

/**
 * @author Emmanuel Bernard
 */
@ExcludeSuperclassListeners
@EntityListeners({FirstOneListener.class, IncreaseListener.class})
@MappedSuperclass
public class VideoSystem extends CommunicationSystem {
	public transient int counter = 0;
	@PreUpdate
	public void increase() {
		isFirst = false;
		isLast = false;
		communication++;
	}

	@PrePersist
	public void prepareEntity() {
		counter++;
	}
}
