<!--<%@ tag pageEncoding="GB2312"%>
<%@ tag dynamic-attributes="numColumn"%>
<%@ attribute name="great" fragment="true"%>
<%@ attribute name="less" fragment="true"%>
<%@ variable name-given="sum" variable-class="java.lang.Object"%>
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty numColumn}">
	<c:forEach items="${numColumn}" var="num">
		<c:set var="sum" value="${num.value + sum}" />
	</c:forEach>
	<c:if test="${sum >= 1000}">
		<jsp:invoke fragment="great" />
	</c:if>
	<c:if test="${sum < 1000}">
		<jsp:invoke fragment="less" />
	</c:if>
</c:if>
