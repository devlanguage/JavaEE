<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'updataPwd.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style.css">
  <script type="text/javascript">
     //妫�鏌ュ瘑鐮�,鍙兘鐢辫嫳鏂囧瓧姣嶅拰鏁板瓧缁勬垚
	function checkPassword(){
		var password1 = document.getElementById("password1");
		var pwdRemind = document.getElementById("pwdRemind");
		var patrn=/^[a-z,A-Z,0-9]{6,15}$/;
		if (!patrn.exec(password1.value)){
			pwdRemind.style.color="red";
			pwdRemind.innerHTML="瀵嗙爜鏍煎紡杈撳叆鏈夎!";
			return false;
		}else{
			pwdRemind.style.color="green";
			pwdRemind.innerHTML="鈭� 杈撳叆姝ｇ‘";
			return true;
		}
	}
    function checkPwd(){
		var password1 = document.getElementById("password1");
		var password2 = document.getElementById("password2");
		var checkPwd = document.getElementById("checkPwd");
		if(password1.value!=password2.value){
			checkPwd.style.color="red";
			checkPwd.innerHTML="涓ゆ瀵嗙爜杈撳叆涓嶄竴鑷�!";
			return false;
		}else{
			checkPwd.style.color="green";
			checkPwd.innerHTML="涓ゆ瀵嗙爜杈撳叆涓�鑷�!";
			return true;
		}
	}
  </script>
  </head>
  
  <body>
  <div id="wrap">
		<%@include file="header.jsp" %>
       <div class="center_content">
       	<div class="left_content">
       		<form action="updataPwd">
      <table>
      <tr>
                    		<td class="label">瀵嗙爜:</td>
                    		<td><input type="password" id="password1" name="password" class="contact_input" onfocus="clearPwd()" onblur="checkPassword()" /></td>
                    		<td class="remind" id="pwdRemind"><span style="color: red">*</span><span style="color:black">鐢辫嫳鏂囧瓧姣嶅拰鏁板瓧(6-16)瀛楃缁勬垚</span></td>
                    	</tr>
                    	<tr>
                    		<td class="label">纭瀵嗙爜:</td>
                    		<td> <input type="password" id="password2" name="password" class="contact_input" onblur="checkPwd()" /></td>
                    		<td id="checkPwd" class="remind">&nbsp;</td>
                    	</tr>
      
      </table>
 <input type="submit" value="纭畾" onblur="checkPwd()">
    </form>
       	
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
