
<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK" autoFlush="true" isErrorPage="false"
	isThreadSafe="true" session="true" buffer="8kb" errorPage="error.jsp"
	import="java.util.Date,java.util.Calendar"%>
<%!String path;%>
<%@ include file="../header.jsp"%>
<%@ taglib uri="http://servlettest.org/pc" prefix="pc"%>

<br>
No_comment:
<%=new Date()%>
<br>
comment1_//:
<%//=new Date()%>
<br>
comment2_&lt;%-- .. -- %&gt; :
<%-- =new Date()--%>
<br>
comment3_&lt;% /* .. */ %&gt; :
<% /*=new Date()*/ %>

<br>
<%
	out.println(" Quoting 和 Escape规则");
  out.println(" %\> 改写为 %\\>");  
%>
<pre> 在JSP的out.println(""),碰到一些特殊字符应该按一下规则书写
单引号 ' 改为 \' 
双引号 " 改为 \" 
斜线 \ 改为 \\ 
起始标签 &lt;% 改为 &amp;lt;%
结束标签 %&gt;   改为 %\> 
</pre>

<%!int t1 = 0;%>
<%!int a1, a2, a3;%>
<%!Date a = new Date();%>
<%!public int add(int i, int j) {

        return i + j;
    }%>
<%
this.path = this.getServletContext().getContextPath();
%>
<hr>
TagLib Test:
<br>
<pc:parent pname="parent first attribute">
	<%=new Date()%>
	<%=path%>
	<pc:child pname="child first attribute"></pc:child>
</pc:parent>


<hr>
