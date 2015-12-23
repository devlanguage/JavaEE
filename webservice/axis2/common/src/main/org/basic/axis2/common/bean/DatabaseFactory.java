package org.basic.axis2.common.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleConnectionCacheImpl;

public class DatabaseFactory {

    private final static DatabaseFactory instance = new DatabaseFactory();
    private static OracleConnectionCacheImpl _dataSource = null;
    static {

        Database database = getDatabase(DatabaseType.ORACLE);

        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            _dataSource = new OracleConnectionCacheImpl();
            _dataSource.setURL(database.getUrl());
            _dataSource.setUser(database.getUser());
            _dataSource.setPassword(database.getPassword());
            _dataSource.setDescription("JDBC DataSource Connection");
            // _dataSource.setMaxStatements(Integer.valueOf(config
            // .getValue(ConfigurationConstant.max_statement)));
            // _dataSource.setMaxLimit(Integer.valueOf(config
            // .getValue(ConfigurationConstant.max_connection)));
            // _dataSource.setMinLimit(Integer.valueOf(config
            // .getValue(ConfigurationConstant.min_connection)));
            _dataSource.setCacheScheme(OracleConnectionCacheImpl.DYNAMIC_SCHEME);
        } catch (SQLException e) {
        }

    }

    public final static DatabaseFactory getInstance() {

        return instance;
    }

    public final static Database getDatabase(DatabaseType dbType) {

        Database database = null;
        switch (dbType) {
            case ORACLE:
                database = new OracleDatabase();
                break;

        }

        return database;
    }

    public final static Connection getConnection() throws SQLException {

        return _dataSource.getConnection();
    }

    public static void close(Connection conn) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt) {

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // public static void main(String[] args) {
    //
    // Connection conn =null;
    // try {
    // conn = getConnection();
    // System.err.println(conn);
    // } catch (SQLException e) {
    // e.printStackTrace();
    // } finally{
    // close(conn);
    // }
    // System.out.println();
    //        
    // }

}
