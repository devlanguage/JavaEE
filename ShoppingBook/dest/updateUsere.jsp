<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>淇敼瀹屽杽涓汉璧勬枡</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
  function test(){
    var cc = document.getElementById("tu");
    var slecCC= document.getElementById("tuid").value;
        cc.src = slecCC ;
  }
  
  //鐢佃瘽鍙风爜鎵瑰
  function checkpp(){
   var patten = /^\d{11}$/;
	     var phone = document.getElementById("phone").value ;
	     var phoneDiv = document.getElementById("phoneDiv1");
	         phoneDiv.style.color ="red" 
	         if(phone==""){
	          return true ;
	         }else if (patten.test(phone)){
	            phoneDiv.innerHTML = "鈭�";
	             return true ;
	         }else{
	            phoneDiv.innerHTML = "鏍煎紡涓嶅";
	             return false ;
	         }
  }
  
	  function checkPhone(){
	     var patten = /^\d{11}$/;
	     var phone = document.getElementById("mphone").value ;
	     var phoneDiv = document.getElementById("phoneDiv");
	         phoneDiv.style.color ="red" 
	         if(phone==""){
	          return true ;
	         }else if (patten.test(phone)){
	            phoneDiv.innerHTML = "鈭�";
	             return true ;
	         }else{
	            phoneDiv.innerHTML = "鏍煎紡涓嶅";
	             return false ;
	         }
	  }
	  //閭紪鎵瑰
	  function checkPcode(){
	     var patton =/^\d{6}$/ ;
	     var pcode = document.getElementById("postcode").value ;
	     var pcodeDiv = document.getElementById("pcodeDiv");
	         pcodeDiv.style.color = "black";
	     if(pcode==""){
	       return true ;
	     }else if(patton.test(pcode)){
	         pcodeDiv.innerHTML = "鈭�";
	           return true ;
	     }else {
	           pcodeDiv.innerHTML ="鏍煎紡涓嶅";
	             return false ;
	     }
	  }
	    //鍒锋柊楠岃瘉鐮�
	  function checkSrc(){
	    var srcImg = document.getElementById("src");
	    srcImg.src = "src";
	  }
	  
	   //楠岃瘉鐮丄JAX
	  function checkcodeIsText(){
	   if(window.XMLHttpRequest){
	       req = new XMLHttpRequest();
	     }else if (window.ActiveXObject){
	       req = new ActiveXObject("Microsoft.XMLHTTP");
	     }
	     req.onreadystatechange = callBackBycode;
	     var code = document.getElementById("code").value;
	     url = "checkcode?code="+code;
	      req.open("get",url,true);
	     req.send(null);
	  }
	  function callBackBycode(){
	     var dom = req.responseXML;
	     var text = dom.getElementsByTagName("text");
	     var va =  text[0].firstChild.data;
	    document.getElementById("idDiv").innerHTML = va ;
	    if(va=='鈭�'){
	       return true ;
	    }else{
	      return false ;
	    }
	  }
	    //楠岃瘉鐮佹壒瀵�
	  function checkCode(){
	  var ptton = /^\d{4}$/;
	  var cc = document.getElementById("code").value ;
	  var codeDiv = document.getElementById("idDiv");
	      codeDiv.style.color="white";
	       if(cc==""){
	        return true ;
	   }else if(ptton.test(cc)){
	       checkcodeIsText();
	   }else{
	         codeDiv.innerHTML = "楠岃瘉鐮佹牸寮忎笉瀵�";
	   }    
	  }
	  
	  function checkForm(){
	   if(checkpp()&& checkPhone() && checkPcode() && checkCode()){
	     document.form.submit();
	  }
	  }
</script>
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
         
         <div>
         	<form action="updateUserTwo" method="post" id="form" name="form" >
    <div align="center">
      <fieldset>
        <legend>浼氬憳璧勬枡淇敼琛�</legend>
        <table>
        <tr>
          <td>绉垎锛� </td>
           <td>${user.score}</td>
        </tr>
          <tr>
            <td>鐢ㄦ埛鍚嶏細</td>
              <td>${user.name} </td>
           </tr>
          <tr>
            <td>瀵� 鐮侊細</td>
            <td>${user.password}</td>
           </tr>
          <tr>
            <td>E-mail锛�</td>
              <td><input type="text" name="email" value="${user.email}"  /> </td>
           </tr>
          <tr>
            <td>鐪� 鍚嶏細</td>
            <td><input type="text" name="trueName" value="${user.trueName}"  /> </td>
           </tr>
          <tr>
            <td>鎬� 鍒細</td>
              <td>
                 <input type="radio" name="sex" value="鐢�" checked="checked" />鐢�${user.sex}
                 <input type="radio" name="sex" value="濂�"  />濂�            
              </td>
           </tr>
          <tr>
            <td>鐢� 鏃ワ細</td>
              <td><input type="text" name="birthday" value="${user.birthday}"  /> </td>
           </tr>
          <tr>
            <td>鍦� 鍧�锛�</td>
              <td><input type="text" name="address" value="${user.address}"  /> </td>
           </tr>
          <tr>
            <td>閭� 缂栵細</td>
              <td><input type="text" name="postcode" id="postcode" value="${user.postcode}" onblur="checkPcode()" /><div id="pcodeDiv">璇锋纭緭鍏�6浣嶉偖缂�</div></td>
           </tr>
          <tr>
            <td>搴� 鏈猴細</td>
              <td><input type="text" name="phone" id="phone" value="${user.phone} " onblur="checkpp()" /> <div id="phoneDiv1">璇锋纭緭鍏ュ尯鍙峰拰鐢佃瘽鍙风爜</div> </td>
           </tr>
          <tr>
            <td>鎵� 鏈猴細</td>
             <td><input type="text" name="mphone" id="mphone"  value="${user.mphone}" onblur="checkPhone()" /><div id="phoneDiv">璇锋纭緭鍏�11浣嶆暟鐨勬墜鏈哄彿鐮�</div> </td>
           </tr>
          <tr>
            <td>瀹夊叏闂锛�</td>
              <td><select name="question">
              		<option value="${user.question}">${user.question }</option>
                  	<option value="鎴戞槸璋�" />鎴戞槸璋�
                    <option value="鎴戠殑鐢熸棩鏄�" />鎴戠殑鐢熸棩鏄�
                  </select>              </td>
           </tr>
          <tr>
            <td>瀹夊叏绛旀锛�</td>
            <td><input type="text" name="answer" value="${user.answer}"  /> </td>
           </tr>
          <tr>
            <td>楠岃瘉鐮侊細<img src="code" alt="楠岃瘉鐮�" onclick="checkSrc()" /> </td>
              <td><input type="text" name="code" size="6" id="code" onblur="checkCode()" /><div id="idDiv">鐐瑰嚮鍒锋柊</div></td>
           </tr>
          <tr>
            <td><input type="button" value=" 纭畾" onclick="checkForm()" /> </td>
              <td><input type="reset" value=" 鍙栨秷" /></td>
           </tr>
        </table>
      </fieldset>
    </div>
  </form>
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
