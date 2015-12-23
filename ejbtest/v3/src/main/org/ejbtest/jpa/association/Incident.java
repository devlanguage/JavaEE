//$Id: Incident.java,v 1.1 2015/06/30 06:43:17 ygong Exp $
package org.ejbtest.jpa.association;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Incident {
	@Id
	String id;

	@OneToOne(cascade = CascadeType.ALL)
	IncidentStatus incidentStatus;

	public Incident() {
	}

	public Incident(String id) {
		this.id = id;
	}

	public IncidentStatus getIncidentStatus() {
		return incidentStatus;
	}

	public void setIncidentStatus(IncidentStatus incidentStatus) {
		this.incidentStatus = incidentStatus;
	}

	@Override
	public String toString() {
		return "Incident: " + id + " " + incidentStatus;
	}
}
