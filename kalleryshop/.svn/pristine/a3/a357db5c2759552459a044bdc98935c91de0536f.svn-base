<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
Logger logger = LoggerFactory.getLogger(getClass());
Tbl_member tbl_member = (Tbl_member) session.getAttribute(GlobalConstants.FRONT_LOGININFO_KEY);

CategoryService categoryService = (CategoryService) wac.getBean(CategoryService.class);
List cateListTop = categoryService.getTbl_cate_mstListByTop();
request.setAttribute("cateListTop", cateListTop);
%>
	<header>
		<div class="row">
			<div class="col-md-12">
				<table style = "width:100%">
					<tr valign="middle">
						<td width="50%" align="left">
							<!--  logo image -->
							<img src="${pageContext.request.contextPath}/upload/image/logo.png">
						</td>
						<td width="50%">
							<div align="right">
							<div class="navbar-custom-menu">
								<ul class="nav navbar-nav" style="float:right">
          							<li class="dropdown user user-menu">
            							<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color:#333">
	              							<img src="${pageContext.request.contextPath}/upload/image/usr/avatar5.png" width="30" height="30" class="img-circle" alt="User Image">
	              							<span class="hidden-xs">
												<%
												if(tbl_member != null) {
													out.println(tbl_member.getMember_nick_name());
												} else {
													out.println("Guest");
												}
												%>
	              							</span>
            							</a>
            							<ul class="dropdown-menu">
              								<!-- User image -->
              								<li class="user-header">
                								<img src="${pageContext.request.contextPath}/upload/image/usr/avatar5.png" width="160" height="160" class="img-circle" alt="User Image">
												<p></p>
												<div class="row">
													<div class="col-xs-12 text-center">
														<%
														if(tbl_member != null) {
															out.println(tbl_member.getMember_nick_name());
														} else {
															out.println("Guest");
														}
														%>
				 									</div>
												</div>
												<div class="row">
													<div class="col-xs-12 text-center">
														<%
														if(tbl_member != null) {
															out.println(" Point : " + tbl_member.getCurr_point() + "");
														}
														%>						
													</div>
												</div>
              								</li>
											<!-- Menu Body -->
											<li class="user-body">
												<div class="row">
													<div class="col-xs-12 text-left">
									                    <a href="${pageContext.request.contextPath}/front/member/info/updateForm.do"><spring:message code="common.wd.개인정보수정" /></a>
													</div>
												</div>
												<div class="row">
													<div class="col-xs-12 text-left">
														<a href="${pageContext.request.contextPath}/front/member/point_order/pointList.do"><spring:message code="common.wd.포인트구매" /></a>
													</div>
												</div>
												<div class="row">
													<div class="col-xs-12 text-left">
														<a href="#"><spring:message code="common.wd.포인트구매" />/<spring:message code="common.wd.사용내역" /></a>
													</div>
												</div>
											</li>
											<!-- Menu Footer-->
											<li class="user-footer">
												<div class="pull-left">
												</div>
												<div class="pull-right">
													<%
													if(tbl_member != null) {
														%><a href="${pageContext.request.contextPath}/front/login/logout.do"><button type="button" class="btn btn-default">Logout</button></a><%
													} else {
														%><a href="${pageContext.request.contextPath}/front/login/loginForm.do"><button type="button" class="btn btn-default">Login</button></a><%				
													}
													%>
           										</div>
											</li>
										</ul>
									</li>
								</ul>
								</div>
							</div>
   							<!-- Control Sidebar Toggle Button -->
						</td>
					</tr>
				</table>
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
						<li><a href="${pageContext.request.contextPath}/front/main/index.do"><%=configProp.get("shop_id")%></a></li>
					</ul>

					<c:forEach items="${cateListTop}" var="list">
						<ul class="nav navbar-nav">
							<li><a href="${pageContext.request.contextPath}/front/main/category.do?cate_mst_seq=${list.cate_mst_seq}">${list.cate_name}</a></li>
						</ul>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>