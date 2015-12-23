//$Id: FakeDataSource.java,v 1.1 2015/06/30 06:43:18 ygong Exp $
package org.ejbtest.jpa.connection;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * @author Emmanuel Bernard
 */
public class FakeDataSource implements DataSource {
	public Connection getConnection() throws SQLException {
		throw new FakeDataSourceException( "connection" );
	}

	public Connection getConnection(String username, String password) throws SQLException {
		throw new FakeDataSourceException( "connection with password" );
	}

	public PrintWriter getLogWriter() throws SQLException {
		throw new FakeDataSourceException( "getLogWriter" );
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		throw new FakeDataSourceException( "setLogWriter" );
	}

	public void setLoginTimeout(int seconds) throws SQLException {
		throw new FakeDataSourceException( "setLoginTimeout" );
	}

	public int getLoginTimeout() throws SQLException {
		throw new FakeDataSourceException( "getLoginTimeout" );
	}

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
}
