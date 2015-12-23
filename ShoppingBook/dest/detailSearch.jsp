<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@include file="common.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>鍥句功楂樼骇鎼滅储</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style.css" />
  <script type="text/javascript">
  	var req;
		function selectedSuper(){
			if(window.XMLHttpRequest){//Mozillia
				req = new XMLHttpRequest();
			}else if(window.ActiveXObject){//IE
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
			//璁剧疆鍥炶皟鍑芥暟
			req.onreadystatechange = callback;
			var superTypeId = document.getElementById("superType").value;
			var url = "showSubTypeServlet?superTypeId="+superTypeId;
			req.open("get",url,true);
			var price1 = document.getElementById("price1");
  			var price2 = document.getElementById("price2");
  			var other = document.getElementById("other");
  			other.style.visibility = "hidden";
  			price1.style.visibility = "hidden";
  			price2.style.visibility = "hidden";
			req.send(null);
		}
		function clearSubType(){
			var subT = document.getElementById("subT");
			subT.length=0;
		}
		function callback(){
			var state = req.readyState;
			var subT = document.getElementById("subT");
			if(state==4 && req.status==200){
			clearSubType();
			var dom = req.responseXML;
			var subType = dom.getElementsByTagName("subType");
			for(i=0;i<subType.length;i++){
				var subTypeId = subType[i].getElementsByTagName("subTypeId")[0];
				var subTypeName = subType[i].getElementsByTagName("subTypeName")[0];
				var subValue = subTypeId.firstChild.data;
				var subText = subTypeName.firstChild.data;
				subT[i] = new Option(subText,subValue);
			}
			}
		}
  	function getSM(){
  		var searchMethod = document.getElementById("searchMethod").value;
  		if(searchMethod=="noChoice"){
  			alert("璇烽�夋嫨鏌ヨ鏂瑰紡");
  		}else if(searchMethod=="price"){
  			var price1 = document.getElementById("price1");
  			var price2 = document.getElementById("price2");
  			var other = document.getElementById("other");
  			other.style.visibility = "hidden";
  			price1.style.visibility = "visible";
  			price2.style.visibility = "visible";
  		}else {
  			var price1 = document.getElementById("price1");
  			var price2 = document.getElementById("price2");
  			var other = document.getElementById("other");
  			other.style.visibility = "visible";
  			price1.style.visibility = "hidden";
  			price2.style.visibility = "hidden";
  		}
  	}
	function checkDetails(){
		var superType = document.getElementById("superType");
		var subT = document.getElementById("subT");
		var upLoadTime = document.getElementById("upLoadTime");
		var searchMethod = document.getElementById("searchMethod");

		if(superType.value != "noChoice" && subT.value != "noChoice" && searchMethod.value != "noChoice" && upLoadTime.value != "noChoice"){
			if(searchMethod.value=="price"){
				var prices = document.getElementById("prices");
				if(prices.value != "noChoice"){
					document.detailSearch.submit();
				}
			}else {
				var content = document.getElementById("content");
				if(content.value != "noChoice"){
					document.detailSearch.submit();
				}
			}
		}else {
			alert("璇烽�夋嫨濂戒綘鐨勬煡璇㈡潯浠�!!");
		}
	}
  </script>
  </head>
  
  <body>
    		<div id="wrap"> 
		 
			<!-- the begin of header -->
			<%@include file="header.jsp"%>
			<!-- the end of header -->
			
			<!-- the begin of content -->
			<div class="center_content">
				<!-- the begin of left -->
					<div>
						<div>鍥句功楂樼骇鎼滅储</div>
						<div>
						<form action="detailSearch" method="post" name="detailSearch">
							<table>
								<tr>
									<td>鎵�灞炲ぇ绫伙細</td>
									<td>
										<select id="superType" name="superType" onchange="selectedSuper()">
											<option value="noChoice">--璇烽�夋嫨澶х被--</option>
											<c:forEach var="flag" items="${superList}">
						  					<option value="${flag.superTypeId}">${flag.typeName}</option>
						  					</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td>鎵�灞炲皬绫伙細</td>
									<td>
										<select id="subT" name="subT">
											<option value="noChoice">--璇烽�夋嫨灏忕被--</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>璇烽�夋嫨鏌ヨ鏂瑰紡</td>
									<td>
										<select name="searchMethod" id="searchMethod" onchange="getSM()">
											<option value="noChoice">--璇烽�夋嫨鏌ヨ鏂瑰紡--</option>
											<option value="bookName">鎸変功鍚嶆煡璇�</option>
											<option value="author">鎸変綔鑰呮煡璇�</option>
											<option value="publisher">鎸夊嚭鐗堢ぞ鏌ヨ</option>
											<option value="ISBN">鎸塈SBN鏌ヨ</option>
											<option value="price">鎸変环鏍兼煡璇�</option>
										</select>
									</td>
									<td id="other" style="visibility: hidden;"><input type="text" name="content" id="content" /></td>
									<td style="visibility:hidden" id="price1">瀹氫环锛�</td>
									<td style="visibility: hidden;" id="price2">
										<select id="prices" name="prices">
											<option value="noChoice">--璇烽�夋嫨浠锋牸鑼冨洿--</option>
											<option value="0-50">50鍏冧互涓�</option>
											<option value="50-100">50-100鍏�</option>
											<option value="100-200">100-200鍏�</option>
											<option value="澶т簬200">200鍏冧互涓�</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>涓婃灦鏃堕棿锛�</td>
									<td>
										<select id="upLoadTime" name="upLoadTime">
											<option value="noChoice">--璇烽�夋嫨涓婃灦鏃堕棿--</option>
											<option value="3">杩戜笁澶�</option>
											<option value="7">杩戜竴涓槦鏈�</option>
											<option value="15">杩戝崐涓湀</option>
											<option value="30">杩戜竴涓湀</option>
											<option value="澶т簬30">涓�涓湀浠ヤ笂</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td><input type="button" value="鎻愪氦" onclick="checkDetails()" /></td>
								</tr>
							</table>
						</form>
						</div>
					</div>
				<div class="clear"></div>
			</div>
			
			
			<!--end of center content-->
			<%@include file="footer.jsp"%>
		</div>
  </body>
</html>
