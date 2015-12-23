//$Id: Mouse.java,v 1.1 2015/06/30 06:43:05 ygong Exp $
package org.ejbtest.jpa.pack.defaultpar;

import javax.persistence.ExcludeDefaultListeners;

/**
 * @author Emmanuel Bernard
 */
@ExcludeDefaultListeners
public class Mouse {
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
