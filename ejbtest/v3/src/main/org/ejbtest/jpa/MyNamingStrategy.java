//$Id: MyNamingStrategy.java,v 1.1 2015/06/30 06:43:12 ygong Exp $
package org.ejbtest.jpa;

import org.hibernate.cfg.EJB3NamingStrategy;

/**
 * @author Emmanuel Bernard
 */
public class MyNamingStrategy extends EJB3NamingStrategy {
	@Override
	public String tableName(String tableName) {
		return "tbl_" + super.tableName( tableName );
	}
}
