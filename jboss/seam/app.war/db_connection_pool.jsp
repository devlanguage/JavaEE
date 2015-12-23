
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>

<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="javax.transaction.UserTransaction"%>


<%@page import="javax.sql.XADataSource"%>
<%@page import="javax.sql.XAConnection"%><pre>Source Code:
    Context ctx = new InitialContext();
    out.println(ctx.lookup("java:/OracleDS"));
</pre>
<%
    Context ctx = new InitialContext();

    DataSource oracleDs = (javax.sql.DataSource) ctx.lookup("java:/OracleDS1");
    Connection conn1 = null;
    try {
        conn1 = oracleDs.getConnection();
        Statement stmt1 = conn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs1 = stmt1.executeQuery("Select * From User_Tables");
        while (rs1.next() && rs1.getRow() < 6) {
            out.println(rs1.getString(1) + "<BR>");
        }
    } catch (Exception e) {

    } finally {
        conn1.close();
    }

    out.println("<pre>java:/OracleXADS test</pre>");
    DataSource oracleXaDs = (javax.sql.DataSource) ctx.lookup("java:/XAOracleDS1");
    Connection conn2 = null;
    try {
        conn2 = oracleXaDs.getConnection();
        Statement stmt2 = conn2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs2 = stmt2.executeQuery("Select * From User_Sequences");
        while (rs2.next() && rs2.getRow() < 6) {
            out.println(rs2.getString(1) + "<BR>");
        }
    } catch (Exception e) {

    } finally {
        conn2.close();
    }
%>

<pre>
JTA Transaction:  UserTransaction Test
</pre>
<%
    javax.transaction.UserTransaction uta1 = (UserTransaction) ctx.lookup("UserTransaction");
    javax.transaction.UserTransaction uta2 = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
    out.println(uta1 == uta2);
    Connection xaconn1 = null, xaconn2 = null;
    try {
        uta1.begin();//Start the JTA Transaction
        xaconn1 = ((DataSource)ctx.lookup("java:/XAOracleDS1")).getConnection();
        xaconn2 = ((DataSource)ctx.lookup("java:/XAOracleDS2")).getConnection();
        
       Statement stmt1= xaconn1.createStatement();
       Statement stmt2= xaconn2.createStatement();
       
       stmt1.execute("insert into aa(a_id, a_name) values(1, 10)");
       stmt2.execute("insert into aa(a_id, a_name) values(2, 20)");
       
       uta1.commit();//Commit the JTA Transaction
    } catch (Exception e) {
        e.printStackTrace();
        uta1.rollback();        
    } finally{
        xaconn1.close();
        xaconn2.close();
    }
%>