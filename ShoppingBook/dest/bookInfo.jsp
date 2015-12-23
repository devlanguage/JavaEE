<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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

		<title>My JSP 'bookInfo.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
	<link rel="stylesheet" type="text/css" href="CSS/link.css">
	</head>

	<body>
		<div>
			<div id="left">
				<table>
					<tr>
						<td>
							<table>
								<tr>
									<td width="200" height="150">
										<img src="${book.picture}" />
									</td>
								</tr>
								<tr>
									<td width="200" height="25">
										<a href="buyBooksServlet?bookId=${book.bookId}"><img
												src="Image/m_buy.gif" />
										</a>
									</td>
								</tr>
							</table>
						<td>
						</td>
					</tr>
				</table>
			</div>
			<div id="right">
				<table border="1px">
					<tr>
						<td>
							涔︾睄缂栧彿ID
						</td>
						<td>
							${book.bookId}
						</td>
					</tr>
					<tr>
						<td>
							涔︾睄鍚嶇О
						</td>
						<td>
							${book.bookName}
						</td>
					</tr>
					<tr></tr>
					<tr>
						<td>
							涔︾睄浠嬬粛
						</td>
						<td>
							${book.introduce}
						</td>
					</tr>
					<tr>
						<td>
							鍘熶环
						</td>
						<td>
							${book.price}
						</td>
					</tr>
					<tr>
						<td>
							鐜颁环
						</td>
						<td>
							${book.nowPrice}
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
