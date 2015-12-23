<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@include file="common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
	<HEAD>
		<TITLE>绠＄悊鍛樼櫥褰�</TITLE>
		<LINK href="images/Default.css" type=text/css rel=stylesheet>
		<LINK href="images/xtree.css" type=text/css rel=stylesheet>
		<LINK href="images/User_Login.css" type=text/css rel=stylesheet>
		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<META content="MSHTML 6.00.6000.16674" name=GENERATOR>
	</HEAD>
	<BODY id=userlogin_body>
		<DIV></DIV>

		<DIV id=user_login>
			<DL>
				<DD id=user_top>
					<UL>
						<LI class=user_top_l></LI>
						<LI class=user_top_c></LI>
						<LI class=user_top_r></LI>
					</UL>
				<DD id=user_main>
					<UL>
						<LI class=user_main_l></LI>
						<LI class=user_main_c>
							<DIV class=user_main_box>
								<UL>
									<LI class=user_main_text>
										鐢ㄦ埛鍚嶏細
									</LI>
									<LI class=user_main_input>
										<INPUT class=TxtUserNameCssClass id=TxtUserName maxLength=20
											name=TxtUserName>
									</LI>
								</UL>
								<UL>
									<LI class=user_main_text>
										瀵� 鐮侊細
									</LI>
									<LI class=user_main_input>
										<INPUT class=TxtPasswordCssClass id=TxtPassword type=password
											name=TxtPassword>
									</LI>
								</UL>
								<UL>
									<LI class=user_main_text>
										Cookie锟�0锟�5锟�0锟�2
									</LI>
									<LI class=user_main_input>
										<SELECT id=DropExpiration name=DropExpiration>
											<OPTION value=None selected>
												涓嶄繚瀛�
											</OPTION>
											<OPTION value=Day>
												淇濆瓨涓�澶�
											</OPTION>
											<OPTION value=Month>
												淇濆瓨涓�鏈�
											</OPTION>
											<OPTION value=Year>
												淇濆瓨涓�骞�
											</OPTION>
										</SELECT>
									</LI>
								</UL>
							</DIV>
						</LI>
						<LI class=user_main_r>
							<INPUT class=IbtnEnterCssClass id=IbtnEnter
								style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px"
								onclick='javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions("IbtnEnter", "", true, "", "", false, false))'
								type=image src="images/user_botton.gif" name=IbtnEnter>
						</LI>
					</UL>
				<DD id=user_bottom>
					<UL>
						<LI class=user_bottom_l></LI>
						<LI class=user_bottom_c>
							<SPAN style="MARGIN-TOP: 40px">锟�0锟�6锟�0锟�4锟�0锟�1锟�0锟�4锟�0锟�2煤锟�0锟�3锟�0锟�5锟�0锟�3锟�0锟�9锟�0锟�8锟�0锟�1锟�0锟�0眉锟�0锟�9脿锟�0锟�2贸锟�0锟�0篓锟�0锟�2锟�0锟�5掳锟�0锟�2锟�0锟�5锟�0锟�1锟�0锟�5锟�0锟�5锟�0锟�8锟�0锟�0锟�0锟�7锟�0锟�9
								<A href="http://www.865171.cn">865171</A> 锟�0锟�3锟�0锟�5</SPAN>
						</LI>
						<LI class=user_bottom_r></LI>
					</UL>
				</DD>
			</DL>
		</DIV>
		<SPAN id=ValrUserName style="DISPLAY: none; COLOR: red"></SPAN>
		<SPAN id=ValrPassword style="DISPLAY: none; COLOR: red"></SPAN>
		<SPAN id=ValrValidateCode style="DISPLAY: none; COLOR: red"></SPAN>
		<DIV id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></DIV>

		<DIV></DIV>

	</BODY>
</HTML>
