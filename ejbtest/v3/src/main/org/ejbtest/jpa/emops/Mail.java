//$Id: Mail.java,v 1.1 2015/06/30 06:43:05 ygong Exp $
package org.ejbtest.jpa.emops;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Mail {
	@Id private Long id;
	private String from;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
