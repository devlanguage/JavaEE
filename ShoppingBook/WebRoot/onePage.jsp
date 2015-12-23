<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>涓汉淇℃伅绠＄悊涓績</title>
    
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
          <div id="archive">
          	 <table>
        <tr>
         <td>绉垎锛�</td>
         <td>${user.score}</td>
       </tr>
       <tr> 
           <td>鐢ㄦ埛鍚嶏細</td>
            <td>${user.name}</td>
       </tr>
       <tr> 
           <td>E-mail锛�</td>
           <td>${user.email}</td>
       </tr>
       <tr> 
           <td>鐪� 鍚嶏細</td>
           <td>${user.trueName}</td>
       </tr>
         <tr> 
           <td>鎬� 鍒細</td>
            <td>${user.sex}</td>
       </tr>
         <tr> 
           <td>鐢� 鏃ワ細</td>
            <td>${user.birthday}</td>
       </tr>
         <tr> 
           <td>鍦� 鍧�锛�</td>
            <td>${user.address}</td>
       </tr>
       <tr> 
           <td>閭� 缂栵細</td>
           <td>${user.postcode}</td>
       </tr>
       <tr> 
           <td>搴� 鏈猴細</td>
           <td>${user.phone}</td>
       </tr>
         <tr> 
           <td>鎵� 鏈猴細</td>
            <td>${user.mphone}</td>
       </tr>
       <tr>
         <td>瀹夊叏闂:</td>
         <td>${user.question}</td>
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
