<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testPage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <pg:pager items="1000">
    	<pg:first>
    		<a href="${pageUrl}">棣栭〉</a>
    	</pg:first>
    	<pg:prev>
    		<a href="${pageUrl}">鍓嶉〉</a>
    	</pg:prev>
    	<pg:pages>
    		<a href="${pageUrl}">${pageNumber}</a>
    	</pg:pages>
    	<pg:next>
    		<a href="${pageUrl}">鍚庨〉</a>
    	</pg:next>
    	<pg:last>
    		<a href="${pageUrl}">灏鹃〉</a>
    	</pg:last>
    </pg:pager>
  </body>
</html>
