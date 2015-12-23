//$Id: ApplicationServer.java,v 1.1 2015/06/30 06:43:05 ygong Exp $
package org.ejbtest.jpa.pack.defaultpar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class ApplicationServer {
	private Integer id;
	private String name;
	private org.ejbtest.jpa.pack.defaultpar.Version version;

	@Id
	@GeneratedValue
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

	public Version getVersion() {
		return version;
	}

	public void setVersion(org.ejbtest.jpa.pack.defaultpar.Version version) {
		this.version = version;
	}
}
