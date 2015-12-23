<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<jsp:directive.page import="com.lovo.cq.shopping10_1.vo.CartItem" />
<jsp:directive.page import="com.lovo.cq.shopping10_1.vo.Cart" />
<%@include file="common.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'buy.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="CSS/link.css">

		<style type="text/css">
table th {
	background-color: "#F0F0F0"
}

#last {
	background-color: "#F0F0F0"
}

#cartImage {
	text-align: center
}

#cart {
	text-align: center
}

#go {
	text-align: center
}
</style>
	</head>

	<body>
		<div id="cartImage">
			<img src="Image/cartnow.gif" />
		</div>
		<div id="cart">
			<br>
			<table border="1px">
				<tr>
					<th>
						涔︾睄ID
					</th>
					<th>
						涔︾睄鍚嶇О
					</th>
					<th>
						璐拱鏁伴噺
					</th>
					<th>
						鍗曚环
					</th>
					<th>
						鎬讳环
					</th>
					<th>
						鎿嶄綔1
					</th>
					<th>
						鎿嶄綔2
					</th>
				</tr>
				<%
					Collection<CartItem> ci = (Collection) session.getAttribute("ci");
					if (ci.size() == 0) {
						out.print("璐墿杞︿腑杩樻病鏈夊晢鍝侊紒");
				%>
				<a href="showBooks"><img src="Image/goon.jpg" /> </a>
				<%
					} else {
						Iterator<CartItem> it = ci.iterator();
						while (it.hasNext()) {
							CartItem cartItem = it.next();
				%>
				<form
					action="updateBookCount?bookId=<%=cartItem.getBook().getBookId()%>"
					method="post">
				<tr>
					<td><%=cartItem.getBook().getBookId()%></td>
					<td><%=cartItem.getBook().getBookName()%></td>
					<td>
						<input type="text" name="count" value="<%=cartItem.getCount()%>" />
					</td>
					<td><%=cartItem.getBook().getNowPrice()%></td>
					<td><%=cartItem.getItemPrice()%></td>
					<td>
						<a
							href="deleteItemServlet?bookId=<%=cartItem.getBook().getBookId()%>"><img
								src="Image/sc.jpg" /> </a>
					</td>
					<td>
						<input type="image" value="submit" src="Image/xiugai.jpg">
					</td>
				</tr>
			
				<%
					}
					}
				%>
				<tr id="last">
					<td>
						鍚堣
					</td>
					<%
						Cart c = (Cart) session.getAttribute("cart");
						if (c != null) {
					%>
					<td><%=c.getTotalPrice()%></td>
					<%
						}
					%>
					<td>
						<a href="checkLogin">涓嬭鍗�</a>
					</td>
					<td>
						-
					</td>
					<td>
						-
					</td>
					<td>
						-
					</td>
					<td>
						-
					</td>
				</tr>
			</table>

		</div>
		<div id="go">
			<br>
			<a href="showBooks"><img src="Image/goon.jpg" /> </a>
		</div>
	</body>
</html>
