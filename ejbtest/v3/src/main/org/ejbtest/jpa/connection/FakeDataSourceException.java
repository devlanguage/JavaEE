//$Id: FakeDataSourceException.java,v 1.1 2015/06/30 06:43:18 ygong Exp $
package org.ejbtest.jpa.connection;

/**
 * @author Emmanuel Bernard
 */
public class FakeDataSourceException extends RuntimeException {
	public FakeDataSourceException(String message) {
		super( message );
	}
}
