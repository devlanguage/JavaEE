//$Id: Dress.java,v 1.1 2015/06/30 06:43:05 ygong Exp $
package org.ejbtest.jpa.emops;

import javax.persistence.Id;
import javax.persistence.Entity;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Dress {
	@Id public String name;

}
