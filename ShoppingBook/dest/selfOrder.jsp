<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>涓汉璁㈠崟鏌ヨ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="style.css">

  </head>
  
  <body>
  	
	<div id="wrap">		
		<%@include file="header.jsp" %>    
       <div class="center_content">
       	<div class="left_content">
       		<div class="crumb_nav">
           		 <a href="index.jsp">棣栭〉</a> &gt;&gt; 涓汉淇℃伅绠＄悊涓績
            </div>
            <div id="managerTop">
			<table width="450">
				  <tr>
				    <td height="40" colspan="4"><div align="center" class="STYLE2">涓汉淇℃伅绠＄悊涓績</div></td>
				  </tr>
				  <tr>
				    <td width="140"><a href="updateUserAll">淇敼瀹屽杽涓汉璧勬枡</a></td>
				    <td width="70"><div align="center"><a href="updatePassword.jsp">淇敼瀵嗙爜</a></div></td>
				    <td width="100"><div align="center"><a href="selectOrder">鏌ョ湅璁㈠崟</a></div></td>
				    <td width="115" height="30"><div align="center"><a href="index.jsp">杩斿洖棣栭〉</a></div></td>
				  </tr>
			</table>
          </div>
          <div id="orderInfo">
     <table border="solid 1px;">
        <tr><td>璁㈠崟id</td>
	        <td>鐪熷疄濮撳悕</td>
	        <td>璇︾粏浣忓潃</td>
	        <td>閭紪</td> 
	        <td>鍙戣揣鐘舵��</td>
	        <td>鏌ョ湅瀛愯鍗�</td>
	    </tr>
	    <c:forEach var="order" items="${list}">
	    	<tr>
			    <td>${order.orderId}</td>
		        <td>${order.recvName}</td>
		        <td>${order.user.address}</td>
		        <td>${order.user.postcode}</td> 
		        <td>${order.flag}</td>
		        <td><a href="son?id=${order.orderId}">鏌ョ湅</a></td>
	    	</tr>
	    </c:forEach>
	    
     </table>
          </div>
        <div class="clear"></div>
        </div><!--end of left content-->
         <%@include file="right.jsp" %>
         <!--end of right content-->
       <div class="clear"></div>
       </div><!--end of center content-->     
      <%@include file="footer.jsp" %> 
</div>
  </body>
</html>
