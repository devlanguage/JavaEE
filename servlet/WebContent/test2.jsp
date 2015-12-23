
<%@page import="java.util.Enumeration"%>
test2.jsp

<hr style="height: 12; color: green border-color: green"/>


<hr/>
<pre>
pageContext=
<%=pageContext%>

<%
            Enumeration<String> reqAttrNames = request.getAttributeNames();
            String attrName = null;
            while (reqAttrNames.hasMoreElements()) {
                attrName = reqAttrNames.nextElement();
            }
%>
</pre>
<hr/>
