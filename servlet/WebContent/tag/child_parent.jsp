
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
	out.println(" Quoting �� Escape����");
  out.println(" %\> ��дΪ %\\>");  
%>
<pre> ��JSP��out.println(""),����һЩ�����ַ�Ӧ�ð�һ�¹�����д
������ ' ��Ϊ \' 
˫���� " ��Ϊ \" 
б�� \ ��Ϊ \\ 
��ʼ��ǩ &lt;% ��Ϊ &amp;lt;%
������ǩ %&gt;   ��Ϊ %\> 
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
