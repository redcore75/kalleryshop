<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
Tbl_member tbl_member = (Tbl_member) session.getAttribute(GlobalConstants.ADMIN_LOGININFO_KEY);
%>
    <header>
		<div class="row">
			<div class="col-md-11">
				<strong><spring:message code="common.wd.접속자" /> : </strong><%=tbl_member.getMember_id() %>(<%=tbl_member.getMember_name() %>)
			</div>
			<div class="col-md-1">
				<a href="${pageContext.request.contextPath}/admin/login/logout.do">
					<button type="submit" class="btn btn-default btn-flat"><spring:message code="common.wd.로그아웃" /></button>
				</a>
			</div>
		</div>
    </header>

	<section class="menu-section">
		<div class="navbar navbar-inverse">
			<div class="container">
	        	<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
	        	</div>
				
				<div id="navbar" class="navbar-collapse collapse">
	          		<ul class="nav navbar-nav">
		            	<li class="dropdown">
		              		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="common.wd.기본설정" /><span class="caret"></span></a>
		              		<ul class="dropdown-menu">
		                		<li><a href="${pageContext.request.contextPath}/admin/shop_env/updateForm.do"><spring:message code="common.wd.기본정보" /></a></li>
		                		<li><a href="${pageContext.request.contextPath}/admin/serv_term/updateForm.do"><spring:message code="common.wd.약관정보" /></a></li>		                	
		              		</ul>
		            	</li>
		            	<li class="dropdown">
		              		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="common.wd.배너관리" /><span class="caret"></span></a>
		              		<ul class="dropdown-menu">
		                		<li><a href="${pageContext.request.contextPath}/admin/banner_manager/searchList.do"><spring:message code="common.wd.배너관리리스트" /></a></li>
		                		<li><a href="${pageContext.request.contextPath}/admin/banner/searchList.do"><spring:message code="common.wd.배너상세리스트" /></a></li>
		              		</ul>
		            	</li>
		            	<li class="dropdown">
		              		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="common.wd.회원관리" /><span class="caret"></span></a>
		              		<ul class="dropdown-menu">
		                		<li><a href="${pageContext.request.contextPath}/admin/admin_member/searchList.do"><spring:message code="common.wd.관리자리스트" /></a></li>
		                		<li><a href="${pageContext.request.contextPath}/admin/front_member/searchList.do"><spring:message code="common.wd.회원리스트" /></a></li>
		              		</ul>
		            	</li>

		            	<li class="dropdown">
		              		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="common.wd.카테고리관리" /><span class="caret"></span></a>
		              		<ul class="dropdown-menu">
		                		<li><a href="${pageContext.request.contextPath}/admin/cate_manager/cateList.do"><spring:message code="common.wd.카테고리리스트" /></a></li>
		                		<li><a href="${pageContext.request.contextPath}/admin/cate_manager/catePrdList.do"><spring:message code="common.wd.카테고리상품리스트" /></a></li>
		              		</ul>
		            	</li>
		            	
		            	<li class="dropdown">
		              		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="common.wd.상품관리" /><span class="caret"></span></a>
		              		<ul class="dropdown-menu">
		                		<li><a href="${pageContext.request.contextPath}/admin/prd_manager/searchList.do"><spring:message code="common.wd.상품리스트" /></a></li>
		              		</ul>
		            	</li>
					</ul>
				</div>
			</div>
		</div>
	</section>