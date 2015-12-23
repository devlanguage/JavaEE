//$Id: Workload.java,v 1.1 2015/06/30 06:43:06 ygong Exp $
package org.ejbtest.jpa.ops;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Workload {
	@Id
	@GeneratedValue
	public Integer id;
	public String name;
	public Integer load;
}
