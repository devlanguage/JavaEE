<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<jsp:directive.page import="com.lovo.cq.shopping10_1.vo.Cart"/>
<jsp:directive.page import="com.lovo.cq.shopping10_1.vo.CartItem"/>
<%@include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>濉啓鏀惰幏浜轰俊鎭祫鏂�</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript">
	//楠岃瘉鏀惰揣浜哄鍚嶄笉鑳戒负绌�
	function checkRN(){
		var recvName = document.getElementById("recvName");
		if(recvName.value==""){
			var remindRN = document.getElementById("remindRN");
			remindRN.style.color="red";
			remindRN.innerHTML="鏀惰揣浜哄鍚嶄笉鑳戒负绌�";
			return false;
		}else{
			var remindRN = document.getElementById("remindRN");
			remindRN.style.color="green";
			remindRN.innerHTML="鈭� 杈撳叆姝ｇ‘";
			return true;
		}
	}
	
	//楠岃瘉鏀惰揣浜哄湴鍧�涓嶈兘涓虹┖
	function checkAddr(){
		var address = document.getElementById("address");
		if(address.value==""){
			var remindAddr = document.getElementById("remindAddr");
			remindAddr.style.color="red";
			remindAddr.innerHTML="鏀惰揣浜哄鍚嶄笉鑳戒负绌�";
			return false;
		}else{
			var remindAddr = document.getElementById("remindAddr");
			remindAddr.style.color="green";
			remindAddr.innerHTML="鈭� 杈撳叆姝ｇ‘";
			return true;
		}
	}
	//鏍￠獙閭斂缂栫爜,蹇呴』鏄叚浣嶆暟瀛楋紝涓旂涓�浣嶄笉鑳戒负0
	function isPostalCode()
	{
	var postCode = document.getElementById("postcode");
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
	
	//鎵�鏈変俊鎭纭墠鍙互鎻愪氦
	function checkAll(){
		if(checkRN()&& checkAddr() && isPostalCode() && checkPhone() && checkMPhone()){
			document.submitOrder.submit();		
		}else{
			alert("璇锋纭～鍐欐敹璐т汉淇℃伅!!");
		}
	}
	function submit_order(){
		if(checkAll()){
			
		}
	}
</script>
</head>
<body>

<div id="wrap">
		
		<%@include file="header.jsp" %>
       <div class="center_content">
       	<div class="left_content">
        	<form name="submitOrder" action="addOrderServlet" method="post">     
        		<table>
        			<tr>
                    	<td class="label"><strong>鐢ㄦ埛:</strong></td>
                    	<td><font style="color: red">${user.name}</font></td>
                    	<td class="remind">&nbsp;</td>
                    </tr>
                    <tr>
                    	<td class="label"><strong>鏀惰揣浜哄鍚�:</strong></td>
                    	<td><input type="text" id="recvName" name="recvName" class="contact_input" onblur="checkRN()"/></td>
                    	<td class="remind" id="remindRN">&nbsp;</td>
                    </tr>
                    <tr>
                    	<td class="label"><strong>鏀惰揣鍦板潃:</strong></td>
                    	<td><input type="text" id="address" name="address" class="contact_input" onblur="checkAddr()" /></td>
                    	<td class="remind" id="remindAddr">&nbsp;</td>
                    </tr>
                    <tr>
                    	<td class="label"><strong>閭斂缂栫爜:</strong></td>
                    	<td><input type="text" id="postcode" name="postcode" class="contact_input" onblur="isPostalCode()" /></td>
                    	<td class="remind" id="remindPostCode">&nbsp;</td>
                    </tr>
                      <tr>
                    	<td class="label"><strong>email:</strong></td>
                    	<td><input type="text" id="email" name="email" class="contact_input" onblur="checkMail()" /></td>
                    	<td class="remind" id="checkMail">&nbsp;</td>
                    </tr>
                     <tr>
                    	<td class="label"><strong>鍥哄畾鐢佃瘽:</strong></td>
                    	<td><input type="text" id="phone" name="phone" class="contact_input" onblur="checkPhone()" /></td>
                    	<td class="remind" id="checkPhone">&nbsp;</td>
                    </tr>
                     <tr>
                    	<td class="label"><strong>绉诲姩鐢佃瘽:</strong></td>
                    	<td><input type="text" id="mphone" name="mphone" class="contact_input" onblur="checkMPhone()" /></td>
                    	<td class="remind" id="checkMphone">&nbsp;</td>
                    </tr>
        		</table>	     
			<div class="feat_prod_box_details">
            <table class="cart_table">
               	<tr class="cart_title">
                	<td>ISBN</td>
                	<td>涔︾睄鍚�</td>
                    <td>鍗曚环</td>
                    <td>鏁伴噺</td>
                    <td>鎬讳环</td>           
                </tr>
				<%
					Collection ci = (Collection)request.getSession().getAttribute("ci");
					
						Iterator<CartItem> it= ci.iterator();
						while(it.hasNext()){
							CartItem cartItem = it.next();
							%>
								<tr>
									<td><%=cartItem.getBook().getISBN()%></td>
									<td><%=cartItem.getBook().getBookName() %></td>
									<td><%=cartItem.getBook().getNowPrice()%></td>
									<td><%=cartItem.getCount()%></td>
									<td><%=cartItem.getItemPrice() %></td>
								</tr>
							<%
						}
				 %>  
                <tr>
                <td colspan="4" class="cart_total"><span class="red">鎬讳环:</span></td>
                	<%
					Cart c = (Cart)session.getAttribute("cart");
					if(c != null){
    	 	   			%>
    	 	   			  <td><%=c.getTotalPrice()%></td>
    	 	   			<%
    	 	  	   }
					%>              
                </tr>             
            </table>
            <a href="cart.jsp" class="continue">&lt; 杩斿洖璐墿杞�</a>
            <span class="submit_order"><input type="button" id="subOrder" name="subOrder" class="register" value="涓嬭鍗�" onclick="checkAll()" />&lgt;</span>
            </div>	   
        </form>  
 		</div><!--end of left content-->
        <%@include file="right.jsp" %> 
       <!--end of right content-->
   
       <div class="clear"></div>
       </div><!--end of center content-->
       
       <%@include file="footer.jsp"%>
</div>

</body>
</html>
