<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>鐢ㄦ埛鐧诲綍</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<div id="wrap">
		<%@include file="header.jsp" %>
       <div class="center_content">
       	<div class="left_content">
       		<div class="crumb_nav">
           	 <a href="index.jsp">棣栭〉</a> &gt;&gt; 鐧诲綍
            </div>
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>璐﹀彿鐧诲綍</div>
        
        	<div class="feat_prod_box_details">
            <p class="details">
            	鍙湁鐧诲綍涔嬪悗鎵嶈兘澶熻喘涔颁功绫嶄互鍙婂彂琛ㄧ暀瑷�锛�
            </p>
            <div align="center"><font color="red">${message}</font></div>
            	<font color="red" style="text-align: center">${NameNotFoundException} ${ErrPwdException}</font>
              	<div class="contact_form">
                <div class="form_subtitle">璐﹀彿鐧诲綍</div>
                 <form name="login" id="loginForm" action="login" method="post">          
                    <div class="form_row">
                    <label class="contact"><strong>璐﹀彿:</strong></label>
                    <input type="text"  name="name" class="contact_input" />
                    </div>  


                    <div class="form_row">
                    <label class="contact"><strong>瀵嗙爜:</strong></label>
                    <input type="password" name="password" class="contact_input" />
                    </div>                     

                    <div class="form_row">
                        <div class="terms">
                        <input type="checkbox" name="terms" />
                        璁颁綇瀵嗙爜
                        </div>
                    </div> 
                    <div class="form_row">
                    <input type="submit" class="register" value="鐧诲綍" />
                    </div>   
                    
                  </form>     
                </div>              
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
