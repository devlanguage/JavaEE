1. add the jdbc driver in the path: $JBOSS_HOME\server\default\lib
2. if non-transactional datasource, add the oracle-ds.xml. [mysql-ds.xml, mssql-ds.xml] in  $JBOSS_HOME\server\default\deploy
    <?xml version="1.0" encoding="UTF-8"?>
    <datasources>
        <local-tx-datasource>
            <jndi-name>DefaultDS</jndi-name>
            <connection-url>jdbc:oracle:thin:@sunshapp10:1521:EMS7100S</connection-url>
            <driver-class>oracle.jdbc.OracleDriver</driver-class>
            <user-name>ygong1</user-name>
            <password>tellabs</password>
            <exception-sorter-class-name>org.jboss.resource.adapter.jdbc.vendor.OracleExceptionSorter</exception-sorter-class-name>
            <valid-connection-checker-class-name>org.jboss.resource.adapter.jdbc.vendor.OracleValidConnectionChecker</valid-connection-checker-class-name>
            <metadata>
                <type-mapping>Oracle9i</type-mapping>
            </metadata>
        </local-tx-datasource>
    </datasources>
3. if transactional datasource, add the oracle-ds.xml. [mysql-ds.xml, mssql-ds.xml] in  $JBOSS_HOME\server\default\deploy 