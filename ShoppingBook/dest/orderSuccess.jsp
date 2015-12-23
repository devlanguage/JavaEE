<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@include file="common.jsp" %>
<%@include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>浜ゆ槗鎴愬姛</title>
<link rel="stylesheet" type="text/css" href="style.css" />

</head>
<body>
<div id="wrap">
		
		<%@include file="header.jsp" %>
       <div class="center_content">
       	<div class="left_content">
       	<pre>
        	浜ゆ槗鎴愬姛
       	     璁㈠崟娴佹按鍙蜂负锛�<font color="red">1986${order.orderId}0712</font>	
       	     鏀惰揣浜猴細<font color="red">${order.recvName}</font>
              鏀惰揣鍦板潃锛�<font color="red">${user.address }</font>
             閭斂缂栫爜锛� <font color="red">${user.postcode }</font>
             email:<font color="red">${user.email}</font>
       	     鑱旂郴鐢佃瘽锛�<font color="red">${user.phone }</font>
       	     鎵嬫満锛�<font color="red">${user.mphone }</font>
       	 <%
       	 	out.print("5绉掑悗椤甸潰灏嗚嚜鍔ㄨ烦杞埌棣栭〉....");
       	 	response.setHeader("refresh","5;url='index.jsp'");
       	  %>
       	 </pre>
 		</div><!--end of left content-->
        <%@include file="right.jsp" %> 
       <!--end of right content-->
   
       <div class="clear"></div>
       </div><!--end of center content-->
       
       <%@include file="footer.jsp"%>
</div>

</body>
</html>
