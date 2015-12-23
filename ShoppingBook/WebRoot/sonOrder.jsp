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
    
    <title>璁㈠崟椤�</title>
    
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
     <tr>
       <td>璁㈠崟椤筰d </td>
       <td>璁㈠崟id</td>
       <td>涔﹀彿</td>
       <td>涔﹀悕</td>
       <td>浠锋牸</td>
       <td>涔︾殑鏁伴噺</td>
     </tr>
     <c:forEach var="sonOr" items="${list}">
     <tr>
       <td>${sonOr.orderItemId}</td>
       <td>${sonOr.orderId}</td>
       <td>${sonOr.bookId}</td>
       <td>${sonOr.bookName}</td>
       <td>${sonOr.price}</td>
       <td>${sonOr.bookNum}</td>
     </tr>
     </c:forEach>
	 <tr>
	 	<td></td>
	 	<td></td>
	 	<td></td>
	 	<td>鎬讳环鏍硷細</td>
	 	<td></td>
	 	<td>${sonOr.price}*${sonOr.bookNum}</td>
	 </tr>   
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
