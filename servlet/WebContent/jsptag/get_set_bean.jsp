<pre>

<jsp:useBean id="jsptest_UserBean" class="jsptest.UserBean" type="java.lang.Object">
	<jsp:setProperty name="jsptest_UserBean" property="userId" value="000111" />
	<jsp:setProperty name="jsptest_UserBean" property="userName" param="requestParam0" />
</jsp:useBean>

<jsp:getProperty name="jsptest_UserBean" property="userId" />
<jsp:getProperty name="jsptest_UserBean" property="userName" />
</pre>

<%@attribute name="password"%> 