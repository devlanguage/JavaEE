<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@include file="common.jsp" %>
   	 <div class="right_content">
   	 			<div id="news">
   	 				<marquee direction="up" height="130px;" style="padding-top: 20px;" truespeed="truespeed" onmouseover="stop()" onmouseout="start()" >
   	 					<ul>
   	 						<c:choose>
   	 							<c:when test="${empty informList }">
   	 								<font color="red">鏆傛椂杩樻病鏈夊箍鍛�</font>
   	 							</c:when>
   	 							<c:otherwise>
   	 								<c:forEach var="inform" items="${informList}">
   	 									<li><a href="#">涓婚锛�${inform.informTitle}</a>&nbsp;&nbsp;&nbsp;&nbsp;[${inform.informTime}]</li>
   	 								</c:forEach>
   	 							</c:otherwise>
   	 						</c:choose>	
   	 					</ul>
   	 				</marquee>
   	 			</div>
              <div>
              	 <img src="images/border.gif" />
              </div> 
                <div class="loginDiv">
                 <form name="login" action="login" method="post">          
					<fieldset>
						<legend id="loginTitle">璐﹀彿鐧诲綍</legend>
						<table>
							<tr>
								<td>璐﹀彿锛�</td>
								<td><input type="text" name="name" /></td>
							</tr>
							<tr>
								<td>瀵嗙爜锛�</td>
								<td><input type="password" name="password" /></td>
							</tr>
							<tr>
								<td><input type="checkbox" name="cookie" />璁颁綇瀵嗙爜</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><input type="submit" class="register" value="鐧诲綍" /></td>
								<td><a class="register" href="register.jsp">娉ㄥ唽</a></td>
							</tr>
							<tr>
								<td style="padding-left: 55px;"><img src="images/mail.png" name="mail" /></td>
								<td><a href="PwdIndex.jsp">蹇樿瀵嗙爜?鐐瑰嚮杩欓噷鎵惧洖瀵嗙爜.</a></td>
							</tr>
						</table>
					</fieldset>    
                  </form>     
                </div> 
              <div>
              	 <img src="images/border.gif" />
              </div> 
             <div class="right_box">
             	<div class="title"><span class="title_icon"><img src="images/bullet4.gif" alt="" title="" /></span>鐗逛环涔�&nbsp;&nbsp;<a href="page?type=3" class="more">-鏇村-</a></div> 
                   <c:forEach var="flag" items="${saleList}">
                    <div class="new_prod_box">
                        <a href="details.jsp">${flag.bookName}</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="images/promo_icon.gif" alt="" title="" /></span>
                        <a href="showBookByIdServlet?bookId=${flag.bookId}"><img src="${flag.picture}" alt="" title="" class="thumb" border="0" /></a>
                        <p class="price">鍘熶环锛氾骏${flag.price}</p>
                 		<p class="nowPrice">鐜颁环锛氾骏${flag.nowPrice}</p>
                        </div>           
                    </div>
                   </c:forEach>
             </div>
             
             <div class="right_box">
             	<div class="title"><span class="title_icon"><img src="images/categories.gif" alt="" title="" /></span>涔︾睄鍒嗙被</div> 
                <div class="title"><span class="title_icon"><img src="images/bullet5.gif" alt="" title="" /></span>澶栬涔︾睄</div> 
                <ul class="list">
                <li><a href="">鍩虹鑻辫</a></li>
                <li><a href="">楂樼骇鑻辫</a></li>
                <li><a href="">鍟嗗姟鑻辫</a></li>
                <li><a href="">鑻辫鍙ｈ</a></li>
                <li><a href="">鍏跺畠鑻辫</a></li>                                           
                </ul>
                
             	<div class="title"><span class="title_icon"><img src="images/bullet6.gif" alt="" title="" /></span>鏂囧鑹烘湳</div> 
                
                <ul class="list">
                <li><a href="">娓彴鏂囧</a></li>
                <li><a href="">澶栧浗鏂囧</a></li>
                <li><a href="">闈掓槬鏂囧</a></li>
                <li><a href="">鏂囧璇勮  </a></li>                      
                </ul>      
				<p>&nbsp;</p>
             	<div class="title"><span class="title_icon"><img src="images/bullet6.gif" alt="" title="" /></span>IT鎶�鏈�</div> 
                
                <ul class="list">
                <li><a href="">杞欢宸ョ▼</a></li>
                <li><a href="">绋嬪簭璁捐</a></li>
                <li><a href="">鎿嶄綔绯荤粺</a></li>
                <li><a href="">鍥惧舰鍥惧儚</a></li>                      
                </ul>      
            </div>  
