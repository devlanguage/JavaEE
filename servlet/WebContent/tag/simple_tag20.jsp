<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" autoFlush="true" isErrorPage="false"
    isThreadSafe="true" session="true" buffer="8kb" errorPage="/error.jsp"
    import="java.util.Date,java.util.Calendar"%>
<%@ include file="../header.jsp"%>
<%@ taglib uri="http://servlettest.org/simple" prefix="simple"%>

<br>
<h2>SimpleTag Demo</h2>
<h3>AddTag Demo</h3>
<br>
<pre>
    public void doTag() throws JspException, IOException {

        JspContext ctx = getJspContext();
        JspWriter out = ctx.getOut();
        
        int sum = num1 + num2;
        ctx.setAttribute("sum", Integer.toString(sum));

        out.println(num1 + " + " + num2 + " = " + sum);
    }
</pre>
<simple:Add num1="100">
  <jsp:attribute name="num2">200</jsp:attribute>
</simple:Add>
num1+num2 = ${sum}

<h3>FragmentAttr_SimpleTag 标签</h3>
<simple:FragmentAttr_SimpleTag count="2">
    <jsp:attribute name="fragment">
重复执行 ....<br> 
<ul>
  <li> Item one </li>
  <li> Item two </li>
</ul>

    </jsp:attribute>
</simple:FragmentAttr_SimpleTag>

<h3>DynAttribute_SimpleTag 标签</h3>
<simple:DynAttribute_SimpleTag attr1="111" attr2="222" attr3="444">
    <jsp:attribute name="great">12</jsp:attribute>
    <jsp:attribute name="less">34</jsp:attribute>
</simple:DynAttribute_SimpleTag>
<font color="blue">SUM：${sum} ...</red>