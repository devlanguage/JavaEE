<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>鐢ㄦ埛娉ㄥ唽</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript">
	//蹇呴』鍚屾剰鍗忚鍚庢墠鍙敞鍐�
	function enable(){
		var terms = document.getElementById("terms");
		var register = document.getElementById("register");
		if(terms.checked){
			register.disabled=false;
		}else{
			register.disabled=true;
		}
	}
	//妫�鏌ョ敤鎴峰悕鏄惁鍚堟硶,鍙兘鐢辫嫳鏂囧瓧姣嶃�佹暟瀛楀拰涓嬪垝绾跨粍鎴愶紝涓斿紑澶翠笉鑳戒负鏁板瓧
	function checkName(){
		var name = document.getElementById("name");
		var pic = document.getElementById("pic");
		var checkName = document.getElementById("checkName");
		var patrn=/^[a-zA-Z_]{1}\w{5,16}$/; 
		if (!patrn.exec(name.value)){
			 checkName.style.color="red";
			 checkName.innerHTML="鐢ㄦ埛鍚嶈緭鍏ユ湁璇�!";
			 return false;
		}else{	
			 checkName.style.color="green";
			 checkName.innerHTML="鈭� 杈撳叆姝ｇ‘";
			 return true;
		}
	}
	//妫�鏌ョ敤鎴峰悕鏄惁瀛樺湪
	var req;
	function checkNE(){
		var name = document.getElementById("name");
		if(checkName()){
			if(window.XMLHttpRequest){
				req = new XMLHttpRequest();
			}else if(window.ActiveXObject){
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
			//璁剧疆鍥炶皟鍑芥暟
			req.onreadystatechange = callbackForName;
			var url = "checkNameExist?name="+name.value;
			req.open("get",url,true);
			req.send(null);
			return true;
		}else{
			return false;
		}
		
	}
	function callbackForName(){
		var state = req.readyState;
		if(state==4){
			var doms = req.responseXML;
			var user = doms.getElementsByTagName("user");
			if(user[0].getElementsByTagName("name")[0].firstChild.data=="exist"){//鐢ㄦ埛鍚嶅凡缁忓瓨鍦�
				var name = document.getElementById("name");
				name.focus();
				window.open("exist.jsp","fail","width=180,height=120,left=200,top=180");
			}else{
				window.open("notExist.jsp","success","width=180,height=120,left=200,top=180");
			}
		}
	}
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
	//纭瀵嗙爜
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
	//楠岃瘉閭鏍煎紡
	function checkMail(){
		var email = document.getElementById("email");
		var patrn=/((\w)|[-]|[.])+@(((\w)|[-])+[.])+[a-z]{2,4}$/;
		var checkMail = document.getElementById("checkMail");
		if(!patrn.exec(email.value)){
			checkMail.style.color="red";
			checkMail.innerHTML="閭鏍煎紡杈撳叆鏈夎!";
			return false;
		}else{
			checkMail.style.color="green";
			checkMail.innerHTML="鈭� 閭杈撳叆姝ｇ‘!";
			return true;
		}
	}
	//鏍￠獙閭斂缂栫爜,蹇呴』鏄叚浣嶆暟瀛楋紝涓旂涓�浣嶄笉鑳戒负0
	function isPostalCode()
	{
	var postCode = document.getElementById("postCode");
	var remindPostCode = document.getElementById("remindPostCode");
	var patrn=/^[1-9]{1}(\d){5}$/;
	if (!patrn.exec(postCode.value)){
		remindPostCode.style.color="red";
		remindPostCode.innerHTML="閭斂缂栫爜杈撳叆鏈夎";
		return false;
	}else{
		remindPostCode.style.color="green";
		remindPostCode.innerHTML="鈭� 杈撳叆姝ｇ‘";
		return true
	}
	}
	//鏍￠獙鍥哄畾鐢佃瘽鍙风爜
	function checkPhone(){
		var phone = document.getElementById("phone");
		var checkPhone = document.getElementById("checkPhone");
		var patrn=/^[+]{0,1}\d{3,5}-?\d{5,9}$/;
		if (!patrn.exec(phone.value)){
			checkPhone.style.color="red";
			checkPhone.innerHTML="鐢佃瘽鏍煎紡涓嶆纭�";
			return false;
		}else{
			checkPhone.style.color="green";
			checkPhone.innerHTML="鈭� 杈撳叆姝ｇ‘";
			return true;
		}
	}
	//鏍￠獙绉诲姩鐢佃瘽鍙风爜
	function checkMPhone(){
		var phone = document.getElementById("mphone");
		var checkMphone = document.getElementById("checkMphone");
		var patrn=/^1[356]\d{9}|01[356]\d{9}$/;
		if (!patrn.exec(phone.value)){
			checkMphone.style.color="red";
			checkMphone.innerHTML="鎵嬫満鏍煎紡涓嶆纭�";
			return false;
		}else{
			checkMphone.style.color="green";
			checkMphone.innerHTML="鈭� 杈撳叆姝ｇ‘";
			return true;
		}
	}
	//妫�鏌ラ獙璇佺爜鏄惁姝ｇ‘
	function checkCode(){
		var code = document.getElementById("code");
		var codeR = document.getElementById("codeR");
		if(code.value != null){
			if(window.XMLHttpRequest){
				req = new XMLHttpRequest();
			}else if(window.ActiveXObject){
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
			//璁剧疆鍥炶皟鍑芥暟
			req.onreadystatechange = callbackForCode;
			var url = "checkRandomCode?code="+code.value;
			req.open("get",url,true);
			req.send(null);
			return true;
		}else{
			codeR.style.color="red";
			codeR.innerHTML="璇疯緭鍏ラ獙璇佺爜";
			return false;
		}
		
	}
	function callbackForCode(){
		var state = req.readyState;
		var codeR = document.getElementById("codeR");
		if(state==4){
			var doms = req.responseXML;
			var code = doms.getElementsByTagName("code");
			var message = code[0].getElementsByTagName("message")[0].firstChild.data;
			if(code[0].getElementsByTagName("message")[0].firstChild.data=="correct"){//楠岃瘉鐮佽緭鍏ユ纭�
				codeR.style.color="green";
				codeR.innerHTML="鈭� 杈撳叆姝ｇ‘";
			}else{
				codeR.style.color="red";
				codeR.innerHTML="杈撳叆閿欒";
			}
		}
	}
	//蹇呴』鎵�鏈変俊鎭～鍐欐纭墠鑳芥垚鍔熸彁浜や俊鎭�
	function checkAll(){
		document.register_form.submit();
	}
	//娓呮鐢ㄦ埛鍚嶉敊璇彁绀�
	function clearRN(){
		var checkName = document.getElementById("checkName");
		checkName.style.color="black";
		checkName.innerHTML="鑻辨枃瀛楁瘝鎴栦笅鍒掔嚎(6-15)瀛楃缁勬垚";
	}
	//娓呮瀵嗙爜楠岃瘉閿欒鎻愮ず
	function clearPwd(){
		var checkPwd = document.getElementById("checkPwd");
		var pwdRemind = document.getElementById("pwdRemind");
		checkPwd.style.color="black";
		checkPwd.innerHTML="鐢辫嫳鏂囧瓧姣嶅拰鏁板瓧(6-15)瀛楃缁勬垚";
		pwdRemind.innerHTML="";
	}
	//娓呴櫎閭閿欒鎻愮ず
	function clearMail(){
		var checkMail = document.getElementById("checkMail");
		checkMail.style.color="black";
		checkMail.innerHTML="璇疯緭鍏ユ纭殑閭鍦板潃";
	}
	//娓呴櫎閭斂缂栫爜閿欒鎻愮ず
	function clearPostR(){
		var remindPostCode = document.getElementById("remindPostCode");
		remindPostCode.innerHTML="";
	}
	//娓呴櫎鍥哄畾鐢佃瘽閿欒鎻愮ず
	function clearPhoneR(){
		var checkPhone = document.getElementById("checkPhone");
		checkPhone.innerHTML="";
	}
	function clearMphoneR(){
		var checkMphone = document.getElementById("checkMphone");
		checkMphone.innerHTML="";
	}
	//鍒锋柊楠岃瘉鐮�
	function refreshCode(){
		var safeCode = document.getElementById("safeCode");
		safeCode.src = "code";
	}
</script>
</head>
<body>
<div id="wrap">		
		<%@include file="header.jsp" %>    
       <div class="center_content">
       	<div class="left_content">
       		<div class="crumb_nav">
           		 <a href="index.jsp">棣栭〉</a> &gt;&gt; 娉ㄥ唽
            </div>
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>娉ㄥ唽璐﹀彿</div>
        
        	<div class="feat_prod_box_details">
            <p class="details">
            </p>
              	<div class="contact_form">
                <div class="form_subtitle">鍒涘缓鏂拌处鍙�</div>
                 <form name="register_form" action="register" method="post">          
                    <table>
                    	<tr>
                    		<td class="label">鐢ㄦ埛鍚�:</td>
                    		<td><input type="text" id="name" name="name" onblur="checkName()" onfocus="clearRN()"/></td>
                    		<td id="checkName" class="remind"><span style="color: red">*</span><span style="color:black">鐢辫嫳鏂囧瓧姣嶃�佹暟瀛楁垨涓嬪垝绾�(6-16)瀛楃缁勬垚,涓斾笉鑳戒互鏁板瓧寮�澶�</span></td>
                    	</tr>
                    	<tr>
                    		<td>&nbsp;</td>
                    		<td><input type="button" value="妫�鏌ョ敤鎴峰悕鏄惁瀛樺湪" id="checkNameExist" onclick="checkNE()" /></td>
                    		<td>&nbsp;</td>
                    	</tr>
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
                    	<tr>
                    		<td class="label">鐢靛瓙閭欢:</td>
                    		<td><input type="text" id="email" name="email" class="contact_input" onblur="checkMail()" onfocus="clearMail()" /></td>
                    		<td id="checkMail" class="remind"><span style="color: red">*</span><span style="color:black">璇疯緭鍏ユ纭殑閭鍦板潃锛屽:<span style="color: aqua">lovo@gmail.cn</span></td>
                    	</tr>
                    	<tr>
                    		<td class="label">鐪熷疄濮撳悕:</td>
                    		<td><input type="text" id="trueName" name="trueName" class="contact_input" /></td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">鎬у埆:</td>
                    		<td>
                    			 <input type="radio" name="sex" value="鐢�" checked="checked"/>鐢�
                    			 <input type="radio" name="sex"  value="濂�" />濂�
                    		</td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">鍑虹敓鏃ユ湡:</td>
                    		<td><input type="text" id="birthday" name="birthday" class="contact_input" /></td>
                    		<td class="remind" style="color: black">鏍煎紡濡傦細1986-07-12</td>
                    	</tr>
                    	<tr>
                    		<td class="label">鍦板潃:</td>
                    		<td><input type="text" id="address" name="address" class="contact_input" /></td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">閭斂缂栫爜:</td>
                    		<td><input type="text" id="postCode" name="postCode" class="contact_input" onblur="isPostalCode()" onfocus="clearPostR()" /></td>
                    		<td class="remind" id="remindPostCode">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">鍥哄畾鐢佃瘽:</td>
                    		<td><input type="text" id="phone" name="phone" class="contact_input" onblur="checkPhone()" onfocus="clearPhoneR()" /></td>
                    		<td id="checkPhone" class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">绉诲姩鐢佃瘽:</td>
                    		<td><input type="text" id="mphone" name="mphone" class="contact_input" onblur="checkMPhone()" onfocus="clearMphoneR()" /></td>
                    		<td id="checkMphone" class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">瀵嗙爜闂鎻愮ず:</td>
                    		<td>
                    			<select id="question" name="question" class="contact_input" style="width: 155px;">
                    				<option value="empty">--璇烽�夋嫨鎻愮ず闂--</option>
                    				<option value="浣犳渶鐖辩殑浜虹殑鍚嶅瓧鍙粈涔�">浣犳渶鐖辩殑浜虹殑鍚嶅瓧鍙粈涔�</option>
                    				<option value="浣犳渶鍠滄鐨勪笟浣欑埍濂芥槸浠�涔�">浣犳渶鍠滄鐨勪笟浣欑埍濂芥槸浠�涔�</option>
                    				<option value="浣犲濡堢殑鐢熸棩鏄粈涔堟椂鍊�">浣犲濡堢殑鐢熸棩鏄粈涔堟椂鍊�</option>
                    				<option value="鍏朵粬">鍏朵粬</option>
                    			</select>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">闂绛旀:</td>
                    		<td><input type="text" id="answer" name="answer" class="contact_input" /></td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td>楠岃瘉鐮�:</td>
                    		<td><input type="text" id="code" name="code"  style="width: 50px;" onblur="checkCode()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="code" id="safeCode" onclick="refreshCode()" /></td>
                    		<td> <span id="codeR"></span></td>
                    	</tr>
                    	<tr>
                    		<td class="label">&nbsp;</td>
                    		<td class="terms"><input type="checkbox" id="terms" name="terms" onclick="enable()" />
                        鎴戝悓鎰忎綘鐨勬墍鏈� <a href="">鏉℃</a> </td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">&nbsp;</td>
                    		<td>&nbsp;</td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    		<tr>
                    		<td class="label">&nbsp;</td>
                    		<td>&nbsp;</td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">&nbsp;</td>
                    		<td><input type="button" id="register" name="register" class="register" value="娉ㄥ唽" disabled="disabled" onclick="checkAll()" /></td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    </table> 
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
