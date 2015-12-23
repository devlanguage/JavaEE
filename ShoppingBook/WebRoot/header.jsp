<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
    <script type="text/javascript">
    	function b1(){
		
		var timeId = document.getElementById("timeId");
		var x  = new Array("鏄熸湡鏃�", "鏄熸湡涓�", "鏄熸湡浜�","鏄熸湡涓�","鏄熸湡鍥�", "鏄熸湡浜�","鏄熸湡鍏�");
		var e = new Date();
		var day = e.getUTCDay();
		timeId.innerHTML = "鏃ユ湡锛�"+e.getYear()+"骞�"+(e.getMonth()+1)+"鏈�"+e.getDate()+"鏃�   " +x[day];
	}
	</script>
    <body onload="b1()">
     <div class="header">
       		<div class="logo"><a href="index.htm"><img src="images/logo.gif" alt="" title="" border="0" /></a></div>            
        <div id="menu">
            <ul>                                                                       
            <li class="selected"><a href="index.jsp">棣栭〉</a></li>
            <li><a href="about.jsp">鍏充簬鎴戜滑</a></li>
            <li><a href="page?type=0">涔︾睄搴�</a></li>
            <li><a href="page?type=4">鐗瑰埆鎺ㄨ崘</a></li>
            <li><a href="okLoggin">涓汉涓績</a></li>
            <li><a href="pageNoteServlet">鐢ㄦ埛鐣欒█</a></li>
            <li><a href="contact.jsp">鑱旂郴鎴戜滑</a></li>
             <li><a href="userLoginOut">娉ㄩ攢</a></li>
            </ul>
        </div>                        
       </div> 
       <div id="serachDiv">
       	<div style="padding-left:50px">
       	 <form action="pageSearchServlet" method="post" id="searchForm">
       	 	<table>
       	 		<tr>
       				<td><input type="text" name="keywords" id="keywords" /></td>
       				<td><input type="image" src="images/search.gif" name="submit" /></td>
       				<td><img src="images/gjsearch.png" name="gjsearch" /></td>    
       				<td><a href="showSuperTypeServlet">楂樼骇鎼滅储</a></td>
       				<td id="timeId" style="padding-left: 250px;"></td>   				
       			</tr>
       		</table>
       	 </form>
       	</div> 		
       </div>
       <!--end of leftTop content-->
      </body> 
