<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
Tbl_member tbl_member = (Tbl_member) session.getAttribute(GlobalConstants.FRONT_LOGININFO_KEY);
%>

<header class="main-header">
	<nav class="navbar navbar-static-top">
		<!-- Sidebar toggle button-->
		<a href="#" class="menu-link sidebar-toggle"><span class="sr-only">Toggle navigation</span></a>
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- 
				<li class="dropdown tasks-menu"><a href="#"><span><spring:message code="common.wd.배팅일정" /></span></a></li>
				<li class="dropdown tasks-menu"><a href="#"><span><spring:message code="common.wd.모의배팅" /></span></a></li>
				<li class="dropdown tasks-menu"><a href="#"><span><spring:message code="common.wd.랭킹" /></span></a></li>
				 -->
			</ul>
		</div>
	</nav>
</header>

<aside id="menu" class="main-sidebar">
	<section class="sidebar" style="height: auto;">
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/upload/images/users/avatar5.png" class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				
				<%
				if(tbl_member != null) {
					out.println("<p>" + tbl_member.getMember_id() + "</p><p>Point : " + tbl_member.getCurr_point() + "</p>");
				} else {
					out.println("<p>Guest</p>");
				}
				 %>
				</p>
			</div>
		</div>
		<div class="user-panel">
			<%
			if(tbl_member != null) {
				%><a href="${pageContext.request.contextPath}/front/login/logout.do"><button type="button" class="btn btn-block btn-primary btn-flat">Logout</button></a><%
			} else {
				%><a href="${pageContext.request.contextPath}/front/login/loginForm.do"><button type="button" class="btn btn-block btn-primary btn-flat">Login</button></a><%				
			}
			%>
		</div>
	</section>
	<ul class="sidebar-menu">
		<li class="header">메뉴리스트</li>
		<li><a href="${pageContext.request.contextPath}/front/member/info/updateForm.do"><i class="fa fa-circle-o text-aqua"></i> <span><spring:message code="common.wd.개인정보" /></span></a></li>
		<li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span><spring:message code="common.wd.포인트구매" />/<spring:message code="common.wd.사용내역" /></span></a></li>
		<li><a href="${pageContext.request.contextPath}/front/member/point_order/pointList.do"><i class="fa fa-circle-o text-aqua"></i> <span><spring:message code="common.wd.포인트구매" /></span></a></li>
		<!-- 
		<li><a href="#"><i class="fa fa-book"></i> <span><spring:message code="common.wd.관심유저" /></span></a></li>
		<li><a href="#"><i class="fa fa-circle-o text-red"></i> <span><spring:message code="common.wd.배팅히스토리" /></span></a></li>
		<li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span><spring:message code="common.wd.경기분석히스토리" /></span></a></li>
		 -->
	</ul>
</aside>