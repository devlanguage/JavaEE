<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>涔︾睄鐨勮缁嗕粙缁�</title>

<link rel="stylesheet" type="text/css" href="style.css" />
	<link rel="stylesheet" href="lightbox.css" type="text/css" media="screen" />
	<script src="js/prototype.js" type="text/javascript"></script>
	<script src="js/scriptaculous.js?load=effects" type="text/javascript"></script>
	<script src="js/lightbox.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/java.js"></script>
</head>
<body>
<div id="wrap">
		<%@include file="header.jsp" %>
		<!-- begin of center_content -->
       <div class="center_content">
       
       <!-- begin of left_content -->
       	<div class="left_content">
        	<div class="crumb_nav">
            <a href="index.jsp">棣栭〉</a> &gt;&gt; 璇︾粏浠嬬粛
            </div>
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>涔︾睄浠嬬粛</div>
        	<div class="feat_prod_box_details">
            	<div class="prod_img"><a href="details.jsp"><img src="${book.picture }" alt="" title="" border="0" /></a>
                <br /><br />
                <a href="images/big_pic.jpg" rel="lightbox"><img src="images/zoom.gif" alt="" title="" border="0" /></a>
                </div>
                <div class="prod_det_box">
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title">鍩烘湰淇℃伅</div>
						<table>
							<tr>
								<td>涔︾睄鍚嶇О</td>
								<td>${book.bookName}</td>
							</tr>
							<tr>
								<td>ISBN</td>
								<td>${book.ISBN}</td>
							</tr>
							<tr>
								<td>椤垫暟</td>
								<td>${book.pages}</td>
							</tr>
							<tr>
								<td>浣滆��</td>
								<td>${book.author}</td>
							</tr>
							<tr>
								<td>鍑虹増绀�</td>
								<td>${book.publisher}</td>
							</tr>
							<tr>
								<td>鍘熶环</td>
								<td>${book.price}</td>
							</tr>
							<tr>
								<td>鐜颁环</td>
								<td>${book.nowPrice}</td>
							</tr>	
						</table>
                    </div>
                    <a href="buyBooksServlet?bookId=${book.bookId}" class="more"><img src="images/order_now.gif" alt="" title="" border="0" /></a>
                    <div class="clear"></div>
                    <div class="box_bottom"></div>                 
                </div>    
            <div class="clear"></div>
            </div>	                    
            <div id="demo" class="demolayout">
                <ul id="demo-nav" class="demolayout">
                <li><a class="active" href="">-浜嗚В鏇村-</a></li>
                <li><a class="" href="">-鐩稿叧涔︾睄-</a></li>
                </ul>
             </div>   
            <div class="tabs-container">
                    <div style="display: block;" class="tab" id="tab1">
                         <p class="more_details"></p>
                            <ul class="list">
                            <li><a href="#">${book.introduce}</li>
                            <li><a href="#">${book.introduce}</a></li>                                       
                            </ul>
                        <p class="more_details"></p>                           
                   </div>	
                   <div style="display: none;" class="tab" id="tab2">
                   
                    <div class="new_prod_box">
                        <a href="details.jsp">product name</a>
                        <div class="new_prod_bg">
                        <a href="details.html"><img src="images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>
                                        
                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <a href="details.html"><img src="images/thumb2.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>    
                                    
                   <div class="clear"></div>
               </div>	
            </div>
        <div class="clear"></div>
       
        </div><!--end of left content-->
      	<%@include file="right.jsp" %>
     	 <!--end of center content-->
     	 </div>
   	    <%@include file="footer.jsp" %>    
	</div>
</body>
<script type="text/javascript">
 var tabber1 = new Yetii({
 id: 'demo'
 });
 </script>
</html>
